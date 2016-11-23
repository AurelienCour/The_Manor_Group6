package the_Manor;

/**
 * <p>This LockedDoor class stands for a door locked thanks to a key. </p>
 * <p>The player will be able to unlock this door if he has the right key.</p>
 * @author Simon Hay
 * @version 22/11/2016
 */

public class LockedDoor extends Door{
	
	private boolean locked;

	/**
	 * Constructor of the LockedDoor class.
	 * @param nextRoom The next room the player is going to enter after having unlocked the door
	 * @param previousRoom The previous room
	 */
	public LockedDoor(Room nextRoom, Room previousRoom) {
		super(nextRoom,previousRoom);
		this.locked = true;
	}
	
	
	/**
	 * Locks the door
	 */
	public void lock(){
		this.locked = true;
	}
	
	/**
	 * Unlocks the door if the player has a key 
	 * @param player The player with the key
	 */
	public void unlock(Player player){
		if(player.haveKey())
			this.locked = false;
	}
	
	/**
	 * Says if the door is locked or not
	 * @return true if the door is locked false if the door is unlocked
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
	 * Function allowing the player to go in another room if the door is open
	 * @return The next room the player is going to enter. If the door is locked return null
	 */
	public Room goNextRoom(){
		if(isLocked())
			return null;
		else
			return nextRoom;
	}
}
