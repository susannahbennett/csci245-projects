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
	boolean readable;

	/**
	 * Constructor to initializes the contents of the paper
	 */
	public Paper(String s, boolean readable) {
		contents=s;
		this.readable = readable;
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
		System.out.println("\n" + contents);

	}

	/**
	 * Paper does not add any new commands for player to use
	 */
	public void addFunctionality(Player p1, Parser p) {	}
	
	/**
	 * Will make message now readable, if it previously was not
	 */
	public void editItem() {
		readable = true;
	}

	@Override
	public void addInspection(String s) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Miscellaneous paper that can have hints to be used later on";
	}

}
