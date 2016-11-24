package package_Test_Manor;

import static org.junit.Assert.*;

import the_Manor.Player;
import the_Manor.Potion;
import the_Manor.Room;
import the_Manor.Shield;
import the_Manor.Weapon;
import the_Manor.Ally;
import the_Manor.Enemy;
import the_Manor.Item;


import org.junit.*;
/**
 * The test class PlayerTest
 * Unit tests of the Player class
 * @author Astemir 
 *
 */
public class PlayerTest {
	
	private Player p;
	
	/**
	 * Constructor for test class PlayerTest 
	 */
	public PlayerTest()
	{
	}
	
    /**
	 * Sets up the test fixture
	 */
    @Before
    public void setUp() {
        // Code execute avant chaque test   
    	p = new Player("John", "Description", null);
    }

    @After
    public void tearDown() {
        // Code execute apres chaque test
    }
    
	@Test
	/**
	 * Methods testPlayerLife
	 * <p>This test allows to see if the beginning life points are really 10</p>
	 */
	public void testPlayerLife() {
		assertEquals(10, p.getHealth());
	}

	@Test
	/**
	 * Methods testPlayerSameRoomAlly
	 * <p>This test allows to see that the player and the ally are in the same room as the ally</p>
	 */
	public void testPlayerSameRoomAlly() {
		//Ally a;
		Room Room2, TestRoom;
		TestRoom = new Room("TestRoom");
		Enemy enemy = new Enemy("John", "description");
		TestRoom.addCharacter(enemy);
		Room2 = p.getCurrentRoom();
		assertEquals(TestRoom, Room2);
	}
	
	
	@Test
	/**
	 * Method testPlayerHeal
	 * <p>This test allows to see if the SetHealth works.</p>
	 * <p>Normally can't set negative values.</p>
	 */
	public void testPlayerHeal() {
		// Tests by adding positive values using the item
		Potion Redbull;
		Redbull = new Potion("Redbull", 2);
		p.heal(Redbull);
		assertEquals(102, p.getHealth());
	}
	
	
	
	@Test
	/**
	 * Method testPlayerSetHealh
	 * <p>This test allows to see if the SetHealth works.</p>
	 * <p>Normally can't set negative values.</p>
	 */
	public void testPlayerSetHealh() {
		// Test by adding positive values. If equals to 12, works
		assertEquals(102, p.getHealth());
		// Test for negative values. If different, method doesn't work correctly
		assertEquals(102, p.getHealth());
	}
	
	@Test
	/**
	 * Method testPlayerSetAttack
	 * <p>This test allows to verify the attack modification<p>
	 */
	public void testPlayerSetAttack() {
		// Normally the attack is 10 by default
		assertEquals(20, p.getAttack());
	}
	
	@Test
	/**
	 * Method testPlayerSetDefense
	 * <p>This test allows to verify the attack modification<p>
	 */
	public void testPlayerSetDefense() {
		// Normally the defense is 10 by default
		assertEquals(20, p.getDefense());
	}
	
	@Test
	/**
	 * Method testPlayerTalkToAlly
	 * <p>This test allows to verify if talking works<p>
	 */
	public void testPlayerTalkToAlly() {
		//TODO
		;
	}
	
	@Test
	/**
	 * Method testPlayerPickUp
	 * <p>This test allows to verify if the item was picked up<p>
	 */
	public void testPlayerPickUp() {
		Weapon sword, knife;
		sword = new Weapon("Sword", 10);
		p.pickUp(sword);
		assertEquals(1, p.numberOfItem()); // 
		// Now verify if the second item of the same class replaes the first
		knife = new Weapon("Knife", 4);
		p.pickUp(knife);
		assertEquals(1, p.numberOfItem()); // 
	}
	
	
}
