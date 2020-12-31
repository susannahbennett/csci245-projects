package hmllm;

import java.util.Iterator;

/**
 * HomemadeLLMap
 * 
 * An implementation of the HomemadeMap class that uses
 * a completely-homemade linked list on the inside.
 * 
 * @author Thomas VanDrunen
 * CSCI 245, Wheaton College
 * June 30, 2014
 */

public class HomemadeLLMap implements HomemadeMap {
	/**
	 * First node in the list
	 */
	private Node head;
	
	/**
	 * Counts the number of nodes added and removed
	 */
	private int length;
	/**
	 * Constructor to initialize head
	 */
	public HomemadeLLMap() {
		head = null;
		length = 0;
	}
	
    /**
     * Test whether an association exists for this key.
     * @param key The key to remove
     * @return true if there is an association for this key, false otherwise
     */
    public boolean containsKey(String key) {
    	if(this.findKey(key)!= null) {
    		return true;
    	} else {
    		return false;
    	}
    }
   
    /**
     * Sees if any of the keys match the given key
     * @param key
     * @return Node containing key
     */
    public Node findKey(String key) {
		Node i = head;
		while (i != null) {
			if (i.getKey().equals(key)) {
				return i;
			}
			i = i.getNext();
		}
		return null;
	}


	/**
     * Add an association to the map.
     * @param key The key to this association
     * @param val The value to which this key is associated
     */
    public void put(String key, String val) {
    	Node holder = this.findKey(key);
    	if (holder != null) {
    		holder.setValue(val);
    	} else {
    		Node added = new Node(key, val);
    		added.setNext(head);
    		head = added;
    		length++;
    	}
    }  

    /**
     * Get the value for a key.
     * @param key The key whose value we're retrieving.
     * @return The value associated with this key, null if none exists
     */
    public String get(String key) {
    	Node holder = this.findKey(key);
    	if (holder != null) {
    		return holder.getValue();
    	} else {
    		return null;
    	}
    }

    /**
     * Get an iterator for all the keys in this map.
     * @return An iterator over the set of keys.
     */
    public Iterator<String> keyIterator() {
    	return new FooIterator(this);
    }
    
    /**
     * Remove the association for this key.
     * @param key The key to remove
     */   
    public void remove(String key) {
    	Node previous = null;
    	Node current = head;
    	int tempLength = length;
    	
    	while (tempLength > 0) {
    		if (current.getKey() == key) {
    			if (current.getNext() == null) {
    				previous.setNext(current.getNext());
    				previous = previous.getNext();
    			} else if (previous == null) {
    				head = head.getNext();
    			} else {
    				previous.setNext(current.getNext());
    				previous = previous.getNext();
    				current = previous.getNext();
    			}
				length--;
				return;
    		}
    		previous = current;
    		current = current.getNext();

    		tempLength--;
    	}
    }
    /**
     * Returns the head
     * @return head The front of the list
     */
	public Node returnHead() {
		return head;
	}
	/**
	 * Returns the number of nodes added or removed from the list
	 * @return length
	 */
	public int length() {
		return length;
	}
	
}
