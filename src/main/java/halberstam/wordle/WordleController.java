package halberstam.wordle;

import javax.swing.*;

public class WordleController {

    private final JButton keyboard[];
    private final JButton enter;
    private final JButton backspace;
    private WordleGame wordleGame;
    private WordleDictionary dictionary;
    private JLabel labels[][];

    public WordleController(WordleGame wordleGame, WordleDictionary dictionary, JLabel[][] labels, JButton[] keyboard, JButton enter, JButton backspace) {
        this.wordleGame = wordleGame;
        this.dictionary = dictionary;
        this.labels = labels;
        this.keyboard = keyboard;
        this.enter = enter;
        this.backspace = backspace;
        addActionListeners();
    }

    public void addLetter(String letter) {
        //check if row is locked - first letter == blocked
        //add letter to the next empty letter in that row
    }

    public void enterGuess() {
        //get current word from label lsit (concat it)
        //check if word is in dictionary  - use method from dictionary class
        //if no - say not a word
        //if yes -
        //run the guess method ==
        // for now replace labels with the allotted place on list (later just change background)
        //lock the row on labels list
    }

    public void backspace() {
        //reset last label to 'X'
        // set label on array to null
    }

    public void addActionListeners() {
        //enter.addActionListener(e -> enterGuess());
        //backspace.addActionListener(e -> backspace());

        for (int i = 0; i < keyboard.length; i++) {
            //String letter = keyboard[i].getText();
            //find open label
            //keyboard[i].addActionListener(e ->/*set open label to letter*/ System.out.println(letter));
        }

    }

    //
//    new* addKeyListener(new KeyListener()
//    {
//
//    }
//    ));
}
