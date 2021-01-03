package calc;

import java.util.Stack;
/**
 * Abstract class representing the different operations to be done 
 * on the calculator
 * 
 * @author Susannah Bennett
 * Wheaton College, CSCI 245, Spring 2020
 * Project 7
 * April, 2020
 */
public abstract class Operation{
	/**
	 * Method that returns the result of the particular operation
	 * @param operands A stack of operands(2) to evaluate
	 * @return operands A stack containing only the result 
	 */
	public abstract Stack<Double> evaluate(Stack<Double> operands);
	/**
	 * Class representing the add operation
	 *
	 */
	public static class Add extends Operation {
		/**
		 * Method that adds the two operands
		 * @param operands A stack of operands(2) to add
		 * @return operands A stack containing only the result
		 */
		public Stack<Double> evaluate(Stack<Double> operands) {
			double n1 = operands.pop();
			double n2 = operands.pop();
			operands.push(n1 + n2);
			return operands;
		}
	}
	/**
	 * Class representing the subtract operation
	 *
	 */
	public static class Subtract extends Operation {
		/**
		 * Method that subtracts the two operands
		 * @param operands A stack of operands(2) to subtract
		 * @return operands A stack containing only the result
		 */
		public Stack<Double> evaluate(Stack<Double> operands) {
			double n1 = operands.pop();
			double n2 = operands.pop();
			operands.push(n2 - n1);
			return operands;
		}
	}
	/**
	 * Class representing the multiply operation
	 *
	 */
	public static class Multiply extends Operation {
		/**
		 * Method that multiples the two operands
		 * @param operands A stack of operands(2) to multiply
		 * @return operands A stack containing only the result
		 */
		public Stack<Double> evaluate(Stack<Double> operands) {
			double n1 = operands.pop();
			double n2 = operands.pop();
			operands.push(n1 * n2);
			return operands;
		}
	}
	/**
	 * Class representing the divide operation
	 *
	 */
	public static class Divide extends Operation {
		/**
		 * Method that divides the two operands
		 * @param operands A stack of operands(2) to divide
		 * @return operands A stack containing only the result
		 */
		public Stack<Double> evaluate(Stack<Double> operands) {
			double n1 = operands.pop();
			double n2 = operands.pop();
			operands.push(n2 / n1);
			return operands;
		}
	}
}