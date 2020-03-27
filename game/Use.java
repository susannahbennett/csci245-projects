package game;

import java.util.HashMap;

/**
 * Command.java
 * 
 * Supertype for all class that represent commands in the game
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public class Use implements Command {
	
	/**
	 * The reference to the player
	 */
	private Player p1;
	
	/**
	 * Constructor
	 * 
	 * @param p1 The player
	 */
	public Use(Player p1) { this.p1 = p1; }

	/**
	 * 
	 * 
	 * @param
	 */
	public void doSomething(String[] command) {
		HashMap<String, Item> items = p1.getItemList();
		if (!items.containsKey(command[1])) {
			System.out.println("Inventory does not contain this item");
			return;
		}
		
		items.get(command[1]).function(p1);
	}

	@Override
	public String getDescription() {return "Use an item in your inventory"; }

}
