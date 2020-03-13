package game;


/**
 * Interface for all items in the game.
 * @author stevenbarker
 */
public interface Item {

	void function(Player p1);

	void inspect(Player p1);

	void addFunctionality(Player p1, Parser p);
}
