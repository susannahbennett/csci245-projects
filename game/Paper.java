/**
 * 
 */
package game;

/**
 * Class to represent paper items. These items can contain clues or hints for the player.
 * @author kaligrose, Susannah Bennett, Steven Barker
 *
 */
public class Paper implements Item {
	
	/**
	 * What the paper says
	 */
	String contents;

	/**
	 * Determines whether or not the words on the paper are readable.  Will be false if the contents are hidden.
	 */
	Boolean readable;

	/**
	 * Constructor to initializes the contents of the paper
	 */
	public Paper(String s) {
		contents=s;
	}

	@Override
	public void function(Player p1) {
		if(readable) {
			System.out.println(contents);
		}else {
			System.out.println("This paper appears to be blank... you may need another item to reveal its contents.");
		}
	}

	@Override
	public void inspect(Player p1) {
		// TODO Auto-generated method stub


	}

	@Override
	public void addFunctionality(Player p1, Parser p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addInspection(String s) {
		// TODO Auto-generated method stub

	}
	
	public void setReadable() {
		readable=!readable;
	}

}
