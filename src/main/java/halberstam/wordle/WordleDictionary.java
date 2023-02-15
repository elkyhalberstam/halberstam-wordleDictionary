package halberstam.wordle;

import java.io.*;
import java.util.ArrayList;

public class WordleDictionary
{
    private File file;
    private ArrayList<String> masterList = new ArrayList<>();

    public WordleDictionary() throws IOException
    {
        this.file = new File("halberstam/wordle/dictionary.txt");
        loadingDictionary();
    }

    private void loadingDictionary() throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null)
        {
            masterList.add(line);
        }
    }

    public String getDefinition(String word)
    {
        int currWord = 0;
        while(currWord < masterList.size())
        {
            String[] currLine = masterList.get(currWord).split(" ", 2);
            if(currLine[0].equalsIgnoreCase(word))
            {
                return currLine[1];
            }
            currWord++;
        }
        return null;
    }

    public ArrayList<String> getList()
    {
        ArrayList<String> retval = new ArrayList<>();
        for(int i=0; i< masterList.size(); i++)
        {
            String[] currLine = masterList.get(i).split(" ", 1);
            retval.add(currLine[0]);
        }
        return retval;
    }
}
