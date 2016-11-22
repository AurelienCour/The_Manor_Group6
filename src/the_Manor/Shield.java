package the_Manor;
	/**
	 * <p> A shield can be found by a player in a room or given by an ally.</p>
	 * <p> A shield allows to add some defense points to the player.</p>
	 * @author alexia
	 * @version 22/11/2016
	 */
public class Shield extends Item{
	
	private int defenseShield; 
	
	/**
	 * This method allows to create a weapon name and initialise its defense points.
	 * @param newItem
	 */
	public Shield(String newItem, int pointDefense) {
		super(newItem);
		defenseShield = pointDefense;
	}

	/**
	 * This method allows to return the attack points of the weapon.
	 * @return weaponAttack
	 */
	public int getDefense() {
		return defenseShield;
	}
}