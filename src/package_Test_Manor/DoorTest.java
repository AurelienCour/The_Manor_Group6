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
    	room = new Room("Test");
    	door = new Door(room);        
    }
    
    @After
    public void tearDown() throws Exception {
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
