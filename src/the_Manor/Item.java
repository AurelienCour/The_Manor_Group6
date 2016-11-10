package the_Manor;

public class Item {
	
private String name; //the name of the item
	
private String itemName;

	/**
	 * The constructor of the class Item
	 * @param newItem A new item 
	 */
	public Item(String newItem){
		itemName = newItem;
		
	}
	
	/**
	 * To set the name of the item
	 * @return name The name of the item
	 */
	public String setName() {
		return name;
	}
	
	/**
	 * To get the name of the item
	 * @return name The name of the item
	 */
	public String getName() {
		return name;
	}
	

}
