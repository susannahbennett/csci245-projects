/**
 * 
 */
package game;

/**
 * DeathExit.java
 * 
 * Use this exit to lose the game
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public class DeathExit implements Exit {

	/**
	 * Constructor
	 */
	public DeathExit() {}


	public Room destination() { return null; }


	public boolean canUse() { return false;}

	
	public void setCanUse() {}

	@Override
	public void use(Player p1) {
		System.out.println("You went down the wrong path and died");
		System.out.println("Game over");
		p1.getGame().finishGame();
	}

	@Override
	public Puzzle getProblem() { return null; }

}
