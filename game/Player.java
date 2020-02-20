package game;
import java.util.*;

/**
 * @author stevenbarker
 *
 */
public class Player {

	private Game game;
	
	private ArrayList<Item> inventory;
	
	private Room currentRoom;

	/**
	 * @param game
	 * @param inventory
	 * @param currentroom
	 */
	public Player(Game game, ArrayList<Item> inventory, Room currentRoom) {
		this.game = game;
		this.inventory = inventory;
		this.currentRoom = currentRoom;
	}
	
	public ArrayList<Item> getItemList () {
		return inventory;
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}

}
