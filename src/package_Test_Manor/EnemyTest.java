package package_Test_Manor;

import the_Manor.Enemy;
import org.junit.*;

/**
 * The test class EnemyTest.
 * Unit tests of the Enemy class
 * @author Group 6
 *
 */
public class EnemyTest {
	
	/**
	 * Default constructor for test class EnemyTest
	 */
	public EnemyTest(){
		
	}
	
    @Before
    public void setUp() {
    	new Enemy("Toto", "", 0, 0, 0, 0,"");
    }

    @After
    public void tearDown() {
    }

}
