package halberstam.wordle;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class WordleControllerTest {
    WordleGame wordleGame = mock(WordleGame.class);
    WordleDictionary dictionary = mock(WordleDictionary.class);
    JLabel letters[][] = new JLabel[][]{
            {mock(), mock(), mock(), mock(), mock(),},
            {mock(), mock(), mock(), mock(), mock(),},
            {mock(), mock(), mock(), mock(), mock(),},
            {mock(), mock(), mock(), mock(), mock(),},
            {mock(), mock(), mock(), mock(), mock(),},
            {mock(), mock(), mock(), mock(), mock(),}
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
        WordleController tempController = controller;
        //when
        controller.addLetter("D");
        controller.addLetter("R");
        controller.addLetter("I");
        controller.addLetter("N");
        controller.addLetter("K");
        controller.enterGuess();

        //then
//        verify(letters[0][0]).setText("D");
//        verify(letters[0][1]).setText("R");
//        verify(letters[0][2]).setText("I");
//        verify(letters[0][3]).setText("N");
//        verify(letters[0][5]).setText("K");
        verify(letters[0][0]).setOpaque(true);
//        verify(letters[0][1]).setOpaque(true);
//        verify(letters[0][2]).setOpaque(true);
//        verify(letters[0][3]).setOpaque(true);
//        verify(letters[0][4]).setOpaque(true);

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