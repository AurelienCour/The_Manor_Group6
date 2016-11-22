package package_Test_Manor;

import static org.junit.Assert.*;

import the_Manor.Character;
import the_Manor.Enemy;
import the_Manor.Fighter;
import the_Manor.Player;

import org.junit.*;

public class FighterTest {
	
	private Player myPlayer;
	private Enemy myEnemy;
	
	
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
    	myPlayer = new Player("John",null);
    	myEnemy = new Enemy("Zombie");
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }   
    
    
    
    /**
     * Method testGetAttackPlayer
     * <p>Check that the attack is initialized to 10.</p>
     */
	@Test
	public void testGetAttackPlayer() {
		assertEquals(10, myPlayer.getAttack());
	}
	
	/**
     * Method testGetDefensePlayer
     * <p>Check that the defense is initialized to 10.</p>
     */
	@Test
	public void testGetDefensePlayer() {
		assertEquals(10, myPlayer.getDefense());
	}
	
	/**
     * Method testGetStaminaPlayer
     * <p>Check that the stamina is initialized to 10.</p>
     */
	@Test
	public void testGetStaminaPlayer() {
		assertEquals(10, myPlayer.getStamina());
	}
	
	/**
     * Method testGetHealthPlayer
     * <p>Check that the health is initialized to 10.</p>
     */
	@Test
	public void testGetHealthPlayer() {
		assertEquals(10, myPlayer.getHealth());
	}
	
	/**
     * Method testAddStaminaPlayer
     * <p>Check that the stamina can be incremented.</p>
     */
	@Test
	public void testAddStaminaPlayer() {
		myPlayer.addStamina(5);
		//Assuming the default value is 5, adding more than 5 points results is 10
		assertEquals(10, myPlayer.getStamina());
	}
	
	/**
     * Method testRemStaminaPlayer
     * <p>Check that the stamina can be decremented.</p>
     */
	@Test
	public void testRemStaminaPlayer() {
		myPlayer.remStamina(5);
		//Assuming the default value is 5, losing more than 5 points results is 0, not negative value
		assertEquals(5, myPlayer.getStamina());
	}
	
	/**
     * Method testAddHealthPlayer
     * <p>Check that the health can be incremented.</p>
     */
	@Test
	public void testAddHealthPlayer() {
		myPlayer.addHealth(5);
		//Assuming the default value is 15, adding more than 5 points results is 20, not superior value
		assertEquals(10, myPlayer.getHealth());
	}
	
	/**
     * Method testRemHealthPlayer
     * <p>Check that the health is initialized to 10.</p>
     */
	@Test
	public void testRemHealthPlayer() {
		myPlayer.remHealth(5);
		//Assuming the default value is 15, losing more than 15 points results is 0, not negative value
		assertEquals(10, myPlayer.getHealth());
	}
    
	/**
     * Method testAddAttackPlayer
     * <p>Check that the attack can be incremented.</p>
     */
	@Test
	public void testAddAttackPlayer() {
		myPlayer.addAttack(5);
		//Assuming the default value is 15, adding more than 5 points results is 20, not superior value
		assertEquals(10, myPlayer.getAttack());
	}
	
	/**
     * Method testRemHealthPlayer
     * <p>Check that the health is initialized to 10.</p>
     */
	@Test
	public void testRemAttackPlayer() {
		myPlayer.remAttack(5);
		//Assuming the default value is 15, losing more than 15 points results is 0, not negative value
		assertEquals(10, myPlayer.getAttack());
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Method testGetAttackEnemy
     * <p>Check that the attack is initialized to 10.</p>
     */
	@Test
	public void testGetAttackEnemy() {
		assertEquals(10, myEnemy.getAttack());
	}
	
	/**
     * Method testGetDefenseEnemy
     * <p>Check that the defense is initialized to 10.</p>
     */
	@Test
	public void testGetDefenseEnemy() {
		assertEquals(10, myEnemy.getDefense());
	}
	
	/**
     * Method testGetStaminaEnemy
     * <p>Check that the stamina is initialized to 10.</p>
     */
	@Test
	public void testGetStaminaEnemy() {
		assertEquals(10, myEnemy.getStamina());
	}
	
	/**
     * Method testGetHealthEnemy
     * <p>Check that the health is initialized to 10.</p>
     */
	@Test
	public void testGetHealthEnemy() {
		assertEquals(10, myEnemy.getHealth());
	}
	
	/**
     * Method testAddStaminaEnemy
     * <p>Check that the stamina is initialized to 10.</p>
     */
	@Test
	public void testAddStaminaEnemy() {
		myEnemy.addStamina(5);
		//Assuming the default value is 5, adding more than 5 points results is 10
		assertEquals(10, myEnemy.getStamina());
	}
	
	/**
     * Method testRemStaminaEnemy
     * <p>Check that the stamina is initialized to 10.</p>
     */
	@Test
	public void testRemStaminaEnemy() {
		myEnemy.remStamina(5);
		//Assuming the default value is 5, losing more than 5 points results is 0, not negative value
		assertEquals(5, myEnemy.getStamina());
	}
	
	/**
     * Method testSetHealthEnemy
     * <p>Check that the health is initialized to 10.</p>
     */
	@Test
	public void testRemHealthEnemy() {
		myEnemy.remHealth(5);
		//Assuming the default value is 15, losing more than 15 points results is 0, not negative value
		assertEquals(10, myEnemy.getHealth());
	}
}
