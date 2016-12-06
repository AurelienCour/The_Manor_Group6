package package_Test_Manor;

import the_Manor.Potion;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * The test class PotionTest
 * Unit tests of the Potion class
 * @author Group 6
 * @version 06/12/16
 */
public class PotionTest {
	
	// Objects used for the tests

	private Potion myPotion;
	private Potion myNegativePotion;
	
	/**
	 * Default constructor for the test class PotionTest 
	 */
	public PotionTest()
	{		
	}
	
    /**
	 * Sets up the test fixture
	 */
	@Before
    public void setUp() {
        myPotion = new Potion("Fruit juice",15);
        myNegativePotion = new Potion("Wine",-15);        
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
     * Method testGetHealth
     * <p>This method allows to know if the method getHealth is functional</p>
     */
    @Test
	public void testGetHealth() {
		assertEquals(15,myPotion.getHealth());
	}
    
    /**
     * Method testGetNegativeHealth
     * Tests if when a negative point health has been added, the health points equal to 0
     */
    @Test
    public void testGetNegativeHealth()
    {
    	assertEquals(0,myNegativePotion.getHealth());
    }
}
