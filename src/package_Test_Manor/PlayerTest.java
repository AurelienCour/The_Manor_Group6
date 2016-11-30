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
    	p = new Player("John", "Description");
    }

    @After
    public void tearDown() {
        // Code execute apres chaque test
    }
    
	@Test
	/**
	 * Methods testPlayerLife
	 * <p>This test allows to see if the beginning life points are really 100</p>
	 */
	public void testPlayerLife() {
		assertEquals(100, p.getHealth());
	}

	
	
	@Test
	/**
	 * Method testPlayerHeal
	 * <p>This test allows to see if the SetHealth works.</p>
	 * <p>Normally can't set negative values.</p>
	 */
	public void testPlayerHeal() {
		// Tests by adding positive values using the item
		p.removeHealth(20);
		Potion Redbull;
		Redbull = new Potion("Redbull", 5);
		p.pickUp(Redbull);
		p.heal(Redbull);
		assertEquals(85, p.getHealth());
		// test for when the health goes over the max
		p.addHealth(100);
		p.heal(Redbull);
		assertEquals(100, p.getHealth());
	}
	
	
	
	@Test
	/**
	 * Method testPlayerSetHealh
	 * <p>This test allows to see if the SetHealth works.</p>
	 * <p>Normally can't set negative values.</p>
	 */
	public void testPlayerSetHealth() {
		// Test by adding positive values. If equals to 12, works
		p.addHealth(102);
		assertEquals(100, p.getHealth());
		// Test for negative values. If different, method doesn't work correctly
		p.addHealth(-100);
		assertEquals(100, p.getHealth());
	}
	
	@Test
	/**
	 * Method testPlayerSetAttack
	 * <p>This test allows to verify the attack modification<p>
	 */
	public void testPlayerPickUpWeapon() {
		// Normally the attack is 10 by default
		Weapon sword, spoon;
		sword = new Weapon("Sword", 10);
		p.pickUp(sword);
		assertEquals(20, p.getAttack());
		// pickup a bad weapon, with negative points
		spoon = new Weapon("Spoon", -5);
		p.pickUp(spoon);
		assertEquals(20, p.getAttack());	
	}
	
	@Test
	/**
	 * Method testPlayerSetDefense
	 * <p>This test allows to verify the attack modification<p>
	 */
	public void testPlayerPickUpShield() {
		// Normally the defense is 10 by default
		Shield pot;
		pot = new Shield("Pot", 10);
		p.pickUp(pot);
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
