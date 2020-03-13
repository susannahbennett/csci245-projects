/**
 * 
 */
package game;

import java.util.*;

/**
 * @author stevenbarker
 *
 */
public class Inventory implements Command {

	/**
	 * 
	 */
	private Player p1;
	/**
	 * 
	 */
	public Inventory(Player p1) { this.p1 = p1;}

	@Override
	public void doSomething(String[] command) {
		Iterator<String> i = p1.getItemList().keySet().iterator();
		System.out.println("Your inventory:");
		while(i.hasNext()) {
			System.out.println(Game.BLUE + i.next() + Game.RESET);
		}
		
	}

	@Override
	public String getDescription() { return "view all items currently in your inventory"; }

}
