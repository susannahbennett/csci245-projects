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
			String com = i.next();
			System.out.println(Game.CYAN + com + Game.RESET + ": " + commands.get(com).getDescription());
		}
	}

	@Override
	public String getDescription() { return "Lists out all known commands" ; }
}
