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
	
	private Item itemGiveByAlly;
	
	/**
	 * This is the Ally constructor
	 * @param newName The name of the Ally
	 * @param InitialRoom The position of the Ally
	 */
	public Ally(String newName,String description,Item item) {
		super(newName,description);
		if(item == null)
			System.out.println("L'allié "+this.name+" ne possèdera pas d'item par defaut");
		this.itemGiveByAlly = item;
	}
	
	/**
	 * This methods allow to know the item give by the ally
	 * @return The item held by the ally
	 */
	public Item getItem(){
		return this.itemGiveByAlly;
	}
	
	/**
	 * Allows to add an item to an ally
	 * If an ally who possess an object, you do not add an another object
	 * Otherwide the object is added
	 * @param item
	 */
	public void addItem(Item item){
		if(getItem() == null)
			this.itemGiveByAlly = item;
		else
			System.out.println("L'alliée possède déja un item");
	}
	
	/**
	 * This method allows for the ally to give an item to the player
	 * @param item
	 */
	public void giveItem(Player player){
		if(getItem() != null){
			player.pickUp(this.itemGiveByAlly);
			this.itemGiveByAlly = null;
		}
		else
			System.out.println("L'alliée ne possède pas d'item");
	}
}
