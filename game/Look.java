/**
 * 
 */
package game;

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
	public void doSomething(Player p1) {
		Room room = p1.getCurrentRoom();
		
		Iterator<String> i = room.getMap().keySet().iterator();
		System.out.println("Surrounding rooms: ");
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		Iterator<String> j = room.getItemMap().keySet().iterator();
		System.out.println("Available items: ");
		while (j.hasNext()) {
			System.out.println(j.next());
		}
	}
	
	public void doSomething(Player p1, String itemname) {
		
	}

	@Override
	public void doSomething(Player p1, String itemname) {
		// TODO Auto-generated method stub
		
	}

}
