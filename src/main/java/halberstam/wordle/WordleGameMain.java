package halberstam.wordle;

import java.io.IOException;

public class WordleGameMain {
    public static void main(String[] args) throws IOException {
        //
        WordleGameFrame frame = new WordleGameFrame(new WordleGame(new WordleDictionary()), new WordleDictionary());
        frame.setVisible(true);
    }
}
