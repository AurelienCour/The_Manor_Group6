package the_Manor;

/**
 * <p>The player have the possibility to found object like weapons 
 * potion, shield or key doors.</p>
 * <p> A item has :</p>
 * <ul>
 * <li> a name : a string that will be defined.</li>
 * </ul>
 * @author Group 6
 * @version 22/11/2016
 */

public abstract class Item {

	private String itemName;//the name of the item

	/**
	 * This constructor
	 * @param itemName The name of the item
	 */
	public Item(String itemName){
		this.itemName = itemName;
	}
	
	/**
	 * This method allows to return the name of the item
	 * @return name The name of the item
	 */
	public String getName() {
		return itemName;
	}
}
