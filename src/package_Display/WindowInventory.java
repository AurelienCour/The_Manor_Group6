package package_Display;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import the_Manor.Game;
import the_Manor.Item;
import the_Manor.Potion;
import the_Manor.Shield;
import the_Manor.Weapon;

public class WindowInventory extends JFrame{
	
	private Game theGame;
	private Window windowGame;
	private JButton[] buttonsShield,buttonsWeapon,buttonsHeal;
	
	public WindowInventory (Game theGame,Window windowGame){
		this.windowGame = windowGame;
		this.theGame = theGame;
		this.setTitle("Inventory");
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		
		JPanel inventory = new JPanel();
		inventory.setLayout(new GridLayout(0,2));
		inventory.setBackground(Color.BLACK);
		JPanel weapon = new JPanel();
		weapon.setLayout(new GridLayout(0,1));
		weapon.setBackground(Color.BLACK);
		JPanel shield = new JPanel();
		shield.setLayout(new GridLayout(0,1));
		shield.setBackground(Color.BLACK);
		ArrayList<Weapon> allWeapon;
		ArrayList<Shield> allShield;
		allWeapon = this.theGame.getPlayer().getWeapon();
		allShield = this.theGame.getPlayer().getShield();
		
		JPanel header = new JPanel();
		header.setLayout(new GridLayout(1,2));
		header.setBackground(Color.BLACK);
		JLabel headerWeapon = new JLabel("Weapon");
		headerWeapon.setHorizontalAlignment(SwingConstants.CENTER);
		headerWeapon.setForeground(Color.RED);
		headerWeapon.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JLabel headerShield = new JLabel("Shield");
		headerShield.setHorizontalAlignment(SwingConstants.CENTER);
		headerShield.setForeground(Color.RED);
		headerShield.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		header.add(headerWeapon);
		header.add(headerShield);
		
		buttonsWeapon = new JButton[allWeapon.size()];
		for (int i=0; i<allWeapon.size(); i++)
		{
			if(this.theGame.getPlayer().haveThisWeapon(allWeapon.get(i))){
				buttonsWeapon[i] = new JButton("desequip");
				buttonsWeapon[i].addActionListener(new ActionListener(){
					public void actionPerformed (ActionEvent e){
						WindowInventory.this.theGame.getPlayer().desequipWeapon();
						WindowInventory.this.windowGame.checkItem();
						WindowInventory.this.dispose();
		            }
				});
			}
			else{
				buttonsWeapon[i] = new JButton("equip");
				buttonsWeapon[i].addActionListener(new Actions(this,allWeapon.get(i),"equip"));
			}
			buttonsWeapon[i].setBackground(Color.BLACK);
			buttonsWeapon[i].setForeground(Color.RED);
			buttonsWeapon[i].setFocusPainted(false);
		    JPanel weaponInventory = new JPanel();
		    weaponInventory.setLayout(new GridLayout(1,2));
		    weaponInventory.setBackground(Color.BLACK);
		    JLabel characWeapon  = new JLabel(allWeapon.get(i).getName().toUpperCase()+"    Attack :"+allWeapon.get(i).getAttack()+"  ");
		    characWeapon.setForeground(Color.WHITE);
		    characWeapon.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		    weaponInventory.add(characWeapon);
		    weaponInventory.add(buttonsWeapon[i]);
		    weapon.add(weaponInventory);
		    try{
				GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
				Font font = Font.createFont(Font.TRUETYPE_FONT,new File("src/package_Display/Font/feast_of_flesh_bb/FEASFBI_.TTF"));
				ge.registerFont(font);
				font = font.deriveFont(Font.TRUETYPE_FONT,20);
				buttonsWeapon[i].setFont(font);
				characWeapon.setFont(font);
			}
			catch(IOException e){
			}catch(FontFormatException e){          
			}catch(IllegalArgumentException e){
			}
		}
		buttonsShield = new JButton[allShield.size()];
		for (int i=0; i<allShield.size(); i++)
		{
			if(this.theGame.getPlayer().haveThisShield(allShield.get(i))){
				buttonsShield[i] = new JButton("desequip");
				buttonsShield[i].addActionListener(new ActionListener(){
					public void actionPerformed (ActionEvent e){
						WindowInventory.this.theGame.getPlayer().desequipShield();
						WindowInventory.this.windowGame.checkItem();
						WindowInventory.this.dispose();
		            }
				});
			}
			else{
				buttonsShield[i] = new JButton("equip");
				buttonsShield[i].addActionListener(new Actions(this,allShield.get(i),"equip"));
			}
			buttonsShield[i].setBackground(Color.BLACK);
			buttonsShield[i].setForeground(Color.RED);
			buttonsShield[i].setFocusPainted(false);
			JPanel shieldInventory = new JPanel();
			shieldInventory.setLayout(new GridLayout(1,2));
			shieldInventory.setBackground(Color.BLACK);
			JLabel characShield = new JLabel(allShield.get(i).getName().toUpperCase()+"    Defense :"+allShield.get(i).getDefense()+"  ");
			characShield.setForeground(Color.WHITE);
			characShield.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			shieldInventory.add(characShield);
			shieldInventory.add(buttonsShield[i]);
			shield.add(shieldInventory);
			try{
				GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
				Font font = Font.createFont(Font.TRUETYPE_FONT,new File("src/package_Display/Font/feast_of_flesh_bb/FEASFBI_.TTF"));
				ge.registerFont(font);
				font = font.deriveFont(Font.TRUETYPE_FONT,20);
				buttonsShield[i].setFont(font);
				characShield.setFont(font);
			}
			catch(IOException e){
			}catch(FontFormatException e){          
			}catch(IllegalArgumentException e){
			}
		}
		
		JPanel inventoryPotionKey = new JPanel();
		inventoryPotionKey.setLayout(new BorderLayout());
		inventoryPotionKey.setBackground(Color.BLACK);
		JLabel headerPotionKey = new JLabel("Potion & Key");
		headerPotionKey.setHorizontalAlignment(SwingConstants.CENTER);
		headerPotionKey.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		headerPotionKey.setForeground(Color.RED);
		JPanel listPotionKey = new JPanel();
		listPotionKey.setLayout(new GridLayout(0,1));
		listPotionKey.setBackground(Color.BLACK);
		ArrayList<Item> potionKey;
		potionKey = this.theGame.getPlayer().getPotionKey();
		buttonsHeal = new JButton[potionKey.size()];
		for (int i=0; i<potionKey.size(); i++)
		{
			JLabel characPotion = new JLabel();
			characPotion.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			if(potionKey.get(i) instanceof Potion){
				JPanel potion = new JPanel();
				potion.setLayout(new GridLayout(1,2));
				potion.setOpaque(false);
				buttonsHeal[i] = new JButton("Use");
				buttonsHeal[i].addActionListener(new Actions(this,potionKey.get(i),"healInv"));
				buttonsHeal[i].setBackground(Color.BLACK);
				buttonsHeal[i].setForeground(Color.RED);
				characPotion.setText(potionKey.get(i).getName()+"   Health :"+((Potion) potionKey.get(i)).getHealth());
				characPotion.setForeground(Color.WHITE);
				potion.add(characPotion);
				potion.add(buttonsHeal[i]);
				listPotionKey.add(potion);
			}
			else{
				characPotion.setText(potionKey.get(i).getName());
				characPotion.setForeground(Color.WHITE);
				listPotionKey.add(characPotion);
			}
			try{
				GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
				Font font = Font.createFont(Font.TRUETYPE_FONT,new File("src/package_Display/Font/feast_of_flesh_bb/FEASFBI_.TTF"));
				ge.registerFont(font);
				font = font.deriveFont(Font.TRUETYPE_FONT,20);
				if(buttonsHeal[i] != null)
					buttonsHeal[i].setFont(font);
				characPotion.setFont(font);
			}
			catch(IOException e){
			}catch(FontFormatException e){          
			}catch(IllegalArgumentException e){
			}
		}
		inventoryPotionKey.add(headerPotionKey,BorderLayout.NORTH);
		inventoryPotionKey.add(listPotionKey,BorderLayout.CENTER);

		
		try{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font font = Font.createFont(Font.TRUETYPE_FONT,new File("src/package_Display/Font/feast_of_flesh_bb/FEASFBI_.TTF"));
			ge.registerFont(font);
			font = font.deriveFont(Font.TRUETYPE_FONT,28);
			headerWeapon.setFont(font);
			headerShield.setFont(font);
			headerPotionKey.setFont(font);
		}
		catch(IOException e){
		}catch(FontFormatException e){          
		}catch(IllegalArgumentException e){
		}
		JPanel inventoryWeaponShield = new JPanel();
		inventoryWeaponShield.setLayout(new BorderLayout());
		inventoryWeaponShield.add(header,BorderLayout.NORTH);
		inventory.add(weapon);
		inventory.add(shield);
		inventoryWeaponShield.add(inventory,BorderLayout.CENTER);
		
		
		this.add(inventoryWeaponShield,BorderLayout.CENTER);
		this.add(inventoryPotionKey,BorderLayout.SOUTH);
		this.setVisible(true);
		this.setResizable(true);
		this.pack();
		this.setLocationRelativeTo(this.windowGame);
	}

	public void equipPlayer(Item itemToEquip) {
		this.theGame.getPlayer().equipItem(itemToEquip);
		this.windowGame.checkItem();
		this.dispose();
	}

	public void heal(Item itemToEquip) {
		if(this.theGame.getPlayer().getHealth() != this.theGame.getPlayer().getNbMaxHealth()){
			this.theGame.getPlayer().heal((Potion) itemToEquip);
			this.windowGame.checkItem();
			this.windowGame.setCharac();
			this.dispose();
		}
		else
			new WindowDisplayMessage("You already have your whole life",this.windowGame);
	}
}
