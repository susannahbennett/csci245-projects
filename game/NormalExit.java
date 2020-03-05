/**
 * 
 */
package game;

/**
 * @author stevenbarker
 *
 */
public class NormalExit implements Exit {

	/**
	 * 
	 */
	private Room nextroom;
	
	/**
	 * 
	 */
	private boolean canuse = true;
	
	/**
	 * @param nextroom
	 */
	public NormalExit(Room nextroom) { this.nextroom = nextroom; }

	/** 
	 * @return 
	 */
	@Override
	public Room destination() { return nextroom; }

	/**
	 * @return 
	 */
	@Override
	public boolean canUse() { return canuse; }
	
	/**
	 * 
	 */
	public void setCanUse() { canuse = !canuse; }

}
