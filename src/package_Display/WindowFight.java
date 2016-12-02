package package_Display;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import the_Manor.Fight;

public class WindowFight extends JFrame{
	
	private Fight combat;
	private JLabel healthEnemy,staminaEnemy,healthPlayer,staminaPlayer;
	
	public WindowFight (Fight combat, Window windowGame){
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
		panelEnemy.add(new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Epee.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT))));
		
		
		
		
		
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
		//new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Epee.png").getImage().getScaledInstance((WIDTH_WINDOW*11)/100, (WIDTH_WINDOW*11)/100, Image.SCALE_DEFAULT)));
		characPlayer.add(healthPlayer);
		characPlayer.add(attackPlayer);
		characPlayer.add(staminaPlayer);
		characPlayer.add(armorPlayer);
		infoPlayer.add(characPlayer);
		
		JButton attack = new JButton("Attack");
		attack.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				WindowFight.this.combat.attack(WindowFight.this.combat.getPlayer());
				WindowFight.this.combat.attack(WindowFight.this.combat.getEnemy());
				WindowFight.this.verifCharac();
            }
		});
		JButton stay = new JButton("Recup");
		stay.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				WindowFight.this.combat.recup(WindowFight.this.combat.getPlayer());
				WindowFight.this.combat.attack(WindowFight.this.combat.getEnemy());
				WindowFight.this.verifCharac();
            }
		});
		JButton heal = new JButton("Heal");
		JButton escape = new JButton("Escape");
		escape.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				System.exit(0);
            }
		});
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
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setSize(600, 300);
	}
	
	public void verifCharac(){
		healthEnemy.setText("  "+this.combat.getEnemy().getHealth()+" / "+this.combat.getEnemy().getNbMaxHealth());
		staminaEnemy.setText("  "+this.combat.getEnemy().getStamina()+" / "+this.combat.getEnemy().getNbMaxStamina());
		healthPlayer.setText(this.combat.getPlayer().getHealth()+" / "+this.combat.getPlayer().getNbMaxHealth()+"  ");
		staminaPlayer.setText(this.combat.getPlayer().getStamina()+" / "+this.combat.getPlayer().getNbMaxStamina()+"  ");
	}
}
