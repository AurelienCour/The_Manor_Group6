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
	 * 
	 */
	public Object getItem(){
		return this.myItem;
	}
	
	/**
	 * Permet d'ajouter un item a un allie
	 * Si l'allie possède déja un objet ne fait rien
	 * Sinon ajoute l'objet
	 * @param item
	 */
	public void addItem(Item item){
		this.myItem = item;
	}
	
	/**
	 * This method allows for the ally to give an item to the player
	 * @param item
	 */
	public void giveItem(Player player){
		this.myItem = null;
	}
}
