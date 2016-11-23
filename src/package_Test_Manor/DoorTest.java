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
	private Room room;
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
    	room = new Room("Test");
    	door = new Door(room);        
    }
    
    @After
    public void tearDown() {
        // Code execute apres chaque test
    }
    
    /**
     * Methods testGoNextRoom
     * <p>This methods allows to verify if the player go in another room</p>
     */
	@Test
	public void testgoNextRoom() {
		assertEquals(room,door.goNextRoom());
	}

}
