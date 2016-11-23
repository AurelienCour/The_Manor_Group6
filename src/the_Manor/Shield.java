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
	 * @param itemName The name of the shield
	 * @param pointDefense The defense of the shield
	 */
	public Shield(String itemName, int pointDefense) {
		super(itemName);
		defenseShield = pointDefense;
	}

	/**
	 * This method allows to return the defense points of the shield.
	 * @return The defense of the shield
	 */
	public int getDefense() {
		return defenseShield;
	}
}