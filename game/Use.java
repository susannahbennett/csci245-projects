package game;

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
		if (!p1.getItemList().contains(item)) {
			System.out.println("Inventory shows this item doesn't exist");
			return;
		}
		item.function(p1);

	}

}
