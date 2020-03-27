package game;

import java.util.HashMap;
import java.util.Iterator;

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
public class Travel implements Command {
	
	/**
	 * The reference to the player
	 */
	private Player p1;
	
	/**
	 * The reference to the game
	 */
	private Game game;
	
	/**
	 * 
	 */
	public Travel(Player p1) {
		this.p1 = p1;
		game = p1.getGame();
	}

	
	public void doSomething(String[] command) {
			HashMap<String, Room> seenRooms = p1.returnMap();
			
			if(seenRooms.containsKey(command[1])) {
				Room nextRoom = seenRooms.get(command[1]);
				game.setCurrentRoom(nextRoom);
				p1.setCurrentRoom(nextRoom);
				System.out.println("You are in the " + nextRoom.getDescription() + "\n" + nextRoom.getInstructions());
			}else 
				System.out.println("Not an accessible room");
			
	}

	@Override
	public String getDescription() {return "Travel to any room you have visted immediatley"; }

}
