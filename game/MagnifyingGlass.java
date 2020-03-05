/**
 * 
 */
package game;

/**
 * @author stevenbarker
 *
 */
public class MagnifyingGlass implements Item {

	/**
	 * 
	 */
	public MagnifyingGlass() {
		
	}

	
	@Override
	public void function(Player p1) {
		System.out.println("You can use the inspect command to use the magnifying glass to inspect items");

	}
	
	public void inspect(Player p1) {
		System.out.println("You are using the magnifying glass... to inspect the magnifying glass");
	}

}
