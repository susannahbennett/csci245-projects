/**
 * 
 */
package game;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author susannahbennett
 *
 */
public class Look implements Command {

	private Player p1;
	
	/**
	 * Constructor
	 */
	public Look(Player p1) {
		this.p1 = p1;
	}

	/**
	 * Method to find available doors and items in the room.
	 * @param p1, the player 
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
		while (j.hasNext()) {
			System.out.println(Game.BLUE + j.next() + Game.RESET);
		}
	}

	@Override
	public String getDescription() { return "Find out more about your surroundings"; }

}
