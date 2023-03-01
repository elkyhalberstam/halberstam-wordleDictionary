package halberstam.wordle;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static halberstam.wordle.CharResult.Correct;
import static halberstam.wordle.CharResult.NotFound;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;

class WordleGameTest {

    @Test
    public void guessCorrect() {
        //given
        WordleDictionary dictionary = Mockito.mock(WordleDictionary.class);
        ArrayList<String> words = new ArrayList<>(List.of("DRINK"));
        doReturn(words).when(dictionary).getList();
        WordleGame testGame = new WordleGame(dictionary);
        //when
        CharResult[] testGuess = testGame.guess("DRINK");
        //then
        CharResult[] guessCorrect = {Correct, Correct, Correct, Correct, Correct};
        assertArrayEquals(guessCorrect, testGuess);
    }

    @Test
    public void guessWrong() {
        //given
        WordleDictionary dictionary = Mockito.mock(WordleDictionary.class);
        ArrayList<String> words = new ArrayList<>(List.of("DRINK"));
        doReturn(words).when(dictionary).getList();
        WordleGame testGame = new WordleGame(dictionary);
        //when
        CharResult[] testGuess = testGame.guess("TRINK");
        //then
        CharResult[] guessWrong = {NotFound, Correct, Correct, Correct, Correct};
        assertArrayEquals(guessWrong, testGuess);
    }
}