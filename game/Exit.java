/**
 * 
 */
package game;

/**
 * @author stevenbarker
 *
 */
public interface Exit {

	public Room destination();
	
	public boolean canUse();
	
	public void setCanUse(boolean a);
	
	public void use(Player p1);
	
	public Problem getProblem();
	
}
