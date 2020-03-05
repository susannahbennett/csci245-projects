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
	
	public void setCanUse();
	
}
