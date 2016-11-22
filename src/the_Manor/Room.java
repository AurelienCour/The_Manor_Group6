package the_Manor;

import java.util.*;

/**
 * Cette classe va permettre la gestion des salles dans notre jeux
 * @author Aurelien
 *
 */
public class Room {
	private HashMap<String,Door> exitPossible;
	private String roomName;
	private ArrayList<Character> characterInRoom;
	private ArrayList<Item> objectInRoom;
	
	/**
	 * Le constructeur de la classe room </br>
	 * Si le nom est vide la salle auras par defaut le nom "Salle" </br>
	 * Crée également nos objets exitPossible ainsi que nos personnages présent dans la salle </br>
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
	 * Permet d'ajouter une sortie simple ou fermé dans la pièce </br>
	 * La direction correspondra a la clef de notre hashMap </br>
	 * Si une direction est incorrect, aucune porte ne seras crée</br>
	 * Si un porte existe déja pour la même direction il y auras un message d'erreur et pas d'ajout</br>
	 * Si l'objet Room donné est invalide aucune porte n'est crée </br>
	 * @param direction The direction for the door (East,West,South,North)
	 * @param lock A boolean to know if the door is locked or not
	 * @param nextRoom The room behind the door
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
	 * Permet d'ajouter une porte deverouillable à l'aide d'une enigme </br>
	 * Si la direction est incorrect ou si elle existe déja dans la salle aucune sortie n'est crée
	 * et il y a un message d'erreur</br>
	 * Si l'enigme est vide aucune porte est crée et un message d'erreur apparait </br>
	 * Si la reponse est vide aucune porte est crée et un message d'erreur apparait </br>
	 * Si l'objet Room donné est invalide aucune porte n'est crée</br>
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
	 * Retourne le nom de la salle
	 * @return The name of the room
	 */
	public String getName(){
		return this.roomName;
	}
	
	/**
	 *  Allow to add a Character in the room
	 *  Si le nom est vide et que le boolean est sur true
	 *   son nom sera mis par defaut à "enemy"</br>
	 *  Si le nom est vide et que le boolean est sur false
	 *   son nom sera mis par defaut à "ally"</br>
	 * @param enemy A boolean to know if it is an enemy
	 * @param name The name of the character
	 */
	public void addCharacter(boolean enemy,String name){
		if(enemy)
			this.characterInRoom.add(new Enemy(name));
		else
			this.characterInRoom.add(new Ally(name));
	}
	
	public int numberOfChararacterInRoom (){
		return this.characterInRoom.size();
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
