package package_Test_Manor;
import junit.framework.TestCase;
import the_Manor.Game;
import org.junit.*;

/**
 * The test class GameTest
 * @author Aurelien
 *
 */
public class GameTest extends TestCase
{
	private Game game1;
	
    /**
	 * Sets up the test fixture
	 */
    @Before
    public void setUp() {
    	this.game1 = new Game();      
    }

    @After
    public void tearDown() {
        // Code execute apres chaque test
    }
    /**
     * 
     * Methods testConstructor
     * <p>This methods allows to verify if the game is created</p> 
     */
    @Test
    public void testConstructor() {
       Game game2 = new Game();
    }
    /**
     * Methods testPlay
     * <p>This methods allows to verify if the game is launched</p>
     */
    @Test
    public void testPlay() {
       this.game1.play();
    }    

}
