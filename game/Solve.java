/**
 * 
 */
package game;

import java.util.*;


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
	@Override
	public void doSomething(String[] command) {
		Problem obstacle  = p1.getCurrentRoom().getProblem();
		if(command[1].equals(obstacle.getSolution())) {
			System.out.println("Good job! You solved the problem, you may now move");
			p1.getNextRoom().problemSolved();
			
		}else {
			System.out.println("Try again");
		}

	}

}
