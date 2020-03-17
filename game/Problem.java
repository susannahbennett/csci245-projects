package game;

/**
 * Problem.java
 * 
 * This is the supertype for all problems tbat
 *
 */
public interface Problem {
	
	void runProblem();
	
	String getSolution();
	
	void solve();
	
	void setExit(Exit e);


}
