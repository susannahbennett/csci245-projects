/**
 * 
 */
package game;

/**
 * @author stevenbarker
 *
 */
public class Solve implements Command {

	
	private Player p1;
	
	/**
	 * 
	 */
	public Solve(Player p1) {
		this.p1 = p1;
	}

	/* (non-Javadoc)
	 * @see game.Command#doSomething(game.Player)
	 */
	@Override
	public void doSomething() {
		

	}

	/**
	 * 	 
	 */
	@Override
	public void doSomething(String solution) {
		Problem obstacle  = p1.getCurrentRoom().getProblem();
		if(solution == obstacle.getSolution()) {
			System.out.println("Good job! You solved the problem, you may now move");
			obstacle.setSolved();
		}else {
			System.out.println("Try again");
		}

	}

}
