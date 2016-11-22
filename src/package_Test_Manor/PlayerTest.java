package package_Test_Manor;

import static org.junit.Assert.*;

import the_Manor.Player;
import the_Manor.Room;
import the_Manor.Shield;
import the_Manor.Weapon;
import the_Manor.Ally;
import the_Manor.Enemy;

import org.junit.*;
/**
 * The test class PlayerTest
 * Unit tests of the Player class
 * @author Astemir 
 *
 */
public class PlayerTest {
	
	private Player p;
	
	
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
		//Ally a;
		Room Room2, TestRoom;
		TestRoom = new Room("TestRoom");
		Enemy enemy = new Enemy("John");
		TestRoom.addCharacter(enemy);
		Room2 = p.currentRoom;
		assertEquals(TestRoom, Room2);
	}
	
	
	@Test
	/**
	 * This test allows to see if the SetHealth works.
	 * Normally can't set negative values.
	 */
	public void testPlayerHeal() {
		// Tests by adding positive values using the item
		p.setHealth(10); // sets health to 10
		p.heal("Chiken",12); // uses the food item
		assertEquals(22, p.getHealth());
	}
	
	
	
	@Test
	/**
	 * This test allows to see if the SetHealth works.
	 * Normally can't set negative values.
	 */
	public void testPlayerSetHealh() {
		// Test by adding positive values. If equals to 12, works
		p.setHealth(12);
		assertEquals(12, p.getHealth());
		// Test for negative values. If different, method doesn't work correctly
		p.setHealth(-12);
		assertEquals(12, p.getHealth());
	}
	
	@Test
	/**
	 * This test allows to verify the attack modification
	 */
	public void testPlayerSetAttack() {
		// Normally the attack is 10 by default
		p.setAttack("sword", 10);
		assertEquals(20, p.getAttack());
	}
	
	@Test
	/**
	 * This test allows to verify the attack modification
	 */
	public void testPlayerSetDefense() {
		// Normally the defense is 10 by default
		p.setAttack("pot", 10);
		assertEquals(20, p.getDefense());
	}
	
	@Test
	/**
	 * This test allows to verify if talking works
	 */
	public void testPlayerTalkToAlly() {
		//TODO
		;
	}
	
	
}
