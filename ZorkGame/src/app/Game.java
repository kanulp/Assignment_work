package app;

import java.util.ArrayList;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private Item seaWeed;
    
    public Game() 
    {
        
        inventory = new ArrayList<Item>();
        parser = new Parser();
        seaWeed = new Item("Seaweed");
        createRooms();
    }

   private void createRooms()
    {
        Room oceanGrotto, outsideFortress, fortressWallEast, fortressWallWest,
                insideFortress, secretTunnel, tunnelEnd, bavesStable, sunkenShip, 
                caviarUniversity, parkingLot, murkeyWaters, otterOasis,
                mysteriousCloud, dryLands, caveEntrance, caveInside,
                darkCrevace, crevaceDown, crevaceBottom;
      
        // create the rooms
        oceanGrotto = new Room("in the whales territory");
        outsideFortress = new Room("the gate of the sharks fortress");
        fortressWallEast = new Room("The eastern stone wall of the fortress");
        fortressWallWest = new Room("western stone wall of the fortress");
        insideFortress = new Room("inside the fortress");
        secretTunnel = new Room("inside the hidden tunnel");
        tunnelEnd = new Room("end of the tunnel");
        bavesStable = new Room("the seahorses house");
        sunkenShip = new Room("a sunken ship");
        caviarUniversity = new Room("Fish school");
        parkingLot = new Room("parking lot behind the school");
        murkeyWaters = new Room("Polluted waters");
        otterOasis = new Room ("Home of the otters");
        mysteriousCloud = new Room("a mysterious cloud above the water");
        dryLands = new Room("area above the ocean");
        caveEntrance = new Room("entrance to the abandoned cave");
        caveInside = new Room("inside  the cave");
        darkCrevace = new Room("a dark hole in the ground");
        crevaceDown = new Room ("deep in the dark crevace");
        crevaceBottom = new Room("the bottom of the crevace");
        
        // initialise room exits
        oceanGrotto.setExit("east", murkeyWaters);
        oceanGrotto.setExit("south", caviarUniversity);
        oceanGrotto.setExit("west", bavesStable);
        oceanGrotto.setExit("north", outsideFortress);
        
        //Add extra exit DOWN later
        bavesStable.setExit("east", oceanGrotto);
        bavesStable.setExit("south", sunkenShip);
        bavesStable.setExit("north", fortressWallWest);
        
        secretTunnel.setExit("north", tunnelEnd);
        secretTunnel.setExit("up", bavesStable);
        
        tunnelEnd.setExit("south", secretTunnel);
        
        fortressWallWest.setExit("south", bavesStable);
        fortressWallWest.setExit("east", outsideFortress);
        
        fortressWallEast.setExit("south", murkeyWaters);
        fortressWallEast.setExit("west", outsideFortress);
        
        outsideFortress.setExit("south", oceanGrotto);
        outsideFortress.setExit("east", fortressWallEast);
        outsideFortress.setExit("west", fortressWallWest);
        
        sunkenShip.setExit("north", bavesStable);
        sunkenShip.setExit("east", caviarUniversity);
        
        caviarUniversity.setExit("north", oceanGrotto);
        caviarUniversity.setExit("east", otterOasis);
        caviarUniversity.setExit("west", sunkenShip);
        
        parkingLot.setExit("north", caviarUniversity);
        
        murkeyWaters.setExit("north", fortressWallEast);
        murkeyWaters.setExit("east", caveEntrance);
        murkeyWaters.setExit("south", otterOasis);
        murkeyWaters.setExit("west", oceanGrotto);
        
        otterOasis.setExit("north", murkeyWaters);
        otterOasis.setExit("east", darkCrevace);
        otterOasis.setExit("south", mysteriousCloud);
        otterOasis.setExit("west", caviarUniversity);
        
        mysteriousCloud.setExit("north", otterOasis);
        mysteriousCloud.setExit("up", dryLands);
        
        caveEntrance.setExit("east", caveInside);
        caveEntrance.setExit("west", murkeyWaters);
        
        caveInside.setExit("west", caveEntrance);
        
        darkCrevace.setExit("west", otterOasis);
        darkCrevace.setExit("down", crevaceDown);
        
        crevaceDown.setExit("up", darkCrevace);
        
        crevaceBottom.setExit("up", crevaceDown);
        
        dryLands.setExit("down", mysteriousCloud);
        
        oceanGrotto.addItem(seaWeed);
        currentRoom = oceanGrotto;
    }
    
    public void play() 
    {            
        printWelcome();

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zork!");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        String commandWord = command.getCommandWord().toUpperCase();
		
        switch (commandWord) {
            case "UNKNOWN":
                System.out.println("I don't know what you mean...");
                break;

            case "HELP":
                printHelp();
                break;

            case "SWIM":
                swimRoom(command);
                break;

            case "QUIT":
                wantToQuit = quit(command);
                break;
            
            case "LOOK":
                System.out.println(currentRoom.getLongDescription());
                System.out.println(currentRoom.getItem());
                break;
        }
        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around the ocean flo'.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void swimRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Swim where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("The water is too polluted, you cant go there!");
        }
        else {
			currentRoom = nextRoom;
			System.out.println(currentRoom.getShortDescription());
            
    }
}   private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
   
}
