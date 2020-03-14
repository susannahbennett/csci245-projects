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
public class Map implements Command {

	
	private Player p1;
	
	/**
	 * Constructor
	 */
	public Map(Player p1) {
		this.p1 = p1;
		
	}

	/** 
	 *
	 */
	@Override

	public void doSomething(String[] command) {
		HashMap<String, Room> seenRooms = p1.returnMap();
		Iterator<String> i = seenRooms.keySet().iterator();
		System.out.println("Rooms you've been to so far: ");
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		
		
	}

	@Override
	public String getDescription() {return "List out rooms that you have visited"; }

	
}
