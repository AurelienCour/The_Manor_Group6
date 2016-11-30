package the_Manor;

/**
 * <p>A weapon can be found by a player in a room or given by an ally.</p>
 * <p>A weapon allows to add some attack points to the player.</p>
 * @author Group 6
 * @version 22/11/2016
 */

public class Weapon extends Item {
	
private int weaponAttack; 

	/**
	 * This constructor allows to create a weapon name and initialize its attack points.
	 * @param itemName The name of the weapon
	 * @param pointAttack The attack of the weapon
	 */
	public Weapon (String itemName, int pointAttack) {
		super(itemName);
		if (pointAttack < 0) {
			this.weaponAttack = 0;
		} else 
			{this.weaponAttack = pointAttack;}
		
	}
	
	/**
	 * This method allows to return the attack points of the weapon.
	 * @return The attack of the weapon
	 */
	public int getAttack() {
		return weaponAttack;
	}
}
