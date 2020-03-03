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
        actions.put("read", new Read(p1));
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
        String[] parsedcom = parseCommand(command);


        if(room.getMap().containsKey(parsedcom[0])) {
            
        	p1.setNextRoom(room.getDirection(parsedcom[0]));
        	Room nextroom = p1.getNextRoom();
            
        	if (nextroom == null) 
                System.out.println("There is no door in that direction.");
            else if(nextroom.enterable()) {
            	p1.updateMap(room.getDescription(), room);
            	game.setCurrentRoom(nextroom);
            	p1.setCurrentRoom(nextroom);
            }else 
            	System.out.println("You cannot move there yet");
            	System.out.println("Running problem");
        		nextroom.getProblem().runProblem();
            	
        }else if(actions.containsKey(parsedcom[0])) 
        	actions.get(parsedcom[0]).doSomething(parsedcom);
                	
        else
            System.out.println("I do not know how to " + parsedcom[0] + ".");

    }
    
    public String[] parseCommand(String command) {
    	if(!command.contains(" ")) {
    		String[] toreturn = {command};
    		return toreturn;
    	}
    	return command.split(" ");	
    }
    
    

}
