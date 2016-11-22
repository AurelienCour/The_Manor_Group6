package the_Manor;

/**
 * This LockedDoor class stands for a door locked thanks to a key. </br>
 * The player will be able to unlock this door if he has the right key.
 * @author Simon Hay
 * @version 22/11/2016
 */

public class LockedDoor extends Door{
	
	// the key opening the locked door
	private Key myKey;
	private boolean locked;

	/**
	 * Constructor of the LockedDoor class.
	 * @param nextRoom The next room the player is going to enter after having unlocked the door
	 */
	public LockedDoor(Room nextRoom) {
		super(nextRoom);
		this.locked = true;
	}
	
	
	/**
	 * Locks the door
	 */
	public void lock(){
		this.locked = true;
	}
	
	/**
	 * Unlocks the door if the player has the right key 
	 */
	public void unlock(Key theKeyOfThePlayer){
		if (theKeyOfThePlayer == myKey){
			this.locked = false;
		}
	}
	
	/**
	 * Says if the door is locked or not
	 * @param The key of the player
	 */
	public Boolean isLocked(){
		if (this.locked) {
			return true;
		} 
		else {
			return false;		
		}
	}
	
	/**
	 * Function allowing the player to go in another room.
	 * @param nextRoom The next room the player is going to enter. 
	 * @return The next room the player is going to enter. 
	 */
	public Room goNextRoom(Room nextRoom){
		return nextRoom;
	}
	


}
