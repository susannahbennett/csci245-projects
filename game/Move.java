/**
 * 
 */
package game;

import java.util.HashMap;

/**
 * @author stevenbarker
 *
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
		
		System.out.println("Commnand " + command[1]);
		if(link != null)
			link.use(p1);
		else
			System.out.println("You cannot move there");
	}

}
