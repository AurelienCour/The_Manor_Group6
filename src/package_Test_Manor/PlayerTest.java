package package_Test_Manor;

import static org.junit.Assert.*;

import the_Manor.Player;
import the_Manor.Room;
import the_Manor.Ally;
import the_Manor.Character;
import org.junit.*;

public class PlayerTest {
	
	private Player p;
	private Ally a;
	private Room Room1, Room2, TestRoom;
	
	
	public PlayerTest()
	{
	}
	
	@BeforeClass
    public static void setUpClass() throws Exception {
        // Code execute avant        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // Code 
    }

    @Before
    public void setUp() throws Exception {
        // Code execute avant chaque test   
    	p = new Player("John", null);
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }
    
	@Test
	/**
	 * This test allows to see if the beginning life points are really 10
	 */
	public void testPlayerLife() {
		assertEquals(10, p.getHealth());
	}

	@Test
	/**
	 * This test allows to see that the player and the ally are in the same room as the ally
	 */
	public void testPlayerSameRoomAlly() {
		TestRoom = new Room("TestRoom");
		TestRoom.addCharacter(false, "John");
		Room2 = p.currentRoom;
		assertEquals(TestRoom, Room2);
	}
}
