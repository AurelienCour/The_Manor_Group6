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
	 * @param nbMaxPV The number max of the health point
	 * @param nbMaxStamina The number max of the stamina point
	 * @param attack the attack of the enemy
	 * @param defense the defense of the enemy
	 */
	public Enemy(String newName, String description, int nbMaxPV, int nbMaxStamina, int attack, int defense) {
		super(newName, description);
		if (nbMaxPV < 0)
			this.NBMAXPV = 0;
		else
			this.NBMAXPV = nbMaxPV;
		if (nbMaxStamina < 0)
			this.NBMAXSTAMINA = 0;
		else
			this.NBMAXSTAMINA = nbMaxStamina;
		if (attack < 0)
			this.attack = 0;
		else
			this.attack = attack;
		if (defense < 0)
			this.defense = 0;
		else
			this.defense = defense;
		this.health = this.NBMAXPV;
		this.stamina = this.NBMAXSTAMINA;
	}

}
