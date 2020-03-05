package game;
import java.util.*;

/**
 * @author stevenbarker
 *
 */
public class Player {

	private Game game;
	
	private HashMap<String, Item> inventory;
	
	private Room currentRoom;
		
	private DynamicMap seenRooms;
	
	public String name;

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
	
	public HashMap<String, Item>  getItemList () {
		return inventory;
	}
	
	public Item getItem(String itemname) {
		return inventory.get(itemname);
	}
		
		
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public void addToInventory(String name, Item item) {
		inventory.put(name, item);
	}

	public void setCurrentRoom(Room room) {
		currentRoom = room;
	}
	
	public void updateMap (String str, Room room) {
		seenRooms.returnMap().put(str, room);
	}
	
	public DynamicMap returnDMap() {
		return seenRooms;
	}
	
	public Game getGame() {
		return game;
	}
	
	
}
