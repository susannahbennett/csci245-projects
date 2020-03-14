/**
 * 
 */
package game;

/**
 * @author stevenbarker
 *
 */
public class Inspect implements Command {

	/**
	 * 
	 */
	private Player p1;

	/**
	 * 
	 */
	public Inspect(Player p1){
		this.p1 = p1;
	}

	/**
	 * @see 
	 */
	@Override
	public void doSomething(String[] command) {
		if (p1.getItemList().containsKey(command[1]))
			p1.getItemList().get(command[1]).inspect(p1);
		else if (command[1].equals("this room"))
			p1.getCurrentRoom().inspect();
		else
			System.out.println("I cannot inspect that");
	}

	@Override
	public String getDescription() { return "Further inspect a room or object"; }
}
