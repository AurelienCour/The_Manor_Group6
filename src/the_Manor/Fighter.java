package the_Manor;

/**
 * This class defines the Fighter characters. </br>
 * <ul>A fighter has : 
 * <ul>
 * <li> health : integer variable defining the lifepoints. 10 by default
 * <li> stamina : integer variable defining the stamina. 20 by default
 * <li> attack : integer variable. 5 by default
 * <li> defense : integer variable. 3 by default
 * </ul>
 * The fighter can : </br>
 * <ul>
 * <li> Attack with his base attack or with a weapon. Weapon adds attack points </br>
 * <li> Defend with his base attack or with a shield. Shield adds defense points  </br>
 * <li> Heal himself with an item to get back life points
 * <li> Die if his health goes bellow 0 
 * <li> Can no longer attack if his stamina reaches 0
 * @author astem
 * @version 22/11/2016
 */
public class Fighter extends Character{

protected int health; // the Fighter's Health
protected int stamina; // the Fighte's Stamina 
protected int attack; // the Fighter's attack
protected int defense; // the Fighet's defense
	

	/**
	 * This is the constructor for the Fighter
	 * @param newName the Name of the Fighter
	 * @param InitialRoom
	 */
	public Fighter(String newName) {
		super(newName);
	}

	/**
	 * This methods returns the health of the fighter
	 * @return health
	 */
	public int getHealth(){
		return health;
	}
	
	/**
	 * This methods returns the stamina of the fighter
	 * @return stamina
	 */
	public int getStamina(){
		return stamina;
	}

	/**
	 * This methods changes the health value of the fighter
	 * @return health
	 */
	public int setHealth(){
		return health;
	}
	
	/**
	 * This methods changes the stamina value of the fighter
	 * @return stamina
	 */
	public int setStamina(){
		return stamina;
	}
	
	/**
	 * This methods allows to attack, thus returns the attack power
	 * @return attack
	 */
	public int getAttack(){
		return attack;
	}
	
	/**
	 * This methods allows to attack, thus returns the defense power
	 * @return defense
	 */
	public int getDefense(){
		return defense;
	}
}
