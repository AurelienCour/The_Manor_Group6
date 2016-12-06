package package_Test_Manor;

import the_Manor.Enemy;
import the_Manor.Room;
import the_Manor.Weapon;
import the_Manor.Key;
import org.junit.*;
import static org.junit.Assert.*;


/**
 * The test class RoomTest
 * Unit test of the Room class
 * 
 * @author Group 6
 * @version 06/12/16
 *
 */
public class RoomTest 
{
	// Objects used for the tests
	
	private Room myRoom;
	private Room myNextRoom;
	private Key myKey;
	
	
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
		myRoom = new Room("Kitchen",null);
		myKey = new Key("The Key");
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
		// The parameter "Kitchen" (see setUp) must be set as the name attribute
		assertEquals("Kitchen", myRoom.getName());
	}
	
	/**
	 * Method testSalleDefaultName
	 * <p> Check that the default name is "Salle", if the given name is empty </p>
	 */
	@Test
	public void testSalleDefaultName()
	{
		Room badRoom = new Room("",null);
		// Assuming that an empty name results in giving "Salle" as a default name for a player
		assertEquals("Room", badRoom.getName());
	}
	
	/**
	 * Method testAddCharacter
	 * Checks if a character is added in a room 
	 */
	@Test
	public void testAddCharacter()
	{
		Enemy myCharacter = new Enemy("Test", "description", 50, 50, 5, 5,"");
		myRoom.addCharacter(myCharacter);
		assertEquals(1, myRoom.numberOfChararacterInRoom());
	}
	
	/**
	 * Method testNameCharacter
	 * Checks the name given to an added character
	 */
	@Test
	public void testNameCharacter()
	{	
		Enemy myCharacter = new Enemy("Test", "description", 50, 50, 5, 5,"");
		myRoom.addCharacter(myCharacter);
		assertEquals(myCharacter, myRoom.getCharacter("Test"));
	}

	
	/**
	 * Method testAddItem
	 * Checks if an item is added in a room 
	 */
	@Test
	public void testAddItem()
	{
		Weapon myItem = new Weapon("Sword", 2);
		myRoom.addItem(myItem);
		assertEquals(1, myRoom.numberOfItemInRoom());
	}
	
	/**
	 * Method testRemoveItem
	 * Checks if an item is removed of the room
	 */
	@Test
	public void testRemoveItem()
	{
		Weapon myItem = new Weapon("Sword", 2);
		myRoom.addItem(myItem);
		myRoom.removeItem(myItem);
		assertEquals(0, myRoom.numberOfItemInRoom());
	}
	
	/**
	 * Method testDeleteEnemy
	 * Checks if an enemy is deleted of the room
	 */
	@Test
	public void testDeleteEnemy()
	{
		Enemy myCharacter = new Enemy("Test", "description", 50, 50, 5, 5,"");
		myRoom.addCharacter(myCharacter);
		myRoom.deleteEnemy(myCharacter);
		assertEquals(0, myRoom.numberOfChararacterInRoom());
	}
	
	/**
	 * Method testAddExit
	 * Test if an exit is added to the room
	 */
	@Test
	public void testAddExit()
	{			
		String direction = "Test";
		myRoom.addExit(direction, myKey, myNextRoom);;
		assertEquals(1, myRoom.numberOfExit());
	}
	
	/**
	 * Method testAddEnigmaticExit
	 * Test if an enigmatic exit is added to the room
	 */
	@Test 
	public void testAddEnigmaticExit()
	{
		String direction = "Test";
		myRoom.addExit(direction, myKey, myNextRoom);
		assertEquals(1, myRoom.numberOfExit());
	}
}
