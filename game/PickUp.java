package game;

import java.util.*;
/**
 * PickUp.java
 * 
 * This class is the command to pick up items
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020   
 */
public class PickUp implements Command {

	/**
	 * The reference to the player
	 */
	private Player p1;
	
	/**
	 * The reference to the parser
	 */
	private Parser p;
	
	/**
	 * Constructor
	 * 
	 * Initiates The player and parser
	 * 
	 * @param p1
	 * @param itemname
	 */
	public PickUp(Player player, Parser parser) {
		p1 = player;
		p = parser;
	}

	/**
	 * Looks for the inputed item in the room, if the user input "all" then it picks up everything, otherwise
	 * it will add the desired item to the player's inventory and remove the reference from the room. 
	 * 
	 * @param command The complete command in a String array
	 */
	public void doSomething(String[] command) {
		HashMap<String, Item> items = p1.getCurrentRoom().getItemMap();	
		HashMap<String,Item> playersItems = p1.getItemList();
		if(playersItems.size() <= 6) {
			if(command[1].equals("all")) {
				Iterator<String> i = items.keySet().iterator();
				System.out.println();
				while(i.hasNext()) {
					String s = i.next();
					p1.addToInventory(s, items.get(s));
					System.out.print(s+", ");
					items.get(s).addFunctionality(p1, p);
					i.remove();				
				}
				System.out.print("have been added to your inventory.");
			}else {
				System.out.println(command[1]);
				if(items.containsKey(command[1])) {
					p1.addToInventory(command[1], items.get(command[1]));
					System.out.println(command[1]+" added to your inventory.");
					items.get(command[1]).addFunctionality(p1, p);
					p1.getCurrentRoom().removeItem(command[1]);
				}
				else 
					System.out.println("\nThat item does not exist");
			}
		}else {
			System.out.println("\nYou have reached carrying capacity.  Please drop an item before picking another up.");
		}
	}

	
	public String getDescription() { return "Pick up a specific item in the room"; }

}
