package the_Manor;

/**
 * <p>This class represents the food available in the game.</p>  
 * <p>An object can give to a player more health.</p>
 * 
 * @author Group 6
 * @version 05/12/16
 */

public class Potion extends Item{
	
	//Quantity of health that the item will give to the player
	private int healthGain; 
	
	/**
	* Constructor of the Potion class
	* The health value can not goes under 0
	* @param newItem : the Name of the Item
	* @param pointHealth : the quantity of health that an item give to the player.
	*/
	public Potion (String newItem, int pointHealth)
	{
		super(newItem); // Uses the Item super-class
		if (pointHealth < 0) { 
			this.healthGain = 0;
		} else {
			this.healthGain = pointHealth;
		}
	}
	
	/**
	* This method allows to return the quantity of health than an object will add to the player's life.
	* @return healthGain 
	*/	
	public int getHealth()
	{
		return this.healthGain; 
	}
}