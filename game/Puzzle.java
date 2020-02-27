/**
 * 
 */
package game;

/**
 * @author stevenbarker
 *
 */
public class Puzzle implements Problem {

	private boolean solved;
	
	/**
	 * 
	 */
	public Puzzle() {
		this.solved = false;
	}

	/* (non-Javadoc)
	 * @see game.Problem#obstruct()
	 */
	@Override
	public void runProblem() {
		

	}

	@Override
	public boolean isSolved() {
		return solved;
	}

	@Override
	public String getSolution() {
		return null;
	}

	@Override
	public void setSolved() {
		// TODO Auto-generated method stub
		
	}

}
