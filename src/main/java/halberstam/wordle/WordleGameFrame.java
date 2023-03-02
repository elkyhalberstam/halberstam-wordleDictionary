package halberstam.wordle;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;

import static java.lang.System.exit;

public class WordleGameFrame extends JFrame {
    //private JTextField[][] fields; - from class

    public WordleGameFrame() {

        WordleDictionary dictionary = null;
        try {
            dictionary = new WordleDictionary();
        } catch (IOException ex) {
            ex.printStackTrace();
            exit(0);
        }
        WordleGame newGame = new WordleGame(dictionary);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JTextField textGuess = new JTextField("Type your guess");
        mainPanel.add(textGuess, BorderLayout.NORTH);

        JLabel output = new JLabel("output");
        mainPanel.add(output, BorderLayout.CENTER);
        JButton button = new JButton("Guess");
        mainPanel.add(button, BorderLayout.SOUTH);

        button.addActionListener(e -> {
            CharResult[] newGuess = newGame.guess(textGuess.getText());
            output.setText(Arrays.toString(newGuess));
        });

        setContentPane(mainPanel);
        setSize(300, 100);
        setTitle("Wordle Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

//code from class
        /*JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 3));


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                JTextField label = new JTextField("LABEL" + i + "," + j);
                centerPanel.add(label);
            }
        }
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        JButton button = new JButton("Guess");
        mainPanel.add(button, BorderLayout.SOUTH);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Guess Clicked");
            }
        });

        setContentPane(mainPanel);
        setSize(600, 1000);
        setTitle("Wordle Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        */
