package package_Test_Manor;
import junit.framework.TestCase;
import the_Manor.CommandWords;
import the_Manor.Parser;

import static org.junit.Assert.fail;
import org.junit.*;

public class CommandWordsTest {
	
	private CommandWords commandWords1;
	private Boolean validCommand;
	
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
    	this.commandWords1 = new CommandWords(validCommand);       
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }
    
    @Test
    public void testConstructor() {
       CommandWords commandWords2 = new CommandWords(validCommand);
    }  
        
}
