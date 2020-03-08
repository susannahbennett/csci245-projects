package game;
import java.util.*;

/**
 * Player.java
 * 
 * Player class that has a reference to the classes: Game, Room, and DynamicMap.
 *
 * @author Steven Barker, Susannah Bennett, and Kali Grose
 * Wheaton College, CS 245, Spring 2020
 * 
 */
public class Player {

	private Game game;
	
	private HashMap<String, Item> inventory;
	
	private Room currentRoom;
		
	private DynamicMap seenRooms;
	
	public String name;
	
	public Problem currentproblem;

	/**
	 * @param game
	 * @param inventory
	 * @param currentroom
	 */
	public Player(Game game, HashMap<String, Item> inventory, DynamicMap seenRooms, Room currentRoom) {
		this.game = game;
		this.inventory = inventory;
		this.currentRoom = currentRoom;
		this.seenRooms = seenRooms;
		name = "Eric";
	}
	
	/**
	 * 
	 * @return
	 */
	public HashMap<String, Item>  getItemList () { return inventory; }
	
	/**
	 * 
	 * @param itemname
	 * @return
	 */
	public Item getItem(String itemname) { return inventory.get(itemname);	}
	
	/**
	 * 
	 * @return
	 */
	public Room getCurrentRoom() { return currentRoom; }
	
	/**
	 * 
	 * @param name
	 * @param item
	 */
	public void addToInventory(String name, Item item) { inventory.put(name, item); }
	
	/**
	 * 
	 * @param room
	 */
	public void setCurrentRoom(Room room) { currentRoom = room;	}
	
	/**
	 * 
	 * @param str
	 * @param room
	 */
	public void updateMap (String str, Room room) {	seenRooms.returnMap().put(str, room); }
	
	/**
	 * 
	 * @return
	 */
	public DynamicMap returnDMap() { return seenRooms; }
	
	/**
	 * 
	 * @return
	 */
	public Game getGame() { return game; }
	
	/**
	 * 
	 * @return
	 */
	public Problem getProblem() { return currentproblem; }
	
	/**
	 * 
	 */
	public void setCurrentProblem(Problem p) { currentproblem = p; }
	
}
