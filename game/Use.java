package game;

import java.util.HashMap;
import java.util.Scanner;

public class Use implements Command {
	
	private Player p1;
	private Scanner keyboard;
	private String item;

	public Use(Player p1) {
		this.p1 = p1;
		keyboard = new Scanner(System.in);
		item = "";
	}

	@Override
	public void doSomething(Player p1) {
		item = keyboard.nextLine().toLowerCase();
		HashMap<String, Item> items = p1.getItemList();
		if (!items.containsKey(item)) {
			System.out.println("Inventory shows this item doesn't exist");
			return;
		}
		items.get(item).function(p1);
	}

	/**
	 * 
	 */
	public void doSomething(Player p1, String itemname) {
		
	}

	@Override
	public void doSomething(Player p1, String itemname) {}

}
