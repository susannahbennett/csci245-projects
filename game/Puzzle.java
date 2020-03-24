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
	 * This is the 
	 */
	private String solution;
	
	/**
	 * 
	 */
	private Exit exit;
	
	/**
	 * 
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
	 * 
	 */
	public void runProblem() { System.out.println(puzzle); }

	/**
	 * 
	 */
	public String getSolution() { return solution; }

	/**
	 * 
	 */
	public void solve() { 
		if(exit != null)
			exit.setCanUse();
		else
			room.setCanMove();
	}
	
	/**
	 * 
	 */
	public void setExit(Exit e) { exit = e; }
	

	
}
