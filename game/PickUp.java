/**
 * 
 */
package game;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author stevenbarker
 *
 */
public class PickUp implements Command {

	/**
	 * 
	 */
	public PickUp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	@Override
	public void doSomething(Player p1) {
		Room currentroom = p1.getCurrentRoom();
		HashMap<String, Item> items = currentroom.getItemMap();
		
		String c;
		//Item topickup = items.get(c);
		//p1.pickup(topickup)
		//currentroom.removeItem(c);
		
		
		
		
		

	}

}
