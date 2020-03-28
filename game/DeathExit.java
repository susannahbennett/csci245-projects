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
	 * Constructor to initialize sameroom
	 * 
	 * @param r Room after the exit (destination)
	 */
	public DeathExit() {}
	/**
	 * Returns the Room after the exit
	 * 
	 * @returns sameroom The Room after the exit
	 */
	public Room destination() { return null; }

	/**
	 * Returns whether the exit is locked or not
	 * 
	 * @return canuse Whether the exit is locked or not
	 */
	public boolean canUse() { return true; }

	/**
	 * Set the exit to unlocked
	 */
	public void setCanUse() {}

	/**
	 * Prints that the player lost the game after using the exit
	 * 
	 * @param p1 The reference to the player.
	 */
	public void use(Player p1) {
		System.out.println("You went down the wrong path and died");
		System.out.println("Game over");
		p1.getGame().finishGame();
	}

	/**
	 * Returns null
	 * 
	 * @return null
	 */
	public Puzzle getProblem() { return null; }

}
