package calc;

import java.util.Stack;

public abstract class Operation{
	
	public abstract Stack<Double> evaluate(Stack<Double> operands);

	public static class Add extends Operation {
		public Stack<Double> evaluate(Stack<Double> operands) {
			double n1 = operands.pop();
			double n2 = operands.pop();
			operands.push(n1 + n2);
			return operands;
		}
	}
	
	public static class Subtract extends Operation {
		public Stack<Double> evaluate(Stack<Double> operands) {
			double n1 = operands.pop();
			double n2 = operands.pop();
			operands.push(n2 - n1);
			return operands;
		}
	}

	public static class Multiply extends Operation {
		public Stack<Double> evaluate(Stack<Double> operands) {
			double n1 = operands.pop();
			double n2 = operands.pop();
			operands.push(n1 * n2);
			return operands;
		}
	}

	public static class Divide extends Operation {
		public Stack<Double> evaluate(Stack<Double> operands) {
			double n1 = operands.pop();
			double n2 = operands.pop();
			operands.push(n2 / n1);
			return operands;
		}
	}
}