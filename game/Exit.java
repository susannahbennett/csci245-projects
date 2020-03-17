package game;

/**
 * Exit.java
 * 
 * Exit interface that coordinates the various types of exits.
 *
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020 
 */
public interface Exit {

	/**
	 * Gives the reference to the next next room.
	 * 
	 * @return the room that the player is going to be moved.
	 */
	Room destination();
	
	/**
	 * Tells whether or not the exit can be used.
	 * @return A boolean value indicating whether or not the exit can be used.
	 */
	boolean canUse();
	
	/**
	 * Will set the canuse value to be true.
	 */
	void setCanUse();
	
	/**
	 * This is what will be run when the exit is being moved through.
	 * 
	 * @param p1
	 */
	public void use(Player p1);
	
	/**
	 * Will return the instance of problem associated with the exit, if there is none, it will 
	 * return null.
	 * 
	 * @return the instance of Problem associated with the exit.
	 */
	public Problem getProblem();
	
}
