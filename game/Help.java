package game;

import java.util.*;

/**
 * Help,java
 * 
 * This class represent the Help command which lists out all possible commands
 * currently available to the player.
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 *
 */
public class Help implements Command {
	
	/**
	 * The reference to the parser to get the HashMap of commands.
	 */
	private Parser p;
	
	/**
	 * Constructor 
	 * 
	 * Initializes the reference to the player.
	 */
	public Help(Player p1, Parser p) { this.p = p; }

	/**
	 * Prints the list of possible commands.
	 */
	public void doSomething(String[] command) {
		HashMap<String, Command> commands = p.getCommands();
		Iterator<String> i = commands.keySet().iterator();
		while(i.hasNext()) {
			String com = i.next();
			System.out.println(Game.CYAN + com + Game.RESET + ": " + commands.get(com).getDescription());
		}
	}

	/**
	 * Gets the description of this command.
	 * 
	 * @return The description of the Help command
	 */
	public String getDescription() { return "Lists out all known commands" ; }
}
