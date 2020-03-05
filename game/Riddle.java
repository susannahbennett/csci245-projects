/**
 * 
 */
package game;


/**
 * @author stevenbarker
 *
 */
public class Riddle implements Problem {

	/**
	 * 
	 */
	public String riddle;
	/**
	 * 
	 */
	private boolean solved;
	
	/**
	 * 
	 */
	private String solution;
	/**
	 * 
	 */
	public Riddle(String riddle, String solution) {
		this.riddle = riddle;
		this.solved = false;
		this.solution = solution;
	}

	/* (non-Javadoc)
	 * @see game.Problem#obstruct()
	 */
	@Override
	public void runProblem() { System.out.println(riddle); }
		

	@Override
	public boolean isSolved() { return solved; }
		
	
	@Override
	public void setSolved() { solved = true; }
	
	@Override
	public String getSolution() { return solution; }

}
