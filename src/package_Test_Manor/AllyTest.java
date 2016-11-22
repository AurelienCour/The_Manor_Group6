package package_Test_Manor;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import the_Manor.Ally;
import the_Manor.Player;
import the_Manor.Item;
import org.junit.Test;

/**
 * The test class AllyTest
 * Unit tests of the Ally class
 * @author alexia
 *
 */
public class AllyTest {
	//protected Item myItem;
	private Player myPlayer;
	private Ally myAlly;
	/**
	 * Default constructor for test class PlayerTest
	 */
	public AllyTest () {
	}
	
    /**
     * Sets up the test fixture
     * <p> Called before every test case </p>
     * <p> Initialize one ally for each test case method </p>
     */
    @Before
    public void setUp() throws Exception {  
    	myAlly = new Ally("Ally","Potion");
    }

    @After
    public void tearDown() throws Exception {
    }
    /**
     * Verify that the object was delete for the ally 
     * when it was given to a player.
     */
	@Test
	public void testGiveItem() {
		assertEquals("", myAlly.giveItem());
	}
}
