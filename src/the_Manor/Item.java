package the_Manor;

/**
 * <p>The player has the possibility to found objects like weapons, potions, shields or keys.</p>
 * <p>An item has :</p>
 * <ul>
 * <li> a name : a string that will be defined.</li>
 * </ul>
 * 
 * @author Group 6
 * @version 05/12/16
 */

public abstract class Item {

	private String itemName; //the name of the item

	/**
	 * Item constructor
	 * @param itemName The name of the item
	 */
	public Item(String itemName){
		this.itemName = itemName;
	}
	
	/**
	 * This method allows to return the name of the item
	 * @return itemName The name of the item
	 */
	public String getName() {
		return itemName;
	}
}
