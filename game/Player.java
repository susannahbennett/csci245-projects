package game;
import java.util.*;

/**
 * Player.java
 * 
 * The class that represents the Player
 *
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public class Player {
	/**
	 * The player's instance of game
	 */
	private Game game;
	/**
	 * The player's inventory of items they've picked up
	 */
	private HashMap<String, Item> inventory;
	/**
	 * The player's current room in the game
	 */
	private Room currentRoom;
	/**
	 * What rooms have already been moved to by the player
	 */
	private HashMap<String, Room> seenRooms;
	/**
	 * The player's current problem at an exit
	 */
	public Puzzle currentproblem;
	/**
	 * Constructor
	 * 
	 * Builds an instance representing the player
	 * 
	 * @param g The reference to the Game
	 * @param i The player's inventory
	 * @param m The player's already seen rooms
	 * @param c The player's current room
	 */
	public Player(Game g, HashMap<String, Item> i, HashMap<String, Room> m, Room c) {
		game = g;
		inventory = i;
		currentRoom = c;
		seenRooms = m;
	}
	/**
	 * Gets the inventory
	 * 
	 * @return The player's inventory
	 */
	public HashMap<String, Item> getItemList () { return inventory; }
	/**
	 * Gets an item out of the inventory
	 * 
	 * @param itemname The String name of the desired item
	 * @return The Item
	 */
	public Item getItem(String itemname) { return inventory.get(itemname);	}
	/**
	 * Gets the current room that the player is in
	 * 
	 * @return the Room
	 */
	public Room getCurrentRoom() { return currentRoom; }
	/**
	 * Adds an item to the player's inventory
	 * @param name The String that is the name of the item
	 * @param item The reference to the instance of Item
	 */
	public void addToInventory(String name, Item item) { inventory.put(name, item); }
	/**
	 * Sets the reference of the current room to keep track of where the player is
	 * 
	 * @param room the instance of Room to be set to the current room
	 */
	public void setCurrentRoom(Room room) { currentRoom = room;	}
	/**
	 * Updates the map of previously visited rooms
	 * 
	 * @param str the name of the room
	 * @param room the reference to the room
	 */
	public void updateMap (String str, Room room) {	seenRooms.put(str, room); }
	/**
	 * Gets the map of previously visited rooms
	 * 
	 * @return a HashMap of the previously visited rooms
	 */
	public HashMap<String, Room> returnMap() { return seenRooms; }
	/**
	 * Gets a reference to the game
	 * 
	 * @return the Game
	 */
	public Game getGame() { return game; }
	/**
	 * Gets the current problem the player is facing
	 * 
	 * @return the current problem
	 */
	public Puzzle getProblem() { return currentproblem; }
	/**
	 * Sets the current problem the player is facing
	 * 
	 * @param p The current problem
	 */
	public void setCurrentProblem(Puzzle p) { currentproblem = p; }
}
