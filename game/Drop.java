package game;

/**
 * Drop.java
 * 
 * This class is the command to drop items
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020   
 */
public class Drop implements Command {
	/**
	 * The reference to the player
	 */
	private Player p1;
	/**
	 * Constructor
	 * 
	 * Initiates The player
	 * 
	 * @param p1
	 * @param itemname
	 */
	public Drop(Player player) { p1 = player; }
	/**
	 * Removes the inputed item from the players inventory and puts it in the room's hashmap of items
	 * 
	 * @return command String[] containing the user's input from Parser.java that indicates and item to drop
	 */
	public void doSomething(String[] command) {
		if(p1.getItemList().containsKey(command[1])) {
			p1.getCurrentRoom().addItem(command[1], p1.getItem(command[1]));
			p1.getItemList().remove(command[1]);
			System.out.println("You have removed " + command[1] +" from your inventory.");
		}else
			System.out.println("That item does not exist");
	}
	/**
	 * Gets the description of the drop command
	 * 
	 * @return The description of the drop command
	 */
	public String getDescription() {return "Removes an item from your personal inventory and moves it to the room."; }
}
