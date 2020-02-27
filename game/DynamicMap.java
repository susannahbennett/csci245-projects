/**
 * 
 */
package game;

import java.util.HashMap;

/**
 * @author susannahbennett
 *
 */
public class DynamicMap {

	private HashMap<String, Room> seenRooms;	
	
	/**
	 * 
	 */
	public DynamicMap() {
		seenRooms = new HashMap<String, Room>();
	}
	
	public HashMap<String, Room> returnMap (){
		return seenRooms;
	}

}
