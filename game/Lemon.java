/**
 * 
 */
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
	 * 
	 */
	public void function(Player p1) {
		if (p1.getItemList().containsKey("hidden message")) {
			p1.getItemList().get("hidden message").editItem();
			System.out.println("\nThe hidden message is changing!\n");
		} else {
			System.out.println("You're missing the correct item to use the lemon on.");
		}

	}

	/**
	 * 
	 */
	public void inspect(Player p1) {
		System.out.println("There is nothing to inspect about lemon");
	}

	/**
	 * The lemon item does not add any extra functionality
	 */
	public void addFunctionality(Player p1, Parser p) {}

	/**
	 * The lemon item does not to be edited
	 */
	public void editItem() {}
	
	
	@Override
	public void addInspection(String s) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeFunctionality(Parser p) {
		// TODO Auto-generated method stub
		
	}

}
