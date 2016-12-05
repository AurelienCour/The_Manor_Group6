package the_Manor;

/**
 * <p>This class allow to make a fight happens between the player and an enemy.</p>
 * <p>As the player enters in a room, if there is a enemy in this room, the fight is launched.</p>
 * 
 * @author Group 6
 * @version 05/12/16
 */
public class Fight {
	
	private Enemy enemy; // The enemy that the player is encountering.
	private Player player; // The player encountering the enemy.
	
	/**
	 * The constructor of the class Fight.
	 * @param player The player of the game.
	 * @param enemy The enemy encountered by the player.
	 */
	public Fight(Player player,Enemy enemy){
		this.enemy = enemy;
		this.player = player;
	}
	
	/**
	 * To know who is the player in the room.
	 * @return The player in the room.
	 */
	public Player getPlayer(){
		return this.player;
	}
	
	/**
	 * To know who is the enemy in the room.
	 * @return The enemy in the room.
	 */
	public Enemy getEnemy(){
		return this.enemy;
	}
	
	/**
	 * <p>Allows a fighter to launch an attack</p>
	 * <p>If the fighter is a player and he has enough stamina, he will remove some health of the enemy but his stamina will goes down according to the power of his attack</p>
	 * <p>If the fighter is an enemy and he has enough stamina, he will remove some health of the player but his stamina will goes down according to the power of his attack</p>	
	 * @param fight The fighter launching the attack
	 */
	public void attack(Fighter fight){
		
		// If the fighter is a Player, his stamina must be upper than 0 to attack the enemy.		
		if(fight instanceof Player){
			if(this.player.getStamina()>0){
				this.enemy.removeHealth(this.player.getAttack() - ((this.enemy.getDefense()*this.player.getAttack())/100)); // The players removes enemy's health according to his attack and the enemy's defense.
				this.player.removeStamina(this.player.getAttack()); // The player loses as much stamina as the value of his attack.
			}
		}
		// If the fighter is an Enemy, his stamina must be upper than 0 to attack the player
		else if(fight instanceof Enemy){
			if(this.enemy.getStamina()>0){
				this.player.removeHealth(this.enemy.getAttack() - ((this.player.getDefense()*this.enemy.getAttack())/100)); // The enemy removes player's health according to his attack and the player's defense.
				this.enemy.removeStamina(this.enemy.getAttack()); // The enemy loses as much stamina as the value of his attack.
			}
			// If the fighter's stamina is lower than 0, the enemy will not attack the player and will get some stamina back.
			else{
				recup(enemy);
			}
		}
	}
	
	/**
	 * Allows the fighter to get some stamina back according to his attack value.
	 * @param fighter The fighter that will get some stamina back.
	 */
	public void recup(Fighter fighter){
		fighter.addStamina(fighter.getAttack());
	}
}
