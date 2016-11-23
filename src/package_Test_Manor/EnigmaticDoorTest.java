package package_Test_Manor;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import the_Manor.EnigmaticDoor;
import the_Manor.Room;
import org.junit.Test;

/**
 * The test class EnigmaticDoor
 * Unit tests of the EnigmaticDoor
 * @author Aurelien
 *
 */
public class EnigmaticDoorTest {
	
	private EnigmaticDoor door;
	private Room room;
	
	public EnigmaticDoorTest(){
	}
	
	@BeforeClass
    public static void setUpClass() throws Exception {
        // Code execute avant l'execution du premier test (et de la methode @Before)        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // Code execute apres l'execution de tous les tests
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
