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

	/**
	 * @param game
	 * @param inventory
	 * @param currentroom
	 */
	public Player(Game game, HashMap<String, Item> inventory, Room currentRoom) {
		this.game = game;
		this.inventory = inventory;
		this.currentRoom = currentRoom;
	}
	
	public HashMap<String, Item>  getItemList () {
		return inventory;
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public void setCurrentRoom(Room room) {
		currentRoom = room;
	}
}
