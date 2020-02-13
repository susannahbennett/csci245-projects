/**
 * 
 */
package game;

/**
 * @author stevenbarker
 *	Supertype for all items in the game
 */
public interface Item {
	
	public void getItemName();
	
	public void pickUp();
	
	public void putDown();

	public void use();
	
	
	
}
