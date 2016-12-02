package the_Manor;

import package_Display.WindowDisplayMessage;

public class Fight {
	
	private Enemy enemy;
	private Player player;
	
	public Fight(Player player,Enemy enemy){
		this.enemy = enemy;
		this.player = player;
	}
	
	public Player getPlayer(){
		return this.player;
	}
	
	public Enemy getEnemy(){
		return this.enemy;
	}
	
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
	
	public void recup(Fighter fighter){
		fighter.addStamina(fighter.getAttack());
	}
}
