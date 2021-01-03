/**
 * 
 */
package game;

/**
 * Problem.java
 * 
 * MProblemExit class implements the Exit interface
 * This class represents an exit with a problem associated with it.
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public class ProblemExit implements Exit {
	
	/**
	 * Holds the reference to the room behind the exit
	 */
	private Room nextroom;
	
	/**
	 * Indicates whether the room has been unlocked yet
	 */
	private boolean canuse = false;
	
	/**
	 * The problem associated with the exit
	 */
	private Puzzle givenproblem;

	/**
	 * Constructor 
	 * 
	 * Initializes instance variables and gives the puzzle a reference to this
	 * 
	 * @param r The reference to the next room
	 * @param p The puzzle associated with this exit
	 */
	public ProblemExit(Room r, Puzzle p) {
		nextroom = r;
		givenproblem = p;
		givenproblem.setExit(this);
		
	}
	/**
	 * Returns the room the player want to enter that is after the exit
	 * 
	 * @return The next room
	 */
	public Room destination() { return nextroom; }
	
	/**
	 * Returns whether the door has been unlocked
	 */
	public boolean canUse() { return canuse; }
	
	/**
	 * Changes the door to being unlocked
	 */
	public void setCanUse() { canuse = true; }
	
	/**
	 * Method for moving the player forward if the door is unlocked
	 */
	public void use(Player p1) {
		p1.setCurrentProblem(givenproblem);
		if (canuse) {
			p1.setCurrentRoom(nextroom);
			p1.getGame().setCurrentRoom(nextroom);
		} else {
			p1.setCurrentProblem(givenproblem);
			givenproblem.runProblem();
		}
	}
	
	/**
	 * Returns the problem associated with the exit
	 */
	public Puzzle getProblem() { return givenproblem; }

}
