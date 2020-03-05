/**
 * 
 */
package game;

import java.util.HashMap;

/**
 * Move.java
 * 
 * Move command that implements the Command interface.
 * This class "moves" the player to a room and works with the exit links.
 *
 * @author Steven Barker, Susannah Bennett, and Kali Grose
 * Wheaton College, CS 245, Spring 2020
 */
public class Move implements Command {

	/**
	 * 
	 */
	private Player p1;
	
	/**
	 * 
	 */
	public Move(Player p1) {
		this.p1 = p1;
	}

	/* (non-Javadoc)
	 * @see game.Command#doSomething(java.lang.String[])
	 */
	@Override
	public void doSomething(String[] command) {
		Room r = p1.getCurrentRoom();
		HashMap<String, Exit> map = r.getExitMap();
		Exit link= map.get(command[1]);
		
		
		if(link != null) {
		
			p1.updateMap(r.getDescription(), r);
			link.use(p1);
			
		}
		else {
			System.out.println("You cannot move there.");
		}
	}

}
