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
	
	private HashMap<String, Exit> exitmap = new HashMap<>();

	private HashMap<String, Item> itemmap = new HashMap<String, Item>();
	
	private Puzzle roomchallenge;
	
    private String description;
    
    private boolean canmove = true;
    
    private String inspection = "Inspection";


    /**
     * Constructor.
     * @param description A String describing this room to the user.
     */
    public Room(String description) { this.description = description; }

    /**
     * Testing Exit idea
     */
    public void setExit(String str, Exit e) { exitmap.put(str, e); }
    
    /**
     * 
     */
	public HashMap<String, Exit> getExitMap() { return exitmap; }
	
	/**
	 * 
	 * @return
	 */
	public Exit getExit() { return exitmap.get(description); }
    
	/**
     * Retrieve a description of this room (to the user).
     */
    public String getDescription() { return description; }
    
    /**
     * 
     */
    public void setDescription(String s) { description = s; }
    
    /**
     * Returns the item map
     * @return itemmap The HashMap of items in a room
     */
    public HashMap<String, Item> getItemMap() { return itemmap; }
    
    /**
     * 
     * @param item
     */
    public void removeItem(String item) { itemmap.remove(item); }

    /**
     * 
     * @return
     */
    public Puzzle getProblem() { return roomchallenge; }
    
    /**
     * 
     */
    public void inspect() { System.out.println(inspection); }

    /**
     * 
     * @param str
     * @param item
     */
    public void addItem(String str, Item item) { itemmap.put(str, item); }
    
    /**
     * Sets the 
     * @param p
     */
    public void setRoomProblem(Puzzle p) {
    	canmove = false;
    	roomchallenge = p;
    }
    
    /**
     * 
     */
    public boolean getCanMove() { return canmove; }
    
    /**
     * 
     */
    public void setCanMove() { canmove = true; } 
    
    /**
     * 
     */
    public void setInspection(String s) { inspection = s; }

}
