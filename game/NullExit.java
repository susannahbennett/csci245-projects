package game;

/**
 * NullExit.java
 * 
 * This class represents the edge of the map
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public class NullExit implements Exit {

	/**
	 * The room that the exit is associated with
	 */
	private Room thatroom;
	
	/**
	 * Constructor
	 * 
	 * Initializes the next room to the current room that the player is in
	 */
	public NullExit(Room r) { thatroom = r; }

	/**
	 * Returns the reference to the next room
	 * 
	 * @return the next room
	 */
	public Room destination() { return thatroom; }

	/**
	 * True if the player can use the exit, false if the player cannot
	 * 
	 * @return whether or not the plater can use the exit
	 */
	public boolean canUse() { return true; }

	/**
	 * Will set canuse to true
	 */
	public void setCanUse() {}
	
	/**
	 * Prints out a message, the player does not move anywhere
	 */
	public void use(Player p1) { System.out.println("You cannot move that way"); }


	public Problem getProblem() { return null; }

}
