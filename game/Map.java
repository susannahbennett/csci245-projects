package game;

import java.util.*;


/**
 * Map.java
 * 
 * This class represents the command to map out all rooms that the player has previously visted
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public class Map implements Command {

	/**
	 * The reference to the player
	 */
	private Player p1;
	
	/**
	 * Constructor
	 * 
	 * Initializes the player
	 * 
	 * @param p1 The reference to the player
	 */
	public Map(Player p1) { this.p1 = p1; }

	/** 
	 * This will list out all rooms that the player has previously visited
	 * 
	 *  @param command The array containing the command
	 */
	public void doSomething(String[] command) {
		if(p1.getItemList().containsKey("dynamic map")) {
			HashMap<String, Room> seenRooms = p1.returnMap();
			Iterator<String> i = seenRooms.keySet().iterator();
			System.out.println("Rooms you've been to so far: ");
			while (i.hasNext()) 
				System.out.println(i.next());
		}else {
			System.out.println("I do not know where I have been without a map.");
		}
			
	}

	public String getDescription() {return "List out rooms that you have visited"; }

	
}
