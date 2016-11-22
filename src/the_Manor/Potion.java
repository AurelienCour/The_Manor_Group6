package the_Manor;

/**
 * <p>This class represents the food available in the game.</p>  
 * <p>An object can give to a player more health.</p>
 * 
 * @author Siham
 * @version 22/11/2016
 */

public class Potion extends Item{
	
private int healthGain; //Quantity of health that the object will give to the player
	
	/**
	* *Constructor of the Potion class
	* @param newItem : the Name of the Item
	* @param pointHealth : the quantity of health that an item give to the player.
	*/
	public Potion (String newItem, int pointHealth)
	{
		super(newItem);
		pointHealth = healthGain;
	}
	
	/**
	*This method allows to return the quantity of health than an object will add to the player's life.
	* @return healthGain 
	**/	
public int getHealth()
	{
		return healthGain; 
	}
}