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
	 * 
	 */
	private Parser p;
	
	/**
	 * @param p1
	 * @param itemname
	 */
	public PickUp(Player p1, Parser p) {
		this.p1 = p1;
		this.p = p;
	}

	/**
	 * 
	 */
	public void doSomething(String[] command) {
		HashMap<String, Item> items = p1.getCurrentRoom().getItemMap();		
		if(command[1].equals("all")) {
			Iterator<String> i = items.keySet().iterator();
			while(i.hasNext()) {
				String s = i.next();
				Item thing = items.get(s);
				p1.addToInventory(s, thing);
				thing.addFunctionality(p1, p);
				p1.getCurrentRoom().removeItem(s);
			}
		}else {
			System.out.println(command[1]);
			if(items.containsKey(command[1])) {
				p1.addToInventory(command[1], items.get(command[1]));
				items.get(command[1]).addFunctionality(p1, p);
				p1.getCurrentRoom().removeItem(command[1]);
			}
			else 
				System.out.println("That item does not exist");
		}
	}

	/**
	 * 
	 */
	public String getDescription() { return "pick up a specific item in the room"; }

}
