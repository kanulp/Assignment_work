package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.StringTokenizer;

class Parser implements Serializable 
{

    private CommandWord commands;

    public Parser() 
    {
        commands = new CommandWord();
    }

    public Command getCommand() 
    {
        String inputLine = "";
        String word1;
        String word2;
        String word3;
        String word4;

        System.out.print("> ");

        BufferedReader reader = 
            new BufferedReader(new InputStreamReader(System.in));
        try {
            inputLine = reader.readLine();
        }
        catch(java.io.IOException exc) {
            System.out.println ("There was an error during reading: "
                                + exc.getMessage());
        }

        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        if(tokenizer.hasMoreTokens())
            word1 = tokenizer.nextToken();
        else
            word1 = null;
        if(tokenizer.hasMoreTokens())
            word2 = tokenizer.nextToken();
        else
            word2 = null;
        if(tokenizer.hasMoreTokens())
            word3 = tokenizer.nextToken();
        else
            word3 = null;
        if(tokenizer.hasMoreTokens())
            word4 = tokenizer.nextToken();
        else
            word4 = null;

        if(commands.isCommand(word1))
            return new Command(word1, word2, word3, word4);
        else
            return new Command(null, word2, word3, word4);
    }

    public void showCommands()
    {
        commands.showAll();
    }
}