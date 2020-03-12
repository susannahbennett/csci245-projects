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
		
	private HashMap<String, Room> seenRooms;
	
	public String name;
	
	public Problem currentproblem;

	/**
	 * @param g
	 * @param i
	 * @param currentroom
	 */
	public Player(Game g, HashMap<String, Item> i, HashMap<String, Room> m, Room c) {
		game = g;
		inventory = i;
		currentRoom = c;
		seenRooms = m;
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
	public void updateMap (String str, Room room) {	seenRooms.put(str, room); }
	
	/**
	 * 
	 * @return
	 */
	public HashMap<String, Room> returnMap() { return seenRooms; }
	
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
