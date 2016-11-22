package package_Test_Manor;
import junit.framework.TestCase;
import the_Manor.Room;

import static org.junit.Assert.fail;

import org.junit.*;

public class RoomTest 
{
	private Room myRoom;
	
	/**
	 * Default constructor for the test class RoomTest
	 */
	public RoomTest()
	{
	}
	
	/**
	 * Sets up the test fixture.
	 * </p> Called before every test case method. </p>
	 * </p> Initialize one player for each test, whose name is "Salle" </p>
	 */
	@Before
	public void setUp()
	{
		myRoom = new Room("Salle");
	}
	
	/**
	 * Tears down the test fixture.
	 * <p> Called after every test case method. Nothing to do in this case </p>
	 */
	@After
	public void tearDown()
	{		
	}
	
	/**
	 * Method testNameSalle
	 * <p> Checks if the name given as parameter in the constructor is correctly set to the attribute </p>
	 */
	@Test
	public void testNameSalle()
	{
		// The parameter "Salle" (see setUp) must be set as the name attribute
		assertEquals("Salle", myRoom.getName());
	}
	
	
	/**
	@BeforeClass
    public static void setUpClass() throws Exception {
        // Code execute avant l'exécution du premier test (et de la méthode @Before)        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // Code execute après l'exécution de tous les tests
    }

    @Before
    public void setUp() throws Exception {
        // Code execute avant chaque test        
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }
    
    @Test
	public void test() {
		fail("Not yet implemented");
	}
	*/
}
