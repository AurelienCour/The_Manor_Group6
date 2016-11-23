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
	
	public PotionTest(){
		
	}
	@BeforeClass
    public static void setUpClass() throws Exception {
        // Code execute avant        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // Code 
    }
    /**
	 * Sets up the test fixture
	 * @throws Exception
	 */
	@Before
    public void setUp() throws Exception {
        potion = new Potion("potion",15);
    }

    @After
    public void tearDown() throws Exception {
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
