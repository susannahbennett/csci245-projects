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
	
	private Problem challenge;
	
    private String description;


    /**
     * Constructor.
     * @param description A String describing this room to the user.
     */
    public Room(String description) { 
    	this.challenge = new Riddle("use \"solve\" and \"pass\" to pass", "pass");
    	this.description = description;
    }

    /**
     * Testing Exit idea
     */
    public void setExit(String str, Exit e) {
    	exitmap.put(str, e);
    }
    
    /**
     * 
     */
	public HashMap<String, Exit> getExitMap() {
		return exitmap;
	}
	
	public Exit getExit() {
		return exitmap.get(description);
	}
    /**
     * Retrieve a description of this room (to the user).
     */
    public String getDescription() { return description; }
    
    /**
     * Method to add a key to the item inventory
     */
    public void addKey() {
    	itemmap.put("key", new Key());
    }
    
    /**
     * Returns the item map
     * @return itemmap The HashMap of items in a room
     */
    public HashMap<String, Item> getItemMap() {
    	return itemmap;
    }
    
    
    public void removeItem(String item) {
    	itemmap.remove(item);
    }
    
    public Problem getProblem() {
    	return challenge;
    }

    public void inspect() {
    	System.out.println("This will do interesting functionality");
    }

    public void addItem(String str, Item item) {
    	itemmap.put(str, item);
    }

}
