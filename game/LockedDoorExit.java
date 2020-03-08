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
	 * 
	 */
	private Key key;
	/**
	 * 
	 * @param nextroom
	 * @param givenProblem
	 * @param key
	 */
	public LockedDoorExit(Room n, Key k) {
		nextroom = n;
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
			System.out.println("You have unlocked the door with the key");
			p1.setCurrentRoom(nextroom);
			p1.getGame().setCurrentRoom(nextroom);
		}else
			System.out.println("You do not have the right key");

	}

	@Override
	public Problem getProblem() {
		
		return null;
	}

}
