/**
 * 
 */
package game;

/**
 * @author susannahbennett
 *
 */
public class PuzzleExit implements Exit {

	private Room nextroom;
	
	private boolean canUse;
	
	/**
	 * Constructor 
	 */
	public PuzzleExit(Room nextroom) {
		this.nextroom = nextroom;
		canUse = false;
	}

	/**
	 *
	 */
	public Room destination() { return nextroom; }

	/**
	 * 
	 */
	public boolean canUse() { return canUse; }

	/** 
	 * 
	 */
	public void setCanUse() { canUse = true;}

}
