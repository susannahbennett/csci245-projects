package game;

import java.util.*;

/**
 * Inventory.java
 * 
 * This class represents the command to see the inventory of the player
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public class Inventory implements Command {

	/**
	 * The reference to the player
	 */
	private Player p1;
	
	/**
	 * Constructor 
	 * 
	 * Initializes the reference to the player.
	 */
	public Inventory(Player p1) { this.p1 = p1;}

	/**
	 * Will get the inventory stored in the player and print it out in blue.
	 * 
	 * @param command This will be ignored
	 */
	public void doSomething(String[] command) {
		Iterator<String> i = p1.getItemList().keySet().iterator();
		System.out.println("Your inventory:");
		while(i.hasNext())
			System.out.println(Game.BLUE + i.next() + Game.RESET);		
	}
	
	/**
	 * Gets the description
	 * 
	 * @return The description
	 */
	public String getDescription() { return "View all items currently in your inventory"; }

}
