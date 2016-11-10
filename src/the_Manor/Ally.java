package the_Manor;

public class Ally extends Character{

	/**
	 * This is the Ally constructor
	 * @param newName The name of the Ally
	 * @param InitialRoom The position of the Ally
	 */
	public Ally(String newName, Room InitialRoom) {
		super(newName, InitialRoom);
	}

	/**
	 * This method allows for the ally to give an item to the player
	 * @param item
	 */
	// TODO a revoire cette methode
	public void giveItem(Item itemName){
		Player.pickUp.add(itemName);
	}

}
