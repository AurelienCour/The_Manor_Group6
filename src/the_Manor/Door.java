package the_Manor;

/**
 * <p>This Door class stands for a door that a player can use to navigate between the different rooms. </p>
 * <p>The only function of this class for the player is the action of going from a room to another room. </p>
 * @author Simon Hay
 * @version 22/11/2016
 */

public class Door 
{
	// next room the player is going to enter
	protected Room nextRoom;
	// the previous room
	protected Room previousRoom;
	/**
	 * Constructor of the class Door.
	 * The previousRoom cannot be null.
	 * The nextRoom can be null. If the nextRoom is null the door leads to the previous room
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
	 * Function allowing the player to go in another room.
	 * @return The next room the player is going to enter. 
	 */
	public Room goNextRoom(){
		return this.nextRoom;
	}
	
	/**
	 * Function to know the previous room
	 * @return The previous room 
	 */
	public Room getPreviousRoom(){
		return this.previousRoom;
	}
}
