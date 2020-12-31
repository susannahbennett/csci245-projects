package game;

/**
 * Key.java
 * 
 * This class represents the keys in the game that unlocks "doors" and allows player to move through
 * LockedDoorExits
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public class Key implements Item {
	
	/**
	 * What will be printed upon inspection
	 */
	private String inspection = "";
	
	/**
	 * Constructor
	 * 
	 * Builds an instance of Key
	 */
	public Key() {}
	
	/**
	 * The key has no real function
	 */
	public void function(Player p1) {}
	
	/**
	 * When the key is inspected, it will print a message
	 * 
	 * @param p1 the reference to the player
	 */
	public void inspect(Player p1) { System.out.println("\n" + inspection); }
	
	/**
	 * The key does not add any extra functionality.
	 * 
	 * @param p1 The reference to the player for the new command.
	 * @param p The reference to the parser to add the command.
	 */
	public void addFunctionality(Player p1, Parser p) {}
	
	/**
	 * Keys do not need to be edited
	 */
	public void editItem() {}
	
	/**
	 * Gives a new String to be printed out upon inspection
	 * 
	 * @param s the new String
	 */
	public void addInspection(String s) { inspection = s; }
	
	/**
	 * Gives the key's description
	 * 
	 * @return String description
	 */
	public String getDescription() { return "Used to unlock doors and when inspected, it will print a message"; }

	/**
	 * Key does not remove any extra functionality.
	 * 
	 * @param p The reference to the parser to remove a command.
	 */
	public void removeFunctionality(Parser p) {}
}
