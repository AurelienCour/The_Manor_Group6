package package_Test_Manor;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import the_Manor.EnigmaticDoor;
import the_Manor.Room;
import org.junit.Test;

public class EnigmaticDoorTest {
	
	private EnigmaticDoor door;
	private Room room;
	
	public EnigmaticDoorTest(){
	}
	
	/**
	 * Sets up the test fixture
	 * @throws Exception
	 */
    @Before
    public void setUp() throws Exception {
    	room = new Room("");
        door = new EnigmaticDoor("","",room);      
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }
    
    /**
     * Methods testResolveEnigma
     * Checks if the enigma is solve with the good response
     */
    @Test
    public void testResolveEnigma(){
    	this.door.solveEnigma("");
    	assertEquals(false,this.door.isLocked());
    }
    
    /**
     * Methods testResolveEnigmaBad
     * Checks if the enigma is solve with the bad response
     */
    @Test
    public void testResolveEnigmaBad(){
    	this.door.solveEnigma("No");
    	assertEquals(true,this.door.isLocked());
    }
    
    /**
     * Methods testGoNextRoomIfResolve
     * Checks if we can go in the nextRoom with the good response
     */
    @Test
    public void testGoNextRoomIfResolve(){
    	this.door.solveEnigma("");
    	assertEquals(room,this.door.goNextRoom());
    }
    
    /**
     * Methods testGoNextRoomIfResolve
     * Checks if we can go in the nextRoom with the bad response
     */
    @Test
    public void testGoNextRoomIfNotResolve(){
    	this.door.solveEnigma("No");
    	assertEquals(null,this.door.goNextRoom());
    }
}
