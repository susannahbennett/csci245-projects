/**
 * 
 */
package game;

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
	public void doSomething(Player p1) {
		Iterator<String> i = p1.returnDMap().returnMap().keySet().iterator();
		System.out.println("Rooms you've been to so far: ");
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}

	/**
	 * 
	 */
	@Override
	public void doSomething(Player p1, String itemname) {
		// TODO Auto-generated method stub

	}

}
