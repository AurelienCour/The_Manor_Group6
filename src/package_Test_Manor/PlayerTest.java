package package_Test_Manor;

import static org.junit.Assert.*;

import the_Manor.Player;
import the_Manor.Character;
import org.junit.*;

public class PlayerTest {
	private Player p;
	
	
	public PlayerTest()
	{
	}
	
	@BeforeClass
    public static void setUpClass() throws Exception {
        // Code execute avant        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // Code 
    }

    @Before
    public void setUp() throws Exception {
        // Code execute avant chaque test   
    	p = new Player("John");
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }
    
	@Test
	/**
	 * This test allows to see if the beginning life points are really 10
	 */
	public void testPlayerLife() {
		assertEquals(10, p.getHealth());
		//test commit
	}


}
