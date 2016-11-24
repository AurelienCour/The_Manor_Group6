package package_Test_Manor;

/**
 * This class defines the tests for Fighter characters. </br>
 * @author Willy Dieuaide
 * @version 22/11/2016
 */

import static org.junit.Assert.*;

import the_Manor.Enemy;
import the_Manor.Player;

import org.junit.*;

/**
 * The test class FighterTest
 * @author Willy Dieuaide
 * @version 24/11/2016
 */
public class FighterTest {
	
	private Player myPlayer;
	private Enemy myEnemy;
	
	
	/**
	 * Default constructor for test class FighterTest
	 */
	public FighterTest()
	{
	}
	
    @Before
    public void setUp() {
    	myPlayer = new Player("John","description",null);
    	myEnemy = new Enemy("Zombie", "description");
    }

    @After
    public void tearDown() {
        // Code execute apres chaque test
    }   
    
    
    
    //////// PLAYER ///////
    
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
		myPlayer.removeStamina(5);
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
     * <p>Check that the health can be decremented.</p>
     */
	@Test
	public void testRemHealthPlayer() {
		myPlayer.removeHealth(5);
		//Assuming the default value is 15, losing more than 15 points results is 0, not negative value
		assertEquals(10, myPlayer.getHealth());
	}
    
	/**
     * Method testAddAttackPlayer
     * <p>Check that the attack can be incremented.</p>
     */
	@Test
	public void testAddAttackPlayer() {
		//Assuming the default value is 15, adding more than 5 points results is 20, not superior value
		this.myPlayer.modifyAttack(5);
		assertEquals(15, myPlayer.getAttack());
	}
	
	/**
     * Method testRemHealthPlayer
     * <p>Check that the health can be decremented.</p>
     */
	@Test
	public void testRemAttackPlayer() {
		myPlayer.removeAttack(5);
		//Assuming the default value is 15, losing more than 15 points results is 0, not negative value
		assertEquals(10, myPlayer.getAttack());
	}
    
	/**
     * Method testAddDefensePlayer
     * <p>Check that the defense can be incremented.</p>
     */
	@Test
	public void testAddDefensePlayer() {
		myPlayer.addDefense(5);
		//Assuming the default value is 15, adding more than 5 points results is 20, not superior value
		assertEquals(15, myPlayer.getDefense());
	}
	
	/**
     * Method testRemDefensePlayer
     * <p>Check that the defense is initialized to 10.</p>
     */
	@Test
	public void testRemDefensePlayer() {
		myPlayer.removeDefense(5);
		//Assuming the default value is 15, losing more than 15 points results is 0, not negative value
		assertEquals(10, myPlayer.getDefense());
	}
	
    
    
    /////// ENEMY ///////
    
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
     * <p>Check that the stamina can be incremented.</p>
     */
	@Test
	public void testAddStaminaEnemy() {
		myEnemy.addStamina(5);
		//Assuming the default value is 5, adding more than 5 points results is 10
		assertEquals(10, myEnemy.getStamina());
	}
	
	/**
     * Method testRemStaminaEnemy
     * <p>Check that the stamina can be decremented.</p>
     */
	@Test
	public void testRemStaminaEnemy() {
		myEnemy.removeStamina(5);
		//Assuming the default value is 5, losing more than 5 points results is 0, not negative value
		assertEquals(5, myEnemy.getStamina());
	}
	
	/**
     * Method testRemHealthEnemy
     * <p>Check that the defense can be decremented.</p>
     */
	@Test
	public void testRemHealthEnemy() {
		myEnemy.removeHealth(5);
		//Assuming the default value is 15, losing more than 15 points results is 0, not negative value
		assertEquals(10, myEnemy.getHealth());
	}
}
