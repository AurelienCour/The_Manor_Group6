package package_Test_Manor;
import junit.framework.TestCase;
import the_Manor.Door;
import the_Manor.Game;
import the_Manor.Player;
import the_Manor.Room;
import the_Manor.Character;

import org.junit.*;

import com.sun.glass.ui.Window;

/**
 * The test class GameTest
 * @author Group 6
 *
 */
public class GameTest extends TestCase
{
	private Game myGame;
	private Window myWindow;
	private Player myPlayer;
	private Character myCharacter;
	private Room friendRoom;
	private Room corridor;
	
	/**
	 * Sets up the test fixture
	 */
    @Before
    public void setUp() {     	    	
    	myGame = new Game(null,"The_Manor_Test","It is a great game");
    	myPlayer = new Player("John", "John is a man");
    	friendRoom = new Room("FriendRoom", null);
    	corridor = new Room("Corridor", null);
    }

    @After
    public void tearDown() {
        // Code execute apres chaque test
    }
    /**
     * 
     * Methods testConstructor
     * <p>This methods allows to verify if the game is created</p> 
     */	
    @Test
    public void testConstructor() {    	
    	assertEquals(myPlayer, myGame.getPlayer());
    }
    
    /**
     * testMoveStandardDoor()
     * <p>Checks if the player moved in the right direction when he is crossing a standard door.</p>
     */
    @Test
    public void testMoveStandardDoor() {
    	// the player's current room is the friendRoom
    	myGame.getPlayer().setCurrentRoom(friendRoom);
    	// there is a south exit in this friedRoom
    	friendRoom.addExit("SOUTH", false, corridor);
    	// the player moves via this exit
    	myGame.move("SOUTH");
    	// the player is in the nextRoom = the corridor
    	assertEquals(corridor, myGame.getPlayer().getCurrentRoom());
    }
    	
        /**
         * testMoveEnigmaticDoor()
         * <p>Checks if the player moved in the right direction when he is crossing an enigmatic door.</p>
         */
        @Test
        public void testMoveEnigmaticDoor() {
        	// the player's current room is the friendRoom
        	myGame.getPlayer().setCurrentRoom(friendRoom);
        	// there is an enigmatic south exit in this friedRoom
        	friendRoom.addEnigmaticExit("SOUTH", "What is the color of the Henri IV's white horse?", "white", corridor);
        	// the player moves via this exit
        	myGame.move("SOUTH");
        	// the player is in the nextRoom = the corridor
        	assertEquals(corridor, myGame.getPlayer().getCurrentRoom());
        }
}
