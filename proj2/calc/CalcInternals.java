/**
 * 
 */
package calc;

/**
 * CalcInternals
 * 
 * Class to represent the internal calculations and functions of a calculator
 * 
 * @author susannahbennett
 * CS 245, Wheaton College
 */

import java.util.*;

public class CalcInternals {
	/**
	 * An ArrayList to hold the two operands before they are evaluated
	 */
	private ArrayList<String> operation;
	/**
	 * String holding the current operand input
	 */
	private String currOperands;
	/**
	 * String holding the current operator input
	 */
	private String currOperator;
	/**
	 * String holding the previous operand input
	 */
	private String prevOperator;
	/**
	 * An object of the class CalculatorFace
	 */
	private CalculatorFace face;
	/**
	 * Double holding the temporary result of the initial operation of evaluate method
	 */
	private double result;
	/**
	 * Counts the number of operators entered before the operation is done
	 */
	private int counter;
	/**
	 * Checks to see if the operand and operator have already been evaluated yet
	 */
	private boolean flag;
	/**
	 * Holds the number of digits trying to be input on the screen
	 * Makes sure that the initial numbers don't leave the screen display
	 */
	private int digitCount;
	
	/**
	 * Constructor to initialize
	 * @param face
	 */
	public CalcInternals(CalculatorFace face) {
		currOperands = "";
		currOperator = "";
		prevOperator = "";
		operation = new ArrayList<String>();
		this.face = face;
		result = 0.0;
		counter = 0;
		flag = false;
		digitCount = 0;
	}

	/**
	 * Method to set the correct number inputs to be evaluated in the operation
	 * 
	 * @param currOperands String holding number sent by action listener
	 */
	public void setOperands (String currOperands){
		if ((result != 0.0 && currOperands.equals("")) || flag) {
			this.currOperands = "";
		}
		if (digitCount <= 14) {
			this.currOperands += currOperands;
		}
		face.writeToScreen(this.currOperands);
		flag = false;
		digitCount++;
	}
	
	/**
	 * Method to set the correct previous and current operators to be evaluated in the operation
	 * 
	 * @param operator String holding the operator symbol from button
	 */
	public void setOperator (String operator) {
		if (!flag) {
			operation.add(currOperands);
		}
		prevOperator = currOperator;
		currOperator = operator;
		counter++;
		if (counter > 1) {
			evaluate();
			counter = 0;
			setOperator(operator);
		}
		currOperands = "";
		digitCount = 0;
	}
	
	/**
	 * Method to format the decimal in the display and in the current operand
	 */
	public void decimalFormat() {
		if (currOperands.contains(".")) {
			return;
		}
		currOperands += ".";
		digitCount++;
		face.writeToScreen(currOperands);
	}
	/**
	 * Method to reset every value when the clear button is clicked
	 */
	public void clearScreen() {
		currOperands = "";
		currOperator = "";
		prevOperator = "";
		operation.clear();
		face.writeToScreen(currOperands);
		counter = 0;
		digitCount = 0;
		result = 0.0;
		flag = false;
	}
	
	/**
	 * Method to refresh the value of currOperands and resetting most other variables after an operation has occurred 
	 */
	public void refresh() {
		currOperands = Double.toString(result);

		operation.clear();
		operation.add(currOperands);
		face.writeToScreen(currOperands);
		counter = 0;
		digitCount = 0;
		flag = true;
	}
	
	/**
	 * Method to add or remove minus sign from the current operand
	 */
	public void plusMinus() {
		if (currOperands.contains("-")) {
			currOperands = currOperands.substring(1);
		} else {
			currOperands = "-" + currOperands;
		}
		digitCount++;
		face.writeToScreen(currOperands);
	}
	
	/**
	 * Method to perform the operation, between the operators and the operands
	 */
	public void evaluate () {
		operation.add(currOperands);
		currOperands = "";
		if (operation.get(0).equals("") || operation.get(0).equals(".") || operation.get(0).equals("-") || operation.get(1).equals("") ) {
			face.writeToScreen(operation.get(0));
			return;
		}
		if (operation.size() > 1) {
			
			if (prevOperator.equals("+") || (prevOperator.equals("") && currOperator.equals("+"))) {			
				String v1 = operation.get(0);
				String v2 = operation.get(1);
				result = (Double.parseDouble(v1)) + (Double.parseDouble(v2));
				
			} else if (prevOperator.equals("-") || (prevOperator.equals("") && currOperator.equals("-"))) {			
				String v1 = operation.get(0);
				String v2 = operation.get(1);
				result = (Double.parseDouble(v1)) - (Double.parseDouble(v2));
		
			} else if (prevOperator.equals("*") || (prevOperator.equals("") && currOperator.equals("*"))) {			
				String v1 = operation.get(0);
				String v2 = operation.get(1);
				result = (Double.parseDouble(v1)) * (Double.parseDouble(v2));
		
			} else if (prevOperator.equals("/") || (prevOperator.equals("") && currOperator.equals("/"))) {			
				String v1 = operation.get(0);
				String v2 = operation.get(1);
				result = (Double.parseDouble(v1)) / (Double.parseDouble(v2));
			
			}
			
			refresh();
		}
		
	}
	
	
	
}
