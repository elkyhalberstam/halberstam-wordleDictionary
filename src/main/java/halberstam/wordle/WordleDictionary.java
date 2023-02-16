package halberstam.wordle;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class WordleDictionary {
    private File file;
    private ArrayList<String> wordList = new ArrayList<>();
    private ArrayList<String> definitionList = new ArrayList<>();

    public WordleDictionary() throws IOException {
        this.file = new File("src/main/java/halberstam/wordle/dictionary.txt");
        loadingDictionary();
    }

    private void loadingDictionary() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            String[] currLine = line.split(" ", 2);
            wordList.add(currLine[0]);
            if(currLine.length>1)
            {
                definitionList.add(currLine[1]);
            }else{
                definitionList.add("");
            }
        }
    }

    public String getDefinition(String word) {
        int idxWord = wordList.indexOf(word.toUpperCase());
        if(idxWord < 0)
        {
            return null;
        }
        return definitionList.get(idxWord);
    }

    public ArrayList<String> getList() {
        return wordList;
    }
}
