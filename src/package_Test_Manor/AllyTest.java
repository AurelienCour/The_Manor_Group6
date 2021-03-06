package package_Test_Manor;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import the_Manor.Ally;
import the_Manor.Player;
import the_Manor.Potion;

import org.junit.Test;

/**
 * The test class AllyTest
 * Unit tests of the Ally class
 * @author Group 6
 * @version 06/12/16
 *
 */
public class AllyTest {

	// Different objects used for the tests
	
	private Ally myAlly;
	private Potion potion;
	
	/**
	 * Default constructor for test class AllyTest
	 */
	public AllyTest () {
	}
	
    /**
     * Sets up the test fixture
     * <p> Called before every test case </p>
     * <p> Initialize one ally for each test case method </p>
     */
    @Before
    public void setUp() {
    	potion = new Potion("Life potion", 40);
    	myAlly = new Ally("myAlly", "An ally", "try", potion);
    }

    @After
    public void tearDown() {
    }
    
    /** 
     * Method testGetItem
     * <p>Verifies that the object was deleted from the ally when it was given to a player.</p> 
     */
	@Test
	public void testGetItem() {
		assertEquals(potion, myAlly.getItem());
	}
	
	/**
	 * Method testAddItem
	 * <p>Verifies that the object given to the ally is present</p>	 
	 */
	@Test
	public void testAddItem(){
		Potion potion2 = new Potion("potion",15);
		Ally myAlly2 = new Ally("try", "try", "try", null);
		assertEquals(null, myAlly2.getItem());
		myAlly2.addItem(potion2);
		assertEquals(potion2, myAlly2.getItem());
	}
	
	/**
	 * Method testAddItemWithItem
	 * <p>Verifies that the first item given to the ally is present after give an other item</p>
	 */
	@Test
	public void testAddItemWithItem(){
		Potion potion2 = new Potion("potion",15);
		Ally myAlly2 = new Ally("try", "try", "try", potion);
		assertEquals(potion, myAlly2.getItem());
		this.myAlly.addItem(potion2);
		assertEquals(potion, myAlly2.getItem());
	}
	
	/**
	 * Method testGiveItem
	 * <p>Verifies that the ally can give an object
	 * and change the value of the object to null</p>
	 */
	@Test
	public void testGiveItem(){
		Player player = new Player("try", "try");
		assertEquals(0, player.numberOfItem());
		assertEquals(potion, myAlly.getItem());
		this.myAlly.giveItem(player);
		assertEquals(null, myAlly.getItem());
		assertEquals(1, player.numberOfItem());
	}
	
	/**
	 * Method testGiveItemWithoutItem
	 * <p>Verifies that the ally can not give an item without an item</p>
	 */
	@Test
	public void testGiveItemWithoutItem(){
		Player player = new Player("try", "try");
		Ally myAlly2 = new Ally("try", "try", "try", null);
		assertEquals(0, player.numberOfItem());
		assertEquals(null, myAlly2.getItem());
		myAlly2.giveItem(player);
		assertEquals(0, player.numberOfItem());
	}
}