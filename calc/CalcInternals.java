package calc;


import java.util.Stack;

public class CalcInternals {
	
	private Stack<Double> operands;

	private CalculatorFace face;
	
	private Operation operation;
	
	private double currOperands;


	/**
	 * Constructor to initialize
	 * @param face
	 */
	public CalcInternals(CalculatorFace face) {
		this.face = face;
		currOperands = 0.0;
		operands = new Stack<Double>();
	}
	/**
	 * Method to set the correct number inputs to be evaluated in the operation
	 * 
	 * @param currOperands String holding number sent by action listener
	 */
	public void setOperands (int numButton){

		currOperands = (currOperands * 10) + numButton;
		
		face.writeToScreen(Double.toString(currOperands));
	}
	/**
	 * Method to set the correct previous and current operators to be evaluated in the operation
	 * 
	 * @param operator String holding the operator symbol from button
	 */
	public void setOperator (Operation op) {
		operands.push(currOperands);
		currOperands = 0;
		if (operands.size() > 1) {
			evaluate();
		}
		operation = op;
	}	
	/**
	 * Method to format the decimal in the display and in the current operand
	 */
	public void decimal() {

	}
	/**
	 * Method to reset every value when the clear button is clicked
	 */
	public void clear() {
		while(!operands.isEmpty()){
			operands.pop();
		}
		currOperands = 0;
		face.writeToScreen("");
	}
	
	public void evaluate() {
		if (currOperands != 0) {
			operands.push(currOperands);
			currOperands = 0;
		}
		operands = operation.evaluate(operands);
		face.writeToScreen(Double.toString(operands.pop()));
	}
	/**
	 * Method to add or remove minus sign from the current operand
	 */
	public void plusMinus() {
		//what if there isn't a number in the stack
		currOperands = currOperands * -1;
		operands.push(currOperands);
		face.writeToScreen(Double.toString(currOperands));
	}
}
	