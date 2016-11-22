package the_Manor;

public class LockedDoor extends Door{
	
	// the key opening the locked door
	private Key myKey;

	/**
	 * Constructor of the LockedDoor class.
	 * @param nextRoom The next room the player is going to enter after having unlocked the door
	 */
	public LockedDoor(Room nextRoom) {
		super(nextRoom);
	}
	
	
	/**
	 * Locks the door
	 */
	public void lock(){
		isLocked(true);
	}
	
	/**
	 * Unlocks the door if the player has the right key 
	 */
	public void unlock(Key theKeyOfThePlayer){
		if (theKeyOfThePlayer == myKey){
			isLocked(false);
		}
	}
	
	/**
	 * Says if the door is locked or not
	 * @param The key of the player
	 */
	public Boolean isLocked(){
		if (isLocked(true)) {
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
