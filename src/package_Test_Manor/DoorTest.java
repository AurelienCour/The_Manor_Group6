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
	private Room r;
	private Door d;

	public DoorTest(){
	}
	
    @Before
    public void setUp() throws Exception {
    	r = new Room("Test");
        d = new Door(r);        
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }
    
	@Test
	public void testgoNextRoom() {
		assertEquals(r,d.goNextRoom());
	}

}
