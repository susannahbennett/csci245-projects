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
	 * 
	 */
	private Player p1;
	/**
	 * @param nextroom
	 */
	public NormalExit(Room nextroom) { 
		this.nextroom = nextroom; 
		//this.p1 = p1;
	}

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
	public void setCanUse(boolean a) { canuse = a; }
	
	/**
	 * 
	 */
	public void use(Player p1) {
		
		p1.setCurrentRoom(nextroom);
		p1.getGame().setCurrentRoom(nextroom);
	}
}
