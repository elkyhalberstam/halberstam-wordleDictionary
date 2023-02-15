package halberstam.wordle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

class WordleDictionaryTest {

    @Test
    void getDefinition() throws IOException
    {
        //given
        WordleDictionary wordle = new WordleDictionary();
        //when
        String definition = wordle.getDefinition("formatting");
        //then
        Assertions.assertEquals(definition, "<format=v> [v]");
    }

    @Test
    void getList() throws IOException
    {
        //given
        WordleDictionary wordle = new WordleDictionary();
        //when
        ArrayList<String> list = wordle.getList();
        //then
        Assertions.assertEquals(167964, list.size());
    }
}