package game;

import java.util.HashMap;

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
    
    private HashMap<String, Command> actions;
    
    private Player p1;
    

    

    /**
     * Plain constructor
     */
    public Parser(Player p1) {
        keyboard = new Scanner(System.in);
        this.p1 = p1;
        actions = new HashMap<String, Command>(); 
        actions.put("help", new Help(p1));
        actions.put("look", new Look(p1));
        actions.put("use", new Use(p1));
        actions.put("pickup", new PickUp(p1));
        actions.put("map", new Map(p1));
        actions.put("solve", new Solve(p1));
        //actions.put("travel",new Travel(p1));
        actions.put("read", new Read(p1));
        actions.put("move", new Move(p1));

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
        String[] parsedcom = parse(command);

        if(actions.containsKey(parsedcom[0])) 
        	actions.get(parsedcom[0]).doSomething(parsedcom);
                	
        else
            System.out.println("I do not know how to " + parsedcom[0] + ".");

    }
    
    
    /**
     * Parses the command to a usable String[] to do different operation on each word in the command.
     * Commands will always either be one or two words.
     * @param command The command given
     * @return String[] containing the words in the command separated by the first space
     */ 
    public String[] parse(String c) {
    	String[] toreturn = {c.substring(0, c.indexOf(" ")), c.substring(c.indexOf(" ")+1, c.length())};
    	return toreturn;
    }
    
    

}
