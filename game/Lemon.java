package game;

/**
 * Lemon.java
 * 
 * This class represents the lemon item in the game that reveals a hidden message later in the game
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public class Lemon implements Item {
	
	/**
	 * Constructor 
	 * 
	 * Build instance of a lemon
	 */
	public Lemon() {}
	
	/**
	 * When the use command is entered, the lemon will reveal the hidden message of an item
	 * 
	 * @param p1 The reference to the player for the new command.
	 */
	public void function(Player p1) {
		if (p1.getItemList().containsKey("hidden message")) {
			p1.getItemList().get("hidden message").editItem();
			System.out.println("\nThe blank paper is changing!\n");
		} else {
			System.out.println("You're missing the correct item to use the lemon on.");
		}
	}
	
	/**
	 * Reveals more information about the lemon to the user.
	 * 
	 * @param p1 The reference to the player for the new command.
	 */
	public void inspect(Player p1) { System.out.println("It's a citrus fruit"); }
	
	/**
	 * The lemon item does not add any extra functionality
	 * 
	 * @param p1 The reference to the player for the new command.
	 * @param p The reference to the parser to add a command.
	 */
	public void addFunctionality(Player p1, Parser p) {}
	
	/**
	 * The lemon item does not to be edited
	 */
	public void editItem() {}
	
	/**
	 * The lemon item does not need additional details about it
	 * 
	 * @param s String that would've held additional details
	 */
	public void addInspection(String s) {}
	
	/**
	 * Returns a hint about how the lemon should be used
	 * 
	 * @return String with hint about lemon
	 */
	public String getDescription() { return "May be helpful in revealing messages"; }
	
	/**
	 * The lemon does not remove any functionality
	 * 
	 * @param p The reference to the parser to remove a command.
	 */
	public void removeFunctionality(Parser p) {}
}
