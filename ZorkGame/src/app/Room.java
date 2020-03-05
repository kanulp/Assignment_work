package app;

import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<Item> items;
    

   public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        items = new ArrayList<Item>();
    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
   
    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        String longDescription = "You are " + description + ".\n" + getExitString();
        if(items.size() > 0) {
            longDescription += "\nThe following things are here: \n";
            for (Item item : items) {
                longDescription += "\t" + item.getItemName() + "\n";
            }
        }
        return longDescription;
            
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
  
    public void addItem(Item i){
        items.add(i);
    }
    public String getItem() {
     
        return items.toString();
        }
     
}