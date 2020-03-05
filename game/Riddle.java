/**
 * 
 */
package game;


/**
 * @author stevenbarker
 *
 */
public class Riddle implements Problem {
	
	public String riddle;

	private boolean solved;
	
	private String solution;
	
	/**
	 * Constructor
	 */
	public Riddle(String riddle, String solution) {
		this.riddle = riddle;
		this.solved = false;
		this.solution = solution;
	}

	public void runProblem() { System.out.println(riddle); }

	public boolean isSolved() { return solved; }

	public void setSolved() { solved = true; }

	public String getSolution() { return solution; }
}
