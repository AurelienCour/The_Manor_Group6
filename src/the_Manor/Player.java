package the_Manor;

import java.util.ArrayList;
/**
 * <p>This class represent the Player. </p>
 * <p>In addition to the possibilities inherited from the Fighter class, the player has extra functionalities: </p>
 * <ul>
 * <li>At the start of the game, a name is inputed. If there is no name, the default name "John" is used.</li>
 * <li>Use items from the inventory</li>
 * <li>Talk with Allies</li>
 * </ul>
 * @author Group 6
 */
public class Player extends Fighter{
	
	private ArrayList<Item>	inventory; // this is the item list of the player
	private Weapon weaponEquip;
	private Shield shieldEquip;
	private Room currentRoom; // current room of the player
	
	/**
	 * The constructor for the player
	 * @param newName The name of the player
	 * @param description The description of the player	 
	 */
	public Player(String newName, String description) {
		super(newName,description);
		this.NBMAXPV = 100; 
		this.NBMAXSTAMINA = 100; 
		this.attack = 10; 
		this.defense = 10; 
		this.health = this.NBMAXPV; 
		this.stamina = this.NBMAXSTAMINA; 
		inventory = new ArrayList<Item>();
	}
	
	/**
	 * Allows to know the number of item possesses by the player
	 * @return The number of item possessed by the player
	 */
	public int numberOfItem(){		
		return this.inventory.size();		
	}
	
	public ArrayList<Weapon> getWeapon(){
		ArrayList<Weapon> weap = new ArrayList<Weapon>();
		for (Item it : inventory) {
			if(it instanceof Weapon)
				weap.add((Weapon) it);
		}
		return weap;
	}
	
	public ArrayList<Shield> getShield(){
		ArrayList<Shield> shield = new ArrayList<Shield>();
		for (Item it : inventory) {
			if(it instanceof Shield)
				shield.add((Shield) it);
		}
		return shield;
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
	 * <p>It can't add the same item (ID) two times to the inventory. It will be replaced.</p>
	 * @param item The item to give to the player
	 */
	public void pickUp(Item item){
		inventory.add(item);		
	}
	
	/**
	 * Allows to know if the player have a specific item
	 * @param item The item to research
	 * @return A boolean : true if an item with the same type is present otherwise false
	 */
	public boolean haveItem (Item item){
		for (Item it : inventory) {
			if(it.getClass().equals(item.getClass()))
				return true;
		}
		return false;
	}
	
	/**
	 * <p>This method allows to heal the player by eating food</p>
	 * <p>If the life points added go over the maximum, health will be limited by the max value</p>
	 * @param potion The potion to use for healing the player
	 */
	public void heal(Potion potion){
		if (this.haveItem(potion)) {
			this.addHealth(potion.getHealth());
			this.inventory.remove(potion);
		}
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
	 * Return true if the player has a specific key
	 * @return Return true if the player has a specific key
	 */
	public boolean haveKey(Key key){
		for (Item item : inventory) {
			if(item.equals(key))
				return true;
		}
		return false;
	}
	
	/**
	 * Return true if the player has a key
	 * @return Return true if the player has a key
	 */
	public boolean haveAnyKey(){
		for (Item item : inventory) {
			if(item instanceof Key)
				return true;
		}
		return false;
	}
	
	public void removeKey(Key key){
		for (Item item : inventory) {
			if(item.equals(key)){
				inventory.remove(item);
				break;
			}
		}
	}
	
	public boolean haveWeapon(){
		if(this.weaponEquip != null)
			return true;
		else
			return false;
	}
	
	public boolean haveShield(){
		if(this.shieldEquip != null)
			return true;
		else
			return false;
	}
	
	public boolean havePotion(){
		for (Item item : inventory) {
			if(item instanceof Potion)
				return true;
		}
		return false;
	}
	
	public Potion getPotion(){
		for (Item item : inventory) {
			if(item instanceof Potion)
				return (Potion) item;
		}
		return null;
	}
	
	
	/**
	 * Allow to equip an item that is in the inventory
	 * @param item The item to equip
	 */
	public void equipItem(Item item){
		if(item instanceof Weapon){
			if(haveWeapon())
				this.removeAttack(this.weaponEquip.getAttack());
			this.weaponEquip = (Weapon) item;
			this.addAttack(weaponEquip.getAttack());
		}else if(item instanceof Shield){
			if(haveShield())
				this.removeDefense(shieldEquip.getDefense());
			this.shieldEquip = (Shield) item;
			this.addDefense(shieldEquip.getDefense());
		}
	}
}
