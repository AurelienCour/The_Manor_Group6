package the_Manor;

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
	public Fighter(String newName, Room InitialRoom) {
		super(newName, InitialRoom);
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
