package game;

import java.util.*;


/**
 * DynamicMap.java
 * 
 * This class represents the Dynamic Map which gives the player the ability to fast travel to 
 * any room that has previously been visited to.
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public class DynamicMap implements Item{
	
	/**
	 * What will be printed upon inspection
	 */
	private String inspection = "Cool clues";
	
	/**
	 * Constructor
	 * 
	 * Builds an instance of the DynamicMap.
	 */
	public DynamicMap() {}
	

	/**
	 * When the player uses the dynamic map, it lists out all previously seen rooms in green
	 * letting the player know that those rooms are now available.
	 * 
	 * @param p1 The reference to the player for getting the HashMap of rooms.
	 */
	public void function(Player p1) {
		HashMap<String, Room> seenRooms = p1.returnMap();
		Iterator<String> i = seenRooms.keySet().iterator();
		System.out.println("Rooms you've been to so far: ");
		while (i.hasNext()) 
			System.out.println(Game.GREEN + i.next() + Game.RESET);			
	}
	
	
	public void inspect(Player p1) { System.out.println(inspection); }

	/**
	 * Gives the user the ability to travel when the map is in the player's inventory.
	 * 
	 * @param p1 The reference to the player for the new command.
	 * @param p The reference to the parser to add the command.
	 */
	public void addFunctionality(Player p1, Parser p) {	p.addCommand("travel", new Travel(p1)); }
		
	/**
	 * Gives a new String to be printed out upon inspection
	 * 
	 * @param s the new String
	 */
	public void addInspection(String s) { inspection = s; }

}
