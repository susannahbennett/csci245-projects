package game;

import java.util.ArrayList;
import java.util.HashMap;

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
	
	private HashMap<String,Room> map = new HashMap<String,Room>();
	private ArrayList<Item> itemarray = new ArrayList<Item>();

    /**
     * A description of this room
     */
    private String description;

    /**
     * Constructor.
     * @param description A String describing this room to the user.
     */
    public Room(String description) { 
    	
    	this.description = description; }
    
    /**
     * Methods for added "doors"-- directional connections to other rooms.
     */
    public void setDirection(String str,Room room) { 
    	map.put(str,room);
    	}
   
	
    /**
     * Retrieve a description of this room (to the user).
     */
    public String getDescription() { return description; }
    
    /**
     * Methods to determine the rooms to which various
     * doors-- if they exist-- lead.
     */
    public Room getDirection(String str) { return map.get(str); }
    
    public void addKey() {
    	itemarray.add(new Key());
    }
   

	
}
