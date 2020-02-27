/**
 * 
 */
package game;

import java.util.*;
/**
 * @author stevenbarker
 *
 */
public class PickUp implements Command {

	/**
	 * 
	 */
	private Player p1;

	

	/**
	 * @param p1
	 * @param itemname
	 */
	public PickUp(Player p1) {
		this.p1 = p1;
	}

	/**
	 * 
	 */
	public void doSomething(String itemname) {
		Room currentroom = p1.getCurrentRoom();
		HashMap<String, Item> items = currentroom.getItemMap();
		Item tograb = items.get(itemname);
		p1.addToInventory(itemname, tograb);

	}


	@Override
	public void doSomething() {}

}
