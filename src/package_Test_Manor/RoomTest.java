package package_Test_Manor;
import the_Manor.Character;
import the_Manor.Enemy;
import the_Manor.Item;
import the_Manor.LockedDoor;
//import junit.framework.TestCase;
import the_Manor.Room;
import the_Manor.Weapon;

import org.junit.*;


import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * The test class RoomTest
 * Unit test of the Room class
 * @author Simon
 *
 */
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
	 * <p> Called before every test case method. </p>
	 * <p> Initialize one player for each test, whose name is "Cuisine" </p>
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
		Enemy myCharacter = new Enemy("Test");
		this.myRoom.addCharacter(myCharacter);
		assertEquals(1, this.myRoom.numberOfChararacterInRoom());
	}
	
	/**
	 * Method testNameCharacter
	 * Checks the name given to an added character
	 */
	@Test
	public void testNameCharacter()
	{	
		Enemy myCharacter = new Enemy("Test");
		this.myRoom.addCharacter(myCharacter);
		assertEquals(myCharacter, this.myRoom.getCharacter("Test"));
	}

	
	/**
	 * Method testAddItem
	 * Checks if an item is added in a room 
	 */
	@Test
	public void testAddItem()
	{
		Weapon myItem = new Weapon("Epee", 2);
		this.myRoom.addItem(myItem);
		assertEquals(1, this.myRoom.numberOfItemInRoom());
	}
	
	/**
	 * Method testRemoveItem
	 * Checks if an item is removed of the room
	 */
	@Test
	public void testRemoveItem()
	{
		Weapon myItem = new Weapon("Epee", 2);
		this.myRoom.addItem(myItem);
		this.myRoom.removeItem(myItem);
		assertEquals(0, this.myRoom.numberOfItemInRoom());
	}
	
	/**
	 * Method testDeleteEnemy
	 * Checks if an enemy is deleted of the room
	 */
	@Test
	public void testDeleteEnemy()
	{
		Enemy myCharacter = new Enemy("Test");
		this.myRoom.addCharacter(myCharacter);
		this.myRoom.deleteEnemy(myCharacter);
		assertEquals(0, this.myRoom.numberOfChararacterInRoom());
	}
	
	/**
	 * Method testAddExit
	 * Test if an exit is added to the room
	 
	@Test
	public void testAddExit()
	{			
		String direction = "Test";
		myRoom.addExit(direction, true, myRoom);
		//assertEquals(0, this.myRoom.numberOfExit());
	}
	*/
	
	
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
