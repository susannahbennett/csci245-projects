package game;

/**
 * Inspect.java
 * 
 * This represents the command to Inspect either a room or an item. This is used only if the
 * magnifying glass is in the inventory. It will give extra cool clues or things to help advance the game.
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 *
 */
public class Inspect implements Command {

	/**
	 * The reference to the player
	 */
	private Player p1;

	/**
	 * Constructor
	 * 
	 * 
	 */
	public Inspect(Player p1){ this.p1 = p1; }

	/**
	 * Will check to see if the user wants to inspect the room or an item, otherwise it shows that you
	 * cannot inspect whatever was typed in.
	 * 
	 * @param command The thing to be inspected.
	 */
	@Override
	public void doSomething(String[] command) {
		if (p1.getItemList().containsKey(command[1]))
			p1.getItemList().get(command[1]).inspect(p1);
		// else if (command[1].equals("this room"))
		// 	p1.getCurrentRoom().inspect();
		else
			System.out.println("I cannot inspect that");
	}
	
	public String getDescription() { return "Further inspect a room or object"; }
}
