package the_Manor;

import java.util.*;

/**
 * This class allows to manage the different rooms in our game. 
 * We can do several things in this class : </br>
 * <ul>
 * <li> Allows to create exits in a room.</li>
 * <li> Allows to add and delete character to a room. </li>
 * <li> Allows to add and delete items in a room. </li>
 * </ul>
 * @author Aurelien
 *
 */
public class Room {
	private HashMap<String,Door> exitPossible;
	private String roomName;
	private ArrayList<Character> characterInRoom;
	private ArrayList<Item> objectInRoom;	
	
	/**
	 * The constructor of the class Room.</br>
	 * If the name is empty, the room will have the default name "Room". </br>
	 * it also creates our object "exitPossible"and our character presents in the room. </br>
	 * 
	 * @param roomName The name of the Room
	 */
	public Room (String roomName){
		if (roomName.isEmpty())
			this.roomName = "Salle";
		else
			this.roomName = roomName;
		this.exitPossible = new HashMap();
		this.characterInRoom = new ArrayList();
		this.objectInRoom = new ArrayList();		
	}
	
	/**
	 * Allows to add a simple or locked exit in the room.</br>
	 * The direction will correspond to a key of our hashMap </br>
	 * If a direction is incorrect, no door will be created. </br>
	 * If a door already exits for the same direction, an error message appears and the door will not be added. </br>
	 * If the Room object is unvalid, no door will be created.</br>
	 * 
	 * @param direction The direction for the door (East,West,South,North)
	 * @param lock A boolean to know if the door is locked or not
	 * @param nextRoom The room behind the door
	 */
	public void addExit(String direction,boolean lock, Room nextRoom){
		if(!this.exitPossible.containsKey(direction)){
			if(lock)
				this.exitPossible.put(direction, new LockedDoor(nextRoom));
			else
				this.exitPossible.put(direction, new Door(nextRoom));
		}
		else
			System.out.println("Erreur");
	}
	
	/**
	 * Allows to add a door which is unlockable by answering to an enigma.</br>
	 * If the direction is incorrect or if it exists already in the room, no exit will be created and there will be an error message.</br> 
	 * If the enigma is empty, no door will be created and an error message appears.</br> 
	 * If the answer is empty, no door will be created and an error message appears. </br> 
	 * If the given Room object is invalid, no door will be created.</br>
	 * 
	 * @param direction
	 * @param enigma
	 * @param response
	 * @param nextRoom
	 */
	public void addEnigmaticExit(String direction,String enigma,String response,Room nextRoom){
		if(!this.exitPossible.containsKey(direction))
			this.exitPossible.put(direction, new EnigmaticDoor(enigma,response,nextRoom));
		else
			System.out.println("Erreur");
	}
	
	/**
	 * Return the name of the room.
	 * @return The name of the room
	 */
	public String getName(){
		return this.roomName;
	}
	
	/**
	 *  Allows to add a Character in the room. </br>
	 *  If the name is empty and that the boolean is true then his name will be "Enemy" by default.</br>
	 *  If the name is empty and that the boolean is false then his name will be "Ally" by default.</br>
	 *  
	 * @param enemy A boolean to know if it is an enemy
	 * @param name The name of the character
	 */
	public void addCharacter(Character charac){
		this.characterInRoom.add(charac);
	}
	
	/**
	 * Allows to know the number of character in the room.
	 * 
	 * @return The number of person in the room.
	 */
	public int numberOfChararacterInRoom (){
		return this.characterInRoom.size();
	}
	
	/**
	 * Allows to recover a door in the room for a specific decision. </br>
	 * If the direction is incorrect, it will return null. </br>
	 * 
	 * @param direction The direction of the door that we want to recover.
	 * @return the specific direction of a door.
	 */
	public Door getDoor(String direction){
		if(this.exitPossible.containsKey(direction))
			return this.exitPossible.get(direction);
		else
			return null;
	}
	
	/**
	 * Allows to delete an enemy in the room.</br>
	 * If the enemy does not exits, an error message appears. </br>
	 *  
	 * @param enemy
	 */
	public void deleteEnemy (Character enemy){
		if(this.characterInRoom.contains(enemy))
			this.characterInRoom.remove(enemy);
		else
			System.out.println("Erreur");
	}
	
	/**
	 * Return a character presents in the room by using his name. </br>
	 * If he does not exist, it returns null. </br>
	 *  
	 * @param name The name of the character that is to be recovered
	 * @return the character owning the name.
	 */
	public Character getCharacter (String name){
		for (int i = 0; i < characterInRoom.size(); i++) {
			if(characterInRoom.get(i).getName().equals(name))
				return characterInRoom.get(i);
		}
		return null;
	}
	
	/**
	 * Allows to add an item in the room.</br>
	 *  
	 * @param item The item to add.
	 */
	public void addItem (Item item){
		this.objectInRoom.add(item);
	}
	
	/**
	 * Allows to remove an item from the room.</br>
	 *  
	 * @param item To item to remove
	 */
	public void removeItem(Item item){
		this.objectInRoom.remove(item);
	}
	
	/**
	 * Allows to know the number of item in the room.</br>
	 * 
	 * @return The number of item in the room
	 */
	public int numberOfItemInRoom(){
		return this.objectInRoom.size();
	}
	
	/**
	 * Allows to know the number of added exit.
	 * 
	 */
	public int numberOfExit(){
		return this.exitPossible.size();
	}
}