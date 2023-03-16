package halberstam.wordle;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

class WordleControllerTest {
    WordleGame wordleGame = mock(WordleGame.class);
    WordleDictionary dictionary = mock(WordleDictionary.class);
    JLabel letters[][] = new JLabel[][]{
            {mock(), mock(), mock(), mock(), mock()},
            {mock(), mock(), mock(), mock(), mock()},
            {mock(), mock(), mock(), mock(), mock()},
            {mock(), mock(), mock(), mock(), mock()},
            {mock(), mock(), mock(), mock(), mock()},
            {mock(), mock(), mock(), mock(), mock()}
    };
    JButton[] keyboard = new JButton[]{mock()};
    JButton enter = mock();
    JButton backspace = mock();

    WordleController controller = new WordleController(
            wordleGame, dictionary, letters, keyboard, enter, backspace);

    @Test
    void addLetter() {
        //given
        WordleController tempController = controller;
        //when
        controller.addLetter("A");
        controller.addLetter("B");
        //then
        verify(letters[0][0]).setText("A");
        verify(letters[0][1]).setText("B");
    }

    @Test
    void enterGuess() {
        //given
        Set words = new HashSet((List.of("DRANK")));
        doReturn(words).when(dictionary).getList();
        doReturn(true).when(dictionary).doesExist("FRANK");

        doReturn("DRANK").when(wordleGame).getWord();

        CharResult[] result = {CharResult.NotFound, CharResult.Correct, CharResult.Correct,
                CharResult.Correct, CharResult.Correct};
        doReturn(result).when(wordleGame).guess("FRANK");

        doReturn("F").when(letters[0][0]).getText();
        doReturn("R").when(letters[0][1]).getText();
        doReturn("A").when(letters[0][2]).getText();
        doReturn("N").when(letters[0][3]).getText();
        doReturn("K").when(letters[0][4]).getText();

        WordleController controller = new WordleController(
                wordleGame, dictionary, letters, keyboard, enter, backspace);
        //when
        controller.addLetter("F");
        controller.addLetter("R");
        controller.addLetter("A");
        controller.addLetter("N");
        controller.addLetter("K");

        controller.enterGuess();

        //then
        verify(letters[0][0]).setBackground(Color.gray);
        verify(letters[0][1]).setBackground(Color.green);
        verify(letters[0][2]).setBackground(Color.green);
        verify(letters[0][3]).setBackground(Color.green);
        verify(letters[0][4]).setBackground(Color.green);

    }

    @Test
    void backspace() {
        //given
        WordleController tempController = controller;
        //when
        controller.addLetter("A");
        controller.addLetter("B");
        controller.backspace();
        //then
        verify(letters[0][0]).setText("A");
        verify(letters[0][1]).setText("");
    }
}