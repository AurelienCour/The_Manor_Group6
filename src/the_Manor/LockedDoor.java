package the_Manor;

/**
 * <p>This LockedDoor class stands for a door locked thanks to a key. </p>
 * <p>The player will be able to unlock this door if he has the right key.</p>
 * 
 * @author Group 6
 * @version 05/12/16
 */

public class LockedDoor extends Door{
	
	private boolean locked; // A boolean that says if a door is locked or not.
	private Key key; // The key used to open the locked door.

	/**
	 * Constructor of the LockedDoor class.
	 * @param lock The key opening the locked door.
	 * @param nextRoom The next room the player is going to enter after having unlocked the door
	 * @param previousRoom The previous room of the player
	 */
	public LockedDoor(Key lock, Room nextRoom, Room previousRoom) {
		super(nextRoom,previousRoom); // Uses the super-class Door
		this.locked = true; // The door is locked
		this.key = lock; 
	}
	
	
	/**
	 * Locks the door
	 */
	@SuppressWarnings("unused")
	private void lock(){
		if(isLocked())
			System.out.println("The door is already locked!");
		else
			this.locked = true;
	}
	
	/**
	 * Unlock the door
	 */
	private void unlock(){
		if(!isLocked())
			System.out.println("The door is already unlocked!");
		else
			this.locked = false;
	}
	
	/**
	 * Unlocks the door if the player has a key 
	 * @param player The player that wants to open the door.
	 * @return A boolean that says if the door is unlocked (True: Unlocked ; False: Still locked).
	 */
	public boolean unlockKey(Player player){		
		if(player.haveKey(this.key)){
			unlock(); // The player has the key in his inventory.
			return true;
		}
		else
			return false; // The player has not the key.
	}
	
	/**
	 * Says if the door is locked or not.
	 * @return A boolean saying if the door is locked (True: Locked ; False: Unlocked).
	 */
	public Boolean isLocked(){
		if (this.locked)
			return true;
		else
			return false;		
	}
	
	/**
	 * Function allowing the player to go in another room if the door is opened.
	 * @return The next room the player is going to enter. If the door is locked, return null.
	 */
	public Room goNextRoom(){
		if(isLocked())
			return null;
		else
			return this.getNextRoom();
	}
	
	/**
	 * To get the key of the locked door
	 * @return The key that opens the locked door.
	 */
	public Key getKey(){
		return this.key;
	}
}
