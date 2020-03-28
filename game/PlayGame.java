package game;

import java.util.*;

/**
 * PlayGame.java
 * 
 * Program to control the playing of this game.
 *
 * @author Thomas VanDrunen
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */

public class PlayGame {
	
    public static void main(String[] args) {
        System.out.println(Game.BLUE + "\nWelcome to the game!"+ Game.RESET + "\n\n" + "You are a treasure hunter searching for the Declaration of Independence. All of your years of hunting have led you to this house. "
        		+ "You walk up a hill to an old abandoned house.\n\n"
        		+ "You’re currently outside the house. \nTo move inside the house, enter " + Game.CYAN + "move to entryway." + Game.RESET + "\n");
        Game game = new Game();   // reference to the game object
        HashMap<String, Item>  inventory = new HashMap<String, Item> ();
        HashMap<String, Room> seenRooms = new HashMap<String, Room> ();
        Room currentRoom = game.getCurrentRoom();
        Parser parser = new Parser(new Player(game, inventory, seenRooms, currentRoom));

        while (! game.isOver()) 
            parser.executeTurn(game);

        System.out.println("Game over.");
    }
    
}
