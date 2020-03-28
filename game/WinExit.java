package game;

/**
 * WinExit.java
 * 
 * Supertype for all class that represent commands in the game
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public class WinExit implements Exit {
	
	/**
	 * Constructor
	 */
	public WinExit() {}

	/**
	 * There is no destination
	 */
	public Room destination() { return null; }

	/**
	 * The player is always able to use this
	 * 
	 * @return true
	 */
	public boolean canUse() { return true; }
	
	/**
	 * Set whether the room can be used or not
	 */
	public void setCanUse() {}
	
	/**
	 * This is what will run when you play the game
	 * 
	 * @param p1 The reference to the player.
	 */
	public void use(Player p1) {
		System.out.println("The revolving bookshelf moves, and suddenly you're in the hidden room!\n\n"
        		+ "Nicholas Cage is in the room. He looks at you and says, 'I'm going to steal the Declaration of Independence.' You struggle with him, fighting for box in his hands (the treasure!!)!\n\n"
        		+ "Fortunately, you remember the lemon in your bag, and you squeeze the lemon in Nicholas Cage's eyes!\n\n"
        		+ "With that, you run off with the box of treasure.\n\n"
        		+ "Finally, once you're out of the house and a safe distance away, you open the box to see the treasure you've fought hard for...!\n\n"
        		+ "...only to find a note from Colonel Sanders and another gift...\n\n"
        		+ "Colonel Sanders beat you in the race to get the Declaration of Independence, but fortunately, he didn't leave you empty-handed.\n\n"
        		+ "With the secret blend of herbs and spices in hand, you ride off into the sunset, not coming away with the treasure you were looking for but the treasure you always wanted.\n\n");
		p1.getGame().finishGame();
	}

	/**
	 * There is no puzzle
	 */
	public Puzzle getProblem() { return null; }

}
