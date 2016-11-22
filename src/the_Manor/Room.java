package the_Manor;

import java.util.*;

/*
 * Cette classe va permettre la gestion des salles dans notre jeux
 */
public class Room {
	private HashMap<String,Door> exitPossible;
	private String roomName;
	private ArrayList<Character> characterInRoom;
	private ArrayList<Item> objectInRoom;
	
	/**
	 * Le constructeur de la classe room
	 * Si le nom est vide la salle auras par defaut le nom "Salle"
	 * Crée également nos objets exitPossible ainsi que nos personnages présent dans la salle 
	 * @param roomName The name of the Room
	 */
	public Room (String roomName){
		if (roomName.isEmpty())
			this.roomName = "Salle";
		else
			this.roomName = roomName;
		this.exitPossible = new HashMap();
		this.characterInRoom = new ArrayList();
	}
	
	/**
	 * Permet d'ajouter une sortie dans la pièce
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
	 *  Allow to add a Character in the room
	 * @param enemy A boolean to know if it is an enemy
	 * @param name The name of the character
	 */
	public void addCharacter(boolean enemy,String name){
		if(enemy)
			this.characterInRoom.add(new Enemy(name));
		else
			this.characterInRoom.add(new Ally(name));
	}
	
	public Door getDoor(String direction){
		if(this.exitPossible.containsKey(direction))
			return this.exitPossible.get(direction);
		else
			return null;
	}
	
	public void deleteEnemy (Character enemy){
		if(this.characterInRoom.contains(enemy))
			this.characterInRoom.remove(enemy);
		else
			System.out.println("Erreur");
	}
	
	public void addItem (Item item){
		this.objectInRoom.add(item);
	}
	
	public void removeItem(Item item){
		this.objectInRoom.remove(item);
	}
	
	
}
