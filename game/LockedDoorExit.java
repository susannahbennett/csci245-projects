/**
 * 
 */
package game;

/**
 * @author stevenbarker
 *
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
	 * The problem associated with the exit
	 */
	private Problem givenProblem;
	
	/**
	 * 
	 */
	private Key key;
	/**
	 * 
	 * @param nextroom
	 * @param givenProblem
	 * @param key
	 */
	public LockedDoorExit(Room n, Problem p, Key k) {
		nextroom = n;
		givenProblem = p;
		key = k;
	}

	@Override
	public Room destination() {	
		return nextroom;
	}

	@Override
	public boolean canUse() {
		return canuse;
	}

	@Override
	public void setCanUse() {
		canuse = !canuse;
	}

	@Override
	public void use(Player p1) {
		if(p1.getItemList().containsValue(key)) {
			System.out.println("You have unlocked the door");
			p1.setCurrentRoom(nextroom);
			p1.getGame().setCurrentRoom(nextroom);
		}

	}

	@Override
	public Problem getProblem() {
		// TODO Auto-generated method stub
		return null;
	}

}
