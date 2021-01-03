package game;

/**
 * NormalExit.java 
 * 
 * This class represents the normal way (always unlocked) to exit a room
 *
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public class NormalExit implements Exit {
	
	/**
	 * Holds the reference to the room behind the exit
	 */
	private Room nextroom;
	
	/**
	 * Indicates whether the room has been unlocked yet
	 */
	private boolean canUse = true;

	/**
	 * Constructor
	 * 
	 * Initializes the next room
	 * 
	 * @param nextroom The room after the exit
	 */
	public NormalExit(Room n) { nextroom = n; }
	
	/**
	 * Returns the room after the exit
	 */
	public Room destination() { return nextroom; }
	
	/**
	 * Returns whether the door has been unlocked
	 */
	public boolean canUse() { return canUse; }
	
	/**
	 * Changes door to unlocked
	 */
	public void setCanUse() { canUse = true; }
	
	/**
	 * Returns the problem associated with the exit
	 */
	public Puzzle getProblem() { return null; }
	
	/**
	 * The method to use the exit that actually moves the player
	 * 
	 * @param p1
	 */
	public void use(Player p1) {
		p1.setCurrentRoom(nextroom);
		p1.getGame().setCurrentRoom(nextroom);
	}
	
}
