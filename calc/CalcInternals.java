package calc;

import java.util.ArrayList;

public class CalcInternals {
	
	private String currNum;

	private CalculatorFace face;
	
	private boolean activeOperation;

	/**
	 * Constructor to initialize
	 * @param face
	 */
	public CalcInternals(CalculatorFace face) {
		currNum = "";
		this.face = face;
		activeOperation = false;

	}
	/**
	 * Method to set the correct number inputs to be evaluated in the operation
	 * 
	 * @param currOperands String holding number sent by action listener
	 */
	public void setOperands (String numButton){
		currNum += numButton;
		face.writeToScreen(currNum);
		activeOperation = true;
	}
	/**
	 * Method to set the correct previous and current operators to be evaluated in the operation
	 * 
	 * @param operator String holding the operator symbol from button
	 */
	public void setOperator (String operator) {
	
	}
	/**
	 * Method to format the decimal in the display and in the current operand
	 */
	public void decimalFormat() {

	}
	/**
	 * Method to reset every value when the clear button is clicked
	 */
	public void clear() {

	}
	
	/**
	 * Sets up the evaluation
	 */
	public void setUpEval() {
		//check if operation.size() > 1
		//check if current operation in progress (for plus minus case)
		//String v1 = operation.get(0);
		//String v2 = operation.get(1);
	}
	
	/**
	 * Method to add or remove minus sign from the current operand
	 */
	public void plusMinus() {
		int temp = Integer.parseInt(currNum) * -1;
		currNum = Integer.toString(temp);
		face.writeToScreen(currNum);
	}
	/**
	 * Method called when the + button is pressed.
	 * It adds two numbers together and puts the result in the stack.
	 */
	public void evalPlus() { 
		setUpEval();
		
	}
	/**
	 * Method for when the - button is pressed.
	 * It subtracts two numbers and puts the result in the stack.
	 */
	public void evalMinus() {
		setUpEval();
	}
	/**
	 * Method for when the / button is pressed.
	 * It divides two numbers and puts the result in the stack.
	 */
	public void evalDiv() {
		setUpEval();
	}
	/**
	 * Method for when the * button is pressed.
	 * It multiplies two numbers together and puts the result in the stack.
	 */
	public void evalMult() {
		setUpEval();
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
