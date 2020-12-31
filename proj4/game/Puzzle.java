package game;

/**
 * Puzzle.java
 * 
 * Makes all puzzles or riddles or problems
 * 
 * @author Susannah Bennett, Kali Grose, and Steven Barker
 * Wheaton College, CSCI 245, Spring 2020
 * Project 4
 * March, 2020
 */
public class Puzzle {

	
	/**
	 * This is what will be displayed when the player is presented the puzzle
	 */
	private String puzzle;
	
	/**
	 * This is the solution
	 */
	private String solution;
	
	/**
	 * The reference to the exit that is using this puzzle
	 */
	private Exit exit;
	
	/**
	 * The reference to the currentroom that the player is in
	 */
	private Room room;
	
	/**
	 * Constructor
	 */
	public Puzzle(String p, String s, Room r) {
		puzzle = p;
		solution = s;
		room = r;
	}

	/**
	 * This is what will run when the puzzle is introduced
	 */
	public void runProblem() { System.out.println(puzzle); }

	/**
	 * Gets the solution to the puzzle
	 * 
	 * @return solution The solution
	 */
	public String getSolution() { return solution; }

	/**
	 * This when the player solves the puzzle using the solve command,
	 * it will allow the player to move or use the exit
	 */
	public void solve() { 
		if(exit != null)
			exit.setCanUse();
		else
			room.setCanMove();
	}
	
	/**
	 * Gives the reference to the exit that is using the puzzle
	 */
	public void setExit(Exit e) { exit = e; }
	

	
}
