package game;

import java.util.HashMap;

/**
 * Game.java
 * 
 * Class to model the game as a collection of rooms. The
 * rooms are organized as a graph, and the Room objects
 * are nodes in the graph.
 *
 * @author Thomas VanDrunen
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */

public class Game {
	
    /**
     * The current room the user is in. This serves to
     * purposes-- it is our only permanent connection to
     * the rooms in this game (the other rooms are reachable
     * by traversing this room's "doors"-- and it maintains
     * the state by representing the user's current location.
     */
    private Room currentRoom;
    
    /**
     * Each of these are used for color coding output to help the user
     * RED: Unused as of now
     * RESET: used after each colored word to keep other text from being colored
     * BLUE: Used for useable, gettable items
     * GREEN: Used for movable places
     * CYAN: Used for executable commands
     */
    public static final String RED = "\u001B[31m";
	public static final String RESET = "\u001B[0m";
	public static final String BLUE = "\u001B[34m";
	public static final String GREEN = "\u001B[32m";
	public static final String CYAN = "\u001B[36m";

    /**
     * Keeps track of whether this game is over or not.
     */
    private boolean over;
    
    /**
     * Return the room in which the user is currently.
     */
    public Room getCurrentRoom() { return currentRoom; }
    
    /**
     * Constructor to set up the game.
     */
    public Game() {

        Room[] rooms = new Room[10];
        rooms[0] = new Room("room 0:\n", " ");
        rooms[1] = new Room("room 1:\n", "Now, you’re in the house. You look around the entryway. Across the room, you notice what looks like a map and a key.\n\n"
        		+ "To pick up the map, enter "+ Game.CYAN + "pickup dynamic map" + Game.RESET + ".\nTo pick up the key, enter " + Game.CYAN + "pickup key to room 2" + Game.RESET + ".\n"
        		+ "From now on, use the "  + Game.CYAN + "look" + Game.RESET + " command (to see what rooms and items are nearby) and the " + Game.CYAN + "move" + Game.RESET + " command (to move to one of the listed rooms). "
        		+ "To get further descriptions of available commands, use the " + Game.CYAN + "help" + Game.RESET + " command.\n");
        rooms[2] = new Room("room 2:\n", " ");
        rooms[3] = new Room("room 3:\n", " ");
        rooms[4] = new Room("room 4:\n", " ");
        rooms[5] = new Room("room 5:\n", " ");
        rooms[6] = new Room("room 6:\n", " ");
        rooms[7] = new Room("room 7:\n", " ");
        rooms[8] = new Room("room 8:\n", " ");
        rooms[9] = new Room("room 9:\n", " ");
        
        rooms[0].setExit("to entryway", new NormalExit(rooms[1]));
        rooms[0].setExit("back", new NullExit(rooms[0]));
        
        Key keytoroom2 = new Key();
        rooms[1].setExit("to room 2", new LockedDoorExit(rooms[2], keytoroom2));
        rooms[1].setExit("back", new NormalExit(rooms[0]));
        DynamicMap m = new DynamicMap();
        rooms[1].addItem("dynamic map", m);
        rooms[1].addItem("key to room 2", keytoroom2);

        rooms[2].setExit("to room 3", new ProblemExit(rooms[3], new Puzzle("Answer this riddle to unlock the door: password is password", "password", null)));
        rooms[2].setExit("back", new NormalExit(rooms[1]));
       
        rooms[3].setExit("to room 4", new NormalExit(rooms[4]));
        rooms[3].setExit("back", new NormalExit(rooms[2]));
        MagnifyingGlass glass = new MagnifyingGlass();
        rooms[3].addItem("magnifying glass", glass);
        rooms[3].setInspection("The room's inspection");
        
        rooms[4].setExit("to room 5", new ProblemExit(rooms[5], new Puzzle("Unscramble given letters to unlock door(Hint: find paper item in room)", "elephant", null)));
        rooms[4].setExit("back", new NormalExit(rooms[3]));
        Paper scrambledWord = new Paper("ateplhen", true);
        rooms[4].addItem("paper with scrambled word", scrambledWord);
        Key keytohiddenexit = new Key();
        rooms[4].addItem("key to hidden exit", keytohiddenexit);
        
        rooms[5].setExit("to room 7", new NormalExit(rooms[7]));
        rooms[5].setExit("back", new NormalExit(rooms[4]));
        rooms[5].setExit("to room 6", new NormalExit(rooms[6]));
        Paper clue1 = new Paper("\nRiddle: What is greater than God,\nmore evil than the devil,\nthe poor have it,\nthe rich need it,\nand if you eat it, you'll die?", true);
        rooms[5].addItem("clue1", clue1);
        
        rooms[6].setExit("back", new NormalExit(rooms[5]));
        Paper deadEndClue = new Paper("\nYou've reached a deadend. Go back.", true);
        rooms[6].addItem("clue2", deadEndClue);
        
        rooms[7].setExit("back", new NormalExit(rooms[5]));
        rooms[7].setExit("to room 8", new ProblemExit(rooms[8], new Puzzle("Answer the riddle that was already given", "nothing", null)));
        Paper hiddenMessage = new Paper("A great treasure lies behind this door; knock to enter", false);
        rooms[7].addItem("hidden message", hiddenMessage);
        
        rooms[8].setExit("back", new NormalExit(rooms[7]));
        rooms[8].setExit("to room 9", new ProblemExit(rooms[9], new Puzzle("When life gives you lemons... try decoding the hidden message", "knock", null)));
        
        HashMap<String, Item> requireditems = new HashMap<>();
        requireditems.put("magnifying glass", glass);
        requireditems.put("key to room 2", keytoroom2);
        requireditems.put("dynamic map", m);

       
        over = false;
        currentRoom = rooms[0];
    }
    
    /**
     * Is this game over or not?
     */
    public boolean isOver() { return over; }

    /**
     * Move into a different current room.
     */
    public void setCurrentRoom(Room currentRoom) { this.currentRoom = currentRoom; }

    /**
     * Indicate that the game is now over.
     */
    public void finishGame() { over = true; }
    
}
