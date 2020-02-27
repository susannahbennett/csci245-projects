/**
 * 
 */
package game;

/**
 * @author stevenbarker
 *
 */
public class Solve implements Command {

	private Problem obstacle;
	
	/**
	 * 
	 */
	public Solve(Problem obstacle) {
		this.obstacle = obstacle;
	}

	/* (non-Javadoc)
	 * @see game.Command#doSomething(game.Player)
	 */
	@Override
	public void doSomething(Player p1) {
		

	}

	/**
	 * 	 
	 */
	@Override
	public void doSomething(Player p1, String solution) {
		if(solution == obstacle.getSolution()) {
			System.out.println("Good job! You solved the problem, you may now move");
			obstacle.setSolved();
		}else {
			System.out.println("Try again");
		}

	}

}
