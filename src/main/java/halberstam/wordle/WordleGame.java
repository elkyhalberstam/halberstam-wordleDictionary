package halberstam.wordle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class WordleGame
{
    ArrayList<String> wordList;
    String word;

    public WordleGame() throws IOException {
        loadingWordlist();
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

    private void loadingWordlist() throws IOException
    {
        wordList = new ArrayList<>();

        WordleDictionary dictionary = new WordleDictionary();

        ArrayList<String> longList = dictionary.getList();

        for(int i =0; i<longList.size(); i++)
        {
            if(longList.get(i).length() < 5)
            {
                continue;
            }
            else if(longList.get(i).length() == 5)
            {
                wordList.add(longList.get(i));
            }
            else if(longList.get(i).length() > 5)
            {
                break;
            }
        }
    }

    public CharResult[] guess(String guessString)
    {
        //--------errors to think about
        //what about double letters in guessString
        //what about double letters in word
        //what about guessString being > 5 letters
        //what about guessString being < 5 letters

        CharResult[] result = new CharResult[5];
        guessString.toUpperCase();
        int currLetter = 0;
        while (currLetter < guessString.length())
        {
            for (int i = 0; i < word.length(); i++)
            {
                if (guessString.charAt(currLetter) == word.charAt(i))
                {
                    if (currLetter == i) {
                        result[currLetter] = CharResult.Correct;
                        break;
                    } else {
                        result[currLetter] = CharResult.WrongPlace;
                        break;
                    }
                }
                result[currLetter] = CharResult.NotFound;
            }
        currLetter++;
        }
        return result;
    }
}
