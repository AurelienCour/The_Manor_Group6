package package_Test_Manor;

/**
 * This class defines the tests for Fighter characters. </br>
 * @author Willy Dieuaide
 * @version 22/11/2016
 */

import static org.junit.Assert.*;

import the_Manor.Enemy;
import the_Manor.Player;
import the_Manor.Room;

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
    	myPlayer = new Player("John","description");
    	myEnemy = new Enemy("Zombie", "description",100,60,10,10);
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
     * <p>Check that the right player's defense value is returned.</p>
     * <p>The player's default defense value is assumed to be 10.</p>
     */
	@Test
	public void testGetDefensePlayer() {
		assertEquals(10, myPlayer.getDefense());
	}
	
	/**
     * Method testGetStaminaPlayer
     * <p>Check that the player's stamina right value is returned.</p>
     * <p>The player's default stamina value is assumed to be 100.</p> 
     */
	@Test
	public void testGetStaminaPlayer() {
		assertEquals(100, myPlayer.getStamina());
	}
	
	/**
     * Method testGetHealthPlayer
     * <p>Check that the right player's health value is returned.</p>
     * <p>The player's default health value is assumed to be 100.</p>
     */
	@Test
	public void testGetHealthPlayer() {
		assertEquals(100, myPlayer.getHealth());
	}
	
	/**
     * Method testAddStaminaPlayer
     * <p>Check that the player's stamina can be incremented.</p>
     * <p>The player's default stamina value is assumed to be 100.</p>
     * <p>If the players stamina value goes upper than 100, it is put to 100.</p>     
     */
	@Test
	public void testAddStaminaPlayer() {
		myPlayer.addStamina(5);	
		assertEquals(35, myPlayer.getStamina());
		myPlayer.addStamina(75);
		// The player's stamina value is now upper than 100, so the value is put to 100.
		assertEquals(100, myPlayer.getStamina());
	}
	
	/**
     * Method testRemStaminaPlayer
     * <p>Check that the stamina can be decremented.</p>
     */
	@Test
	public void testRemStaminaPlayer() {
		myPlayer.removeStamina(5);
		//Assuming the default value is 100, losing more than 5 points results is 0, not negative value
		assertEquals(95, myPlayer.getStamina());
	}
	
	/**
     * Method testAddHealthPlayer
     * <p>Check that the player's health value can be incremented.</p>
     * <p>The player's default health value is assumed to be 100.</p>
     * <p>If the players health value goes upper than 100, it is put to 100.</p>
     */
	@Test
	public void testAddHealthPlayer() {
		myPlayer.addHealth(5);
		// The player's health value equals to 105, so it is put to 100.
		assertEquals(100, myPlayer.getHealth());
		myPlayer.removeHealth(20);
		myPlayer.addHealth(5);
		assertEquals(85, myPlayer.getHealth());
	}
	
	/**
     * Method testRemHealthPlayer
     * <p>Check that the player's health can be decremented.</p>
     * <p>The player's default health value is assumed to be 100.</p>
     * <p>If the player's health value goes under 0, the value is put to 0.</p> 
     */
	@Test
	public void testRemHealthPlayer() {
		myPlayer.removeHealth(10);
		assertEquals(90, myPlayer.getHealth());
		// The player's health value equals to -10, so it is put to 0.
		myPlayer.removeHealth(100);
		assertEquals(0, myPlayer.getHealth());
	}
    
	/**
     * Method testAddAttackPlayer
     * <p>Check that player's attack value can be incremented.</p>
     * <p>The player's default attack value is assumed to be 10.</p>
     */
	@Test
	public void testAddAttackPlayer() {		
		this.myPlayer.addAttack(5);
		assertEquals(15, myPlayer.getAttack());
	}
	
	/**
     * Method testRemAttackPlayer
     * <p>Check that player's attack value can be decremented.</p>
     * <p>The player's default attack value is assumed to be 10.</p>
     * <p>If player's attack value goes under 0, the value is put to 0.</p>
     */
	@Test
	public void testRemAttackPlayer() {
		myPlayer.removeAttack(5);
		assertEquals(5, myPlayer.getAttack());
		myPlayer.removeAttack(6);
		// The player's attack value equals to -1, so it is set to 0.
		assertEquals(0, myPlayer.getAttack());
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
     * <p>Check that the defense of the player can be decremented.</p>
     * <p>The player's default defense value is assumed to be 10.</p>
     * <p>If the player's defense value goes under 0, it is put to 0.</p>
     */
	@Test
	public void testRemDefensePlayer() {
		myPlayer.removeDefense(5);		
		assertEquals(5, myPlayer.getDefense());
		myPlayer.removeDefense(6);
		// The player's defense value is now lower than 0, so it is put to 0.
		assertEquals(0, myPlayer.getDefense());
	}
	
    
    
    /////// ENEMY ///////
    
    /**
     * Method testGetAttackEnemy
     * <p>Check that the right enemy's attack value is returned.</p>
     * <p>The enemy's default attack value is assumed to be 5.</p>
     */
	@Test
	public void testGetAttackEnemy() {
		assertEquals(5, myEnemy.getAttack());
	}
	
	/**
     * Method testGetDefenseEnemy
     * <p>Check that the right enemy's defense value is returned.</p>
     * <p>The enemy's default defense value is assumed to be 3.</p>
     */
	@Test
	public void testGetDefenseEnemy() {
		assertEquals(3, myEnemy.getDefense());
	}
	
	/**
     * Method testGetStaminaEnemy
     * <p>Check the right enemy's stamina value is returned.</p>
     * <p>The default enemy's stamina value is assumed to be 60.<p>
     */
	@Test
	public void testGetStaminaEnemy() {
		assertEquals(60, myEnemy.getStamina());
	}
	
	/**
     * Method testGetHealthEnemy
     * <p>Check that the right enemy's health value is returned.</p>
     * <p>The enemy's default health value is assumed to be 100.</p>
     */
	@Test
	public void testGetHealthEnemy() {
		assertEquals(100, myEnemy.getHealth());
	}
	
	/**
     * Method testAddStaminaEnemy
     * <p>Check that the enemy's stamina value can be incremented.</p>
     * <p>Assuming that the enemy's stamina maximal value is 100, when it goes upper, the value is put to 100.</p>
     */
	@Test
	public void testAddStamina() {
		//Assuming the default value for the fighter is 60, adding more than 5 points results is 65
		//The default value for the Player is 100
		// Enemy normal test
		myEnemy.addStamina(10);
		assertEquals(60, myEnemy.getStamina());
		// Enemy over max value test
		myEnemy.addStamina(10);
		assertEquals(60, myEnemy.getStamina());
		// Player normal test
		myPlayer.addStamina(10);
		assertEquals(80, myPlayer.getStamina());
		// Player over max value test
		myPlayer.addStamina(20);
		assertEquals(100, myPlayer.getStamina());
	}
	
	/**
     * Method testRemStaminaEnemy
     * <p>Check that the stamina can be decremented.</p>
     */
	@Test
	public void testRemStaminaEnemy() {
		myEnemy.removeStamina(5);
		//Assuming the default value is 60, losing more than 5 points results is 0, not negative value
		assertEquals(55, myEnemy.getStamina());
	}
	
	/**
     * Method testRemHealthEnemy
     * <p>Check that the health of the enemy can be decremented.</p>
     * <p>The enemy's default health value is assumed to be 100.</p>
     * <p>If the health goes under 0, the enemy dies and should be removed of the room.</p>
     */
	@Test
	public void testRemHealthEnemy() {
		myEnemy.removeHealth(5);
		assertEquals(95, myEnemy.getHealth());
		//Testing when the health of an enemy equals to 0 : the enemy is dead
		Room myRoom = new Room("Cave","image");
		myRoom.addCharacter(myEnemy);
		// There is 1 character in the room with 95 life points
		assertEquals(1, myRoom.numberOfChararacterInRoom());
		myEnemy.removeHealth(105);
		// The player's health value equals to -10, so it is put to 0 and the enemy has to die.		
		if (myEnemy.getHealth() <= 0)
			myRoom.deleteEnemy(myEnemy);
			assertEquals(0, myRoom.numberOfChararacterInRoom());		
	}
}
