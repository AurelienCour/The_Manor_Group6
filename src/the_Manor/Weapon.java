package the_Manor;

public class Weapon extends Item {

private int weaponAttack; 
	
	public Weapon (String newAttack) {
		super(newAttack);		
	}
	
	public int getAttack() {
		return weaponAttack;
	}
}
