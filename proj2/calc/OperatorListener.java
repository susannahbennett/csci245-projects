package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * OperatorListener
 * 
 * ActionListener class that passes into the CalcInternals where the respective operator will be set 
 * Implements the ActionListener class
 * 
 * @author susannahbennett
 * CS 245, Wheaton College
 */
public class OperatorListener implements ActionListener {
	/**
	 * Holds the character passed from the button being clicked
	 */
	private char operator;
	/**
	 * An object of the CalcInternals class
	 */
	private CalcInternals internal;
	/**
	 * Constructor
	 * @param internal The object of the CalcInternals class
	 * @param operator The passed operator from the clicked button
	 */
	public OperatorListener(CalcInternals internal, char operator) {
		this.operator = operator;
		this.internal = internal;
	}

	/**
	 * The actionPerformed method directs to the CalcInternals class for either the setOperator method or the respective method associated with that button
	 */
	public void actionPerformed(ActionEvent e) {
		switch (operator) {
		case'+':
			internal.setOperator(Character.toString(operator));
			break;
		case'-':
			internal.setOperator(Character.toString(operator));
			break;
		case'/':
			internal.setOperator(Character.toString(operator));
			break;
		case'*':
			internal.setOperator(Character.toString(operator));
			break;
		case'=':
			internal.evaluate();
			break;
		case'.':
			internal.decimalFormat();
			break;
		case'C':
			internal.clearScreen();
			break;
		}
		
	}

	
}
