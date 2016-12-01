package the_Manor;

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
}
