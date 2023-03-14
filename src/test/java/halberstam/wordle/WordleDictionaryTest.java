package halberstam.wordle;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Set list = wordle.getList();
        //then
        assertEquals(167964, list.size());
    }
}