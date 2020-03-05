/**
 * 
 */
package game;

import java.util.Iterator;

/**
 * @author kaligrose
 *
 */
public class CheckBag implements Command {

	private Player p1;

	
	/**
	 * 
	 */
	public CheckBag(Player p1) {
		this.p1 = p1;
	}

	/* (non-Javadoc)
	 * @see game.Command#doSomething(java.lang.String[])
	 */
	@Override
	public void doSomething(String[] command) {
		Iterator<String> i = p1.getItemList().keySet().iterator();
		System.out.println("Your Inventory:");
		while(i.hasNext()) {
			System.out.println(Game.BLUE + i.next() + Game.RESET);
		}
		

	}

}
