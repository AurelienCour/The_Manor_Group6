package the_Manor;

import java.util.ArrayList;
/**
 * This class represent the Player. </br>
 * In addition to the possibilities inherited from the Fighter class, the player can: </br>
 * <ul>
 * <li> At the start of the game, a name is inputed. If no name, a default name "John" is used for the name
 * <li> Use items from the inventory
 * <li> Talk with Allies
 * <li> </li>
 * @author astem
 *
 */
public class Player extends Fighter{
private String newName;
private int attack, defense;
private ArrayList<Item>	inventory; // this is the item list of the player
public Room currentRoom;
	
	/**
	 * The constructor for the player
	 * @param newName
	 * @param InitialRoom
	 */
	public Player(String newName, String description, Room InitialRoom) {
		super(newName,description);
		if (newName.isEmpty())
			this.newName = "John";
		else
			this.newName = newName;
		this.attack = 10;
		this.defense = 10;
		this.currentRoom = InitialRoom;
		inventory = new ArrayList<Item>();
	}
	

	/**
	 * This method allows to set the new room position
	 * It changes the room value. It can never be null.
	 * @param NewRoom
	 */
	public void setCurrentRoom(Room NewRoom){
		Room CurrentRoom = NewRoom;
	}
	
	/**
	 * This method allows to pick up an item in the room
	 * It adds the item once to the inventory
	 * It can't add the same item (ID) two times to the inventory
	 * @param itemName
	 */
	public void pickUp(Item item){
		inventory.add(item);
	}
	
	/**
	 * This method allows to heal the player by eating food
	 * If the life points added go over the maximum, health will be limited by the max value
	 * @param healing
	 */
	public void heal(String food,int healing){
		health = health+healing;
	}
	
	/**
	 * This methods changes the attack value of the fighter
	 * It uses the weapon's attack power to augment the player's attack power
	 * @return attack
	 */
	public void setAttack(String weapon, int attack){
		//TODO 
	}
	
	/**
	 * This methods changes the defense value of the fighter
	 * It uses the shield's defense power to augment the shield's defense power
	 * @return defense
	 */
	public int setDefense(){
		return this.defense;
	}
	
	/**
	 * This method allows to talk to an NPC
	 * It allows to initiate a discussion with the Ally
	 * A player can only talk to one ally at a time
	 * A player can talk only with an ally in the same room as the player
	 */
	public void talk(){
		// TODO 
	}

	/**
	 * This method allows to set new health with an item
	 * @param i / The amount of life points to add to the health
	 */
	public void setHealth(int i) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Return true if the player has a key
	 * @return Return true if the player has a key
	 */
	public boolean haveKey(){
		for (Item item : inventory) {
			if(item instanceof Key)
				return true;
		}
		return false;
	}
}
