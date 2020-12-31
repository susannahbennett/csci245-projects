package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * PlusMinus Listener
 * 
 * ActionListener class that passes into the CalcInternals where the plus/minus operation will be done 
 * Implements the ActionListener class
 * 
 * @author susannahbennett
 * CS 245, Wheaton College
 */
public class PlusMinusListener implements ActionListener {
	/**
	 * Object of the CalcInternals class
	 */
	private CalcInternals internal;
	
	/**
	 * Constructor
	 * @param internal The object of the CalcInternals class
	 */
	public PlusMinusListener(CalcInternals internal) {
		this.internal = internal;
	}
	/**
	 * The actionPerformed method directs to the CalcInternals class for the plusMinus method
	 */
	public void actionPerformed(ActionEvent e) {
		internal.plusMinus();
	}

}
