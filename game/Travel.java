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
		
		if(p1.getItemList().containsKey("dynamic map")) {
			HashMap<String, Room> seenRooms = p1.returnMap();
			if(seenRooms.containsKey(command[1])) {
				Room nextRoom = seenRooms.get(command[1]);
				game.setCurrentRoom(nextRoom);
				p1.setCurrentRoom(nextRoom);
			}else {
				System.out.println("Not an accessible room");
				return;
			}
		}else {
			System.out.println("I do not know how to travel without a Map.");
		}
	}

}
