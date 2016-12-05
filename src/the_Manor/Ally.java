package the_Manor;
/**
 * <p> This class represents all characters who are allies for the main character.</p>
 * <p> An ally is only present in one room and there is only one ally per room. 
 * <p> An ally can give objects and clues to the player.</p>
 * 
 * @author Group 6
 * @version 2016-05-12
 */
public class Ally extends Character{
	
	private Item itemGivenByAlly; // The item that the ally gives to the player.
	private String message; // The message that the ally tells to the player.
	
	/**
	 * Ally constructor
	 * @param newName The name of the ally
	 * @param description The description of the ally
	 * @param message The message say by the ally
	 * @param item The item held by the ally
	 */
	public Ally(String newName,String description,String message,Item item) {
		super(newName,description); // Uses the Fighter super class. 
		if(item == null)
			System.out.println("The ally"+this.getName()+" will not possess a default item.");
		if(message.isEmpty())
			this.message = "Hello";
		else
			this.message = message;
			this.itemGivenByAlly = item;
	}
	
	/**
	 * This method allows to know the item given by the ally to the player.
	 * @return The item held by the ally.
	 */
	public Item getItem(){
		return this.itemGivenByAlly;
	}
	
	/**
	 * Allows to add an item to an ally.
	 * If an ally already possesses an item, an another item cannot be added.
	 * @param item The item to give to the ally.
	 */
	public void addItem(Item item){
		if(!haveItem())
			this.itemGivenByAlly = item;
	}
	
	/**
	 * Allows the ally to give an item to the player if the ally possesses an item.
	 * @param player The player to give the item.
	 */
	public void giveItem(Player player){
		if(haveItem()){
			player.pickUp(this.itemGivenByAlly);
			this.itemGivenByAlly = null;
		}
		else
			System.out.println("The ally does not have any item.");
	}
	
	/**
	 * Allows to see if an ally owns an item.
	 * @return Boolean True if the ally owns an item, false if he does not.
	 */
	public boolean haveItem(){
		if(getItem() == null)
			return false;
		else
			return true;
	}
	
	/**
	 * Allows to get the message told by the ally to the player.
	 * @return The message told.
	 */
	public String getMessage(){
		return this.message;
	}
	
	/**
	 * Allows to set the message told by the ally to the player.
	 * @param newMessage The message to be tell.
	 */
	public void setMessage(String newMessage){
		this.message = newMessage;
	}
}
