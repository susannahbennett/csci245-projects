package game;

import java.util.*;

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
    public Parser(Player p) {
        keyboard = new Scanner(System.in);
        p1 = p;
        actions = new HashMap<String, Command>(); 
        actions.put("help", new Help(p1, this));
        actions.put("look", new Look(p1));
        actions.put("use", new Use(p1));
        actions.put("pickup", new PickUp(p1, this));
        actions.put("map", new Map(p1));
        actions.put("solve", new Solve(p1));
        actions.put("read", new Read(p1));
        actions.put("move", new Move(p1));
        actions.put("inventory", new Inventory(p1));
        actions.put("drop", new Drop(p1)); 
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
        if(room.getProblem() != null)
        	p1.setCurrentProblem(room.getProblem());

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
    	String[] toreturn = new String[2];
    	if(c.contains(" ")) {
	    	toreturn[0] = c.substring(0, c.indexOf(" "));
	    	toreturn[1]	=c.substring(c.indexOf(" ")+1, c.length());
    	}else 
    		toreturn[0] = c;
    	return toreturn;
    }
    
    /**
     * 
     * @param s
     * @param c
     */
    public void addCommand(String s, Command c) { actions.put(s, c); }
    
    /**
     * 
     */
    public HashMap<String, Command> getCommands(){ return actions; }
    
    

}
