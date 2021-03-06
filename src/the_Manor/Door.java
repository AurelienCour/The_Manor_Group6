package the_Manor;

/**
 * <p>This Door class stands for a door that a player can use to navigate between two different rooms. </p>
 * <p>The only function of this class for the player is the action of going from a room to another room. </p>
 * 
 * @author Group 6
 * @version 05/12/16
 */

public class Door 
{
	// next room the player is going to enter
	private Room nextRoom;
	// the previous room of the player
	private Room previousRoom;
	
	/**
	 * Constructor of the class Door.
	 * The previousRoom cannot be null.
	 * The nextRoom can be null. If the nextRoom is null the door leads to the previous room.
	 * @param nextRoom The next room
	 * @param previousRoom The previous room
	 */
	public Door(Room nextRoom, Room previousRoom){
		if(previousRoom == null)
			System.out.println("Error");
		else
			this.previousRoom = previousRoom;
		if(nextRoom == null)
			this.nextRoom= previousRoom;
		else
			this.nextRoom = nextRoom;
	}
	
	/**
	 * Allow to get the NextRoom behind the Door
	 * @return the nextRoom behind the Door
	 */
	public Room getNextRoom(){
		return this.nextRoom;
	}
	
	/**
	 * Function allowing the player to go in another room.
	 * @return The next room the player is going to enter. 
	 */
	public Room goNextRoom(){
		return this.getNextRoom();
	}
	
	/**
	 * Function to know the previous room of the player.
	 * @return The previous room  of the player.
	 */
	public Room getPreviousRoom(){
		return this.previousRoom;
	}
		
}
