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
 * @author Steven Barker, Susannah Bennett, and Kali Grose
 * Wheaton College, CS 245, Spring 2020
 */
public class ProblemExit implements Exit {
	/**
	 * Holds the reference to the room behind the exit
	 */
	private Room nextRoom;
	/**
	 * Indicates whether the room has been unlocked yet
	 */
	private boolean canUse = false;
	/**
	 * The problem associated with the exit
	 */
	private Problem givenproblem;

	/**
	 * Constructor to set the next room and the given problem
	 */
	public ProblemExit(Room r, Problem p) {
		nextRoom = r;
		givenproblem = p;
		givenproblem.setExit(this);
		
	}
	/**
	 * Returns the room the player want to enter that is after the exit
	 */
	public Room destination() {
		return nextRoom;
	}
	/**
	 * Returns whether the door has been unlocked
	 */
	public boolean canUse() { return canUse; }
	
	/**
	 * Changes the door to being unlocked
	 */
	public void setCanUse() { canUse = true; }
	
	/**
	 * Method for moving the player forward if the door is unlocked
	 */
	public void use(Player p1) {
		System.out.println("If givenproblem in ProblemExit is null: " + givenproblem == null);
		p1.setCurrentProblem(givenproblem);
		if (canUse) {
			p1.setCurrentRoom(nextRoom);
			p1.getGame().setCurrentRoom(nextRoom);
		} else {
			p1.setCurrentProblem(givenproblem);
			givenproblem.runProblem();
		}
	}
	
	/**
	 * Returns the problem associated with the exit
	 */
	public Problem getProblem() { return givenproblem; }

}
