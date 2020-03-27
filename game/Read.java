package game;

/**
 * Read.java
 * 
 * This class is the command to read an instance of Message
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public class Read implements Command {
	
	/**
	 * The reference to the player
	 */
	private Player p1;
	
	/**
	 * Constructor
	 * 
	 * Initializes the player
	 * 
	 * @param p1 The reference to the player
	 */
	public Read(Player p) { p1 = p; }

	/**
	 * If the message exists, it prints out the message
	 * 
	 * @param command The String array of the command
	 */
	@Override
	public void doSomething(String[] command) {
		if(!p1.getItemList().containsKey(command[1])) {
			System.out.println("That item does not exist, try again");
			return;
		}
		if(p1.getItem(command[1]) instanceof Paper)
			p1.getItem(command[1]).function(p1);
		else
			System.out.println("You cannot read that");
	}

	/**
	 * Gets the description of the command
	 * 
	 * @return The description
	 */
	public String getDescription() {return "Read a message or writting that may be around"; }

}
