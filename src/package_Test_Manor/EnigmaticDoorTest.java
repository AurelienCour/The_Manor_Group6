package package_Test_Manor;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import the_Manor.EnigmaticDoor;
import the_Manor.Room;
import org.junit.Test;

public class EnigmaticDoorTest {
	
	private EnigmaticDoor door;
	private Room room;
	
	public EnigmaticDoorTest(){
	}
	
    @Before
    public void setUp() throws Exception {
    	room = new Room("");
        door = new EnigmaticDoor("","",room);      
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }
    
    @Test
    public void testResolveEnigma(){
    	this.door.solveEnigma("");
    	assertEquals(false,this.door.isLocked());
    }
    
    @Test
    public void testResolveEnigmaBad(){
    	this.door.solveEnigma("No");
    	assertEquals(true,this.door.isLocked());
    }
    
    @Test
    public void testGoNextRoomIfResolve(){
    	this.door.solveEnigma("");
    	assertEquals(room,this.door.goNextRoom());
    }
    
    @Test
    public void testGoNextRoomIfNotResolve(){
    	this.door.solveEnigma("No");
    	assertEquals(null,this.door.goNextRoom());
    }
    

}
