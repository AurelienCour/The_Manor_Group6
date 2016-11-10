package the_Manor;

import java.util.*;

public class Room {
	private HashMap<String,Door> exitPossible;
	private String roomName;
	private Character enemy;
	private Character ally;
	private Item objectInRoom;
	
	/**
	 * The constructor of the class Room
	 * @param roomName The name of the Room
	 */
	public Room (String roomName){
		this.roomName = roomName;
		this.exitPossible = new HashMap();
	}
	
	/**
	 * Allows to add an exit to the room
	 * @param direction The direction for the door (East,West,South,North)
	 * @param lock A boolean to know if the door is locked or not
	 */
	public void addExit(String direction,boolean lock, Room nextRoom){
		if(!this.exitPossible.containsKey(direction)){
			if(lock)
				this.exitPossible.put(direction, new LockedDoor(nextRoom));
			else
				this.exitPossible.put(direction, new Door());
		}
		else
			System.out.println("Erreur");
	}
	
	/**
	 * Allows to add an Enigmatic door to the room
	 * @param direction
	 */
	public void addEnigmaticExit(String direction,String enigma,String response,Room nextRoom){
		if(!this.exitPossible.containsKey(direction))
			this.exitPossible.put(direction, new EnigmaticDoor(enigma,response,nextRoom));
		else
			System.out.println("Erreur");
	}
	
	/**
	 * @return The name of the room
	 */
	public String getName(){
		return this.roomName;
	}
	
	/**
	 * @return If an enemy is in the room
	 */
	public Character getEnemy(){
		return this.enemy;
	}
	
	/**
	 * @return If an ally is in the room
	 */
	public Character getAlly(){
		return this.ally;
	}
	
}
