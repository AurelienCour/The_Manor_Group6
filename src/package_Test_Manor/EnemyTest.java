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
	
	public EnemyTest(){
		
	}
	
    @Before
    public void setUp() throws Exception {
    	this.enemy = new Enemy("Toto");
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }

}
