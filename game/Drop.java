package game;

import java.util.*;
/**
 * Drop.java
 * 
 * This class is the command to drop items
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020   
 */
public class Drop implements Command {

	/**
	 * The reference to the player
	 */
	private Player p1;

	
	/**
	 * Constructor
	 * 
	 * Initiates The player and parser
	 * 
	 * @param p1
	 * @param itemname
	 */
	public Drop(Player player) {
		p1 = player;
		
	}
	
	
	@Override
	public void doSomething(String[] command) {
		HashMap<String, Item> roomItems = p1.getCurrentRoom().getItemMap();	
		HashMap<String, Item> playerItems = p1.getItemList();
		
		if(playerItems.containsKey(command[1])) {
			roomItems.put(command[1], playerItems.get(command[1]));
			playerItems.remove(command[1]);
		}
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Removes an item from your personal inventory and moves it to the room.";
	}

}
