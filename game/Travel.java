/**
 * 
 */
package game;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author kaligrose
 *
 */
public class Travel implements Command {
	private Scanner keyboard;
	private Player p1;
	private Game game;
	
	/**
	 * 
	 */
	public Travel(Player p1) {
		this.p1 = p1;
		game = p1.getGame();
	}

	/* (non-Javadoc)
	 * @see game.Command#doSomething()
	 */
	@Override
	public void doSomething() {
		HashMap<String, Room> seenRooms = p1.returnDMap().returnMap();
		
		System.out.println("Which room would you like to transport into? Otherwise type \"quit\"");
		keyboard = new Scanner(System.in);
		String room = keyboard.nextLine();
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

	/* (non-Javadoc)
	 * @see game.Command#doSomething(java.lang.String)
	 */
	@Override
	public void doSomething(String itemname) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSomething(String[] command) {
		// TODO Auto-generated method stub
		
	}

}
