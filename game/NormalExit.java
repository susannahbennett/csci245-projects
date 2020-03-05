/**
 * 
 */
package game;

/**
 * @author stevenbarker
 *
 */
public class NormalExit implements Exit {

	/**
	 * 
	 */
	private Room nextroom;
	
	/**
	 * 
	 */
	private boolean canuse = true;
	
	private Problem givenProblem;
	
	/**
	 * @param nextroom
	 */
	public NormalExit(Room nextroom, Problem givenProblem) { 
		this.nextroom = nextroom;
		this.givenProblem = givenProblem;
		}

	/** 
	 * @return 
	 */
	@Override
	public Room destination() { return nextroom; }

	/**
	 * @return 
	 */
	@Override
	public boolean canUse() { return canuse; }
	
	/**
	 * 
	 */
	public void setCanUse() { canuse = !canuse; }
	
	public Problem getProblem(){ return givenProblem; }

}
