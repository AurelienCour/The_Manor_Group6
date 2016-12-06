package package_Test_Manor;
import junit.framework.TestCase;
import package_Display.Window;
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
    	myGame = new Game(new Window("", ""),"The_Manor_Test","It is a great game");
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
         * testMoveEnigmaticDoorWithGoodResponse()
         * <p>Checks if the player moved in the right direction when he is crossing an enigmatic door with the good answer.</p>
         */
        @Test
        public void testMoveEnigmaticDoorWithGoodResponse() {
        	// the player's current room is the friendRoom
        	myGame.getPlayer().setCurrentRoom(friendRoom);
        	// there is an enigmatic south exit in this friedRoom
        	friendRoom.addEnigmaticExit("SOUTH", "What is the color of the Henri IV's white horse?", "white", corridor);
        	
        	myGame.verifyResponseForEnigma("white", "SOUTH");
        	// the player moves via this exit
        	myGame.move("SOUTH");
        	// the player is in the nextRoom = the corridor
        	assertEquals(corridor, myGame.getPlayer().getCurrentRoom());
        }
        
        /**
         * testMoveEnigmaticDoorWithBadResponse()
         * <p>Checks if the player moved in the right direction when he is crossing an enigmatic door with the bad answer.</p>
         */
        @Test
        public void testMoveEnigmaticDoorWithBadResponse() {
        	// the player's current room is the friendRoom
        	myGame.getPlayer().setCurrentRoom(friendRoom);
        	// there is an enigmatic south exit in this friedRoom
        	friendRoom.addEnigmaticExit("SOUTH", "What is the color of the Henri IV's white horse?", "white", corridor);
        	// Resolve the enigma
        	myGame.verifyResponseForEnigma("red", "SOUTH");
        	// the player moves via this exit
        	myGame.move("SOUTH");
        	// the player is in the nextRoom = the corridor
        	assertEquals(friendRoom, myGame.getPlayer().getCurrentRoom());
        }
        
        /**
         * testMoveLockedDoor()
         * Check if the player can crossing a locked door with the good key
         */
        @Test
        public void testMoveLockedDoor() {
        	// the player's current room is the friendRoom
        	myGame.getPlayer().setCurrentRoom(friendRoom);
        	// there is an enigmatic south exit in this friedRoom
        	friendRoom.addExit("SOUTH",myKey, corridor);
        	// Add the key to the player
        	myGame.getPlayer().pickUp(myKey);
        	// Unlock the door
        	myGame.lockMove("SOUTH");
        	// the player moves via this exit
        	myGame.move("SOUTH");
        	// the player is in the nextRoom = the corridor
        	assertEquals(corridor, myGame.getPlayer().getCurrentRoom());
        }
        
        /**
         * testMoveLockedDoorBad()
         * Check if the player can crossing a locked door with the wrong key
         */
        @Test
        public void testMoveLockedDoorBad() {
        	// the player's current room is the friendRoom
        	myGame.getPlayer().setCurrentRoom(friendRoom);
        	// there is an enigmatic south exit in this friedRoom
        	friendRoom.addExit("SOUTH",myKey, corridor);
        	// Add the key to the player
        	myGame.getPlayer().pickUp(new Key("testBad"));
        	// Unlock the door
        	myGame.lockMove("SOUTH");
        	// the player moves via this exit
        	myGame.move("SOUTH");
        	// the player is in the nextRoom = the corridor
        	assertEquals(friendRoom, myGame.getPlayer().getCurrentRoom());
        }
        
        /**
         * Check the methods search, to search an item in a room
         */
        @Test
        public void testSearch(){
        	Key keyTest = new Key("testSearch");
        	// Add the Item in the room
        	friendRoom.addItem(keyTest);
        	// The player's current room is the friendRoom
        	myGame.getPlayer().setCurrentRoom(friendRoom);
        	// Search in the room and verify the name of the item
        	assertEquals("testSearch",myGame.search());
        	assertEquals(1,myGame.getPlayer().numberOfItem());
        	assertEquals(0,friendRoom.numberOfItemInRoom());
        	assertEquals(true,myGame.getPlayer().haveKey(keyTest));
        }
}
