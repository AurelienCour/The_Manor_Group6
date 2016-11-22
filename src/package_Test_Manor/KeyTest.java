package package_Test_Manor;
import junit.framework.TestCase;
import the_Manor.Key;

import static org.junit.Assert.fail;

import org.junit.*;

public class KeyTest {

	private Key key;
	
	public KeyTest(){
		
	}

    @Before
    public void setUp() throws Exception {
        this.key = new Key("clef");        
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }

}
