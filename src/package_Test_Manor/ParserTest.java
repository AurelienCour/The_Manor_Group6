package package_Test_Manor;
import junit.framework.TestCase;
import the_Manor.Game;
import the_Manor.Parser;

import static org.junit.Assert.fail;

import org.junit.*;

public class ParserTest {
	
	private Parser parser1;
	private String command;
	
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
    	this.parser1 = new Parser(command);       
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }
    
    @Test
    public void testConstructor() {
       Parser parser2 = new Parser(command);
    }    
    
    @Test
    public void testGetCommand() {
       this.parser1.getCommand();
    } 
    
}
