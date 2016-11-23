package package_Test_Manor;

import static org.junit.Assert.*;
import the_Manor.Enemy;
import org.junit.*;

/**
 * The test class EnemyTest.
 * Unit tests of the Enemy class
 * @author Aurelien
 *
 */
public class EnemyTest {
	
	private Enemy enemy;
	
	/**
	 * Default constructor for test class EnemyTest
	 */
	public EnemyTest(){
		
	}
	
    @Before
    public void setUp() {
    	this.enemy = new Enemy("Toto", "");
    }

    @After
    public void tearDown() {
    }

}
