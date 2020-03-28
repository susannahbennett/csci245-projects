package game;

/**
 * Command.java
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
	 * The reference to the game
	 */
	private Game game;

	/**
	 * Constructor
	 * 
	 * @param g The game
	 */
	public WinExit(Game g) { game = g;	}

	/**
	 * There is no destination
	 */
	public Room destination() { return null; }

	/**
	 * The player is always able to use this
	 */
	public boolean canUse() { return true; }
	
	
	public void setCanUse() {}
	
	/**
	 * This is what will run when you play the game
	 */
	public void use(Player p1) {
		System.out.println("With the secret blend of herbs and spices in hand, you ride off into the sunset, not "
				+ "coming away with the treasure you were looking for, "
				+ "but the treasure you always wanted");
		try {
			System.out.println(".");
			Thread.sleep(1000);
			System.out.println(".");
			Thread.sleep(1000);
			System.out.println(".");
			Thread.sleep(1000);
		}catch (InterruptedException e) { 
			e.printStackTrace();
		}
		System.out.println("You stay classy San Diego");
		
		game.finishGame();
	}

	/**
	 * There is no puzzle
	 */
	public Puzzle getProblem() { return null; }

}
