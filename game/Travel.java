package game;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Travel.java
 * 
 * The command to move to any room the player's been to already, using the dynamic map
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
	 * Constructor
	 * 
	 * @param p1 The reference to the player.
	 */
	public Travel(Player p1) {
		this.p1 = p1;
		game = p1.getGame();
	}
	
	/**
	 * When the command travel is used, this method is called to move the player to another room
	 * 
	 * @param command String[] of the user's input from parser, containing the room to move to
	 */
	public void doSomething(String[] command) {
			HashMap<String, Room> seenRooms = p1.returnMap();
			
			if(seenRooms.containsKey(command[1])) {
				Room nextRoom = seenRooms.get(command[1]);
				game.setCurrentRoom(nextRoom);
				p1.setCurrentRoom(nextRoom);
				System.out.println("You are in the " + nextRoom.getDescription() + "\n");
				if(nextRoom.getSeenRoom() == false) {
					System.out.println(nextRoom.getInstructions());
					p1.getCurrentRoom().setSeenRoom();
				}
			}else 
				System.out.println("Not an accessible room");
	}

	/**
	 * Returns a String of the command travel's purpose
	 * 
	 * @return String of the travel command's purpose
	 */
	public String getDescription() {return "Travel to any room you have visted immediatley"; }

}
