package package_Test_Manor;
import junit.framework.TestCase;
import the_Manor.Potion;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * The test class PotionTest
 * Unit tests of the Potion class
 * @author Aurelien
 */
public class PotionTest {

	private Potion potion;
	/**
	 * Constructor for test class PotionTest 
	 */
	public PotionTest(){
		
	}
	
    /**
	 * Sets up the test fixture
	 */
	@Before
    public void setUp() {
        potion = new Potion("potion",15);
    }

    @After
    public void tearDown() {
        // Code execute apres chaque test
    }
    
    /**
     * Method testGetHealth
     * <p>This method allows to know if the method getHealth is functional</p>
     */
    @Test
	public void testGetHealth() {
		assertEquals(15,this.potion.getHealth());
	}
}
