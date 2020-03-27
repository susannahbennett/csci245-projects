package game;

/**
 * Message.java
 * 
 * This class represents messages in that can be placed in rooms and interacted with
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public class Message implements Item {

	/**
	 * What will be printed upon inspection
	 */
	private String inspection = "\"Nicholas Cage's fancy signature\"";
	
	/**
	 * The string that is the message
	 */
	private String message;
	
	/**
	 * Constructor
	 *
	 * Initializes the string that is the message
	 *
	 * @param message The message
	 */
	public Message(String message) { this.message = message; }

	/**
	 * Will print out the message when the read command or use command is used
	 */
	public void function(Player p1) {System.out.println(message);}
	

	/**
	 * Will print out the inspection
	 * 
	 * @param p1 The reference to the player
	 */
	public void inspect(Player p1) { System.out.println(inspection); }

	public void addFunctionality(Player p1, Parser p) {}
	
	public void editItem() { }

	/**
	 * Gives a new String to be printed out upon inspection
	 * 
	 * @param s the new String
	 */
	public void addInspection(String s) { inspection = s; }

	/**
	 * Gives the message's description
	 * 
	 * @return String description
	 */
	public String getDescription() {
		return "Will print out the message when the read command or use command is used";
	}
	
}
