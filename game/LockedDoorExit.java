/**
 * 
 */
package game;

/**
 * LockedDoorExit.java
 * 
 * This class represents the exit that is locked and requires a specific key to open
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public class LockedDoorExit implements Exit {

	/**
	 * Holds the reference to the room behind the exit
	 */
	private Room nextroom;
	
	/**
	 * Indicates whether the room has been unlocked yet
	 */
	private boolean canuse = false;
	
	
	/**
	 * The reference to the specific instance of Key that will unlock this exit
	 */
	private Key key;
	
	/**
	 * Constructor
	 * 
	 * Initializes the nextroom and the key 
	 * @param nextroom The reference to the next room
	 * @param k the reference to the key needed to open the exit
	 */
	public LockedDoorExit(Room n, Key k) {
		nextroom = n;
		key = k;
	}
	
	/**
	 * Returns the reference to the next room
	 * 
	 * @return the next room
	 */
	public Room destination() { return nextroom; }

	/**
	 * True if the player can use the exit, false if the player cannot
	 * 
	 * @return whether or not the plater can use the exit
	 */
	public boolean canUse() { return canuse; }

	/**
	 * Will set canuse to true
	 */
	public void setCanUse() { canuse = true; }

	/**
	 * Will check if the players' inventory contains the key associated with this exit.
	 * 
	 * @param p1 The reference to the player
	 */
	public void use(Player p1) {
		if(canuse) {
			p1.setCurrentRoom(nextroom);
			p1.getGame().setCurrentRoom(nextroom);
		}
		else if(p1.getItemList().containsValue(key)) {
			setCanUse();
			System.out.println("You have unlocked the door with the key");
			p1.setCurrentRoom(nextroom);
			p1.getGame().setCurrentRoom(nextroom);
		}else
			System.out.println("You do not have the right key");
	}
	

	public Puzzle getProblem() { return null; }

}
