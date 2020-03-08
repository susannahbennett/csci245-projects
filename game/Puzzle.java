package game;

/**
 * @author stevenbarker
 *
 */
public class Puzzle implements Problem {

	
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

	@Override
	public void solve() { exit.setCanUse(); }
	
	/**
	 * 
	 */
	public void setExit(Exit e) { exit = e; }
	

	
}
