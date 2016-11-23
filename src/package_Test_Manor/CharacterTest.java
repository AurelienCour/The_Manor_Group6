package package_Test_Manor;

import static org.junit.Assert.*;

import the_Manor.Ally;
import the_Manor.Character;
import the_Manor.Enemy;
import the_Manor.Player;

import org.junit.*;

/**
 * The test class CharacterTest
 * Unit tests of the Character class
 * @author Aurelien
 *
 */
public class CharacterTest {
	
	private Ally ally;
	private Enemy enemy;
	private Player player;
	
	/**
	 * Default constructor for test class CharacterTest
	 */
	public CharacterTest()
	{
		
	}
	
	@BeforeClass
    public static void setUpClass() throws Exception {
        // Code execute avant l'execution du premier test (et de la methode @Before)        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // Code execute apres l'execution de tous les tests
    }

    @Before
    public void setUp(){
        ally = new Ally(null, null);
        enemy = new Enemy(null);
        player = new Player(null, null);
    }

    @After
    public void tearDown(){
    }
    
    /**
     * Method testCharacterName
     * <p>Checks if the name given as parameter in the constructor is correctly set to the attribute</p>
     */
	@Test
	public void testCharacterName() {
		
	}

	/**
	 * Method testJohnDefaultName
	 * <p>Check that the default name is "John", if the given name is empty</p>
	 */
	@Test
	public void testJohnDefaultName(){
		
	}
	
	/**
	 * Method testJohnDefaultName
	 * <p>Check that the default name is "John", if the given name is empty</p>
	 */
	@Test
	public void testDescription(){
		
	}
}
