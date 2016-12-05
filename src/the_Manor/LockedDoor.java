package the_Manor;

/**
 * <p>This LockedDoor class stands for a door locked thanks to a key. </p>
 * <p>The player will be able to unlock this door if he has the right key.</p>
 * @author Group 6
 * @version 23/11/2016
 */

public class LockedDoor extends Door{
	
	private boolean locked;
	private Key key;

	/**
	 * Constructor of the LockedDoor class.
	 * @param lock 
	 * @param nextRoom The next room the player is going to enter after having unlocked the door
	 * @param previousRoom The previous room
	 */
	public LockedDoor(Key lock, Room nextRoom, Room previousRoom) {
		super(nextRoom,previousRoom);
		this.locked = true;
		this.key = lock;
	}
	
	
	/**
	 * Locks the door
	 */
	public void lock(){
		if(isLocked())
			System.out.println("The door is already locked!");
		else
			this.locked = true;
	}
	
	/**
	 * Unlocks the door if the player has a key 
	 * @param player The player with the key
	 */
	public boolean unlock(Player player){		
		if(player.haveKey(this.key)){
			this.locked = false;
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Says if the door is locked or not
	 * @return true if the door is locked false if the door is unlocked
	 */
	public Boolean isLocked(){
		if (this.locked)
			return true;
		else
			return false;		
	}
	
	/**
	 * Function allowing the player to go in another room if the door is open
	 * @return The next room the player is going to enter. If the door is locked return null
	 */
	public Room getNextRoom(){
		if(isLocked())
			return null;
		else
			return this.nextRoom;
	}
	
	/**
	 * To get the key of the locked door
	 * @return The key
	 */
	public Key getKey(){
		return this.key;
	}
}
