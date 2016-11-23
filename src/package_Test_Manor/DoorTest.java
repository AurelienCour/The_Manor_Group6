package package_Test_Manor;

import static org.junit.Assert.*;
import org.junit.*;
import the_Manor.Door;
import the_Manor.Room;

/**
 * The test class DoorTest
 * Unit tests of the Door class
 * @author Aurelien
 *
 */
public class DoorTest {
	private Room nextRoom;
	private Room previousRoom;
	private Door door;
	
	/**
	 * Default constructor for test class DoorTest
	 */
	public DoorTest(){
	}
	
	/**
	 * Sets up the test fixture
	 */
    @Before
    public void setUp() {
    	nextRoom = new Room("Kitchen");
    	previousRoom = new Room("Bedroom");
    	door = new Door(nextRoom,previousRoom);        
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Methods testInstance
     * Allows to knows if the instanciation works
     */
    @Test
    public void testInstance(){
    	assertEquals(nextRoom,door.goNextRoom());
    	assertEquals(previousRoom,door.getPreviousRoom());
    }
    
    /**
     * Methods testDefaultInstance
     * Allows to knows if the default instanciation works
     */
    @Test
    public void testDefaultInstance(){
    	Door doorTest = new Door(null,previousRoom); 
    	assertEquals(previousRoom,doorTest.goNextRoom());
    	assertEquals(previousRoom,doorTest.getPreviousRoom());
    }
    
    /**
     * Methods testGoNextRoom
     * <p>This methods allows to verify if the player go in another room</p>
     */
	@Test
	public void testgoNextRoom() {
		assertEquals(nextRoom,door.goNextRoom());
	}

}
