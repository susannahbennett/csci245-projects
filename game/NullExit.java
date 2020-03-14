/**
 * 
 */
package game;

/**
 * @author stevenbarker
 *
 */
public class NullExit implements Exit {

	/**
	 * 
	 */
	private Room thatroom;
	/**
	 * 
	 */
	public NullExit(Room r) {
		thatroom = r;
		
	}

	@Override
	public Room destination() { return thatroom; }

	@Override
	public boolean canUse() { return true; }

	@Override
	public void setCanUse() {}
	

	@Override
	public void use(Player p1) { System.out.println("You cannot move that way"); }

	@Override
	public Problem getProblem() { return null; }

}
