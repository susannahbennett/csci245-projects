package game;

import java.util.*;

/**
 * InventoryExit.java
 * 
 * Similar to a locked door with a key except you need to have a 
 * bunch of specified items in your inventory to pass. For example, you 
 * need to have three specific keys and the dynamic map to pass.
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public class InventoryExit implements Exit {
	
	/**
	 * Holds the reference to the room behind the exit
	 */
	private Room nextroom;
	
	/**
	 * Indicates whether the room has been unlocked yet
	 */
	private boolean canuse = false;
	
	
	/**
	 * The list of items required to pass through
	 */
	private HashMap<String, Item> requireditems;
	
	/**
	 * Constructor
	 * 
	 * Initializes the nextroom and the HashMap for the required items.
	 * @param r The reference to the next room
	 * @param i The map of required items
	 */
	public InventoryExit(Room r, HashMap<String, Item> i) {
		nextroom = r;
		requireditems = i;	
	}

	/**
	 * Returns the reference to the next room
	 * 
	 * @return the next room
	 */
	public Room destination() { return nextroom; }

	/**
	 * True if the player can use the exit, false if the player cannot
	 * 
	 * @return whether or not the plater can use the exit
	 */
	public boolean canUse() { return canuse; }

	/**
	 * Will set canuse to true
	 */
	public void setCanUse() { canuse = true; }

	/**
	 * Get the players inventory and check it against the map of things that are 
	 * required to use the exit to determine if the player can pass or not.
	 * 
	 * @param p1 the reference to the player
	 */
	public void use(Player p1) {
		HashMap<String, Item> inventory = p1.getItemList();
		Iterator<String> i = requireditems.keySet().iterator();
		while(i.hasNext()) {
			if(!inventory.containsKey(i.next())) {
				System.out.println("Someone's dog is right outside the door. He looks vicious! You're missing two dog-related items to get past."
						+ "\n Try inspecting items.");
				return;
			}
		}
		System.out.println("You had everything you needed. Looks like little Barky is happy now!");
		p1.setCurrentRoom(nextroom);
		p1.getGame().setCurrentRoom(nextroom);
		setCanUse();
	}

	/**
	 * No problem
	 */
	public Puzzle getProblem() { return null; }

}
