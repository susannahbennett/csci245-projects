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
	 * 
	 */
	private boolean canuse = true;

	/**
	 * 
	 */
	private Room sameroom;
	
	/**
	 * 
	 */
	public DeathExit(Room r) { 
		sameroom = r;
	}


	public Room destination() { return sameroom; }


	public boolean canUse() { return canuse; }

	@Override
	public void setCanUse() {}

	@Override
	public void use(Player p1) {
		System.out.println("You finished the game");
		p1.getGame().finishGame();
	}

	@Override
	public Puzzle getProblem() { return null; }

}
