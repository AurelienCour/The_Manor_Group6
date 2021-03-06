package the_Manor;

import java.util.*;

/**
 * <p>This class allows to manage the different rooms in our game. </p>
 * <p>We can do several things in this class : </p>
 * <ul>
 * <li> Allows to create exits in a room.</li>
 * <li> Allows to add and delete a character to a room. </li>
 * <li> Allows to add and delete items in a room. </li>
 * </ul>
 * 
 * @author Group 6
 * @version 05/12/16
 *
 */
public class Room {
	
	private HashMap<String,Door> exitPossible; // All the exits present in the room
	private String roomName; // Name of the room
	private ArrayList<Character> characterInRoom; // Number of character(s) in a room
	private ArrayList<Item> objectInRoom; // All the objects present in the room
	private String background; // Background image of the room
	
	/**
	 * <p>The constructor of the class Room.</p>
	 * <p>If the name is empty, the room will have the default name "Room". </p>
	 * <p>it also creates our object "exitPossible" and our character presents in the room. </p>
	 * 
	 * @param roomName The name of the Room
	 * @param background The picture of the background of the room
	 */
	public Room (String roomName,String background){
		if (roomName.isEmpty())
			this.roomName = "Room"; // default name
		else
			this.roomName = roomName;
		if(background == null || background.isEmpty())
			this.background="fond.png"; // default background
		else
			this.background = background;
		this.exitPossible = new HashMap<String, Door>(); // instanciation of the HashMap that will contains the exits of the room
		this.characterInRoom = new ArrayList<Character>(); // instanciation of the ArrayList that will contains the characters of the room
		this.objectInRoom = new ArrayList<Item>(); // instanciation of the ArrayList that will contains the objects of the room
	}
	
	/**
	 * To get the background of the Room
	 * @return background The background of the Room
	 */
	public String getBackground(){
		return this.background;
	}
	
	/**
	 * <p>Allows to add a simple or locked exit in the room.</p>
	 * <p>The direction will correspond to a key of our hashMap.</p>
	 * <p>If a direction is incorrect, no door will be created. </p>
	 * <p>If a door already exits for the same direction, an error message appears and the door will not be added. </p>
	 * <p>If the Room object is invalid, no door will be created.</p>
	 * 
	 * @param direction The direction for the door (East,West,South,North)
	 * @param lock A boolean to know if the door is locked or not
	 * @param nextRoom The room behind the door
	 */
	public void addExit(String direction, Key lock, Room nextRoom){
		if(!this.exitPossible.containsKey(direction)){ // The HashMap contains a direction
			if(lock != null) // There is a key
				this.exitPossible.put(direction, new LockedDoor(lock,nextRoom,this)); // New exit with a direction and a Door containing the key in parameter, the next room it gives access to and the previous Room
			else // The door will not have a lock
				this.exitPossible.put(direction, new Door(nextRoom,this)); // New exit with a direction and a Door containing the next and the previous room
		}
		else
			System.out.println("Error");
	}
	
	/**
	 * <p>Allows to add a door which is unlockable by answering to an enigma.</p>
	 * <p>If the direction is incorrect or if it exists already in the room, no exit will be created and there will be an error message.</p> 
	 * <p>If the enigma is empty, no door will be created and an error message appears.</p>
	 * <p>If the answer is empty, no door will be created and an error message appears. </p> 
	 * <p>If the given Room object is invalid, no door will be created.</p>
	 * 
	 * @param direction The directon for the new exit door
	 * @param enigma The enigma to unlock the door
	 * @param response The response to give to unlock the door
	 * @param nextRoom The room behind the door
	 */
	public void addEnigmaticExit(String direction,String enigma,String response,Room nextRoom){
		if(!this.exitPossible.containsKey(direction)) // If this exit does not already exist
			this.exitPossible.put(direction, new EnigmaticDoor(enigma,response,nextRoom,this)); // creation of the new enigmatic exit
		else
			System.out.println("Error");
	}
	
	/**
	 * Return the name of the room.
	 * @return The name of the room
	 */
	public String getName(){
		return this.roomName;
	}
	
	/**
	 *  <p>Allows to add a Character in the room. </p>
	 *  <p>If the name is empty and that the boolean is true then his name will be "Enemy" by default.</p>
	 *  <p>If the name is empty and that the boolean is false then his name will be "Ally" by default.</p>
	 *  
	 * @param charac The character to add in the room
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
	 * <p>Allows to recover a door in the room for a specific decision. </p>
	 * <p>If the direction is incorrect, it will return null. </p>
	 * 
	 * @param direction The direction of the door that we want to recover.
	 * @return the door of a specific direction.
	 */
	public Door getDoor(String direction){
		if(this.exitPossible.containsKey(direction))
			return this.exitPossible.get(direction);
		else
			return null;
	}
	
	/**
	 * <p>Allows to delete an enemy in the room.</p>
	 * <p>If the enemy does not exits, an error message appears. </p>
	 *  
	 * @param enemy The enemy to delete
	 */
	public void deleteEnemy (Character enemy){
		if(this.characterInRoom.contains(enemy))
			this.characterInRoom.remove(enemy);
		else
			System.out.println("Erreur");
	}
	
	/**
	 * <p>Return a character presents in the room by using his name. </p>
	 * <p>If he does not exist, returns null. </p>
	 *  
	 * @param name The name of the character that is to be recovered
	 * @return the character owning the name.
	 */
	public Character getCharacter (String name){
		for (int i = 0; i < characterInRoom.size(); i++) { // the Array containing all the characters in the room is crossed
			if(characterInRoom.get(i).getName().equals(name)) // if the two names equal each other
				return characterInRoom.get(i); // return the name
		}
		return null;
	}
	
	/**
	 * Allows to get the enemy in the room
	 * @return Null if the room don't have an enemy or the enemy.
	 */
	public Enemy getEnemy(){
		for (Character character : characterInRoom) {
			if(character instanceof Enemy)
				return (Enemy) character;
		}
		return null;
	}
	
	/**
	 * Allows to have the ally in the room if there is one.
	 * @return the ally
	 */
	public Ally getAlly(){
		for (Character character : characterInRoom) {
			if(character instanceof Ally)
				return (Ally) character;
		}
		return null;
	}
	
	/**
	 * Allows to add an item in the room.
	 *  
	 * @param item The item to add.
	 */
	public void addItem (Item item){
		this.objectInRoom.add(item);
	}
	
	/**
	 * Allows to remove an item from the room.
	 *  
	 * @param item To item to remove
	 */
	public void removeItem(Item item){
		this.objectInRoom.remove(item);
	}
	
	/**
	 * Allows to know the number of item in the room.
	 * 
	 * @return The number of item in the room
	 */
	public int numberOfItemInRoom(){
		return this.objectInRoom.size();
	}
	
	
	/**
	 * To get an item present in the room
	 * @return temp An item present in the room
	 */
	public Item getItem(){
		if(numberOfItemInRoom() != 0){
			Item temp = this.objectInRoom.get(0);
			return temp;
		}else
			return null;
	}
	
	/**
	 * Allows to know the number of added exit.
	 * @return The number of exit in the room
	 */
	public int numberOfExit(){
		return this.exitPossible.size();
	}
}