package package_Test_Manor;
import junit.framework.TestCase;
import the_Manor.Item;

import org.junit.*;

public class ItemTest {
	
	private Item item1;
	private String name;
	
	
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
        this.item1 = new Item(name);       
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }
    
    @Test
    public void testConstructor() {
    	Item item2 = new Item(name);
    }
    
    @Test
    public void testSetName() {
    	this.item1.setName();
    }
    
    @Test
    public void testGetName() {
    	this.item1.getName();
    }

}
