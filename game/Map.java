/**
 * 
 */
package game;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author susannahbennett
 *
 */
public class Map implements Command {

	private Scanner keyboard;
	private Player p1;
	private Game game;
	
	/**
	 * Constructor
	 */
	public Map(Player p1) {
		this.p1 = p1;
		game = p1.getGame();
	}

	/** 
	 *
	 */
	@Override

	public void doSomething(String[] command) {
		HashMap<String, Room> seenRooms = p1.returnDMap().returnMap();
		Iterator<String> i = seenRooms.keySet().iterator();
		System.out.println("Rooms you've been to so far: ");
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		System.out.println("Which room would you like to transport into? Otherwise type \"quit\"");
		keyboard = new Scanner(System.in);
		String room = keyboard.next();
		if(!room.equals("quit")) {
			if(seenRooms.containsKey(room)) {
				Room nextRoom = seenRooms.get(room);
				game.setCurrentRoom(nextRoom);
				p1.setCurrentRoom(nextRoom);
			}else {
				System.out.println("Not an accessible room");
				return;
			}
		}else {
			return;
		}
		
	}

	
}
