package package_Test_Manor;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import the_Manor.EnigmaticDoor;
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
    	nextRoom = new Room("Kitchen",null);
    	previousRoom = new Room("Bedroom", null);
        door = new LockedDoor(myKey,nextRoom,previousRoom);      
    }

    @After
    public void tearDown() {
        // Code executed after every test
    }

    /**
     * Methods testUnlock
     * Checks if the player has a key and unlock the door
     */
    @Test
    public void testUnlock(){
    	Player player = new Player("Paul", "Description");
    	Key key = new Key("key");
    	player.pickUp(key);
    	this.door.unlock(player);
    	assertEquals(false,this.door.isLocked());
    }
    
    /**
     * Methods testBadUnlock
     * Checks if the player don't has a key
     */
    @Test
    public void testBadUnlock(){
    	Player player = new Player("Paul", "Description");
    	this.door.unlock(player);
    	assertEquals(true,this.door.isLocked());
    }
    
    /**
     * Methods testLock
     * Checks if we can lock an open door
     */
    @Test
    public void testLock(){
    	Player player = new Player("Paul", "Description");
    	Key key = new Key("key");
    	player.pickUp(key);
    	this.door.unlock(player);
    	assertEquals(false,this.door.isLocked());
    	this.door.lock();
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
    	player.pickUp(key);
    	this.door.unlock(player);
    	assertEquals(nextRoom,this.door.goNextRoom());
    }
    
    /**
     * Methods testGoNextRoomIfLock
     * Checks if we can go in the nextRoom without a key
     */
    @Test
    public void testGoNextRoomIfLock(){
    	Player player = new Player("Paul", "Description");
    	this.door.unlock(player);
    	assertEquals(null,this.door.goNextRoom());
    }
}
