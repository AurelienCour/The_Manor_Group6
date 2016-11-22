package the_Manor;
/**
 * <p> This class represent all character who are allies for the main character.</p>
 * <p> An ally is only in one room.
 * <p> So only one ally per room.
 * <p> An ally can give an object to the player.</p>
 * 
 * @author Willy Dieuaide
 * @version 2016-22-11
 */
public class Ally extends Character{
	private Item myItem;
	/**
	 * This is the Ally constructor
	 * @param newName The name of the Ally
	 * @param InitialRoom The position of the Ally
	 */
	public Ally(String newName,Item item) {
		super(newName);
		this.myItem = item;
		//myItem = new Item(item);
	}
	/**
	 * methods qui permet de définir quel type d'item il possède
	 */
	public Object getTypeOfItem(){
		return this.myItem;
	}
	
	/**
	 * This method allows for the ally to give an item to the player
	 * @param item
	 */
	public void giveItem(Item itemName,Player player){
		// item devient "vide" --> myItem = ""
	}
}
