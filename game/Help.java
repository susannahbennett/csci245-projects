/**
 * 
 */
package game;

import java.util.*;

/**
 * @author susannahbennett
 *
 */
public class Help implements Command {

	/**
	 * 
	 */
	private Player p1;
	
	/**
	 * 
	 */
	private Parser p;
	
	/**
	 * Constructor
	 */
	public Help(Player p1, Parser p) {
		this.p1 = p1;
		this.p = p;
	}

	/**
	 * Method prints the list of possible commands
	 */
	public void doSomething(String[] command) {
		HashMap<String, Command> commands = p.getCommands();
		Iterator<String> i = commands.keySet().iterator();
		while(i.hasNext()) {
			System.out.println(Game.CYAN + i.next() + Game.RESET + ": " + commands.get(i.next()).getDescription());
		}
	}

	@Override
	public String getDescription() { return "Lists out all known commands" ; }
}
