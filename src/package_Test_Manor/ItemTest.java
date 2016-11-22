package package_Test_Manor;
import junit.framework.TestCase;
import the_Manor.Item;
import the_Manor.Key;
import the_Manor.Potion;
import the_Manor.Shield;
import the_Manor.Weapon;

import static org.junit.Assert.*;

import org.junit.*;

public class ItemTest {
	
	private Shield shield;
	private Weapon weapon;
	private Potion potion;
	private Key key;

	public ItemTest(){
		
	}
	
    @Before
    public void setUp() throws Exception {
        this.shield = new Shield("bouclier",15);
        this.weapon = new Weapon("epee",10);
        this.potion = new Potion("potion",40);
        this.key = new Key("clef");
    }

    @After
    public void tearDown() throws Exception {
        // Code execute apres chaque testf
    }
    
    @Test
    public void testGetNameShield(){
    	assertEquals("bouclier",this.shield.getName());
    }
    
    @Test
    public void testGetNameWeapon(){
    	assertEquals("epee",this.weapon.getName());
    }
    
    @Test
    public void testGetNamePotion(){
    	assertEquals("potion",this.potion.getName());
    }
    
    @Test
    public void testGetNameKey(){
    	assertEquals("clef",this.key.getName());
    }
}
