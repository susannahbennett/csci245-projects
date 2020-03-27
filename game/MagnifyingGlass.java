package game;

/**
 * MagnifyingGlass.java
 * 
 * This class represents the magnifying glass which allows the player to further inspect rooms and 
 * items
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020 
 */
public class MagnifyingGlass implements Item {

	/**
	 * What will be printed upon inspection
	 */
	private String inspection = ("You are using the" + Game.BLUE + " magnifying glass " + Game.RESET + "to inspect the" + Game.BLUE + "magnifying glass" + Game.RESET);

	/**
	 * Constructor
	 * 
	 * Builds an instance of the MagnifyingGlass.
	 */
	public MagnifyingGlass() {}

	
	/**
	 * Print out text when the item is attempted to be used
	 * 
	 * @param p1 The reference to the player
	 */
	public void function(Player p1) {
		System.out.println("You can use the inspect command to use the magnifying glass to inspect items");
	}
	
	/**
	 * Print out text when the item is inspected
	 * 
	 * @param p1 The reference to the player
	 */
	public void inspect(Player p1) {
		System.out.println("\n" + inspection);
	}

	/**
	 * Will give the player the ability to inspect items and rooms
	 * 
	 * @param p1 The reference to the player to construct the command
	 * @param p The reference to the parser to add the command
	 */
	public void addFunctionality(Player p1, Parser p) { p.addCommand("inspect", new Inspect(p1)); }

	/**
	 * Magnifying glass does not need to be edited
	 */
	public void editItem() {}
	
	/**
	 * Gives a new String to be printed out upon inspection
	 * 
	 * @param s the new String
	 */
	public void addInspection(String s) { inspection = s; }


	/**
	 * Gets the description of the Magnifying glass
	 * 
	 * @return The description
	 */
	public String getDescription() { return "Will give the player the ability to inspect items and rooms"; }


	/**
	 * Will take away the player's the ability to inspect items and rooms
	 * 
	 * @param p The reference to the parser to add the command
	 */
	public void removeFunctionality(Parser p) { p.removeCommand("inspect"); }

}
