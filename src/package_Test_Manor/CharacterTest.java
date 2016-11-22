package package_Test_Manor;

import static org.junit.Assert.*;
import the_Manor.Character;
import org.junit.*;


public class CharacterTest {
	private Character myCharacter;
	
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
        // Code execute après l'exécution de tous les tests
    }

    @Before
    public void setUp(){
        myCharacter = new Character("John");
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
		assertEquals("John", myCharacter.getName());
	}

	/**
	 * Method testJohnDefaultName
	 * <p>Check that the default name is "John", if the given name is empty</p>
	 */
	@Test
	public void testJohnDefaultName(){
		Character emptyName = new Character("");
		//Assuming that a empty name results in giving "John" as a default name for a player
		assertEquals("John", emptyName.getName());
	}
	
	/**
	 * Method testJohnDefaultName
	 * <p>Check that the default name is "John", if the given name is empty</p>
	 */
	@Test
	public void testDescription(){
		assertEquals("This is a description", myCharacter.getDescription());
		//test
	}
}
