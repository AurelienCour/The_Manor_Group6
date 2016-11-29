package the_Manor;

/**
 * <p>This class defines the Fighter characters.</p>
 * <p>A fighter has : </p>
 * <ul>
 * <li> health : integer variable defining the lifepoints. 100 by default</li>
 * <li> stamina : integer variable defining the stamina. 60 by default</li>
 * <li> attack : integer variable. 5 by default</li>
 * <li> defense : integer variable. 3 by default</li>
 * </ul>
 * <p>The fighter can : </p>
 * <ul>
 * <li> Attack with his base attack or with a weapon. Weapon adds attack points </li>
 * <li> Defend with his base attack or with a shield. Shield adds defense points  </li>
 * <li> Die if his health goes bellow 0 </li>
 * <li> Can no longer attack if his stamina reaches 0</li>
 * </ul>
 * @author Willy Dieuaide
 * @version 24/11/2016
 */
public abstract class Fighter extends Character{


	protected int health; // the Fighter's Health
	protected int stamina; // the Fighter's Stamina 
	protected int NBMAXSTAMINA;
	protected int NBMAXPV;
	protected int attack; // the Fighter's Attack
	protected int defense; // the Fighter's Defense
	

	/**
	 * This is the constructor for the Fighter
	 * @param newName the Name of the Fighter
	 * @param description The description of the fighter
	 */
	public Fighter(String newName, String description) {
		super(newName, description);
	}
	
	public int getNbMaxHealth(){
		return this.NBMAXPV;
	}
	
	public int getNbMaxStamina(){
		return this.NBMAXSTAMINA;
	}

	/**
	 * This methods returns the health of the fighter
	 * @return The health of the fighter
	 */
	public int getHealth(){
		return this.health;
	}
	
	/**
	 * This methods returns the stamina of the fighter
	 * @return The stamina of the fighter
	 */
	public int getStamina(){
		return this.stamina;
	}
	
	/**
	 * This methods allows to attack, thus returns the attack power
	 * @return The attack of the fighter
	 */
	public int getAttack(){
		return this.attack;
	}
	
	/**
	 * This methods allows to attack, thus returns the defense power
	 * @return The defense of the fighter
	 */
	public int getDefense(){
		return this.defense;
	}
	
	/**
	 * Allows to add stamina for the fighter
	 * If the addition exceeds the maximum, put the stamina to the maximum
	 * @param nbToAdd The number to add to the stamina of the fighter
	 */
	public void addStamina(int nbToAdd){
		if(this.getNbMaxStamina() < (this.getStamina()+nbToAdd))
			this.setStamina(this.getNbMaxStamina());
		else 
			this.setStamina(this.getStamina()+nbToAdd);
	}
	
	/**
	 * Allows to remove stamina for the fighter
	 * If the subtraction exceeds the minimum, put the stamina to the minimum
	 * @param nbToRemove The number to remove to the stamina of the fighter
	 */
	public void removeStamina (int nbToRemove){
		if((this.getStamina()-nbToRemove) < 0)
			this.setStamina(0);
		else
			this.setStamina(this.getStamina()-nbToRemove);
	}
	
	/**
	 * Allows to add health for the fighter
	 * If the addition exceeds the maximum, put the health to the maximum
	 * @param nbToAdd The number to add to the health of the fighter
	 */
	public void addHealth(int nbToAdd){	
		if(this.getNbMaxHealth() < (this.getHealth()+nbToAdd))
			this.setHealth(this.getNbMaxHealth());
		else 
			this.setHealth(this.getHealth()+nbToAdd);
	}
	
	/**
	 * Allows to decrement the player's health.
	 * If the player's health goes under 0, the value is put to 0 and the player has to die.
	 * @param nbToRemove The number to remove to the health of the fighter
	 */
	public void removeHealth(int nbToRemove){		
		if((this.getHealth()-nbToRemove) < 0)
			this.setHealth(0);
		else
			this.setHealth(this.getHealth()-nbToRemove);
	}
	
	/**
	 * Allows to increment the attack for the fighter
	 * @param nbToAdd The number to add to the attack of the fighter
	 */
	public void addAttack(int nbToAdd)
	{
		this.setAttack(this.getAttack()+nbToAdd);
	}
	
	/**
	 * Allows to set the attack points of the fighter
	 * @param attackPoints The new value of the attack for the fighter
	 */
	private void setAttack(int attackPoints)
	{
		this.attack = attackPoints;
	}

	/**
	 * Allows to set the defense points of the fighter
	 * @param attackPoints The new value of the defense for the fighter
	 */
	private void setDefense(int defensePoints)
	{
		this.defense = defensePoints;
	}	
	
	/**
	 * Allows to remove attack for the fighter
	 * If the subtraction exceeds the minimum, put the attack to 0
	 * @param nbToRemove The number to remove to the attack of the fighter
	 */
	public void removeAttack(int nbToRemove){
		if(this.getAttack()-nbToRemove < 0)
			this.setAttack(0);
		else
			this.setAttack(this.getAttack()-nbToRemove);
	}
	
	/**
	 * Allows to add defense for the fighter
	 * @param nbToAdd The number to add to the defense of the fighter
	 */
	public void addDefense(int nbToAdd){
		this.setDefense(this.getDefense()+nbToAdd);
	}
	
	/**
	 * Allows to remove defense for the fighter
	 * If the subtraction exceeds 0, put the defense to 0
	 * @param nbToRemove The number to remove to the defense of the fighter
	 */
	public void removeDefense(int nbToRemove){
		if(this.getDefense()-nbToRemove < 0)
			this.setDefense(0);
		else
			this.setDefense(this.getDefense()-nbToRemove);
	}
	
	/**
	 * Allow to set the health points of the player
	 * @param healthPoints The number of health points to set
	 * already tested
	 */
	private void setHealth(int healthPoints)
	{
		this.health = healthPoints;
	}
	
	/**
	 * Allow to set player's stamina value.
	 * @param staminaPoints The number of stamina points to set	 
	 */
	private void setStamina(int staminaPoints)
	{
		this.stamina = staminaPoints;
	}	
	
}
