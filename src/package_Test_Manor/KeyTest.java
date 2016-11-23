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
	
	@BeforeClass
    public static void setUpClass() throws Exception {
        // Code execute avant l'execution du premier test (et de la methode @Before)        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // Code execute apres l'execution de tous les tests
    }
	/**
	 * Sets up the test fixture
	 * @throws Exception
	 */
    @Before
    public void setUp() throws Exception {
        this.key = new Key("clef");        
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }

}
