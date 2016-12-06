package package_Test_Manor;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import the_Manor.EnigmaticDoor;
import the_Manor.Room;
import org.junit.Test;

/**
 * The test class EnigmaticDoor
 * Unit tests of the EnigmaticDoor
 * @author Group 6
 * @version 06/12/15
 *
 */
public class EnigmaticDoorTest {
	
	// Different objects used for the tests
	
	private EnigmaticDoor door;
	private Room nextRoom;
	private Room previousRoom;
	
	public EnigmaticDoorTest(){
	}
	
	/**
	 * Sets up the test fixture
	 */
    @Before
    public void setUp() {
    	nextRoom = new Room("Kitchen","Kitchen");
    	previousRoom = new Room("Bedroom","Bedroom");
        door = new EnigmaticDoor("Who is the leader of the group 6 ?","aurelien",nextRoom,previousRoom);     
    }

    
    /**
     * Method testInstance
     * Checks if the instanciation is good
     */
    @Test
    public void testInstance(){
    	assertEquals("Who is the leader of the group 6 ?",this.door.getEnigma());
    	assertEquals("aurelien".toUpperCase(),this.door.getResponse());
    }
    
    /**
     * Method testDefaultInstance
     * Checks if the default instanciation works
     */
    @Test
    public void testDefaultInstance(){
    	EnigmaticDoor doorTest = new EnigmaticDoor("", "", nextRoom,previousRoom);
    	assertEquals("No enigma, response : No enigma",doorTest.getEnigma());
    	assertEquals("No enigma".toUpperCase(),doorTest.getResponse());
    	EnigmaticDoor doorTestNull = new EnigmaticDoor(null, null, nextRoom,previousRoom);
    	assertEquals("No enigma, response : No enigma",doorTestNull.getEnigma());
    	assertEquals("No enigma".toUpperCase(),doorTestNull.getResponse());
    }
    
    /**
     * Methods testResolveEnigma
     * Checks if the enigma is solved with the good response
     */
    @Test
    public void testResolveEnigma(){
    	this.door.solveEnigma("aurelien");
    	assertEquals(false,this.door.isLocked());
    }
    
    /**
     * Methods testResolveEnigmaBad
     * Checks if the enigma is solved with the bad response
     */
    @Test
    public void testResolveEnigmaBad(){
    	this.door.solveEnigma("Not solved");
    	assertEquals(true,this.door.isLocked());
    }
    
    /**
     * Methods testGoNextRoomIfResolve
     * Checks if we can go in the nextRoom with the good response
     */
    @Test
    public void testGoNextRoomIfResolve(){
    	this.door.solveEnigma("Aurelien");
    	assertEquals(nextRoom,this.door.goNextRoom());
    }
    
    /**
     * Methods testGoNextRoomIfResolve
     * Checks if we can go in the nextRoom with the bad response
     */
    @Test
    public void testGoNextRoomIfNotResolve(){
    	this.door.solveEnigma("Not solve");
    	assertEquals(null,this.door.goNextRoom());
    }
}
