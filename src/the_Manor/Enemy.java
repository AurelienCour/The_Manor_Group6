package the_Manor;
/**
 * <p>This class represents all the characters who are enemies of the main character.</p>
 * <p>For the moment, this class does not contain methods, it is just representative</p>
 * 
 * @author Willy Dieuaide
 * @version 2016-22-11
 */
public class Enemy extends Fighter{

	/**
	 * The constructor for the Enemy class
	 * @param newName The name of the enemy
	 * @param description The description of the enemy
	 */
	public Enemy(String newName, String description, int nbMaxPV, int nbMaxStamina, int attack, int defense) {
		super(newName, description);
		this.NBMAXPV = nbMaxPV;
		this.NBMAXSTAMINA = nbMaxStamina;
		this.attack = attack;
		this.defense = defense;
		this.health = this.NBMAXPV;
		this.stamina = this.NBMAXSTAMINA;
	}

}
