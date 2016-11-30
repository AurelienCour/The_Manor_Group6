package package_Test_Manor;
import junit.framework.TestCase;
import the_Manor.Key;

import static org.junit.Assert.fail;

import org.junit.*;

/**
 * The test class KeyTest
 * @author Group 6
 *
 */
public class KeyTest {

	private Key key;
	
	public KeyTest(){
		
	}
	
	/**
	 * Sets up the test fixture
	 */
    @Before
    public void setUp() {
        this.key = new Key("key");        
    }

    @After
    public void tearDown() {
        
    }

}
