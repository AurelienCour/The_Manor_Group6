package the_Manor;

/**
 * This Door class stands for a door that a player can use to navigate between the different rooms. </br>
 * The only function of this class for the player is the action of going from a room to another room. </br>
 * @author Simon Hay
 * @version 22/11/2016
 */

public class Door 
{
	// next room the player is going to enter
	private Room nextRoom;
	
	/**
	 * Constructor of the class Door.
	 * @param nextRoom The next room
	 */
	public Door(Room nextRoom){
		this.nextRoom = nextRoom;		
	}
	
	/**
	 * Function allowing the player to go in another room.
	 * @return The next room the player is going to enter. 
	 */
	public Room goNextRoom(){
		return this.nextRoom;
	}
}
