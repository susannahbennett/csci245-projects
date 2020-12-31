package game;

/**
 * Command.java
 * 
 * Supertype for all class that represent commands in the game
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public interface Command { 
	
	/**
	 * doSomething will what each command will execute upon the user entering
	 * a valid command. 
	 * @param command The String array that contains the command in the 0 index
	 * and whatever information in necessary in the 1 index.
	 */
	void doSomething(String[] command);
	
	
	/**
	 * Will return the description of each command for the Help feature.
	 * @return A description of the command.
	 */
	String getDescription();
	
}
