package halberstam.wordle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

class WordleDictionaryTest {

    @Test
    void getDefinition() throws IOException {
        //given
        WordleDictionary wordle = new WordleDictionary();
        //when
        String definition = wordle.getDefinition("formatting");
        //then
        assertEquals(definition, "<format=v> [v]");
    }

    @Test
    void getList() throws IOException {
        //given
        WordleDictionary wordle = new WordleDictionary();
        //when
        ArrayList<String> list = wordle.getList();
        //then
        assertEquals(167964, list.size());
    }
}