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
protected int attack; // the Fighter's Attack
protected int defense; // the Fighter's Defense
	

	/**
	 * This is the constructor for the Fighter
	 * @param newName the Name of the Fighter
	 * @param description The description of the fighter
	 */
	public Fighter(String newName, String description) {
		super(newName, description);
		this.attack = 5;
		this.defense = 3;
		this.health = 100;
		this.stamina = 60;
	}

	/**
	 * This methods returns the health of the fighter
	 * @return The health of the fighter
	 */
	public int getHealth(){
		return health;
	}
	
	/**
	 * This methods returns the stamina of the fighter
	 * @return The stamina of the fighter
	 */
	public int getStamina(){
		return stamina;
	}
	
	/**
	 * This methods allows to attack, thus returns the attack power
	 * @return The attack of the fighter
	 */
	public int getAttack(){
		return attack;
	}
	
	/**
	 * This methods allows to attack, thus returns the defense power
	 * @return The defense of the fighter
	 */
	public int getDefense(){
		return defense;
	}
	
	/**
	 * Allows to add stamina for the fighter
	 * If the addition exceeds the maximum, put the stamina to the maximum
	 * @param nbToAdd The number to add to the stamina of the fighter
	 */
	public void addStamina(int nbToAdd){
		this.stamina += nbToAdd;
	}
	
	/**
	 * Allows to remove stamina for the fighter
	 * If the subtraction exceeds the minimum, put the stamina to the minimum
	 * @param nbToRemove The number to remove to the stamina of the fighter
	 */
	public void removeStamina (int nbToRemove){
		this.stamina -= nbToRemove;
	}
	
	/**
	 * Allows to add health for the fighter
	 * If the addition exceeds the maximum, put the health to the maximum
	 * @param nbToAdd The number to add to the health of the fighter
	 */
	public void addHealth(int nbToAdd){
		this.health += nbToAdd;
	}
	
	/**
	 * Allows to remove health for the fighter
	 * If the subtraction exceeds the minimum, put the health to the minimum
	 * @param nbToRemove The number to remove to the health of the fighter
	 */
	public void removeHealth(int nbToRemove){
		this.health -= nbToRemove;
	}
	
	/**
	 * Allows to increment the attack for the fighter
	 * @param nbToAdd The number to add to the attack of the fighter
	 */
	public void modifyAttack(int nbToAdd)
	{
		this.attack += nbToAdd; 
	}
	
	/**
	 * Allows to set the attack points of the fighter
	 * @param attackPoints The new value of the attack for the fighter
	 */
	public void setAttack(int attackPoints)
	{
		this.attack = attackPoints;
	}
	
	/**
	 * Allows to increment the defense for the fighter
	 * @param nbToAdd The number to add to the defense of the fighter
	 */
	public void modifyDefense(int nbToAdd)
	{
		this.defense += nbToAdd;
	}
	
	/**
	 * Allows to set the defense points of the fighter
	 * @param attackPoints The new value of the defense for the fighter
	 */
	public void setDefense(int defensePoints)
	{
		this.defense = defensePoints;
	}	
	
	/**
	 * Allows to remove attack for the fighter
	 * If the subtraction exceeds the minimum, put the attack to 0
	 * @param nbToRemove The number to remove to the attack of the fighter
	 */
	public void removeAttack(int nbToRemove){
		this.attack -= nbToRemove;
	}
	
	/**
	 * Allows to add defense for the fighter
	 * @param nbToAdd The number to add to the defense of the fighter
	 */
	public void addDefense(int nbToAdd){
		this.defense += nbToAdd;
	}
	
	/**
	 * Allows to remove defense for the fighter
	 * If the subtraction exceeds 0, put the defense to 0
	 * @param nbToRemove The number to remove to the defense of the fighter
	 */
	public void removeDefense(int nbToRemove){
		this.defense -= nbToRemove;
	}
	
	/**
	 * Allow to set the health points of the player
	 * @param healthPoints The number of health points to set
	 * already tested
	 */
	public void setHealth(int healthPoints)
	{
		if (healthPoints > 0) {
			this.health = healthPoints;
		}
	}
}
