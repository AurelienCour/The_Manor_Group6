package package_Test_Manor;
import junit.framework.TestCase;
import the_Manor.Game;
import the_Manor.Room;
import the_Manor.Key;
import org.junit.*;

/**
 * The test class GameTest
 * @author Group 6
 *
 */
public class GameTest extends TestCase
{
	private Game myGame;
	private Room friendRoom;
	private Room corridor;
	private Key myKey;
	
	/**
	 * Sets up the test fixture
	 */
    @Before
    public void setUp() {     	    	
    	myGame = new Game(null,"The_Manor_Test","It is a great game");
    	friendRoom = new Room("FriendRoom", "");
    	corridor = new Room("Corridor", "");
    	myKey = new Key("The Key");
    }

    @After
    public void tearDown() {
        // Code execute apres chaque test
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
    	friendRoom.addExit("SOUTH", null, corridor);
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
