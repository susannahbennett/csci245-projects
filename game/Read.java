/**
 * 
 */
package game;

/**
 * @author stevenbarker
 *
 */
public class Read implements Command {

private Player p1;
	
	/**
	 * 
	 */
	public Read(Player p1) {
		this.p1 = p1;
	}

	/**
	 * @see game.Command#doSomething(java.lang.String)
	 */
	@Override
	public void doSomething(String[] command) {
		if(!p1.getItemList().containsKey(command[1])) {
			System.out.println("That item does not exist, try again");
			return;
		}
		p1.getItem(command[1]).function(p1);
		
	}

}
