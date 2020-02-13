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
	public Help() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see game.Command#doSomething(game.Player)
	 */
	public void doSomething(Player p1) {
		System.out.println("Available commands:\n help: gives a list of commands\nlook: describes the room");
	}

}
