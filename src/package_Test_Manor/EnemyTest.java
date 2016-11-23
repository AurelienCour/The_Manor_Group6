package package_Test_Manor;

import static org.junit.Assert.*;
import the_Manor.Enemy;
import org.junit.*;

/**
 * The test class EnemyTest.
 * Unit tests of the Enemy class
 * @author Aurelien
 *
 */
public class EnemyTest {
	
	private Enemy enemy;
	
	/**
	 * Default constructor for test class EnemyTest
	 */
	public EnemyTest(){
		
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
    	this.enemy = new Enemy("Toto");
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }

}
