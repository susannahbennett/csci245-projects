package hmllm;
/**
 * A node class
 * 
 * @author susannahbennett
 *
 */
public class Node {
	/**
	 * The node being accessed
	 */
	private Node next;
	/**
	 * The key associated with the node
	 */
	private String key;
	/**
	 * The value associated with the key and node
	 */
	private String value;
	
	/**
	 * Constructor for when there's no next node
	 * @param key The specific key associated with this node
	 * @param value The value associated with this key
	 */
	public Node(String key, String value) {
		this.key = key;
		this.value = value;
		next = null;
	}
	/**
	 * Constructor for when there's a next node
	 * @param key The specific key associated with this node
	 * @param value The value associated with this key
	 * @param next The node after the current
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
	 * @return next The node after the current
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
	 * @return key The key of this node
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
	 * @return value The value at this key
	 */
	public String getValue() {
		return this.value;
	}
}
