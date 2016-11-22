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
	protected Item item;
	/**
	 * This is the Ally constructor
	 * @param newName The name of the Ally
	 * @param InitialRoom The position of the Ally
	 */
	public Ally(String newName) {
		super(newName);
	}

	/**
	 * This method allows for the ally to give an item to the player
	 * @param item
	 */
	// TODO a revoir cette methode
	public void giveItem(Item itemName,Player player){
	}
}
