package halberstam.wordle;

import javax.swing.*;

public class WordleController {

    private final JButton keyboard[];
    private final JButton enter;
    private final JButton backspace;
    private WordleGame wordleGame;
    private WordleDictionary dictionary;
    private JLabel labels[][];

    private int lettersTyped;
    private int numGuesses;

    public WordleController(WordleGame wordleGame, WordleDictionary dictionary, JLabel[][] labels, JButton[] keyboard, JButton enter, JButton backspace) {
        this.wordleGame = wordleGame;
        this.dictionary = dictionary;
        this.labels = labels;
        this.keyboard = keyboard;
        this.enter = enter;
        this.backspace = backspace;
        lettersTyped = 0;
        numGuesses = 0;
        addActionListeners();
    }

    public void addLetter(String letter) {
        if (numGuesses < 6 && lettersTyped < 6) {
            labels[numGuesses][lettersTyped].setText(letter);
            lettersTyped++;
        }
    }

    public void enterGuess() {

        if (numGuesses < 6 && lettersTyped == 6) {
            String word = null;
            for (int i = 0; i < labels[numGuesses].length; i++) {
                word += labels[numGuesses][i].getText();
            }
            String exist = dictionary.getDefinition(word);
            if (exist != null) {
                CharResult[] guessResult = wordleGame.guess(word);
                System.out.println(guessResult); //this really should be a color thing
                numGuesses++;
            } else {
                System.out.println("not a word");
            }
        }
    }

    public void backspace() {
        //reset last label to 'X'
        // set label on array to null
    }

    public void addActionListeners() {
        //enter.addActionListener(e -> enterGuess());
        //backspace.addActionListener(e -> System.out.println("try"));

        for (int i = 0; i < keyboard.length; i++) {
            //String letter = keyboard[i].getText();
            //find open label
            //keyboard[i].addActionListener(e ->/*set open label to letter*/ System.out.println(letter));
        }

    }

}
