package package_Test_Manor;

import the_Manor.Shield;


import static org.junit.Assert.*;

import org.junit.*;

/**
 * <p>The test class ShieldTest</p>
 * <p>Unit test of the Shield class</p>
 * @author Group 6
 * @version 22/11/2016
 */

public class ShieldTest {
	
	private Shield shield;
	private Shield wrongShield;
	/**
	 * Constructor for test class ShieldTest 
	 */
    
	public ShieldTest()
	{		
	}
	
    /**
	 * Sets up the test fixture
	 */
    @Before
    public void setUp() {
    	shield = new Shield ("Shield", 15) ;  
    	wrongShield = new Shield ("Paper", -15);
    }

    @After
    public void tearDown() {
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
    
    /**
     * Method testGetWrongDefense
     * <p>This method allows to put the value 0 if the defense is negative.</p>
     */
    
    @Test
    public void testGetWrongDefense()
    {
    	assertEquals(0, wrongShield.getDefense());			
    }
}
