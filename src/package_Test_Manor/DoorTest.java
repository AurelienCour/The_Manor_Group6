package package_Test_Manor;

import static org.junit.Assert.*;
import org.junit.*;
import the_Manor.Door;
import the_Manor.Room;

public class DoorTest {

	public DoorTest(){
	}
	
    @Before
    public void setUp() throws Exception {
    	Room r = new Room("Test");
        Door d = new Door(r);        
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
