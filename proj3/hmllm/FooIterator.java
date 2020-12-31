/**
 * 
 */
package hmllm;

import java.util.Iterator;

/**
 * Iterator class for going over the list
 * @author susannahbennett
 *
 */
public class FooIterator implements Iterator<String> {

	/**
	 * List to iterator through
	 */
	private HomemadeLLMap list;	
	
	/**
	 * The front of the list
	 */
	private Node head;
	
	/**
	 * Counts the current node
	 */
	private int counter;
	
	/**
	 * Temporary holder node
	 */
	private Node temp;
	
	/**
	 * Constructor to initialize list and head
	 */
	public FooIterator(HomemadeLLMap list) {
		this.list = list;
		head = list.returnHead();
		temp = head;
		counter = 0;
	}

	/**
	 * Checks whether or not there is another node in the list
	 * @return true or false
	 */
	public boolean hasNext() {
		if (counter < list.length()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Advances temp and counter 
	 * @return key of temp
	 */
	public String next() {
		String key = temp.getKey();
		temp = temp.getNext();
		counter++;
		return key;
	}

}
