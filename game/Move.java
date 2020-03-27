package game;

import java.util.*;

/**
 * Move.java
 * 
 * Move command that implements the Command interface.
 * This class "moves" the player to a room and works with the exit links.
 *
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public class Move implements Command {

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
	public Move(Player p1) { this.p1 = p1; }

	/**
	 * If the room exits and the player can move there, it will move the player
	 * 
	 * @param command The full command
	 */
	public void doSomething(String[] command) {
		Room r = p1.getCurrentRoom();
		HashMap<String, Exit> exitmap = r.getExitMap();
		Exit link= exitmap.get(command[1]);
		
		if(!r.getCanMove())
			System.out.println("You cannot move, there is a problem you need to solve");	
		else {
			if(link != null) {
				p1.updateMap(r.getDescription(), r);
				link.use(p1);
				System.out.println(r.getInstructions());
			}else 
				System.out.println("You cannot move there.");	
		}
	}

	
	public String getDescription() { return "Move to another place"; }

}
