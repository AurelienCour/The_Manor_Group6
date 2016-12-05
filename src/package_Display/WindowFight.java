package package_Display;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import javax.swing.*;
import the_Manor.Fight;
import the_Manor.Room;

/**
 * The window to manage a fight
 * @author Group6
 *
 */
public class WindowFight extends JFrame{
	
	/**
	 * The serial ID for the version of the 5/12/2016
	 */
	private static final long serialVersionUID = 5122016L;
	private Fight fight; // The fight
	private JLabel healthEnemy,staminaEnemy,healthPlayer,staminaPlayer; // All the label for the characteristics of the enemy and the player
	private Room previousRoomPlayer; // The previousRoom in the case of an escape
	private Window windowGame; // The window of the game to center the panel and refresh the characteristics
	
	/**
	 * The constructor of the class WindowFight
	 * @param fight The fight to display
	 * @param windowGame The window of the game
	 * @param previousRoomPlayer // The previous room of the player in case of escape
	 */
	public WindowFight (Fight fight, Window windowGame, Room previousRoomPlayer){
		this.windowGame = windowGame;
		this.previousRoomPlayer = previousRoomPlayer;
		this.windowGame.setEnabled(false);
		this.fight = fight;
		this.setTitle("Fight");
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new GridLayout(2,1));
		this.setUndecorated(true);
		this.requestFocusInWindow();
		
		////// ENEMY
		// All the characteristics about the enemy
		healthEnemy = new JLabel("  "+this.fight.getEnemy().getHealth()+" / "+this.fight.getEnemy().getNbMaxHealth());
		healthEnemy.setForeground(Color.RED);
		staminaEnemy = new JLabel("  "+this.fight.getEnemy().getStamina()+" / "+this.fight.getEnemy().getNbMaxStamina());
		staminaEnemy.setForeground(Color.GREEN);
		JLabel armorEnemy = new JLabel("Armor : "+this.fight.getEnemy().getDefense());
		JLabel attackEnemy = new JLabel("Attack : "+this.fight.getEnemy().getAttack());
		armorEnemy.setForeground(Color.BLUE);
		attackEnemy.setForeground(Color.BLUE);
		
		// Add the characteristics to a Panel
		JPanel characEnemy = new JPanel();
		characEnemy.setLayout(new GridLayout(2,2));
		characEnemy.setOpaque(false);
		characEnemy.add(healthEnemy);
		characEnemy.add(attackEnemy);
		characEnemy.add(staminaEnemy);
		characEnemy.add(armorEnemy);
		
		// The label for the name of the enemy
		JLabel nameEnemy = new JLabel(this.fight.getEnemy().getName());
		nameEnemy.setForeground(Color.WHITE);
		nameEnemy.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Add all the informations about the enemy in a panel
		JPanel infoEnemy = new JPanel();
		infoEnemy.setLayout(new GridLayout(2,1));
		infoEnemy.setOpaque(false);
		infoEnemy.add(nameEnemy);
		infoEnemy.add(characEnemy);
		
		// Recup the icon for the enemy
		URL url = StartingWindow.class.getResource("Image/PictureMob/"+this.fight.getEnemy().getImage());
		ImageIcon icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(250, 140, Image.SCALE_DEFAULT));
		
		// The panel with the information about the enemy
		JPanel panelEnemy = new JPanel();
		panelEnemy.setLayout(new GridLayout(1,2));
		panelEnemy.setBackground(Color.BLACK);
		panelEnemy.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		panelEnemy.add(infoEnemy);
		panelEnemy.add(new JLabel(icon));
		
		///// PLAYER
		healthPlayer = new JLabel(this.fight.getPlayer().getHealth()+" / "+this.fight.getPlayer().getNbMaxHealth()+"  ");
		healthPlayer.setForeground(Color.RED);
		staminaPlayer = new JLabel(this.fight.getPlayer().getStamina()+" / "+this.fight.getPlayer().getNbMaxStamina()+"  ");
		staminaPlayer.setForeground(Color.GREEN);
		JLabel armorPlayer = new JLabel("Armor : "+this.fight.getPlayer().getDefense());
		JLabel attackPlayer = new JLabel("Attack : "+this.fight.getPlayer().getAttack());
		armorPlayer.setForeground(Color.BLUE);
		attackPlayer.setForeground(Color.BLUE);
		
		JPanel characPlayer = new JPanel();
		characPlayer.setLayout(new GridLayout(2,2));
		characPlayer.setOpaque(false);
		characPlayer.add(healthPlayer);
		characPlayer.add(attackPlayer);
		characPlayer.add(staminaPlayer);
		characPlayer.add(armorPlayer);
		
		JLabel namePlayer = new JLabel(this.fight.getPlayer().getName());
		namePlayer.setForeground(Color.WHITE);
		namePlayer.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel infoPlayer = new JPanel();
		infoPlayer.setLayout(new GridLayout(2,1));
		infoPlayer.setOpaque(false);
		infoPlayer.add(namePlayer);
		infoPlayer.add(characPlayer);
		
		JButton attack = new JButton("Attack");
		attack.addActionListener(new Actions(this,"attack"));
		attack.setBackground(Color.BLACK);
		attack.setForeground(Color.WHITE);
		attack.setFocusPainted(false);
		JButton stay = new JButton("Recup");
		stay.addActionListener(new Actions(this,"recup"));
		stay.setBackground(Color.BLACK);
		stay.setForeground(Color.WHITE);
		stay.setFocusPainted(false);
		JButton heal = new JButton("Heal");
		heal.addActionListener(new Actions(this,"heal"));
		heal.setBackground(Color.BLACK);
		heal.setForeground(Color.WHITE);
		heal.setFocusPainted(false);
		JButton escape = new JButton("Escape");
		escape.addActionListener(new Actions(this,"escape"));
		escape.setBackground(Color.BLACK);
		escape.setForeground(Color.WHITE);
		escape.setFocusPainted(false);
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(2,2));
		buttons.add(attack);
		buttons.add(stay);
		buttons.add(heal);
		buttons.add(escape);
		
		JPanel panelPlayer = new JPanel();
		panelPlayer.setLayout(new GridLayout(1,2,5,5));
		panelPlayer.setBackground(Color.BLACK);
		panelPlayer.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		panelPlayer.add(buttons);
		panelPlayer.add(infoPlayer);
		
		try{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font font = Font.createFont(Font.TRUETYPE_FONT,this.getClass().getResourceAsStream("Font/feast_of_flesh_bb/FEASFBI_.TTF"));
			ge.registerFont(font);
			font = font.deriveFont(Font.TRUETYPE_FONT,25);
			healthEnemy.setFont(font);
			staminaEnemy.setFont(font);
			attackEnemy.setFont(font);
			armorEnemy.setFont(font);
			nameEnemy.setFont(font);
			
			healthPlayer.setFont(font);
			staminaPlayer.setFont(font);
			attackPlayer.setFont(font);
			armorPlayer.setFont(font);
			namePlayer.setFont(font);
			
			attack.setFont(font);
			stay.setFont(font);
			heal.setFont(font);
			escape.setFont(font);
		}
		catch(IOException e){
		}catch(FontFormatException e){          
		}catch(IllegalArgumentException e){
		}
		this.add(panelEnemy);
		this.add(panelPlayer);
		this.setSize(600, 300);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	public void verifCharac(){
		this.windowGame.setCharac();
		this.healthEnemy.setText("  "+this.fight.getEnemy().getHealth()+" / "+this.fight.getEnemy().getNbMaxHealth());
		this.staminaEnemy.setText("  "+this.fight.getEnemy().getStamina()+" / "+this.fight.getEnemy().getNbMaxStamina());
		this.healthPlayer.setText(this.fight.getPlayer().getHealth()+" / "+this.fight.getPlayer().getNbMaxHealth()+"  ");
		this.staminaPlayer.setText(this.fight.getPlayer().getStamina()+" / "+this.fight.getPlayer().getNbMaxStamina()+"  ");
	}
	
	public void attack(){
		if(this.fight.getPlayer().getStamina() == 0)
			new WindowDisplayMessage("You need more stamina",this.windowGame);
		else
			this.fight.attack(this.fight.getPlayer());
		this.windowGame.setEnabled(false);
		this.verifCharac();
		if(!this.fight.getEnemy().isAlive()){
			new WindowDisplayMessage("You won the fight !", this.windowGame);
			this.fight.getPlayer().addStamina(this.fight.getPlayer().getNbMaxStamina());
			this.fight.getPlayer().getCurrentRoom().deleteEnemy(this.fight.getEnemy());
			this.verifCharac();
			this.dispose();
		}
		else{
			this.fight.attack(this.fight.getEnemy());
			this.verifCharac();
			if(!this.fight.getPlayer().isAlive()){
				new WindowEnd(this.windowGame,"GameOver.png");
				this.dispose();
			}
		}
	}
	
	
	public void recup(){
		this.fight.recup(this.fight.getPlayer());
		this.fight.attack(this.fight.getEnemy());
		this.verifCharac();
		if(!this.fight.getPlayer().isAlive()){
			new WindowEnd(this.windowGame,"GameOver.png");
			this.dispose();
		}
		this.verifCharac();
	}
	
	
	public void heal(){
		if(this.fight.getPlayer().havePotion()){
			this.fight.getPlayer().heal(this.fight.getPlayer().getPotion());
			this.windowGame.checkItem();
		}
		else{
			new WindowDisplayMessage("You need food to take care of yourself", this.windowGame);
			this.windowGame.setEnabled(false);
		}
		this.windowGame.setEnabled(false);
		if(!this.fight.getPlayer().isAlive()){
			new WindowEnd(this.windowGame,"GameOver.png");
			this.dispose();	
		}
		this.verifCharac();
	}
	
	
	public void escape(){
		Random rand = new Random();
		int nombre = rand.nextInt(3); //Entre 0 et 3
		if(nombre==0){
			this.dispose();
			this.windowGame.setEnabled(true);
			new WindowDisplayMessage("You fled.", this.windowGame);
			this.fight.getPlayer().setCurrentRoom(previousRoomPlayer);
			this.windowGame.gameMove("");
		}
		else{
			this.fight.attack(this.fight.getEnemy());
			this.verifCharac();
			if(!this.fight.getPlayer().isAlive()){
				new WindowEnd(this.windowGame,"GameOver.png");
				this.dispose();	
			}
			else
				new WindowDisplayMessage("The escape failed.", this.windowGame);
		}
	}
}
