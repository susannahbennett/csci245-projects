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
	
	private String correctsol;
	
	/**
	 * 
	 */
	public Solve(Player p1) {
		this.p1 = p1;
		correctsol = p1.getCurrentRoom().getProblem().getSolution();
	}

	/**
	 * 	 
	 */
	public void doSomething(String[] command) {
		if (command[1].equals(correctsol)) {
			p1.getCurrentRoom().problemSolved();
		}
	}

}
