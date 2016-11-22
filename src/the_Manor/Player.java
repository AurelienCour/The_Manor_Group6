package the_Manor;

import java.util.ArrayList;
/**
 * This class represent the Player. </br>
 * In addition to the possibilities inherited from the Fighter class, the player can: </br>
 * <ul>
 * <li> Use items from the inventory
 * <li> Talk with Allies
 * <li> </li>
 * @author astem
 *
 */
public class Player extends Fighter{

private ArrayList<Item>	inventory; // this is the item list of the player
private Room currentRoom;
	
	/**
	 * The constructor for the player
	 * @param newName
	 * @param InitialRoom
	 */
	public Player(String newName, Room InitialRoom) {
		super(newName);
		this.currentRoom = InitialRoom;
		inventory = new ArrayList<Item>();
	}
	

	/**
	 * This method allows to set the new room position
	 * @param NewRoom
	 */
	public void setCurrentRoom(Room NewRoom){
		Room CurrentRoom = NewRoom;
	}
	
	/**
	 * This method allows to pick up an itme in the room
	 * @param itemName
	 */
	public void pickUp(Item itemName){
		inventory.add(itemName);
	}
	
	/**
	 * This method allows to heal the player by eating food
	 * @param healing
	 */
	public void heal(int healing){
		health = health+healing;
	}
	
	/**
	 * This methods changes the attack value of the fighter
	 * @return attack
	 */
	public int setAttack(){
		return attack;
	}
	
	/**
	 * This methods changes the defense value of the fighter
	 * @return defense
	 */
	public int setDefense(){
		return this.defense;
	}
	
	/**
	 * This method allows to talk to an NPC
	 */
	public void talk(){
		// TODO 
	}
}
