package package_Test_Manor;
import junit.framework.TestCase;
import the_Manor.Shield;
import the_Manor.Weapon;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * <p>The test class ShieldTest</p>
 * <p>Unit test of the Shield class</p>
 * @author Siham
 * @version 22/11/2016
 */

public class ShieldTest {
	
	private Shield shield;
	/**
	 * Constructor for test class WeaponTest 
	 */
    
	public ShieldTest()
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
    /**
	 * Sets up the test fixture
	 * @throws Exception
	 */
    @Before
    public void setUp() throws Exception {
    	shield = new Shield ("Shield", 15) ;        
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }
    /**
     * Method testGetDefense
     * <p>This method allows to know if the defense of the shield have the good defense point</p>
     */
    @Test
    public void testGetDefense()
    {
    	assertEquals(15, shield.getDefense());			
    }
}
