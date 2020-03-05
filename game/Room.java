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
	
	private HashMap<String, Exit> linkmap = new HashMap<>();
	
	private HashMap<String,Room> directionMap = new HashMap<String,Room>();

	private HashMap<String, Item> itemmap = new HashMap<String, Item>();
	
	private Problem challenge;
	
	private boolean canmove;
	

    /**
     * A description of this room
     */
    private String description;

    /**
     * Constructor.
     * @param description A String describing this room to the user.
     */
    public Room(String description) { 
    	this.challenge = new Riddle("use \"solve\" and \"pass\" to pass", "pass");
    	this.description = description;
    	canmove = false;
    }
    
    /**
     * Methods for added "doors"-- directional connections to other rooms.
     */
    public void setDirection(String str,Room room) { 
    	directionMap.put(str,room);
    }
    
    /**
     * Testing Exit idea
     */
    public void setLink(String str, Exit e) {
    	linkmap.put(str, e);
    }
	
    /**
     * Retrieve a description of this room (to the user).
     */
    public String getDescription() { return description; }
    
    /**
     * Methods to determine the rooms to which various
     * doors-- if they exist-- lead.
     */
    public Room getDirection(String str) { return directionMap.get(str); }
    
    /**
     * Method to add a key to the item inventory
     */
    public void addKey() {
    	itemmap.put("key", new Key());
    }
    
    /**
     * Method to retrieve direction map
     * @return the map containing the available directions
     */
    public HashMap<String, Room> getMap(){
    	return directionMap;
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
    
    public void problemSolved() {
    	canmove = true;
    }
    
    public boolean enterable() {
    	return canmove;
    }
    
	
}
