package halberstam.wordle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Locale;

public class WordleGameFrame extends JFrame {
    private JLabel[][] labels = new JLabel[6][5];
    private JButton[] keyboard = new JButton[28];
    private JButton enter;
    private JButton backspace;

    private CharResult[] guessResult;
    private String theGuess;
    private WordleController controller;

    public WordleGameFrame(WordleGame wordleGame, WordleDictionary dictionary) {

        controller = new WordleController(wordleGame, dictionary, labels, keyboard, enter, backspace);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(6, 5));

        for (int i = 0; i < labels.length; i++) {
            for (int j = 0; j < labels[i].length; j++) {
                labels[i][j] = new JLabel("", SwingConstants.CENTER);
                centerPanel.add(labels[i][j]);
                labels[i][j].setBorder(BorderFactory.createLineBorder(Color.black, 1));

            }
        }
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        JPanel keyboardlayout = new JPanel();
        keyboardlayout.setLayout(new BorderLayout());

        char[][] keyboardlist = {{'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'}, {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'}, {'Z', 'X', 'C', 'V', 'B', 'N', 'M'}};
        int letterNum = 0;

        JPanel keyboardline1 = new JPanel();
        keyboardline1.setLayout(new FlowLayout());
        for (int i = 0; i < keyboardlist[0].length; i++) {
            char letter = keyboardlist[0][i];
            keyboard[letterNum] = new JButton(String.valueOf((letter)));
            keyboardline1.add(keyboard[letterNum++]);
        }
        keyboardlayout.add(keyboardline1, BorderLayout.NORTH);

        JPanel keyboardline2 = new JPanel();
        keyboardline2.setLayout(new FlowLayout());
        for (int i = 0; i < keyboardlist[1].length; i++) {
            char letter = keyboardlist[1][i];
            keyboard[letterNum] = new JButton(String.valueOf((letter)));
            keyboardline2.add(keyboard[letterNum++]);
        }
        keyboardlayout.add(keyboardline2, BorderLayout.CENTER);


        JPanel keyboardline3 = new JPanel();
        keyboardline3.setLayout(new FlowLayout());

        enter = new JButton("Enter");
        keyboardline3.add(enter);

        for (int i = 0; i < keyboardlist[2].length; i++) {
            char letter = keyboardlist[2][i];
            keyboard[letterNum] = new JButton(String.valueOf((letter)));
            keyboardline3.add(keyboard[letterNum++]);
        }

        backspace = new JButton("Backspace");
        keyboardline3.add(backspace);

        keyboardlayout.add(keyboardline3, BorderLayout.SOUTH);

        mainPanel.add(keyboardlayout, BorderLayout.SOUTH);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (Character.isAlphabetic(input)) {
                    controller.addLetter(String.valueOf(e.getKeyChar()).toUpperCase(Locale.ROOT));
                } else if (String.valueOf(e.getKeyChar()).equals("\b")) {
                    controller.backspace();
                } else if (String.valueOf(e.getKeyChar()).equals("\n")) {
                    controller.enterGuess();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        setContentPane(mainPanel);
        setSize(600, 400);
        setTitle("Wordle Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

