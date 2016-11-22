package the_Manor;

public class Weapon extends Item {
	/**
	 * <p>A weapon can be found by a player in a room or given by an ally.</p>
	 * <p>A weapon allows to add some attack points to the player.</p>
	 * @author alexia
	 * @version 22/11/2016
	 */
private int weaponAttack; 

	/**
	 * This method allows to create a weapon name and initialise its attack points.
	 * @param newAttack
	 */
	public Weapon (String newAttack, int pointAttack) {
		super(newAttack);		
		weaponAttack = pointAttack;
	}
	
	/**
	 * This method allows to return the attack points of the weapon.
	 * @return weaponAttack
	 */
	public int getAttack() {
		return weaponAttack;
	}
}
