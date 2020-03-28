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
	 * Boolean concerning whether the exit is locked or not
	 */
	private boolean canuse = true;

	/**
	 * What room is after it
	 */
	private Room sameroom;
	
	/**
	 * Constructor to initialize sameroom
	 * 
	 * @param r Room after the exit (destination)
	 */
	public DeathExit(Room r) { 
		sameroom = r;
	}
	/**
	 * Returns the Room after the exit
	 * 
	 * @returns sameroom The Room after the exit
	 */
	public Room destination() { return sameroom; }

	/**
	 * Returns whether the exit is locked or not
	 * 
	 * @return canuse Whether the exit is locked or not
	 */
	public boolean canUse() { return canuse; }

	/**
	 * Set the exit to unlocked
	 */
	public void setCanUse() { canuse = true; }

	/**
	 * Prints that the player lost the game after using the exit
	 * 
	 * @param p1 The reference to the player.
	 */
	public void use(Player p1) {
		System.out.println("You lost the game! You went through a trapdoor and died!");
		p1.getGame().finishGame();
	}

	/**
	 * Returns null
	 * 
	 * @return null
	 */
	public Puzzle getProblem() { return null; }

}
