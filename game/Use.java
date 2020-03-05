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
	public void doSomething(String[] command) {
		item = keyboard.nextLine().toLowerCase();
		HashMap<String, Item> items = p1.getItemList();
		if (!items.containsKey(item)) {
			System.out.println("Inventory does not contain this item");
			return;
		}
		items.get(item).function(p1);
	}

}
