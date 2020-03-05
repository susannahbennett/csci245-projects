/**
 * 
 */
package game;

/**
 * Solve.java
 * 
 * Solve class that implements the Command interface.
 * This class checks if the user's entered solution matches the solution stored in the problem in the room/exit.
 *
 * @author Steven Barker, Susannah Bennett, and Kali Grose
 * Wheaton College, CS 245, Spring 2020
 * 
 */
public class Solve implements Command {
	/**
	 * Current player
	 */
	private Player p1;
	/**
	 * The solution to the current problem
	 */
	private String correctsol;
	
	/**
	 * Constructor to initialize player and the correct solution
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
			p1.getCurrentRoom().getExit().setCanUse();
			
			System.out.println("Correct answer! You can move forward now.");
		} else {
			System.out.println("The entered solution is not correct.");
		}
	}

}
