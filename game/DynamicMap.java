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
	
	private Parser p;
	
	/**
	 * Constructor
	 */
	public DynamicMap(Parser p) {
		seenRooms = new HashMap<String, Room>();
		this.p = p;
	}
	
	public HashMap<String, Room> returnMap (){
		return seenRooms;
	}

	@Override
	public void function(Player p1) {
		HashMap<String, Room> seenRooms = p1.returnMap();
		Iterator<String> i = seenRooms.keySet().iterator();
		System.out.println("Rooms you've been to so far: ");
		while (i.hasNext()) {
			System.out.println(Game.GREEN + i.next() + Game.RESET);
		}
		
	}

	@Override
	public void inspect(Player p1) {
		System.out.println("Cool clues");
	}

	@Override
	public void addFunctionality(Player p1) {
		p.addCommand("travel", new Travel(p1));
		
	}
		
	

}
