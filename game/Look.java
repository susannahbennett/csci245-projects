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
	 * 
	 */
	public void doSomething(Player p1) {
		Room room = p1.getCurrentRoom();
		
		Iterator<String> i = room.getMap().keySet().iterator();
		System.out.println("Surrounding rooms: ");
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}

	@Override
	public void doSomething(Player p1, String itemname) {
		// TODO Auto-generated method stub
		
	}

}
