package hmllm;
/**
 * A node class
 * 
 * @author susannahbennett
 *
 */
public class Node {
	
	private Node next;
	
	private String key;
	
	private String value;
	
	/**
	 * Constructor for when there's no next node
	 * @param key
	 * @param value
	 */
	public Node(String key, String value) {
		this.key = key;
		this.value = value;
		next = null;
	}
	/**
	 * Constructor for when there's a next node
	 * @param key
	 * @param value
	 * @param next
	 */
	public Node(String key, String value, Node next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}
	
	/**
	 * Method for setting the node
	 */
	public void setNext(Node next) {
		this.next = next;
	}
	/**
	 * Method for getting the node
	 * @return next
	 */
	public Node getNext() {
		return this.next;
	}
	
	
	/**
	 * Method for setting the key
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * Method for getting the key
	 * @return key
	 */
	public String getKey() {
		return this.key;
	}

	
	/**
	 * Method for setting the value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * Method for setting the key
	 * @return value
	 */
	public String getValue() {
		return this.value;
	}
}
