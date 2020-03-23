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
	public void inspect(Player p1) { System.out.println(inspection); }
	
	/**
	 * Keys do not give any added ability
	 */
	public void addFunctionality(Player p1, Parser p) {}
	
	/**
	 * Gives a new String to be printed out upon inspection
	 * 
	 * @param s the new String
	 */
	public void addInspection(String s) { inspection = s; }

}
