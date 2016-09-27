package game;

/**
 * Parser.java
 * 
 * Class to interpret the user's commands
 *
 * @author Thomas VanDrunen
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */

import java.util.Scanner;

public class Parser {

    /**
     * For user input from the keyboard.
     */
    private Scanner keyboard;

    /**
     * Plain constructor
     */
    public Parser() {
        keyboard = new Scanner(System.in);
    }

    /**
     * Let the user make one "turn" at this game.
     * Give the user a description of the room, prompt for
     * a command, and interpret the command.
     * @param game A reference to the object representing the game.
     */
    public void executeTurn(Game game) {
        // The room that the user is in.
        Room room = game.getCurrentRoom();

        System.out.println("You are in " + room.getDescription());

        System.out.print("Enter command--> ");
        String command = keyboard.nextLine().toLowerCase();  // user's command


        if (command.equals("north") || command.equals("south") 
            || command.equals("west") || command.equals("east")) {
            Room nextRoom;   // the room we're moving to
            if (command.equals("north"))
                nextRoom = room.getNorth();
            else if (command.equals("south"))
                nextRoom = room.getSouth();
            else if (command.equals("west"))
                nextRoom = room.getWest();
            else
                nextRoom = room.getEast();
            if (nextRoom == null) 
                System.out.println("There is no door in that direction.");
            else
                game.setCurrentRoom(nextRoom);
        }
        else
            System.out.println("I do not know how to " + command + ".");

    }


}
