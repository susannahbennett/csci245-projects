package game;

import java.util.*;

/**
 * Help.java
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
	 * 
	 * @param command String[] of the user's input in Parser.java
	 */
	public void doSomething(String[] command) {
		if (command[1] == null) {
			HashMap<String, Command> commands = p.getCommands();
			Iterator<String> i = commands.keySet().iterator();
			while(i.hasNext()) {
				String com = i.next();
				System.out.println(Game.CYAN + com + Game.RESET + ": " + commands.get(com).getDescription());
			}
		} else {
			String item = command[1];
			HashMap<String, Item> items = p.getItems();
			Iterator<String> i = items.keySet().iterator();
			if(items.containsKey(command[1]))
				System.out.println(Game.CYAN + item + Game.RESET + ": " + items.get(item).getDescription());
			else
				System.out.println("That item does not exist");
		}
	}
	/**
	 * Gets the description of this command.
	 * 
	 * @return The description of the help command
	 */
	public String getDescription() { return "Lists out all known commands. You can also type \""
			+ Game.BLUE + "help" + Game.RESET + "\'some item\'\" " ; }
}
