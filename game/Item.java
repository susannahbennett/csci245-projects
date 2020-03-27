package game;


/**
 * Item.java
 * 
 * The supertype for all items in the game
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public interface Item {

	/**
	 * This is what will be executed upon the "use" command.
	 * 
	 * @param p1 The reference to the player
	 */
	void function(Player p1);
	
	/**
	 * This is what will be executed upon the "inspect" command.
	 * 
	 * @param p1 The reference to the player.
	 */
	void inspect(Player p1);
	
	
	/**
	 * This will add any additional abilities to the HashMap of commands if the item requires new functionality,
	 * otherwise this will be empty.
	 * 
	 * @param p1 The reference to the player.
	 * @param p The reference to the parser to add the new command to the HashMap of commands.
	 */
	void addFunctionality(Player p1, Parser p);
	
	/**
	 * This will add any remove abilities from the HashMap of commands if the item that is dropped gives new functionality,
	 * otherwise this will be empty.
	 *
	 * @param p The reference to the parser to add the new command to the HashMap of commands.
	 */
	void removeFunctionality(Parser p);
	
	/**
	 * This gives each instance of an item a specific message to print when inspected
	 * 
	 * @param s The string that will print out
	 */
	void addInspection(String s);
	
	/**
	 * Will return the description of each item for the Help feature.
	 * @return A description of the item.
	 */
	String getDescription();
}
