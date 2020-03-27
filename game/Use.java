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
		//item = keyboard.nextLine().toLowerCase();
		HashMap<String, Item> items = p1.getItemList();
		if (!items.containsKey(command[1])) {
			System.out.println("Inventory does not contain this item");
			return;
		}
		System.out.println("contains item");
		items.get(command[1]).function(p1);
	}

	@Override
	public String getDescription() {return "Use an item in your inventory"; }

}
