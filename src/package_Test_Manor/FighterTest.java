package package_Test_Manor;

import static org.junit.Assert.*;

import the_Manor.Character;
import the_Manor.Fighter;
import org.junit.*;

public class FighterTest {
	
	private Fighter myFighter;
	private Ennemy myEnnemy;
	



	
	/**
	 * Default constructor for test class CharacterTest
	 */
	public FighterTest()
	{
	}
	
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
    	myEnnemy = new Ennemy();
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }
    
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
