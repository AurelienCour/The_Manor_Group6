package the_Manor;

import java.util.ArrayList;
/**
 * <p>This class represents the Player. </p>
 * <p>In addition to the possibilities inherited from the Fighter class, the player has extra functionalities: </p>
 * <ul>
 * <li>At the start of the game, a name is inputed. If there is no name, the default name "John" is used.</li>
 * <li>The player uses items from his inventory</li>
 * <li>The player talks with allies</li>
 * </ul>
 * 
 * @author Group 6
 * @version 05/12/16
 * 
 */
public class Player extends Fighter{
	
	private ArrayList<Item>	inventory; // this is the item list of the player
	private Weapon weaponEquip; // the weapon to be equipped by the player
	private Shield shieldEquip; // the shield to be equipped by the player
	private Room currentRoom; // current room of the player
	
	/**
	 * The constructor for the player
	 * @param newName The name of the player
	 * @param description The description of the player	 
	 */
	public Player(String newName, String description) {
		super(newName,description); // Uses the super-class Fighter
		this.NBMAXPV = 100; // max value of the player's health points
		this.NBMAXSTAMINA = 100; // max value of the player's stamina points
		this.setAttack(10); // player's attack set to 10
		this.setDefense(10); // player's defense set to 10
		this.setHealth(this.NBMAXPV); // player's health set to the max value
		this.setStamina(this.NBMAXSTAMINA); // player's stamina set to the max value
		inventory = new ArrayList<Item>(); // instanciation of the inventory
	}
	
	/**
	 * Allows to know the number of item possesses by the player
	 * @return The number of item possessed by the player
	 */
	public int numberOfItem(){		
		return this.inventory.size();		
	}
	
	
	/**
	 * To have all the player's weapons
	 * @return weap The list of all the player's weapons 
	 */
	public ArrayList<Weapon> getWeapon(){
		ArrayList<Weapon> weap = new ArrayList<Weapon>();
		for (Item it : inventory) {
			if(it instanceof Weapon)
				weap.add((Weapon) it);
		}
		return weap;
	}
	
	/**
	 * To have all the player's shields
	 * @return shield The list of all the player's shields 
	 */
	public ArrayList<Shield> getShield(){
		ArrayList<Shield> shield = new ArrayList<Shield>();
		for (Item it : inventory) {
			if(it instanceof Shield)
				shield.add((Shield) it);
		}
		return shield;
	}
	
	/**
	 * To have all the player's potions or key
	 * @return potionKey The list of all the player's potions or keys
	 */
	public ArrayList<Item> getPotionKey(){
		ArrayList<Item> potionKey = new ArrayList<Item>();
		for (Item it : inventory) {
			if(it instanceof Potion || it instanceof Key)
				potionKey.add(it);
		}
		return potionKey;
	}

	/**
	 * <p>This method allows to set the new room position</p>
	 * <p>It changes the room value. It can not be null.</p>
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
	 * Allows to know if the player has a specific item
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
	 * Return true if the player has a specific key
	 * @param key The specific key
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
	
	/**
	 * To remove a key from the inventory
	 * @param key The key to be removed
	 */
	public void removeKey(Key key){
		for (Item item : inventory) {
			if(item.equals(key)){
				inventory.remove(item);
				break;
			}
		}
	}
	
	/**
	 * To know if the player has a weapon in is inventory
	 * @return True if he has, false if he has not.
	 */
	public boolean haveWeapon(){
		if(this.weaponEquip != null)
			return true;
		else
			return false;
	}
	
	/**
	 * To know if the player has a specific weapon.
	 * @param weapon The researched weapon
	 * @return True if the player has the researched weapon in his inventory, false if he has not
	 */
	public boolean haveThisWeapon(Weapon weapon){
		if(haveWeapon()){
			if(this.weaponEquip.equals(weapon))
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	/**
	 * To know if the player has a shield in is inventory
	 * @return True if he has, false if he has not.
	 */
	public boolean haveShield(){
		if(this.shieldEquip != null)
			return true;
		else
			return false;
	}
	
	
	/**
	 * To know if the player has a specific shield.
	 * @param shield The researched shield.
	 * @return True if the player has the researched shield in his inventory, false if he has not.
	 */
	public boolean haveThisShield(Shield shield){
		if(haveShield()){
			if(this.shieldEquip.equals(shield))
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	/**
	 * To know if the player has a potion in is inventory
	 * @return True if he has, false if he has not.
	 */
	public boolean havePotion(){
		for (Item item : inventory) {
			if(item instanceof Potion)
				return true;
		}
		return false;
	}
	
	/**
	 * To get a potion in the inventory of the player
	 * @return The potion if the player has one, otherwise returns null.
	 */
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
		if(item instanceof Weapon){ // The item to equip is a weapon
			if(haveWeapon()) // The player has a weapon in his inventory
				this.removeAttack(this.weaponEquip.getAttack()); // The attack given by the weapon already equipped is removed
			this.weaponEquip = (Weapon) item; // The Item type of the item to equip is turned into Weapon type because weaponEquip has this type
			this.addAttack(weaponEquip.getAttack()); // The value of the equipped weapon is given at the player's attack
		}else if(item instanceof Shield){ // The item to equip is a shield
			if(haveShield()) // The player has a shield in his inventory
				this.removeDefense(shieldEquip.getDefense()); // The defense given by the shield already equipped is removed
			this.shieldEquip = (Shield) item; // The Item type of the item to equip is turned into Shield type because shieldEquip has this type
			this.addDefense(shieldEquip.getDefense()); // The value of the equipped shield is given at the player's defense
		}
	}
	
	/**
	 * Allows to unequip a weapon from the player
	 */
	public void desequipWeapon(){
		if(haveWeapon()){ // The player has a weapon
			this.removeAttack(this.weaponEquip.getAttack()); // The attack given by the weapon to unequipped is removed
			this.weaponEquip = null; // There is not equipped weapon anymore
		}
	}
	
	/**
	 * Allows to unequip a shield from the player
	 */
	public void desequipShield(){
		if(haveShield()){ // The player has a shield
			this.removeDefense(shieldEquip.getDefense()); // The defense given by the shield to unequipped is removed
			this.shieldEquip = null; // There is not equipped shield anymore
		}
	}
}
