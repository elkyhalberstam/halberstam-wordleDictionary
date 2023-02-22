package halberstam.wordle;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WordleGameTest {

    @Test
    public void guess() throws IOException {
        //given
        WordleGame one = new WordleGame();
        //when
        String word = one.getWord();
        CharResult[] whats = one.guess(word);
        CharResult[] once = {CharResult.Correct ,CharResult.Correct,CharResult.Correct,CharResult.Correct,CharResult.Correct};
        //then
        assertArrayEquals(whats, once);
    }
}