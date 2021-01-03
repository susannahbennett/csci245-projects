package calc;

import java.lang.Math;
import java.text.DecimalFormat;
import java.util.Stack;

/**
 * Class representing the "brain" of the calculator that coordinates the 
 * internal calculations
 * 
 * @author Susannah Bennett
 * Wheaton College, CSCI 245, Spring 2020
 * Project 7
 * April, 2020
 */

public class CalcInternals {
	/**
	 * Stack containing the operands to be evaluated
	 */
	private Stack<Double> operands;
	/**
	 * Current instance of face
	 */
	private CalculatorFace face;
	/**
	 * Holds current operation; instance of the abstract class Operation
	 */
	private Operation operation;
	/**
	 * Double holding the current number entered
	 */
	private double currOperands;
	/**
	 * Int holding the number of digits over the decimal point is
	 * Only applicable for operands with decimals
	 */
	private int counter;
	/**
	 * Int holding the sign value of currOperands (-1 or 1)
	 */
	private int plusMinus;
	/**
	 * Holds current state currOperands is in (either normal operands or decimal)
	 */
	private State current;
	/**
	 * Decimal formatting
	 */
	private DecimalFormat df;

	/**
	 * Constructor to initialize
	 * @param face This instance of CalculatorFace
	 */
	public CalcInternals(CalculatorFace face) {
		operands = new Stack<Double>();
		this.face = face;
		currOperands = 0;
		counter = 0;
		plusMinus = 1;
		current = new firstOperands();
		df = new DecimalFormat("###.##########");
	}
	/**
	 * Method for when buttons are pressed
	 * @param numButton Int of button pressed
	 */
	public void setOperands (int numButton){
		current.digit(numButton);
		current.updateScreen();
	}
	/**
	 * Method for when an operator is pressed
	 * @param op Operation of what the current operation will change to
	 */
	public void setOperator (Operation op) {
		current.operate();
		current = new secondOperands();
		plusMinus = 1;
		operation = op;
		counter = 0;
	}	
	/**
	 * Method for setting up the decimal as a state and operand
	 */
	public void decimal() {
		current = current.setDecOp();
	}
	/**
	 * Method setting all of the values back to their starting positions
	 */
	public void reset() {
		operands.clear();
		operation = null;
		current = new firstOperands();
		currOperands = 0;
		counter = 0;
		plusMinus = 1;
		face.writeToScreen("");
	}
	/**
	 * Method for when the equals sign is pressed
	 * Based on the state, the correct operation will be fulfilled
	 */
	public void goToOperation() {
		current.operate();
		counter = 0;
		plusMinus = 1;
		current = new firstOperands();
	}
	/**
	 * Method for when the plusMinus button is pressed
	 */
	public void plusMinus() {
		plusMinus = -1 * plusMinus;
		current.updateScreen();
	}
	/**
	 * Abstract class representing the different states of calculator operands
	 */
	private abstract class State {
		/**
		 * Method for changing what is displayed on the calculator face
		 */
		public abstract void updateScreen();
		/**
		 * Method for pushing operands to the stack and potentially, completing the operation
		 */
		public abstract void operate();
		/**
		 * Method for setting up the decimal operands initially
		 * @return The state to change to (a decimal operands)
		 */
		public abstract State setDecOp();
		/**
		 * Method that updates the currOperands
		 * @param n Int of the button's number
		 */
		public abstract void digit(int n);

	}
	/**
	 * Class representing the state when the first operand is not a decimal
	 * 
	 */
	private class firstOperands extends State {
		/**
		 * Method that displays the current operands as an int
		 */
		public void updateScreen() {
			face.writeToScreen(Integer.toString(plusMinus * (int)currOperands));
		}
		/**
		 * Method that pushes the most recent operands
		 */
		public void operate() {
			operands.push(plusMinus * currOperands);
			currOperands = 0;
			
		}
		/**
		 * Method that sets up the operand for being in the decimal state
		 * @return state The new decimal state to be in
		 */
		public State setDecOp() {
			counter++;
			face.writeToScreen(Double.toString(currOperands));
			return new firstDecimal();
		}
		/**
		 * Method that is called when a number button is pressed and where 
		 * currOperands is updated
		 * @param n The numButton to be added to the current operand
		 */
		public void digit(int n) {
			currOperands = (currOperands * 10) + n;
		}
	}
	/**
	 * Class representing the state when the second operand is not a decimal
	 * 
	 */
	private class secondOperands extends State {
		/**
		 * Method that displays the current operands as an int
		 */
		public void updateScreen() {
			face.writeToScreen(Integer.toString(plusMinus * (int)currOperands));
		}
		/**
		 *  Method that pushes the most recent operands and runs the current operation
		 *  on the operands in the stack for operands
		 */
		public void operate() {
			operands.push(currOperands * plusMinus);
			currOperands = 0;
		
			operands = operation.evaluate(operands);
			
			face.writeToScreen(Double.toString(operands.peek()));
		}
		/**
		 * Method that sets up the operand for being in the decimal state
		 * @return state The new decimal state to be in
		 */
		public State setDecOp() {
			counter++;
			face.writeToScreen(Double.toString(currOperands));
			return new secondDecimal();
		}
		/**
		 * Method that is called when a number button is pressed and where
		 * currOperands is updated
		 * @param n The numButton to be added to the current operand
		 */
		public void digit(int n) {	
			currOperands = (currOperands * 10) + n;
		}
	}
	/**
	 * Class representing the state when the first operand is a decimal
	 */
	private class firstDecimal extends State {
		/**
		 * Method that updates the screen with currOperands as a double
		 */
		public void updateScreen() {
			face.writeToScreen(Double.toString(currOperands * plusMinus));
		}
		/**
		 * Method that pushes the current operand
		 */
		public void operate() {
			operands.push(currOperands * plusMinus);
			currOperands = 0;
		}
		/**
		 * Returns the current state
		 * @return state The current decimal state to be in
		 */
		public State setDecOp() { 
			return current;
		}
		/**
		 * Method that is called when a number button is pressed and where
		 * currOperands and counter are updated
		 * @param n The numButton to be added to the current operand
		 */
		public void digit(int n) {
			currOperands = currOperands + (n / Math.pow(10, counter));
			counter++;
			currOperands = Double.parseDouble(df.format(currOperands));
			face.writeToScreen(df.format(currOperands));
		}
	}
	/**
	 * Class representing the state when the second operand is a decimal
	 */
	private class secondDecimal extends State {
		/**
		 * Method that updates the screen with currOperands as a double
		 */
		public void updateScreen() {
			face.writeToScreen(Double.toString(currOperands * plusMinus));
		}
		/**
		 * Method that pushes the current operand and completes the given
		 * operation on the stack of operands
		 */
		public void operate() {
			operands.push(currOperands * plusMinus);
			currOperands = 0;
			
			operands = operation.evaluate(operands);
			
			face.writeToScreen(Double.toString(operands.peek()));
		}
		/**
		 * Returns the current state
		 * @return state The current decimal state to be in 
		 */
		public State setDecOp() {
			return current;
		}
		/**
		 * Method that is called when a number button is pressed and where
		 * currOperands and counter are updated
		 * @param n The numButton to be added to the current operand
		 */
		public void digit(int n) {
			currOperands = currOperands + Math.copySign(n, 1)/Math.pow(10, counter);
			counter++;
			currOperands = Double.parseDouble(df.format(currOperands));
			face.writeToScreen(df.format(currOperands));
		}
		
	}
}
	