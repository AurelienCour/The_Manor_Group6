package package_Test_Manor;
import junit.framework.TestCase;
import the_Manor.Weapon;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * <p>The test class WeaponTest</p>
 * <p>Unit test of the Weapon class</p>
 * @author Siham
 * @version 22/11/2016
 */

public class WeaponTest {
	
	private Weapon weapon;
	/**
	 * Constructor for test class WeaponTest 
	 */
    
	public WeaponTest()
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
    public void setUp() throws Exception 
    {
    	weapon = new Weapon ("Gun", 5) ;
    }

    @After
    public void tearDown() throws Exception {
    }
    /**
     * Method testGetAttack
     * <p>This method allows to know if the defense of the weapon have the good attack point</p>
     */
    @Test
     public void testGetAttack()
     {
    	assertEquals(5, weapon.getAttack());			
     }
}
