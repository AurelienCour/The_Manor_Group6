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
	
	private Character ally;
	private Character enemy;
	private Character player;
	
	/**
	 * Default constructor for test class CharacterTest
	 */
	public CharacterTest()
	{
	}

    @Before
    public void setUp(){
    	ally = new Ally("MyAlly","Description Ally",null);
    	enemy = new Enemy("MyEnemy","Description Enemy");
    	player = new Player("MyPlayer","Description Player",null);
    }

    @After
    public void tearDown(){
    }
    
    /**
     * Method testCharacterNameAlly
     * <p>Checks if the name given as parameter in the constructor is correctly set to the attribute</p>
     */
	@Test
	public void testCharacterNameAlly() {
		assertEquals("MyAlly",ally.getName());
	}
	
	/**
     * Method testCharacterNameEnemy
     * <p>Checks if the name given as parameter in the constructor is correctly set to the attribute</p>
     */
	@Test
	public void testCharacterNameEnemy() {
		assertEquals("MyEnemy",enemy.getName());
	}
	
	/**
     * Method testCharacterNamePlayer
     * <p>Checks if the name given as parameter in the constructor is correctly set to the attribute</p>
     */
	@Test
	public void testCharacterNamePlayer() {
		assertEquals("MyPlayer",player.getName());
	}
	
	/**
     * Method testCharacterNameAllyDefault
     * <p>Cheks the default name for an ally</p>
     */
	@Test
	public void testCharacterNameAllyDefault() {
		Character allyTest = new Ally("", "", null);
		assertEquals("Ally",allyTest.getName());
		Character allyTest2 = new Ally(null, "", null);
		assertEquals("Ally",allyTest2.getName());
	}
	
	/**
     * Method testCharacterNameEnemyDefault
     * <p>Cheks the default name for an enemy</p>
     */
	@Test
	public void testCharacterNameEnemyDefault() {
		Character enemyTest = new Enemy("", "");
		assertEquals("Enemy",enemyTest.getName());
		Character enemyTest2 = new Enemy(null, "");
		assertEquals("Enemy",enemyTest2.getName());
	}
	
	/**
     * Method testCharacterNamePlayerDefault
     * <p>Cheks the default name for a player</p>
     */
	@Test
	public void testCharacterNamePlayerDefault() {
		Character playerTest = new Player("", "",null);
		assertEquals("Player",playerTest.getName());
		Character playerTest2 = new Player(null, "",null);
		assertEquals("Player",playerTest2.getName());
	}
	
	/**
     * Method testCharacterDescriptionAlly
     * <p>Checks if the description given as parameter in the constructor is correctly set to the attribute</p>
     */
	@Test
	public void testCharacterDescriptionAlly() {
		assertEquals("Description Ally",ally.getDescription());
	}
	
	/**
     * Method testCharacterDescriptionEnemy
     * <p>Checks if the description given as parameter in the constructor is correctly set to the attribute</p>
     */
	@Test
	public void testCharacterDescriptionEnemy() {
		assertEquals("Description Enemy",enemy.getDescription());
	}
	
	/**
     * Method testCharacterDescriptionPlayer
     * <p>Checks if the description given as parameter in the constructor is correctly set to the attribute</p>
     */
	@Test
	public void testCharacterDescriptionPlayer() {
		assertEquals("Description Player",player.getDescription());
	}
	
	/**
     * Method testCharacterDescriptionAllyDefault
     * <p>Cheks the default description for an ally</p>
     */
	@Test
	public void testCharacterDescriptionAllyDefault() {
		Character allyTest = new Ally("MyAlly", "", null);
		assertEquals("No description",allyTest.getDescription());
		Character allyTest2 = new Ally("MyAlly", null, null);
		assertEquals("No description",allyTest2.getDescription());
	}
	
	/**
     * Method testCharacterDescriptionEnemyDefault
     * <p>Cheks the default description for an enemy</p>
     */
	@Test
	public void testCharacterDescriptionEnemyDefault() {
		Character enemyTest = new Enemy("MyEnemy", "");
		assertEquals("No description",enemyTest.getDescription());
		Character enemyTest2 = new Enemy("MyEnemy", null);
		assertEquals("No description",enemyTest2.getDescription());
	}
	
	/**
     * Method testCharacterDescriptionPlayerDefault
     * <p>Cheks the default description for a player</p>
     */
	@Test
	public void testCharacterDescriptionPlayerDefault() {
		Character playerTest = new Player("MyPlayer", "", null);
		assertEquals("No description",playerTest.getDescription());
		Character playerTest2 = new Player("MyPlayer", null, null);
		assertEquals("No description",playerTest2.getDescription());
	}
}
