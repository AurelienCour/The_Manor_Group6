package the_Manor;
/**
 * <p> This class represents all characters who are allies for the main character.</p>
 * <p> An ally is only in one room.
 * <p> So there is only one ally per room.
 * <p> An ally can give an object to the player.</p>
 * 
 * @author Willy Dieuaide
 * @version 2016-23-11
 */
public class Ally extends Character{
	
	private Item itemGivenByAlly;
	
	/**
	 * This is the Ally constructor
	 * @param newName The name of the Ally
	 * @param description The description of the ally
	 * @param item The item held by the ally
	 */
	public Ally(String newName,String description,Item item) {
		super(newName,description);
		if(item == null)
			System.out.println("L'alliÃ© "+this.name+" ne possÃ¨dera pas d'item par defaut");
		this.itemGivenByAlly = item;
	}
	
	/**
	 * This method allows to know the item given by the ally
	 * @return The item held by the ally
	 */
	public Item getItem(){
		return this.itemGivenByAlly;
	}
	
	/**
	 * Allows to add an item to an ally
	 * If an ally already possesses an item, an another item cannot be added
	 * @param item The item to give to the ally
	 */
	public void addItem(Item item){
		if(getItem() == null)
			this.itemGivenByAlly = item;
		else
			System.out.println("L'alliÃ©e possÃ¨de dÃ©ja un item");
	}
	
	/**
	 * This method allows the ally to give an item to the player
	 * @param player The player to give the item
	 */
	public void giveItem(Player player){
		if(getItem() != null){
			player.pickUp(this.itemGivenByAlly);
			this.itemGivenByAlly = null;
		}
		else
			System.out.println("L'alliÃ©e ne possÃ¨de pas d'item");
	}
}
