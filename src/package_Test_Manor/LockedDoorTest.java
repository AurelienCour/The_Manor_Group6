package package_Test_Manor;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import the_Manor.Key;
import the_Manor.LockedDoor;
import the_Manor.Player;
import the_Manor.Room;
import org.junit.Test;

/**
 * The test class LockedDoorTest
 * Unit tests of the Player class
 * @author Group 6
 * @version 23/11/2016
 */
public class LockedDoorTest {
	
	// Different objects used for the tests
	
	private LockedDoor door;
	private Room nextRoom;
	private Room previousRoom;
	private Key myKey;
	
	public LockedDoorTest(){
	}
	
	/**
	 * Sets up the test fixture
	 */
    @Before
    public void setUp() {
    	myKey = new Key("test");
    	nextRoom = new Room("Kitchen",null);
    	previousRoom = new Room("Bedroom", null);
        door = new LockedDoor(myKey,nextRoom,previousRoom);        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Methods testUnlock
     * Checks if the player has a key and unlock the door
     */
    @Test
    public void testUnlock(){
    	Player player = new Player("", "");
    	player.pickUp(this.myKey);
    	this.door.unlockKey(player);
    	assertEquals(false,this.door.isLocked());
    }
    
    /**
     * Methods testBadUnlock
     * Checks if the player does not have a key
     */
    @Test
    public void testBadUnlock(){
    	Player player = new Player("Paul", "Description");
    	this.door.unlockKey(player);
    	assertEquals(true,this.door.isLocked());
    }
    
    /**
     * Methods testLock
     * Checks if we can lock an opened door
     */
    @Test
    public void testLock(){
    	Player player = new Player("Paul", "Description");    
    	Key key = new Key("");
    	player.pickUp(key);
    	this.door.unlockKey(player);
    	assertEquals(true,this.door.isLocked());
    }
    
    /**
     * Methods testGoNextRoomIfUnlock
     * Checks if we can go in the nextRoom with a key
     */
    @Test
    public void testGoNextRoomIfUnlock(){
    	Player player = new Player("Paul", "Description");
    	Key key = new Key("key");
    	player.setCurrentRoom(previousRoom);    	    	
    	player.pickUp(key);
    	this.door.unlockKey(player);    	
    	this.door.goNextRoom();
    	assertEquals(nextRoom,player.getCurrentRoom());
    }
    
    /**
     * Methods testGoNextRoomIfLock
     * Checks if we can go in the nextRoom without a key
     */
    @Test
    public void testGoNextRoomIfLock(){
    	Player player = new Player("Paul", "Description");
    	this.door.unlockKey(player);
    	assertEquals(null,this.door.goNextRoom());
    }
}
