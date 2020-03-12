/**
 * 
 */
package game;

/**
 * @author stevenbarker
 *
 */
public class MagnifyingGlass implements Item {

	private Parser p;
	
	/**
	 * 
	 */
	public MagnifyingGlass(Parser p) {
		this.p = p;
	}

	
	@Override
	public void function(Player p1) {
		System.out.println("You can use the inspect command to use the magnifying glass to inspect items");

	}
	
	public void inspect(Player p1) {
		System.out.println("You are using the" + Game.BLUE + "magnifying glass" + Game.RESET + "to inspect the" + Game.BLUE + "magnifying glass" + Game.RESET);
	}


	@Override
	public void addFunctionality(Player p1) { p.addCommand("inspect", new Inspect(p1)); }

}
