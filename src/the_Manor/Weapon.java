package the_Manor;
package 

public class Weapon extends Item {

private int weaponAttack; 
	
	public Weapon (int newAttack) {
		super(newAttack);		
	}
	
	public int getAttack() {
		return weaponAttack;
	}
}
