package halberstam.wordle;

import java.io.*;
import java.util.ArrayList;

public class WordleDictionary
{
    private File file;
    private ArrayList<String> masterList = new ArrayList<>();
    //private final ArrayList<String> definition = new ArrayList<>();


    public WordleDictionary(String filePath) throws IOException
    {
        this.file = new File(filePath);
        loadingDictionary();
    }

    private void loadingDictionary() throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null)
            masterList.add(line);
    }

    public String getDefinition(String word)
    {
        String retval = null;
        boolean isFound = false;
        int currWord = 0;
        while(!isFound && currWord < masterList.size())
        {
            String[] currLine = masterList.get(currWord).split(" ", 2);
            if(currLine[0].equalsIgnoreCase(word))
            {
                isFound = true;
                retval = currLine[1];
            }
            currWord++;
        }
        return retval;
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
