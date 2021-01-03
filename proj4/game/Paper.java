package game;

/**
 * Paper.java
 * 
 * The class that represents the paper item
 *
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public class Paper implements Item {
	/**
	 * What the paper says
	 */
	private String contents;
	
	/**
	 * Determines whether or not the words on the paper are readable.  Will be false if the contents are hidden.
	 */
	private boolean readable;
	
	/**
	 * Reveals texture/other clues about the paper
	 */
	private String inspection; 
	
	/**
	 * Constructor to initializes the contents of the paper
	 * 
	 * @param s The contents on the paper
	 */
	public Paper(String s, boolean readable) {
		contents=s;
		this.readable = readable;
	}
	
	/**
	 * When the use command is entered, the paper will print its contents
	 * 
	 * @param p1 The reference to the player for the new command.
	 */
	public void function(Player p1) {
		if(readable) 
			System.out.println(contents);
		else 
			System.out.println("This paper appears to be blank... you may need another item to reveal its contents.");
	}
	
	/**
	 * Reveals more information about the paper item to the user.
	 * 
	 * @param p1 The reference to the player for the new command.
	 */
	public void inspect(Player p1) { System.out.println("\n" + inspection); }
	
	/**
	 * Paper does not add any new commands for player to use
	 * 	
	 * @param p1 The reference to the player for the new command.
	 * @param p The reference to the parser to add a command.
	 */
	public void addFunctionality(Player p1, Parser p) {}
	
	/**
	 * Will make message now readable, if it previously was not.
	 */
	public void editItem() { readable = true; }
	
	/**
	 * Adds additional information to the paper item
	 * 
	 * @param s String holding the assigned extra details
	 */
	public void addInspection(String s) { inspection = s; }
	
	/**
	 * Returns the item's purpose when the help command is used
	 * 
	 * @return String of the items purpose
	 */
	public String getDescription() { return "Miscellaneous paper that can have hints to be used later on"; }
	
	/**
	 * Paper does not remove functionality
	 * 
	 * @param p The reference to the parser to remove a command
	 */
	public void removeFunctionality(Parser p) {}

}
