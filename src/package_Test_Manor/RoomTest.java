package package_Test_Manor;
import the_Manor.Character;
import the_Manor.Enemy;
//import junit.framework.TestCase;
import the_Manor.Room;
import org.junit.*;


import static org.junit.Assert.*;

import java.util.ArrayList;


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
	 * </p> Initialize one player for each test, whose name is "Cuisine" </p>
	 */
	@Before
	public void setUp()
	{
		myRoom = new Room("Cuisine");
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
	public void testNameCuisine()
	{
		// The parameter "Cuisine" (see setUp) must be set as the name attribute
		assertEquals("Cuisine", myRoom.getName());
	}
	
	/**
	 * Method testSalleDefaultName
	 * <p> Check that the default name is "Salle", if the given name is empty </p>
	 */
	@Test
	public void testSalleDefaultName()
	{
		Room badRoom = new Room("");
		// Assuming that an empty name results in giving "Salle" as a default name for a player
		assertEquals("Salle", badRoom.getName());
	}
	
	/**
	 * Method testAddCharacter
	 * Checks if a character is added in a room 
	 */
	@Test
	public void testAddCharacter()
	{
		this.myRoom.addCharacter(true,"Test");
		assertEquals(1, this.myRoom.numberOfChararacterInRoom());
	}
	
	/**
	 * Method testNameCharacter
	 * Checks the name given to an added character
	 * 	 
	@Test
	public void testNameCharacter()
	{	
		Character myCharacter = new Character("Test");
		this.myRoom.addCharacter(true,"Test");
		assertEquals(myCharacter, this.myRoom.getCharacter("Test"));
	}
	*/
	
	/**
	 * Method testAddItem
	 * Checks if an item is added in a room 
	 */
	@Test
	public void testAddItem()
	{
		Item myItem = new Item("Epee");
		this.myRoom.addItem(myItem);
		assertEquals(1, this.myRoom.numberOfChararacterInRoom());
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
