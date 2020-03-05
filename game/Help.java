/**
 * 
 */
package game;

/**
 * @author susannahbennett
 *
 */
public class Help implements Command {

	private Player p1;
	
	/**
	 * Constructor
	 */
	public Help(Player p1) {
		this.p1 = p1;
	}

	/**
	 * Method prints the list of possible commands
	 */
	public void doSomething(String[] command) {
		System.out.println("Available commands:\n look: describes the room\n use: use the item for its intended function\n map: display the rooms that have already been traversed by player\n pickup: get specified object from room");
	}
}
