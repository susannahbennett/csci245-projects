/**
 * 
 */
package game;

import java.util.HashMap;


/**
 * @author kaligrose
 *
 */
public class Travel implements Command {
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
	public void doSomething(String[] command) {
		HashMap<String, Room> seenRooms = p1.returnDMap().returnMap();
		if(seenRooms.containsKey(command[1])) {
			Room nextRoom = seenRooms.get(command[1]);
			game.setCurrentRoom(nextRoom);
			p1.setCurrentRoom(nextRoom);
		}else {
			System.out.println("Not an accessible room");
			return;
		}
	}

}
