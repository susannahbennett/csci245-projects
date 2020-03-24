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
	 * 
	 */
	private String puzzle;
	
	/**
	 * 
	 */
	private String solution;
	
	/**
	 * 
	 */
	private Exit exit;
	
	
	/**
	 * Constructor
	 */
	public Puzzle(String puzzle, String solution) {
		this.puzzle = puzzle;
		this.solution = solution;
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
	public void solve() { exit.setCanUse(); }
	
	/**
	 * 
	 */
	public void setExit(Exit e) { exit = e; }
	

	
}
