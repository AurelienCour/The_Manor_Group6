package package_Test_Manor;
import junit.framework.TestCase;
import the_Manor.Key;

import static org.junit.Assert.fail;

import org.junit.*;

/**
 * The test class KeyTest
 * @author Aurelien
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
        this.key = new Key("clef");        
    }

    @After
    public void tearDown() {
        // Code execute apres chaque test
    }

}
