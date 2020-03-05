package game;

/**
 * @author stevenbarker
 *
 */
public class Message implements Item {

	/**
	 * 
	 */
	private String message;
	
	/**
	 * @param message
	 */
	public Message(String message) {
		this.message = message;
	}

	/**
	 * 
	 */
	public void function(Player p1) {
		System.out.println(message);
	}


	/**
	 * 
	 */
	public void inspect(Player p1) {
		 System.out.println("Nicholas Cage's fancy signature");
	}
	
	
}
