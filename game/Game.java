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

        Room[] rooms = new Room[7];
        for (int i = 0; i < rooms.length; i++)
            rooms[i] = new Room("room " + i + ":");

      /*
        rooms[0].setExit("room 1", exit0S);
        rooms[1].setExit("room 0", exit1N);//from room 1 back to room 0
        rooms[1].addItem("dynamic map",new DynamicMap());
        rooms[1].setExit("room 2", room2E);
        rooms[2].setExit("room 1", );//from room 2 back to room 1
    	*/
        
        /*needed simpler world for testing but didnt want to delete this
        rooms[0].setExit("room 1", new LockedDoorExit(rooms[1], keytoroom1));
        rooms[1].setExit("room 0",new NormalExit(rooms[0])); //from room 1 back to room 0
        rooms[1].setExit("room 2", new NormalExit(rooms[2]));
        rooms[2].setExit("room 1", new NormalExit(rooms[1]));//from room 2 back to room 1
        rooms[1].setExit("room 3", new NormalExit(rooms[3]));
        rooms[3].setExit("room 2", new NormalExit(rooms[1]));//from room 3 back to room 1
        rooms[3].setExit("room 4", new NormalExit(rooms[4]));
        rooms[4].setExit("room 3", new NormalExit(rooms[3]));//from room 4 back to room 3
        rooms[4].setExit("to infinity and beyond", null);
        rooms[2].setRiddle("Mary's mother has four kids. The names of the first three are Summer, Autumn, Winter. What's the name of the four kid?", "Mary");
        rooms[0].addItem("Key to room 1", keytoroom1);
        rooms[1].addItem("dynamic map", new DynamicMap());
        */
       
        //making sure I didnt break anything
        //outside the house
      
        rooms[0].setExit("to the entryway", new NormalExit(rooms[1]));
        rooms[0].setExit("back", new NullExit(rooms[0]));
        //testing keys and locked doors
        
        Key keytoroom2 = new Key();
        rooms[1].setExit("to room 2", new LockedDoorExit(rooms[2], keytoroom2));
        rooms[1].setExit("back", new NormalExit(rooms[0]));
        DynamicMap m = new DynamicMap();
        rooms[1].addItem("dynamic map", m);
        rooms[1].addItem("key to room 2", keytoroom2);

        //testing Puzzle exits
        rooms[2].setExit("to room 3", new ProblemExit(rooms[3], new Puzzle("Password is password", "password", null)));
        rooms[2].setExit("back", new NormalExit(rooms[1]));
       
        //testing magnifying glass
        rooms[3].setExit("to room 4", new NormalExit(rooms[4]));
        rooms[3].setExit("back", new NormalExit(rooms[2]));
        MagnifyingGlass glass = new MagnifyingGlass();
        //DynamicMap m = new DynamicMap();
        rooms[3].addItem("magnifying glass", glass);
       // rooms[3].addItem("dynamic map", m);
        rooms[3].setInspection("The room's inspection");
        
        rooms[4].setExit("to room 5", new ProblemExit(rooms[5], new Puzzle("Unscramble given letters. (Hint: find paper item in room)", "ELEPHANT", null)))
        rooms[4].setExit("back", new NormalExit(rooms[3]));
        //rooms[4].setExit("to gameover1", new DeathExit());
        Paper scrambledWord = new Paper("ATEPLHEN");
        rooms[4.addItem("scrambled word", word);
        Key keytohiddenexit = new Key();
        rooms[4].addItem("key to hidden exit", keytohiddenexit);
        
        rooms[5].setExit("to room 7", new NormalExit(rooms[6]));
        rooms[5].setExit("back", new NormalExit(rooms[4]));
        rooms[5].setExit("to room 6, deadend", new NormalExit(rooms[6]));
        Paper clue1 = new Paper("What is greater than God,\nmore evil than the devil,\nthe poor have it,\nthe rich need it,\nand if you eat it, you'll die?");
        rooms[5].addItem("clue1", clue1);
        
        //dead end room, so only one exit (back)
        rooms[6].setExit("back", new NormalExit(rooms[5]));
        
        rooms[7].setExit("back", new NormalExit(rooms[5]));
        //rooms[7].setExit("to gameover2", new DeathExit());
        //rooms[7].setExit("to gameover3", new DeathExit());
        rooms[7].setExit("to room 8", new ProblemExit(rooms[8], new Puzzle("Answer the riddle that was already given", "Nothing", null)));
        
        HashMap<String, Item> requireditems = new HashMap<>();
        requireditems.put("magnifying glass", glass);
        requireditems.put("key to room 2", keytoroom2);
        requireditems.put("dynamic map", m);

        /**
        // rooms[4].setExit("to room 5", new InventoryExit(rooms[5], requireditems));

        rooms[4].setExit("to room 5", new InventoryExit(rooms[5], requireditems));
        rooms[4].setExit("back", new NormalExit(rooms[3]));
        
        //testing null exits
        rooms[5].setExit("null", new NullExit(rooms[5]));
        rooms[5].setExit("back", new NormalExit(rooms[4]));
        
        over = false;
        currentRoom = rooms[0];
        */
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
