package calc;

import java.util.Stack;

/**
 * CalcInternals
 * 
 * Class to represent the internal calculations and functions of a calculator
 * 
 * @author Susannah Bennett
 * Wheaton College, CSCI 245, Spring 2020
 * Project 6
 * April, 2020
 *
 */

public class CalcInternals {
	/**
	 * Current object of CalculatorFace
	 */
	private CalculatorFace face;
	/**
	 * Stack holding the operands (last in, first out)
	 */
	private Stack<String> operands;
	/**
	 * String holding the most recent digits put in before the "."
	 */
	private String currNum;
	/**
	 * Boolean indicating whether currNum has been put in the stack yet
	 */
	private boolean pushed;
	/**
	 * Holds values/operands when operations are being done
	 */
	private int num1, num2;
	/**
	 * Boolean indicating whether a current operation is being done or not
	 */
	private boolean activeOperation;
	/**
	 * Constructor for initializing
	 * @param face Current object of CalculatorFace
	 */
	public CalcInternals(CalculatorFace face) {
		this.face = face;
		operands = new Stack<>();
		currNum = "";
		pushed = false;
		num1 = 0;
		num2 = 0;
		activeOperation = false;
	}
	/**
	 * Method for what happens when the "." is pressed.
	 * This method updates the stack and other values.
	 */
	public void nextOperand() {
		operands.push(currNum);
		currNum = "";
		face.writeToScreen(".");
		pushed = true;
	}
	/**
	 * Method for what happens when the clear button is pressed.
	 * This methods resets all of the values.
	 */
	public void clearScreen() {
		face.writeToScreen("");
		while(!operands.empty()) {
			operands.pop();
		}
		pushed = false;
		currNum = "";
		activeOperation = false;
	}
	/**
	 * Method for what happens when a number is pressed.
	 * The numbers are added to currNum and they are not pushed yet.
	 * @param number The number button was pressed
	 */
	public void setOperands(String number) {
		currNum += number;
		face.writeToScreen(currNum);
		pushed = false;
	}
	/**
	 * Method called from one of the operation evaluate methods (and plusMinus).
	 * It checks whether numbers have been pushed and works with setting up operations.
	 */
	public void setUpEval() {
		if (!pushed) {
			operands.push(currNum);
			currNum = "";
			pushed = true;
		}
		if(activeOperation) {
			num2 = Integer.parseInt(operands.pop());
			num1 = Integer.parseInt(operands.pop());
		}
	} 
	/**
	 * Method called when the + button is pressed.
	 * It adds two numbers together and puts the result in the stack.
	 */
	public void evalPlus() {
		if(operands.empty()) { return; }
		activeOperation = true;
		setUpEval();
		
		operands.push(Integer.toString(num1 + num2));
		
		face.writeToScreen(Integer.toString(num1 + num2));
		activeOperation = false;
	}
	/**
	 * Method for when the - button is pressed.
	 * It subtracts two numbers and puts the result in the stack.
	 */
	public void evalMinus() {
		if(operands.empty()) { return; }
		activeOperation = true;
		setUpEval();
		
		operands.push(Integer.toString(num1 - num2));
		
		face.writeToScreen(Integer.toString(num1 - num2));
		activeOperation = false;
	}
	/**
	 * Method for when the / button is pressed.
	 * It divides two numbers and puts the result in the stack.
	 */
	public void evalDiv() {
		if(operands.empty()) { return; }
		activeOperation = true;
		setUpEval();
			
		operands.push(Integer.toString(num1 / num2));
		
		face.writeToScreen(Integer.toString(num1 / num2)); 
		activeOperation = false;
	}
	/**
	 * Method for when the * button is pressed.
	 * It multiplies two numbers together and puts the result in the stack.
	 */
	public void evalMult() {
		if(operands.empty()) { return; }
		activeOperation = true;
		setUpEval();
		
		operands.push(Integer.toString(num1 * num2));
		
		face.writeToScreen(Integer.toString(num1 * num2));
		activeOperation = false;
	}
	/**
	 * Method for when the +- button is pressed.
	 * It changes the current operands value to negative/to positive and updates the stack.
	 */
	public void plusMinus() {
		setUpEval();
		
		int temp = -1 * (Integer.parseInt(operands.pop()));
		String t = Integer.toString(temp);
		operands.push(t);
		face.writeToScreen(t);
	}
	
}
