package halberstam.wordle;

import java.util.ArrayList;
import java.util.Random;

public class WordleGame {
    private ArrayList<String> wordList;
    private String word;

    public WordleGame(WordleDictionary dictionary) {
        loadingWordlist(dictionary);
        generateRandomWord();

    }

    public String getWord() {
        return word;
    }

    private void generateRandomWord() {
        Random random = new Random();
        int rand = random.nextInt(wordList.size());
        word = wordList.get(rand);
    }

    private void loadingWordlist(WordleDictionary dictionary) {
        wordList = new ArrayList<>();

        ArrayList<String> longList = dictionary.getList();

        for (int i = 0; i < longList.size(); i++) {
            String currWord = longList.get(i);
            if (currWord.length() == 5) {
                wordList.add(longList.get(i));
            } else if (currWord.length() > 5) {
                break;
            }
        }
    }

    public CharResult[] guess(String guessString) {
        //--------errors to think about
        //what about double letters in guessString
        //what about double letters in word
        //what about guessString being > 5 letters
        //what about guessString being < 5 letters

        CharResult[] result = {CharResult.NotFound, CharResult.NotFound, CharResult.NotFound, CharResult.NotFound, CharResult.NotFound};
        guessString.toUpperCase();
        for (int currLetter = 0; currLetter < guessString.length(); currLetter++) {
            for (int i = 0; i < word.length(); i++) {
                if (guessString.charAt(currLetter) == word.charAt(i)) {
                    if (currLetter == i) {
                        result[currLetter] = CharResult.Correct;
                        break;
                    } else {
                        //I still have the double letter problem - will be dealing wiht it after class
                        result[currLetter] = CharResult.WrongPlace;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
