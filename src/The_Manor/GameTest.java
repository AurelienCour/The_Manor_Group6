package The_Manor;
import junit.framework.TestCase;
import org.junit.*;

public class GameTest extends TestCase
{
	private Game game1;
	
	@BeforeClass
    public static void setUpClass() throws Exception {
        // Code execution avant l'execution du premier test (et de la methode @Before)        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // Codeexecution apres l'execution de tous les tests
    }

    @Before
    public void setUp() throws Exception {
        // Code execution avant chaque test        
    }

    @After
    public void tearDown() throws Exception {
        // Code execution apres chaque test
    }
    
    @Test
    public void testConstructor() {
       this.game1 = new Game();
    }
    
    
    @Test
    public void testCalculer() throws Exception {

        assertEquals(2,Game.calculer(1,1));
      }
}
