/**
 * 
 */
package game;

/**
 * @author stevenbarker
 *
 */
public class Solve implements Command {
	
	private Player p1;
	
	/**
	 * 
	 */
	public Solve(Player p1) {
		this.p1 = p1;
	}

	/**
	 * 	 
	 */
	public void doSomething(String[] command) {
		if (command[1].equals(nextexit().getProblem().getSolution())) {
			
		}
	}

}
