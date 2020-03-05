
package game;

/**
 * Exit.java
 * 
 * Exit interface that coordinates the various types of exits.
 *
 * @author Steven Barker, Susannah Bennett, and Kali Grose
 * Wheaton College, CS 245, Spring 2020
 * 
 */
public interface Exit {

	public Room destination();
	
	public boolean canUse();
	
	public void setCanUse(boolean a);
	
	public void use(Player p1);
	
	public Problem getProblem();
	
}
