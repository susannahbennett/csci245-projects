/**
 * 
 */
package game;

/**
 * Class representing the normal way (always unlocked) to exit a room
 *
 */
public class NormalExit implements Exit {
	/**
	 * Holds the reference to the room behind the exit
	 */
	private Room nextRoom;
	/**
	 * Indicates whether the room has been unlocked yet
	 */
	private boolean canUse = true;

	/**
	 * Constructor
	 * @param nextroom The room after the exit
	 */
	public NormalExit(Room nextroom) { 
		this.nextRoom = nextroom; 
	}
	/**
	 * Returns the room after the exit
	 */
	public Room destination() { return nextRoom; }
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
	public Problem getProblem(){ return null; }
	/**
	 * @param p1
	 */
	public void use(Player p1) {
		p1.setCurrentRoom(nextRoom);
		p1.getGame().setCurrentRoom(nextRoom);
		
	}
}
