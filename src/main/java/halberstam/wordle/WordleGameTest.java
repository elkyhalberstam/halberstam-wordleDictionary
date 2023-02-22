package halberstam.wordle;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WordleGameTest {

    @Test
    public void guessCorrect() throws IOException {
        //given
        WordleGame testGame = new WordleGame();
        //when
        String word = testGame.getWord();
        CharResult[] testGuess = testGame.guess(word);
        CharResult[] guessCorrect = {CharResult.Correct ,CharResult.Correct,CharResult.Correct,CharResult.Correct,CharResult.Correct};
        //then
        assertArrayEquals(guessCorrect, testGuess);
    }
    @Test
    public void guessWrong() throws IOException {
        //given
        WordleGame testGame = new WordleGame();
        //when
        String word = testGame.getWord();
        word = "z" +word.substring(1);
        CharResult[] testGuess = testGame.guess(word);
        CharResult[] guessWrong = {CharResult.NotFound ,CharResult.Correct,CharResult.Correct,CharResult.Correct,CharResult.Correct};
        //then
        assertArrayEquals(guessWrong,testGuess);
    }
}