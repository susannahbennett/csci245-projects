package game;
import java.util.*;

/**
 * Look.java
 * 
 * This class represents the command to look at all available rooms and items
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public class Look implements Command {
	
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
	public Look(Player p1) { this.p1 = p1; }
	
	/**
	 * Will find and list out all available rooms and available items.
	 * 
	 * @param p1 The reference to the player 
	 */
	public void doSomething(String[] command) {
		Room room = p1.getCurrentRoom();
		HashMap<String, Exit> exitmap = room.getExitMap();
		
		Iterator<String> i = room.getExitMap().keySet().iterator();
		System.out.println("Surrounding rooms: ");
		while (i.hasNext()) {
			Exit e = exitmap.get(i.next());
			if(!(e instanceof NullExit)) 
				System.out.println(Game.GREEN + e.destination().getDescription() + Game.RESET);	
		}
		Iterator<String> j = room.getItemMap().keySet().iterator();
		System.out.println("Available items: ");
		while (j.hasNext()) 
			System.out.println(Game.BLUE + j.next() + Game.RESET);
	}
	
	/**
	 * Returns the purpose of this command when the help command is used
	 * 
	 * @return String describing the look command
	 */
	public String getDescription() { return "Find out more about your surroundings"; }

}
