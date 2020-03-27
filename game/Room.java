package game;

import java.util.*;

/**
 * Room.java
 * 
 * Class to model a room in the game.
 *
 * @author Thomas VanDrunen
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */

public class Room {
	
	/**
	 * The map of exits accessible from this room
	 */
	private HashMap<String, Exit> exitmap = new HashMap<>();

	/**
	 * The player's inventory
	 */
	private HashMap<String, Item> itemmap = new HashMap<String, Item>();
	
	/**
	 * The puzzle associated with the room, if there is one
	 */
	private Puzzle roomchallenge;
	
	/**
	 * Description of the room
	 */
    private String description;
    
    /**
     * Further instruction with the room
     */
    private String instructions;
    
    /**
     * Determines if the player is able to move out of the room
     */
    private boolean canmove = true;
    
    /**
     * What will be printed if the room is inspected with the magnifying glass
     */
    private String inspection = "Inspection";
    
    /**
     * Name of the room
     */
    private String name = "";

    /**
     * Constructor.
     * 
     * @param description A String naming this room.
     * @param instruction Sets the scene of the room and provides instruction
	 */
    public Room(String description, String instructions) { 
    	this.description = description; 
    	this.instructions = instructions;
    }

    /**
     * Give the room an exit
     */
    public void setExit(String str, Exit e) { exitmap.put(str, e); }
    
    /**
     * Accesses the HashMap of available exits
     * 
     * @return A map of Exits
     */
	public HashMap<String, Exit> getExitMap() { return exitmap; }
	
	/**
	 * Returns an exit with a specific description
	 * 
	 * @return An Exit
	 */
	public Exit getExit() { return exitmap.get(description); }
    
	/**
     * Retrieve a description of this room (to the user).
     * 
     * @return The description
     */
    public String getDescription() { return description; }
    
    /**
     * Sets the description of the room
     * 
     * @param s The new description
     */
    public void setDescription(String s) { description = s; }
    
    /**
     * Returns the item map
     * 
     * @return itemmap The HashMap of items in a room
     */
    public HashMap<String, Item> getItemMap() { return itemmap; }
    
    /**
     * Takes an item out of the room
     * 
     * @param item The item to remove
     */
    public void removeItem(String item) { itemmap.remove(item); }


    /**
     * Gets the Puzzle associated with the room
     * 
     * @return The Puzzle
     */
    public Puzzle getProblem() { return roomchallenge; }
    
    /**
     * This is what will run when the room is inspected
     */
    public void inspect() { System.out.println(inspection); }

    /**
     * Adds an item to the room's inventory
     * 
     * @param str
     * @param item
     */
    public void addItem(String str, Item item) { itemmap.put(str, item); }
    
    /**
     * Sets the puzzle associated with the room
     * @param p
     */
    public void setRoomProblem(Puzzle p) {
    	canmove = false;
    	roomchallenge = p;
    }
    
    /**
     * Gets whether or not the player can move from the room
     * 
     * @return True if the player can move, false if not
     */
    public boolean getCanMove() { return canmove; }
    
    /**
     * Sets canmove to true
     */
    public void setCanMove() { canmove = true; } 
    
    /**
     * Give the room a new thing to print when inspected
     * 
     * @param s The new string
     */
    public void setInspection(String s) { inspection = s; }

	/**
	 * Gets the instructions for the room
	 * 
	 * @return the instructions
	 */
	public String getInstructions() { return instructions; }

	/**
	 * Gives the room new instructions
	 * 
	 * @param instructions the instructions to set
	 */
	public void setInstructions(String i) { instructions = i; }
	
	/**
	 * Sets the name 
	 */
	public void setName(String s) { name = s; }
	
	/**
	 * Gets the name of the room
	 * 
	 * @return The name
	 */
	public String getName() { return name; }
}	
