package halberstam.wordle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

class WordleDictionaryTest {

    @Test
    void getDefinition() throws IOException {
        //given
        WordleDictionary wordle = new WordleDictionary("C:\\Users\\Elky\\Documents\\Touro\\Spring 2023\\Swimmer 1\\dictionary.txt");
        //when
        ArrayList<String> list = wordle.getList();
        //then
        Assertions.assertEquals(167964, list.size());
    }

    @Test
    void getList() throws IOException {
        //given
        WordleDictionary wordle = new WordleDictionary("C:\\Users\\Elky\\Documents\\Touro\\Spring 2023\\Swimmer 1\\dictionary.txt");
        //when
        String definition = wordle.getDefinition("eh");
        //then
        Assertions.assertEquals(definition, "used to express doubt or surprise [interj]");
    }
}