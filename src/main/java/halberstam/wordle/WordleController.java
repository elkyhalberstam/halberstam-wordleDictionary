package halberstam.wordle;

import javax.swing.*;
import java.awt.*;

import static halberstam.wordle.CharResult.*;
import static java.awt.Color.GRAY;
import static java.awt.Color.white;

public class WordleController {

    private final JButton keyboard[];
    private final JButton enter;
    private final JButton backspace;
    private WordleGame wordleGame;
    private WordleDictionary dictionary;
    private JLabel labels[][];

    private int lettersTyped;
    private int numGuesses;

    public WordleController(WordleGame wordleGame, WordleDictionary dictionary, JLabel[][] labels,
                            JButton[] keyboard, JButton enter, JButton backspace) {
        this.wordleGame = wordleGame;
        this.dictionary = dictionary;
        this.labels = labels;
        this.keyboard = keyboard;
        this.enter = enter;
        this.backspace = backspace;
        lettersTyped = 0;
        numGuesses = 0;
    }

    public void addLetter(String letter) {
        if (numGuesses < 6 && lettersTyped < 6) {
            labels[numGuesses][lettersTyped].setText(letter);
            lettersTyped++;
        }

        if (lettersTyped == 5) {
            enter.setOpaque(true);
            enter.setBackground(Color.green);
        }
    }

    public void enterGuess() {

        if (numGuesses < 6 && lettersTyped == 5) {
            String word = "";
            for (int i = 0; i < labels[numGuesses].length; i++) {
                word += labels[numGuesses][i].getText();
            }

            if (dictionary.doesExist(word)) {
                CharResult[] guessResult = wordleGame.guess(word);
                checkingResult(guessResult);
                numGuesses++;
                lettersTyped = 0;
                enter.setBackground(white);
            } else {
                System.out.println(word + "Dose not exist");
            }
        }
    }

    private void checkingResult(CharResult[] guessResult) {
        for (int i = 0; i < guessResult.length; i++) {
            CharResult currChar = guessResult[i];
            if (currChar.equals(NotFound)) {
                labels[numGuesses][i].setOpaque(true);
                labels[numGuesses][i].setBackground(GRAY);
            } else if (currChar.equals(WrongPlace)) {
                labels[numGuesses][i].setOpaque(true);
                labels[numGuesses][i].setBackground(Color.YELLOW);
            } else if (currChar.equals(Correct)) {
                labels[numGuesses][i].setOpaque(true);
                labels[numGuesses][i].setBackground(Color.GREEN);
            }
        }
    }

    public void backspace() {
        if (lettersTyped > 0) {
            lettersTyped--;
            labels[numGuesses][lettersTyped].setText("");
        }
        enter.setBackground(white);
    }
}
