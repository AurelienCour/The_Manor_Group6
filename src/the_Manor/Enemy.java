package the_Manor;
/**
 * <p>This class represents all the characters who are enemies of the main character.</p>
 * 
 * @author Group 6
 * @version 05/12/16
 */
public class Enemy extends Fighter{

	private String image; // The image of the enemy
	
	
	/**
	 * The constructor for the Enemy class
	 * If the different parameters are null or under zero, a default value is settled.
	 * @param newName The name of the enemy
	 * @param description The description of the enemy
	 * @param nbMaxPV The enemy's max health points value
	 * @param nbMaxStamina The enemy's max stamina points value
	 * @param attack The enemy's max attack value
	 * @param defense The enemy's max defense value
	 * @param image The image of the enemy
	 */
	public Enemy(String newName, String description, int nbMaxPV, int nbMaxStamina, int attack, int defense, String image) {
		super(newName, description); // Uses the Fighter super-class
		if (nbMaxPV < 0)
			this.NBMAXPV = 0; // default value
		else
			this.NBMAXPV = nbMaxPV;
		if (nbMaxStamina < 0)
			this.NBMAXSTAMINA = 0;
		else
			this.NBMAXSTAMINA = nbMaxStamina;
		if (attack < 0)
			this.setAttack(0);
		else
			this.setAttack(attack);
		if (defense < 0)
			this.setDefense(0);
		else
			this.setDefense(defense);
		if(image == null || image.isEmpty())
			this.image="Robert.png"; // default image
		else
			this.image=image;
		this.setHealth(this.NBMAXPV);
		this.setStamina(this.NBMAXSTAMINA);
	}
	
	/**
	 * Allows to get the image of the enemy.
	 * @return The image of the enemy.
	 */
	public String getImage(){
		return this.image;
	}

}
