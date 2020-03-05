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
public class DynamicMap implements Item{

	private HashMap<String, Room> seenRooms;	
	
	/**
	 * Constructor
	 */
	public DynamicMap() {
		seenRooms = new HashMap<String, Room>();
	}
	
	public HashMap<String, Room> returnMap (){
		return seenRooms;
	}

	@Override
	public void function(Player p1) {
		HashMap<String, Room> seenRooms = p1.returnDMap().returnMap();
		Iterator<String> i = seenRooms.keySet().iterator();
		System.out.println("Rooms you've been to so far: ");
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		
	}

	@Override
	public void inspect(Player p1) {
		// TODO Auto-generated method stub
		
	}

}
