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
    public void setNorth(Room north) { map.put("north",north); }
    public void setSouth(Room south) { map.put("south",south);}
    public void setEast(Room east) { map.put("east",east);}
    public void setWest(Room west) { map.put("west",west); }

	
    /**
     * Retrieve a description of this room (to the user).
     */
    public String getDescription() { return description; }
    
    /**
     * Methods to determine the rooms to which various
     * doors-- if they exist-- lead.
     */
    public Room getNorth() { return map.get("north"); }
    public Room getSouth() { return map.get("south");  }
    public Room getEast() { return map.get("east");  }
    public Room getWest() { return map.get("west"); }
    
    public void addKey() {
    	itemarray.add(new Key());
    }
   

	
}
