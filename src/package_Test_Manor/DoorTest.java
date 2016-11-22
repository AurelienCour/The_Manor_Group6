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

	public DoorTest(){
	}
	
    @Before
    public void setUp() throws Exception {
    	room = new Room("Test");
    	door = new Door(room);        
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }
    
	@Test
	public void testgoNextRoom() {
		assertEquals(room,door.goNextRoom());
	}

}
