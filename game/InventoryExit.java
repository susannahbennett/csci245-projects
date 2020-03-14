package game;

import java.util.*;

/**
 * Similar to a locked door with a key except you need to have a 
 * bunch of specified items in your inventory to pass.
 * For example, you need to have three specific keys and the dynamic map to pass.
 * @author stevenbarker
 *
 */
public class InventoryExit implements Exit {
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
	private HashMap<String, Item> requireditems;
	/**
	 * 
	 */
	public InventoryExit(Room r, Problem p, HashMap<String, Item> i) {
		nextroom = r;
		givenproblem = p;
		requireditems = i;
		
	}

	@Override
	public Room destination() { return nextroom; }

	@Override
	public boolean canUse() { return canuse; }

	@Override
	public void setCanUse() { canuse = true; }

	@Override
	public void use(Player p1) {
		HashMap<String, Item> inventory = p1.getItemList();
		Iterator<String> i = requireditems.keySet().iterator();
		while(i.hasNext()) {
			if(!inventory.containsKey(i.next())) {
				System.out.println("You don't have all of the neccesary items");
				return;
			}
		}
		System.out.println("You had everything you needed");
		p1.setCurrentRoom(nextroom);
		p1.getGame().setCurrentRoom(nextroom);
		setCanUse();
		

	}

	@Override
	public Problem getProblem() { return givenproblem; }

}
