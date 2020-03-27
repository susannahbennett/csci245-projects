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
	 * Constructor to initialize player
	 */
	public Solve(Player p1) { this.p1 = p1; }

	/**
	 * 	 
	 */
	public void doSomething(String[] command) {
		if(p1.getProblem() != null) {
			if(p1.getProblem().getSolution().equals(command[1])) {
				System.out.println("\nCongrats, you solved the problem");
				p1.getProblem().solve();
			}else {
				System.out.println("Wrong");
			}
		}else {
			System.out.println("There is no problem to solve");
		}
		
	}

	@Override
	public String getDescription() {return "Enter 'solve' followed by the answer to a puzzle to unlock a locked door"
			+ "\n\t(However, if faced with a locked door needing a key, pickup the key to unlock the door)"; }

}
