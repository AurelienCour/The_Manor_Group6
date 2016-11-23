package package_Test_Manor;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import the_Manor.Ally;
import the_Manor.Player;
import the_Manor.Potion;
import the_Manor.Item;
import org.junit.Test;

/**
 * The test class AllyTest
 * Unit tests of the Ally class
 * @author Aurelien
 *
 */
public class AllyTest {

	private Ally myAlly;
	/**
	 * Default constructor for test class PlayerTest
	 */
	public AllyTest () {
	}
	@BeforeClass
    public static void setUpClass() throws Exception {
        // Code execute avant l'exécution du premier test (et de la méthode @Before)        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // Code execute après l'exécution de tous les tests
    }
    /**
     * Sets up the test fixture
     * <p> Called before every test case </p>
     * <p> Initialize one ally for each test case method </p>
     */
    @Before
    public void setUp() throws Exception {
    	this.myAlly = new Ally("Ally",null);
    }

    @After
    public void tearDown() throws Exception {
    }
    
    /**
     * Verify that the object was delete for the ally 
     * when it was given to a player.
     */
	@Test
	public void testGetItem() {
		assertEquals(null, myAlly.getItem());
	}
	
	/**
	 * Verify that the object given to the ally
	 * is present
	 */
	@Test
	public void testAddItem(){
		Potion potion = new Potion("potion",15);
		this.myAlly.addItem(potion);
		assertEquals(potion, myAlly.getItem());
	}
	
	/**
	 * Verify that the ally can give an object
	 * and change the value of the object to null
	 */
	@Test
	public void testGiveItem(){
		Potion potion = new Potion("potion",15);
		this.myAlly.addItem(potion);
		Player player = new Player("PlayerTest", null);
		this.myAlly.giveItem(player);
		assertEquals(null, this.myAlly.getItem());
	}
}