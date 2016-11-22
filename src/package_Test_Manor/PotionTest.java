package package_Test_Manor;
import junit.framework.TestCase;
import the_Manor.Potion;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * 
 * @author Aurelien
 */
public class PotionTest {

	private Potion potion;
	
	public PotionTest(){
		
	}
	
	@Before
    public void setUp() throws Exception {
        potion = new Potion("potion",15);
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque test
    }
    
    /**
     * This method allows to know if the method getHealth is functional
     */
    @Test
	public void testGetHealth() {
		assertEquals(15,this.potion.getHealth());
	}
}
