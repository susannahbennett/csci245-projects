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
	public void doSomething(String[] command) {
		HashMap<String, Item> items = p1.getCurrentRoom().getItemMap();
		
		if(items.containsKey(command[1])) {
			p1.addToInventory(command[1], items.get(command[1]));
			p1.getCurrentRoom().removeItem(command[1]);
		}
		else {
			System.out.println("That item does not exist");
		}
	}

}
