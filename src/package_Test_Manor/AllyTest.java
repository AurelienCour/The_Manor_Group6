package package_Test_Manor;

import static org.junit.Assert.*;
import the_Manor.Ally;
import org.junit.*;
/**
 * The test class AllyTest
 * Unit tests of the Ally class
 * @author alexia
 *
 */
public class AllyTest {
	private Item item;
	private Player player;
	private Ally ally;
	/**
	 * Default constructor for test class PlayerTest
	 */
	public AllyTest {
	}
	
    /**
     * Sets up the test fixture
     * <p> Called before every test case </p>
     * <p> Initialize one ally for each test case method </p>
     */
    @Before
    public void setUp() throws Exception {  
    	myAlly = new Ally("Ally");
    	item = new Item("Potion");
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
		ally.giveItem(item, player);
		assertEquals(ally.item, "");
	}

}
