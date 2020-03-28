package game;

import java.util.HashMap;

/**
 * Game.java
 * 
 * Class to model the game as a collection of rooms. The
 * rooms are organized as a graph, and the Room objects
 * are nodes in the graph.
 *
 * @author Thomas VanDrunen
 * Wheaton College, CS 245, Spring 2007
 * Lab 5
 * Feb 8, 2007
 */

public class Game {
	
    /**
     * The current room the user is in. This serves to
     * purposes-- it is our only permanent connection to
     * the rooms in this game (the other rooms are reachable
     * by traversing this room's "doors"-- and it maintains
     * the state by representing the user's current location.
     */
    private Room currentRoom;
    
    /**
     * Each of these are used for color coding output to help the user
     * RED: Unused as of now
     * RESET: used after each colored word to keep other text from being colored
     * BLUE: Used for useable, gettable items
     * GREEN: Used for movable places
     * CYAN: Used for executable commands
     */
    public static final String RED = "\u001B[31m";
	public static final String RESET = "\u001B[0m";
	public static final String BLUE = "\u001B[34m";
	public static final String GREEN = "\u001B[32m";
	public static final String CYAN = "\u001B[36m";

    /**
     * Keeps track of whether this game is over or not.
     */
    private boolean over;
    
    /**
     * Return the room in which the user is currently.
     */
    public Room getCurrentRoom() { return currentRoom; }
    
    /**
     * Constructor to set up the game.
     */
    public Game() {
        Room[] rooms = new Room[14];
        // rooms[0] = new Room("porch", "You’re currently outside the house. \nTo move inside the house, enter " + Game.CYAN + "move to entryway." + Game.RESET);
        rooms[0] = new Room("porch", "You’re currently outside the house. \nTo move inside the house, enter " + Game.CYAN + "move" + Game.RESET  + "to" + Game.GREEN +  "entryway." + Game.RESET);
        rooms[1] = new Room("entryway", "\nNow you’re in the house. From where you are now, you can either move to the rooms upstairs or move to the rooms on the main floor." + 
        		"\n\nTo see the rooms you can move to, enter " + Game.CYAN + "look" + Game.RESET + ". For help about commands you can use, enter " + Game.CYAN + "help" + Game.RESET + ".");
        rooms[2] = new Room("stairs", "\nYou look ahead at a locked door. If prompted with a puzzle or riddle, enter " + Game.CYAN + "solve " + Game.RESET + "and your answer to unlock it.");
        rooms[3] = new Room ("hallway", "\nYou are now upstairs. Some rooms may be locked; to unlock them, you must find and pick up the key (enter " + Game.CYAN + "pickup " + Game.RESET + "). "
        		+ "\nUse the " + Game.CYAN + "pickup all" + Game.RESET + " command to pick up all items in a room. However, don’t pick up every item you come across" +
        		"because you have limited space in your bag for items. To view your inventory, enter inventory.");
        rooms[4] = new Room("bedroom", "\nYou look across the room, and see something."
        		+ "To determine how to use the item, enter " + Game.CYAN + "help " + Game.RESET + "and the item's name. To drop an item, use "+ Game.CYAN + "drop");
        rooms[5] = new Room("bathroom", "\n The lights flicker as cockroaches scurry across the floor.  Peeling wallpaper and a leaky faucet reveal the room’s age. ");
        rooms[6] = new Room("master bedroom", "\nThe room is musty and dark.  A desk in the corner is covered in papers and other miscellaneous items. "
        		+ "\n With the magnifying glass in the room, you now have the " + Game.CYAN + "inspect " + Game.RESET + "command."
        				+ "\n You must be holding an item to inspect it. " );
        rooms[7] = new Room("living room", "\nYou hear creaks coming from upstairs. Better hurry to find the treasure before this N.C. person!\n"
        		+ "Some items need to be read; to do so, use the " + Game.CYAN + "use " + Game.RESET + "command."
        				+ "To get more information about the item, you will need the magnifying glass to " + Game.CYAN + "inspect" + Game.RESET + " it.");
        rooms[8] = new Room("kitchen", "\nSome items you find may not be helpful in your search for the treasure. "
        		+ "Remember to limit the items you pick up and put in your inventory.");
        rooms[13] = new Room("other room", "\nRoom where you die");
        rooms[9] = new Room("deck", "\nSome items might be parts of a series, so make sure to " + Game.CYAN + "inspect" + Game.RESET + " the additional information about items.");
        rooms[10] = new Room("dining room", "\nThe study seems suspicious... Stay on your toes as you get closer to the last puzzles and the treasure.");
        rooms[11] = new Room("study", "There's a large bookcase. There isn't an obivious exit from the room, but you think there might be another room beyond this one. "+
        		"\n The bookshelf looks like it revolves, revealing an exit.  To get past the revolving door, you pull a book on the shelf "
        		+"\n enter " + Game.CYAN + "move to hidden room "+ Game.RESET+ " to enter the final room. ");
        rooms[12] = new Room("hidden room", " ");

        //items:
        Key keyToMasterBed = new Key(); // in hallway
        rooms[3].addItem("key to master bed", keyToMasterBed);
        Key keyToBedroom = new Key(); //in bathroom
        rooms[5].addItem("key to bedroom", keyToBedroom);
        Paper cutout = new Paper("Cardboard cutout of Nicolas Cage", true);
        cutout.addInspection("Dang, his eyebrows even look good on cardboard!");
        rooms[5].addItem("Cardboard cutout", cutout);
        MagnifyingGlass glass = new MagnifyingGlass();//in master bedroom
        rooms[6].addItem("magnifying glass", glass);
        DynamicMap dm = new DynamicMap(); //in bedroom
        dm.addInspection("Changing map that shows you rooms you've already been to (and hidden rooms)");
        rooms[4].addItem("map", dm);
        Paper poster = new Paper("National Treasure movie Premiere: November 14, 2004", true); //in bedroom
        rooms[6].addItem("old poster", poster);
        poster.addInspection("The movie poster looks epic! It's even signed by Nicolas Cage!!");
        Paper toKitchen = new Paper("HTEPLENA",true); //in living room
        rooms[7].addItem("notebook paper", toKitchen);
        Paper newspaper = new Paper("The New York Times\t Headline: Declaration of Independence Goes Missing (Published October 1, 2019)", true); // in living room
        newspaper.addInspection("An old newspaper on a chair in the living room");
        rooms[7].addItem("newspaper", newspaper); 
        Paper throwblanket = new Paper("Throw blanket with Nicholas Cage's face on it", true); // in living room
        throwblanket.addInspection("It's Barky's favorite blanket!");
        rooms[7].addItem("Nicholas Cage throw blanket", throwblanket);
		Lemon lemon = new Lemon(); //in kitchen
		rooms[8].addItem("lemon", lemon);
		Paper toDining = new Paper("A great treasure lies behind this door; knock to enter", false); //in the kitchen
        toDining.addInspection("This paper looks worn and old.");
        rooms[8].addItem("crumpled paper", toDining);
        Paper cageRecipe = new Paper("Mama Cage's lemon bar recipe", true);
        cageRecipe.addInspection("Wait... this recipe was signed by Joy Cage!");
        rooms[8].addItem("Joy's baking guide", cageRecipe);
		Paper recipe = new Paper("recipe for lemonade", true); // in the kitchen
		rooms[8].addItem("recipe", recipe);
		Paper dogtreat = new Paper("dog treat", true); // in the kitchen
		dogtreat.addInspection("Looks tasty");
		rooms[8].addItem("dog treat", dogtreat);
		recipe.addInspection("Stained, old recipe for juicing lemons");
        Key keyToLiving = new Key();//in master bedroom
        rooms[6].addItem("key to living room", keyToLiving);
        Paper mug = new Paper("You are my national treasure", true);
        mug.addInspection("Nothing like Cage Face merch to say \"I love you\"");
        
        //these four clues together will unlock the study (final room)
       /**
        * Treehouse items commented out because they are in dynamic map
        * Paper piece1 = new Paper("7", true); 
        * piece1.addInspection("The paper appears to be ripped... look for missing pieces to complete the message");
        */
        Paper piece2 = new Paper("7", false); // in master bed
        piece2.addInspection("The paper appears to be ripped... look for missing pieces to complete the message");
        Paper piece3 = new Paper("6", false); // on deck
        piece3.addInspection("The paper appears to be ripped... look for missing pieces to complete the message");
        Paper piece4 = new Paper("1", true); // in dining room
        piece4.addInspection("The paper appears to be ripped... look for missing pieces to complete the message");
        rooms[6].addItem("torn paper 2", piece2);
        rooms[9].addItem("torn paper 3", piece2);
        rooms[10].addItem("torn paper 4", piece2);
     
        // Room exits:
        rooms[0].setExit("to entryway", new NormalExit(rooms[1]));
        rooms[0].setExit("back", new NullExit(rooms[0]));
        rooms[1].setExit("to porch", new NormalExit(rooms[0]));
        rooms[1].setExit("to stairs", new NormalExit(rooms[2]));
        rooms[1].setExit("to living room", new LockedDoorExit(rooms[7], keyToLiving));
        rooms[2].setExit("to entryway", new NormalExit(rooms[1]));
        rooms[2].setExit("to hallway", new ProblemExit(rooms[3], new Puzzle("Answer this riddle to unlock the door: password is password", "password", null)));
        rooms[3].setExit("to stairs", new NormalExit(rooms[2]));
        rooms[3].setExit("to bedroom", new LockedDoorExit(rooms[4], keyToBedroom));
        rooms[3].setExit("to bathroom", new NormalExit(rooms[5]));
        rooms[3].setExit("to laundry shoot", new DeathExit(rooms[13]));
        rooms[3].setExit("to master bedroom", new LockedDoorExit(rooms[6], keyToMasterBed)); 
       	rooms[5].setExit("to hallway", new NormalExit(rooms[3]));
       	rooms[5].setExit("to master bedroom", new LockedDoorExit(rooms[6], keyToMasterBed));
       	rooms[6].setExit("to hallway", new NormalExit(rooms[3]));
       	rooms[6].setExit("to bathroom", new NormalExit(rooms[5]));
       	rooms[7].setExit("to kitchen", new ProblemExit(rooms[8], new Puzzle("Unscramble given letters to unlock door(Hint: find paper item in room)", "elephant", null)));
       	rooms[7].setExit("to entryway", new NormalExit(rooms[1]));
       	rooms[8].setExit("to living room", new NormalExit(rooms[7]));
       	rooms[8].setExit("to hidden exit", new DeathExit(rooms[13]));
       	
        HashMap<String, Item> requireditems = new HashMap<>();
        requireditems.put("dog treat", dogtreat);
        requireditems.put("Nicholas Cage throw blanket", throwblanket);
       	
       	rooms[8].setExit("to deck", new InventoryExit(rooms[9], requireditems));
       	rooms[8].setExit("to dining room", new ProblemExit(rooms[10], new Puzzle("When life gives you lemons... try decoding the hidden message", "knock", null)));
       	rooms[9].setExit("to kitchen", new NormalExit(rooms[8]));
       	rooms[10].setExit("to kitchen", new NormalExit(rooms[9]));
       	rooms[10].setExit("to study", new ProblemExit(rooms[11], new Puzzle("To unlock the door, you must enter the correct 4-digit code", "1776", null)));
       	rooms[11].setExit("to dining room", new NormalExit(rooms[10]));
     
       	//rooms[11].setExit("to another room", new ProblemExit);


        over = false;
        currentRoom = rooms[0];
    }
    
    /**
     * Is this game over or not?
     */
    public boolean isOver() { return over; }

    /**
     * Move into a different current room.
     */
    public void setCurrentRoom(Room currentRoom) { this.currentRoom = currentRoom; }

    /**
     * Indicate that the game is now over.
     */
    public void finishGame() { 
    	try {
    		
    		System.out.println( Game.RED + ".");
    		Thread.sleep(1000);
    		System.out.println(".");
    		Thread.sleep(1000);
    		System.out.println(".");
    		Thread.sleep(1000);
    		System.out.println(".");
    		
    	}catch(Exception e) {}
    	
    	System.out.println("Thank you for playing the game!!");
    	System.out.println("This game is made by Susannah Bennett, Kali Grose, and Steven Barker" +
    	"for CSCI245 Spring 2020");
    	System.out.println("Have a nice day" + Game.RESET);
    	over = true;
    	
    }
    
}
