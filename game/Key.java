package game;

import java.util.Scanner;

/**
 * @author stevenbarker
 *
 */
public class Key implements Item {

	public void function(Player p1) {
		Room r = p1.getCurrentRoom();
		
		Scanner keyboard = new Scanner(System.in);
		
		while(true) {
			System.out.println("Which door would you like to try to unlock? ->");
			String door = keyboard.nextLine().toLowerCase();
			
			if(r.getMap().containsKey(door)) {
				System.out.println("This door is now unlocked!");
				break;
			}else {
				System.out.println("That door does not exist, please try again");
			}
		}
		keyboard.close();
		
		
		
	}
	
}
