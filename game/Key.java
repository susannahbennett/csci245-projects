package game;

/**
 * @author stevenbarker
 *
 */
public class Key implements Item {

	
	
	
	/**
	 * @param name
	 */
	public Key() {
		
	}

	public void function(Player p1) {
	
	}
	
	public void inspect(Player p1) {
		System.out.println("This is what you get when you inspect this key");
	}

	@Override
	public void addFunctionality(Player p1, Parser p) {}

}
