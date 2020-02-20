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
	public void doSomething(Player p1) {
		System.out.println("Available commands:\n help: gives a list of commands\nlook: describes the room");
	}

}
