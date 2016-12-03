package the_Manor;

import package_Display.WindowDisplayMessage;

/**
 * <p>This class allow to make a fight happens between the player and an enemy</p>
 * <p>As the player enters in a room, if there is a enemy in this room, the figth is lauched</p>
 * <p></p>
 * @author Group 6
 *
 */
public class Fight {
	
	private Enemy enemy;
	private Player player;
	
	/**
	 * The constructor of the class Fight
	 * @param player The player of the game
	 * @param enemy The enemy encountered by the player
	 */
	public Fight(Player player,Enemy enemy){
		this.enemy = enemy;
		this.player = player;
	}
	
	/**
	 * To know who is the player in the room
	 * @return The player in the room
	 */
	public Player getPlayer(){
		return this.player;
	}
	
	/**
	 * To know who is the enemy in the room
	 * @return The enemy in the room
	 */
	public Enemy getEnemy(){
		return this.enemy;
	}
	
	/**
	 * <p>Allow a fighter to launch an attack</p>
	 * <p>If the fighter is a player and he has enough stamina, he will remove some health of the enemy but his stamina will goes down according to the power of his attack</p>
	 * <p>If the fighter is an enemy and he has enough stamina, he will remove some health of the player but his stamina will goes down according to the power of his attack</p>	
	 * @param fight The fighter that launches the attack
	 */
	public void attack(Fighter fight){
		if(fight instanceof Player){
			if(this.player.getStamina()>0){
				this.enemy.removeHealth(this.player.getAttack() - ((this.enemy.getDefense()*this.player.getAttack())/100));
				this.player.removeStamina(this.player.getAttack());
			}
		}
		else if(fight instanceof Enemy){
			if(this.enemy.getStamina()>0){
				this.player.removeHealth(this.enemy.getAttack() - ((this.player.getDefense()*this.enemy.getAttack())/100));
				this.enemy.removeStamina(this.enemy.getAttack());
			}
			else{
				recup(enemy);
			}
		}
	}
	
	/**
	 * Allow for a fighter to get some stamina back
	 * @param fighter The fighter that wants to get some stamina back
	 */
	public void recup(Fighter fighter){
		fighter.addStamina(fighter.getAttack());
	}
}
