package game;

/**
 * Similar to a locked door with a key except you need to have a 
 * bunch of specified items in your inventory to pass.
 * For example, you need to have three specific keys and the dynamic map to pass.
 * @author stevenbarker
 *
 */
public class InventoryDoorExit implements Exit {
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
	private Problem givenproblem;
	
	/**
	 * 
	 */
	public InventoryDoorExit(Room r, Problem p) {
		nextroom = r;
		givenproblem = p;
		givenproblem.setExit(this);
		
	}

	@Override
	public Room destination() { return nextroom; }

	@Override
	public boolean canUse() { return canuse; }

	@Override
	public void setCanUse() { canuse = true; }

	@Override
	public void use(Player p1) {
		//TBD

	}

	@Override
	public Problem getProblem() { return givenproblem; }

}
