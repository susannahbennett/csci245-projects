/**
 * 
 */
package game;

/**
 * @author stevenbarker
 *
 */
public class Inspect implements Command {

	private Player p1;
	/**
	 * 
	 */
	public Inspect(Player p1){
		this.p1 = p1;
	}

	/**
	 * @see game.Command#doSomething(java.lang.String[])
	 */
	@Override
	public void doSomething(String[] command) {
		if(!p1.getItemList().containsKey("Magnifying Glass"))
			System.out.println("I do not know how to inspect");
		else{	
			System.out.println(p1.getItemList().get(command[1]).getInspection());
		}
	
	}

}
