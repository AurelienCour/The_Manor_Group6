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
	

    @Before
    public void setUp() throws Exception {
    	shield = new Shield ("Shield", 15) ;        
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }
    
    @Test
    public void testGetDefense()
    {
    	assertEquals(15, shield.getDefense());			
    }
}
