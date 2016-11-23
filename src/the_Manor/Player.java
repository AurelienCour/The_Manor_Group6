package the_Manor;

import java.util.ArrayList;
/**
 * <p>This class represent the Player. </p>
 * <p>In addition to the possibilities inherited from the Fighter class, the player can: </p>
 * <ul>
 * <li> At the start of the game, a name is inputed. If no name, a default name "John" is used for the name</li>
 * <li> Use items from the inventory</li>
 * <li> Talk with Allies</li>
 * </ul>
 * @author astem
 */
public class Player extends Fighter{
	
	private String newName;
	private int attack, defense;
	private ArrayList<Item>	inventory; // this is the item list of the player
	private Room currentRoom;
	
	/**
	 * The constructor for the player
	 * @param newName The name of the player
	 * @param description The description of the player
	 * @param initialRoom The initial room of the player
	 */
	public Player(String newName, String description, Room initialRoom) {
		super(newName,description);
		this.attack = 10;
		this.defense = 10;
		this.currentRoom = initialRoom;
		inventory = new ArrayList<Item>();
	}
	
	/**
	 * Allows to know the number of item possesses by the player
	 * @return The number of item possessed by the player
	 */
	public int numberOfItem(){
		return this.inventory.size();
	}
	

	/**
	 * <p>This method allows to set the new room position</p>
	 * <p>It changes the room value. It can never be null.</p>
	 * @param newRoom The new room of the player
	 */
	public void setCurrentRoom(Room newRoom){
		this.currentRoom = newRoom;
	}
	
	/**
	 * This methods allow to know the current room of the player
	 * @return The current room of the player
	 */
	public Room getCurrentRoom(){
		return this.currentRoom;
	}
	
	/**
	 * <p>This method allows to pick up an item in the room</p>
	 * <p>It adds the item once to the inventory</p>
	 * <p>It can't add the same item (ID) two times to the inventory</p>
	 * @param item The item to give to the player
	 */
	public void pickUp(Item item){
		inventory.add(item);
	}
	
	/**
	 * <p>This method allows to heal the player by eating food</p>
	 * <p>If the life points added go over the maximum, health will be limited by the max value</p>
	 * @param potion The potion to use for heal the player
	 */
	public void heal(Potion potion){
		
	}
	
	/**
	 * <p>This methods changes the attack value of the fighter</p>
	 * <p>It uses the weapon's attack power to augment the player's attack power</p>
	 */
	public void setAttack(){
		//TODO 
	}
	
	/**
	 * <p>This methods changes the defense value of the fighter</p>
	 * <p>It uses the shield's defense power to augment the shield's defense power</p>
	 */
	public void setDefense(){
		
	}
	
	/**
	 * <p>This method allows to talk to an NPC</p>
	 * <p>It allows to initiate a discussion with the Ally</p>
	 * <p>A player can only talk to one ally at a time</p>
	 * <p>A player can talk only with an ally in the same room as the player</p>
	 */
	public void talk(){
		// TODO 
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
