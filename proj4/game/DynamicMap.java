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
	private String inspection;
	
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
		Room treehouse = new Room("a treehouse", "You open your eyes, and you are in a small wooden box overlooking the backyard."+
		"You can't seem to remember quite how you got there, but the map in your hands refreshes your memory."
		+ " The floorboards creak as you carefully snoop around. ");
		
		if(!seenRooms.containsKey("treehouse")) {
			p1.updateMap("treehouse", treehouse);
		}
		
		
		Paper book1 = new Paper("Declaration of Independence for Dummies",true);
		book1.addInspection("Hmm... it looks someone wrote a joke on the over: \n"
				+ "Q. Why couldn’t the two elephants go swimming together?\n" + 
				"A. Because they only had one pair of trunks!");
		Paper book2 = new Paper("Nicolas Cage: A Biography",true);
		book2.addInspection("It looks like this book was signed by Nicolas Cage himself!");
		Paper piece1 = new Paper("7", true); // in treehouse
		piece1.addInspection("The paper appears to be ripped... look for missing pieces to complete the message");
		treehouse.addItem("torn paper 1", piece1);
		treehouse.addItem("old book", book1);
		treehouse.addItem("book with green cover", book2);

		Iterator<String> i = seenRooms.keySet().iterator();
		System.out.println("Rooms you've been to so far (and hidden rooms): ");
		while (i.hasNext()) 
			System.out.println(Game.GREEN + i.next() + Game.RESET);			
	}
	
	/**
	 * Reveals more information about the dynamic map to the user.
	 * 
	 * @param p1 The reference to the player for the new command.
	 */
	public void inspect(Player p1) { System.out.println("\n" + inspection); }
	
	/**
	 * Gives the user the ability to travel when the map is in the player's inventory.
	 * 
	 * @param p1 The reference to the player for the new command.
	 * @param p The reference to the parser to add the command.
	 */
	public void addFunctionality(Player p1, Parser p) {	p.addCommand("travel", new Travel(p1)); }
	
	/**
	 * Dynamic Map has no edits to be implemented or changed.
	 */
	public void editItem() { }
	
	/**
	 * Gives the user the ability to travel when the map is in the player's inventory.
	 * 
	 * @param p1 The reference to the player for the new command.
	 * @param p The reference to the parser to add the command.
	 */
	public void removeFunctionality(Parser p) {	p.removeCommand("travel"); }
	
	/**
	 * Gives a new String to be printed out upon inspection
	 * 
	 * @param s the new String
	 */
	public void addInspection(String s) { inspection = s; }
	
	/**
	 * Gives the DynamicMap's description
	 * 
	 * @return String description
	 */
	public String getDescription() {
		return "Lists all of the previously seen rooms (and hidden rooms), letting the player"
				+ " know that those room are now available by" + Game.CYAN + "Travel";
	}
}
