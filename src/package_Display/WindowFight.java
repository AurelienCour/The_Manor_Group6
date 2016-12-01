package package_Display;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import the_Manor.Fight;

public class WindowFight extends JFrame{
	
	private Fight combat;
	
	public WindowFight (Fight combat){
		this.combat = combat;
		this.setTitle("Fight");
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(2,1,4,4));
		
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
		JLabel healthEnemy = new JLabel("  "+this.combat.getEnemy().getHealth()+" / "+this.combat.getEnemy().getNbMaxHealth());
		healthEnemy.setForeground(Color.RED);
		JLabel staminaEnemy = new JLabel("  "+this.combat.getEnemy().getStamina()+" / "+this.combat.getEnemy().getNbMaxStamina());
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
		panelPlayer.setLayout(new GridLayout(1,2));
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
		JLabel healthPlayer = new JLabel(this.combat.getPlayer().getHealth()+" / "+this.combat.getPlayer().getNbMaxHealth()+"  ");
		healthPlayer.setForeground(Color.RED);
		JLabel staminaPlayer = new JLabel(this.combat.getPlayer().getStamina()+" / "+this.combat.getPlayer().getNbMaxStamina()+"  ");
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
		
		panelPlayer.add(new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Epee.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT))));
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
		}
		catch(IOException e){
		}catch(FontFormatException e){          
		}catch(IllegalArgumentException e){
		}
		this.add(panelEnemy);
		this.add(panelPlayer);
		this.setVisible(true);
		this.pack();
	}
}
