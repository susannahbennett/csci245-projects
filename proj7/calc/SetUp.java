package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * SetUp
 * 
 * Class to set up and start the calculator, plus
 * facilities for test-driving the calculator.
 *
 * @author Thomas VanDrunen
 * CS 245, Wheaton College
 * June 27, 2014
*/
public class SetUp {

	/**
	 * Method for initializing the calculator internals and
	 * connecting them to the calculator face.
	 * @param face The component representing the user interface of 
	 * the calculator. 
	 */
	public static void setUpCalculator(CalculatorFace face) {
		CalcInternals internal = new CalcInternals(face);
		
		//add action listeners to every button on the calculator 
		face.addNumberActionListener(0, new NumListener(internal, 0));
		face.addNumberActionListener(1, new NumListener(internal, 1));
		face.addNumberActionListener(2, new NumListener(internal, 2));
		face.addNumberActionListener(3, new NumListener(internal, 3));
		face.addNumberActionListener(4, new NumListener(internal, 4));
		face.addNumberActionListener(5, new NumListener(internal, 5));
		face.addNumberActionListener(6, new NumListener(internal, 6));
		face.addNumberActionListener(7, new NumListener(internal, 7));
		face.addNumberActionListener(8, new NumListener(internal, 8));
		face.addNumberActionListener(9, new NumListener(internal, 9));
		
		//add anonymous action listeners 
		face.addActionListener('+', new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				internal.setOperator(new Operation.Add());
			}
		});
		face.addActionListener('-', new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				internal.setOperator(new Operation.Subtract());
			}
		});
		face.addActionListener('*', new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				internal.setOperator(new Operation.Multiply());
			}
		});
		face.addActionListener('/', new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				internal.setOperator(new Operation.Divide());
			}
		});
		face.addActionListener('.', new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				internal.decimal();
			}
		});
		face.addActionListener('C', new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				internal.reset();
			}
		});
		face.addActionListener('=', new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				internal.goToOperation();
			}
		});
		face.addPlusMinusActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				internal.plusMinus();
			}
		});
	}
	
	
	/**
	 * This main method is for your testing of your calculator.
	 * It will *not* be used during grading. Any changes you make
	 * to this method will be ignored at grading.
	 */
	public static void main(String[] args) {
		setUpCalculator(new PlainCalculatorFace());
	}

}
