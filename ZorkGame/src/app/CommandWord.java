package app;

import java.io.Serializable;

class CommandWord implements Serializable
{
    private static final String validCommands[] = {
        "go", "back", "quit", "help", "eat", "use", "take", "drop", "give", "hit", "smash", "fight", "attack", "battle", "brawl", "n", "e", "s", "w", "u", "d",
        "items", "save", "swim","look"
    };

    public CommandWord()
    {
    }

    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++)
        {
            if(validCommands[i].equals(aString))
                return true;
        }
        return false;
    }

    public void showAll() 
    {
        for(int i = 0; i < validCommands.length; i++)
        {
            System.out.print(validCommands[i] + "  ");
        }
        System.out.println();
    }
}