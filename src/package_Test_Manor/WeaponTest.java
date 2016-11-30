package package_Test_Manor;

import the_Manor.Weapon;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * <p>The test class WeaponTest</p>
 * <p>Unit test of the Weapon class</p>
 * @author Group 6
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
	
    /**
	 * Sets up the test fixture
	 */
    @Before
    public void setUp()
    {
    	weapon = new Weapon ("Gun", 5) ;
    	
    }

    @After
    public void tearDown() {
    }
    /**
     * Method testGetAttack
     * <p>This method allows to know if the attack of the weapon have the good attack point</p>
     */
    @Test
     public void testGetAttack()
     {
    	assertEquals(5, weapon.getAttack());			
     }
    
    /**
     * Method testGetWrongAttack
     * <p>This method allows to put the value 0 if the attack is negative.</p>
     */
    @Test
     public void testGetWrongAttack()
     {
    	Weapon wrongWeapon = new Weapon ("Flower", -5) ;
    	assertEquals(0, wrongWeapon.getAttack());			
     }
}
