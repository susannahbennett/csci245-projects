package game;

import java.util.ArrayList;

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
        System.out.println("Welcome to the game");
        Game game = new Game();   // reference to the game object
        ArrayList<Item> inventory = new ArrayList<Item>();
        Room currentRoom = new Room("Room 0");
        Parser parser = new Parser(new Player(game, inventory, currentRoom));

        while (! game.isOver()) 
            parser.executeTurn(game);

        System.out.println("Game over.");
    }
    
}
