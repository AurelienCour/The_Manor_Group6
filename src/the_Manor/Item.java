package the_Manor;

/**
 * <p>The player have the possibility to found object like weapons 
 * potion, shield or key doors.</p>
 * <ul> A item has : </ul>
 * <li> a name : a string that will be defined
 * @author alexia
 * @version 22/11/2016
 */

public abstract class Item {

	protected String itemName;//the name of the item

	/**
	 * This constructor
	 * @param itemName The name of the item
	 * @param newItem A new item 
	 */
	public Item(String newItem){
		itemName = newItem;
	}
	
	/**
	 * This method allows to return the name of the item
	 * @return name The name of the item
	 */
	public String getName() {
		return itemName;
	}
}
