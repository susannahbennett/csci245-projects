package game;
import java.util.*;

/**
 * @author stevenbarker
 *
 */
public class Player {

	private Game game;
	
	private ArrayList<Item> inventory;
	
	private String currentroom;

	/**
	 * @param game
	 * @param inventory
	 * @param currentroom
	 */
	public Player(Game game, ArrayList<Item> inventory, String currentroom) {
		this.game = game;
		this.inventory = inventory;
		this.currentroom = currentroom;
	}
	
	public void use(Item item) {
	}

}
