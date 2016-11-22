package package_Test_Manor;
import junit.framework.TestCase;
import the_Manor.Weapon;

import static org.junit.Assert.fail;

import org.junit.*;

/**
 * <p>The test class WeaponTest.</p>
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

    @Before
    public void setUp() throws Exception {
    	name = "Gun";
    	weapon = 5;       
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }
    
    @Test
     public void testGetAttack()
     {
    	assertEquals(5, weapon.getAttack());			
     }
    
    
}
