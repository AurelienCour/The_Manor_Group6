package package_Display;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.*;
import the_Manor.Fight;
import the_Manor.Room;

public class WindowFight extends JFrame{
	
	private Fight combat;
	private JLabel healthEnemy,staminaEnemy,healthPlayer,staminaPlayer;
	private Room previousRoomPlayer;
	private Window windowGame;
	
	public WindowFight (Fight combat, Window windowGame, Room previousRoomPlayer){
		this.windowGame = windowGame;
		this.previousRoomPlayer = previousRoomPlayer;
		this.windowGame.setEnabled(false);
		this.combat = combat;
		this.setTitle("Fight");
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new GridLayout(2,1));
		this.setUndecorated(true);
		
		JPanel panelEnemy = new JPanel();
		panelEnemy.setLayout(new GridLayout(1,2));
		panelEnemy.setBackground(Color.BLACK);
		panelEnemy.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		JPanel infoEnemy = new JPanel();
		infoEnemy.setLayout(new GridLayout(2,1));
		infoEnemy.setOpaque(false);
		JLabel nameEnemy = new JLabel(this.combat.getEnemy().getName());
		nameEnemy.setForeground(Color.WHITE);
		nameEnemy.setHorizontalAlignment(SwingConstants.CENTER);
		infoEnemy.add(nameEnemy);
		
		JPanel characEnemy = new JPanel();
		characEnemy.setLayout(new GridLayout(2,2));
		characEnemy.setOpaque(false);
		healthEnemy = new JLabel("  "+this.combat.getEnemy().getHealth()+" / "+this.combat.getEnemy().getNbMaxHealth());
		healthEnemy.setForeground(Color.RED);
		staminaEnemy = new JLabel("  "+this.combat.getEnemy().getStamina()+" / "+this.combat.getEnemy().getNbMaxStamina());
		staminaEnemy.setForeground(Color.GREEN);
		JLabel armorEnemy = new JLabel("Armor : "+this.combat.getEnemy().getDefense());
		JLabel attackEnemy = new JLabel("Attack : "+this.combat.getEnemy().getAttack());
		armorEnemy.setForeground(Color.BLUE);
		attackEnemy.setForeground(Color.BLUE);
		//new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Epee.png").getImage().getScaledInstance((WIDTH_WINDOW*11)/100, (WIDTH_WINDOW*11)/100, Image.SCALE_DEFAULT)));
		characEnemy.add(healthEnemy);
		characEnemy.add(attackEnemy);
		characEnemy.add(staminaEnemy);
		characEnemy.add(armorEnemy);
		infoEnemy.add(characEnemy);
		panelEnemy.add(infoEnemy);
		panelEnemy.add(new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/PictureMob/Dog.png").getImage().getScaledInstance(250, 140, Image.SCALE_DEFAULT))));
		
		
		
		
		
		JPanel panelPlayer = new JPanel();
		panelPlayer.setLayout(new GridLayout(1,2,5,5));
		panelPlayer.setBackground(Color.BLACK);
		panelPlayer.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		JPanel infoPlayer = new JPanel();
		infoPlayer.setLayout(new GridLayout(2,1));
		infoPlayer.setOpaque(false);
		
		JLabel namePlayer = new JLabel(this.combat.getPlayer().getName());
		namePlayer.setForeground(Color.WHITE);
		infoPlayer.add(namePlayer);
		namePlayer.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel characPlayer = new JPanel();
		characPlayer.setLayout(new GridLayout(2,2));
		characPlayer.setOpaque(false);
		healthPlayer = new JLabel(this.combat.getPlayer().getHealth()+" / "+this.combat.getPlayer().getNbMaxHealth()+"  ");
		healthPlayer.setForeground(Color.RED);
		staminaPlayer = new JLabel(this.combat.getPlayer().getStamina()+" / "+this.combat.getPlayer().getNbMaxStamina()+"  ");
		staminaPlayer.setForeground(Color.GREEN);
		JLabel armorPlayer = new JLabel("Armor : "+this.combat.getPlayer().getDefense());
		JLabel attackPlayer = new JLabel("Attack : "+this.combat.getPlayer().getAttack());
		armorPlayer.setForeground(Color.BLUE);
		attackPlayer.setForeground(Color.BLUE);
		characPlayer.add(healthPlayer);
		characPlayer.add(attackPlayer);
		characPlayer.add(staminaPlayer);
		characPlayer.add(armorPlayer);
		infoPlayer.add(characPlayer);
		
		JButton attack = new JButton("Attack");
		attack.addActionListener(new Actions(this,"attack"));
		JButton stay = new JButton("Recup");
		stay.addActionListener(new Actions(this,"recup"));
		JButton heal = new JButton("Heal");
		heal.addActionListener(new Actions(this,"heal"));
		JButton escape = new JButton("Escape");
		escape.addActionListener(new Actions(this,"escape"));
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(2,2));
		buttons.add(attack);
		attack.setBackground(Color.BLACK);
		attack.setForeground(Color.WHITE);
		attack.setFocusPainted(false);
		buttons.add(stay);
		stay.setBackground(Color.BLACK);
		stay.setForeground(Color.WHITE);
		stay.setFocusPainted(false);
		buttons.add(heal);
		heal.setBackground(Color.BLACK);
		heal.setForeground(Color.WHITE);
		heal.setFocusPainted(false);
		buttons.add(escape);
		escape.setBackground(Color.BLACK);
		escape.setForeground(Color.WHITE);
		escape.setFocusPainted(false);
		buttons.setOpaque(false);
		panelPlayer.add(buttons);
		panelPlayer.add(infoPlayer);
		try{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font font = Font.createFont(Font.TRUETYPE_FONT,new File("src/package_Display/Font/feast_of_flesh_bb/FEASFBI_.TTF"));
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
		this.healthEnemy.setText("  "+this.combat.getEnemy().getHealth()+" / "+this.combat.getEnemy().getNbMaxHealth());
		this.staminaEnemy.setText("  "+this.combat.getEnemy().getStamina()+" / "+this.combat.getEnemy().getNbMaxStamina());
		this.healthPlayer.setText(this.combat.getPlayer().getHealth()+" / "+this.combat.getPlayer().getNbMaxHealth()+"  ");
		this.staminaPlayer.setText(this.combat.getPlayer().getStamina()+" / "+this.combat.getPlayer().getNbMaxStamina()+"  ");
	}
	
	public void attack(){
		if(this.combat.getPlayer().getStamina() == 0)
			new WindowDisplayMessage("You need more stamina",this.windowGame);
		else
			this.combat.attack(this.combat.getPlayer());
		this.windowGame.setEnabled(false);
		this.verifCharac();
		if(!this.combat.getEnemy().isAlive()){
			new WindowDisplayMessage("You win the fight !", this.windowGame);
			this.combat.getPlayer().addStamina(this.combat.getPlayer().getNbMaxStamina());
			this.combat.getPlayer().getCurrentRoom().deleteEnemy(this.combat.getEnemy());
			this.verifCharac();
			this.dispose();
		}
		else{
			this.combat.attack(this.combat.getEnemy());
			this.verifCharac();
			if(!this.combat.getPlayer().isAlive()){
				new WindowGameOver(this.windowGame);
				this.dispose();
			}
		}
	}
	
	
	public void recup(){
		this.combat.recup(this.combat.getPlayer());
		this.combat.attack(this.combat.getEnemy());
		this.verifCharac();
		if(!this.combat.getPlayer().isAlive()){
			new WindowGameOver(this.windowGame);
			this.dispose();
		}
		this.verifCharac();
	}
	
	
	public void heal(){
		if(this.combat.getPlayer().havePotion()){
			this.combat.getPlayer().heal(this.combat.getPlayer().getPotion());
			this.windowGame.checkItem();
		}
		else{
			new WindowDisplayMessage("You need food to take care of yourself", this.windowGame);
			this.windowGame.setEnabled(false);
		}
		this.windowGame.setEnabled(false);
		this.combat.attack(this.combat.getEnemy());
		this.verifCharac();
		if(!this.combat.getPlayer().isAlive()){
			new WindowGameOver(this.windowGame);
			this.dispose();	
		}
	}
	
	
	public void escape(){
		Random rand = new Random();
		int nombre = rand.nextInt(3); //Entre 0 et 3
		if(nombre==0){
			this.dispose();
			this.windowGame.setEnabled(true);
			new WindowDisplayMessage("You fled.", this.windowGame);
			this.combat.getPlayer().setCurrentRoom(previousRoomPlayer);
			this.windowGame.gameMove("");
		}
		else{
			this.combat.attack(this.combat.getEnemy());
			this.verifCharac();
			if(!this.combat.getPlayer().isAlive()){
				new WindowGameOver(this.windowGame);
				this.dispose();	
			}
			else
				new WindowDisplayMessage("The escape failed.", this.windowGame);
		}
	}
}
