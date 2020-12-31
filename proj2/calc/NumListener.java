package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * NumListener
 * 
 * ActionListener class that passes into the CalcInternals where the plus/minus operation will be done 
 * Implements the ActionListener class
 * 
 * @author susannahbennett
 * CS 245, Wheaton College
 */
public class NumListener implements ActionListener {
	/**
	 * An integer to hold the number value of the designated calc button
	 */
	private int button;
	/**
	 * An object of the CalcInternals class
	 */	
	private CalcInternals internal;
	
	/**
	 * Constructor
	 * @param internal Object of the CalcInternals class
	 * @param button The int passed from the button clicked
	 */
	public NumListener (CalcInternals internal, int button) {
		this.button = button;
		this.internal = internal;
	}
	
	/**
	 * The actionPerformed method directs to the CalcInternals class for the setOperands method
	 */
	public void actionPerformed(ActionEvent e) {
		internal.setOperands(Integer.toString(this.button));
	}

}
