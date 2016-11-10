package package_Test_Manor;
import junit.framework.TestCase;
import the_Manor.Game;
import org.junit.*;

public class GameTest extends TestCase
{
	private Game game1;
	
	@BeforeClass
    public static void setUpClass() throws Exception {
        // Code execute avant l'exécution du premier test (et de la méthode @Before)        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // Code execute après l'exécution de tous les tests
    }

    @Before
    public void setUp() throws Exception {
    	this.game1 = new Game();      
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }
    
    @Test
    public void testConstructor() {
       Game game2 = new Game();
    }
    
    @Test
    public void testPlay() {
       this.game1.play();
    }    

}