package game;

import java.awt.event.ActionListener; 

public interface KeyPadFace {
	
	
	/**
	 * Writes the input to the screen
	 * @param display is the string to be added to the display
	 */
	public void display(String display);
	
	
	/**
	 * Adds an ActionListener object to corresponding button
	 * @param button The button that is to correspond to the listener
	 * @param listener 
	 */
	public void addActionListener(char button, ActionListener listener);
	
	/**
	 * Adds an ActionListener object to a button that corresponds to a number
	 * @param button The button
	 * @param listener The listener for that button
	 */
	public void addNumActionListener(int button, ActionListener listener);
}
