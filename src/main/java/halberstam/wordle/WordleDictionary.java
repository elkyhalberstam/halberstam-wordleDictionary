package halberstam.wordle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class WordleDictionary {
    private File file;
    private HashMap dictionary = new HashMap<String, String>();

    public WordleDictionary() throws IOException {
        this.file = new File("src/main/java/halberstam/wordle/dictionary.txt");
        loadingDictionary();
    }

    private void loadingDictionary() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            String[] currLine = line.split(" ", 2);
            if (currLine.length > 1) {
                dictionary.put(currLine[0], currLine[1]);
            } else {
                dictionary.put(currLine[0], "");
            }
        }
    }

    public String getDefinition(String word) {
        if (!dictionary.containsKey(word.toUpperCase())) {
            return null;
        }
        return (String) dictionary.get(word.toUpperCase());
    }

    public boolean doesExist(String word) {
        return dictionary.containsKey(word.toUpperCase());
    }

    public Set getList() {
        return dictionary.keySet();
    }
}
