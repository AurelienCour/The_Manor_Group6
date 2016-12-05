package package_Display;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import the_Manor.Game;
import the_Manor.Item;
import the_Manor.Potion;
import the_Manor.Shield;
import the_Manor.Weapon;

public class WindowInventory extends JFrame{
	
	/**
	 * The serial ID for the version of the 5/12/2016
	 */
	private static final long serialVersionUID = 5122016L;
	private Game theGame;
	private Window windowGame;
	private JButton[] buttonsShield,buttonsWeapon,buttonsHeal;
	
	public WindowInventory (Game theGame,Window windowGame){
		this.windowGame = windowGame;
		this.windowGame.setEnabled(false);
		this.theGame = theGame;
		this.setTitle("Inventory");
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		this.requestFocusInWindow();
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
				buttonsWeapon[i] = new JButton("unequip");
				buttonsWeapon[i].addActionListener(new ActionListener(){
					public void actionPerformed (ActionEvent e){
						WindowInventory.this.theGame.getPlayer().desequipWeapon();
						WindowInventory.this.windowGame.checkItem();
						WindowInventory.this.dispose();
						WindowInventory.this.windowGame.setEnabled(true);
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
		    JLabel nameWeapon = new JLabel("  "+allWeapon.get(i).getName().toUpperCase());
		    nameWeapon.setHorizontalAlignment(SwingConstants.LEFT);
		    nameWeapon.setForeground(Color.WHITE);
			JLabel attckWeapon = new JLabel("Attack : "+allWeapon.get(i).getAttack()+"  ");
			attckWeapon.setHorizontalAlignment(SwingConstants.RIGHT);
			attckWeapon.setForeground(Color.WHITE);
			JPanel characWeapon = new JPanel();
			characWeapon.setLayout(new GridLayout(1,2));
			characWeapon.add(nameWeapon);
			characWeapon.add(attckWeapon);
			characWeapon.setOpaque(false);
			characWeapon.setPreferredSize(new Dimension(210,40));
		    characWeapon.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		    weaponInventory.add(characWeapon);
		    weaponInventory.add(buttonsWeapon[i]);
		    weapon.add(weaponInventory);
		    try{
				GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
				Font font = Font.createFont(Font.TRUETYPE_FONT,this.getClass().getResourceAsStream("Font/feast_of_flesh_bb/FEASFBI_.TTF"));
				ge.registerFont(font);
				font = font.deriveFont(Font.TRUETYPE_FONT,20);
				buttonsWeapon[i].setFont(font);
				nameWeapon.setFont(font);
				attckWeapon.setFont(font);
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
				buttonsShield[i] = new JButton("unequip");
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
			JLabel nameShield = new JLabel("  "+allShield.get(i).getName().toUpperCase());
			nameShield.setHorizontalAlignment(SwingConstants.LEFT);
			nameShield.setForeground(Color.WHITE);
			JLabel defShield = new JLabel("Defense : "+allShield.get(i).getDefense()+"  ");
			defShield.setHorizontalAlignment(SwingConstants.RIGHT);
			defShield.setForeground(Color.WHITE);
			JPanel characShield = new JPanel();
			characShield.setLayout(new GridLayout(1,2));
			characShield.add(nameShield);
			characShield.add(defShield);
			characShield.setOpaque(false);
			characShield.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			shieldInventory.add(characShield);
			shieldInventory.add(buttonsShield[i]);
			shield.add(shieldInventory);
			try{
				GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
				Font font = Font.createFont(Font.TRUETYPE_FONT,this.getClass().getResourceAsStream("Font/feast_of_flesh_bb/FEASFBI_.TTF"));
				ge.registerFont(font);
				font = font.deriveFont(Font.TRUETYPE_FONT,20);
				buttonsShield[i].setFont(font);
				nameShield.setFont(font);
				defShield.setFont(font);
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
			if(potionKey.get(i) instanceof Potion){
				JPanel potion = new JPanel();
				potion.setLayout(new GridLayout(1,2));
				potion.setOpaque(false);
				buttonsHeal[i] = new JButton("Use");
				buttonsHeal[i].addActionListener(new Actions(this,potionKey.get(i),"healInv"));
				buttonsHeal[i].setBackground(Color.BLACK);
				buttonsHeal[i].setForeground(Color.RED);
				buttonsHeal[i].setFocusPainted(false);
				JLabel namePotion = new JLabel("  "+potionKey.get(i).getName());
				namePotion.setHorizontalAlignment(SwingConstants.LEFT);
				namePotion.setForeground(Color.WHITE);
				JLabel defPotion = new JLabel("Health :"+((Potion) potionKey.get(i)).getHealth()+"  ");
				defPotion.setHorizontalAlignment(SwingConstants.RIGHT);
				defPotion.setForeground(Color.WHITE);
				JPanel characPotion = new JPanel();
				characPotion.setLayout(new GridLayout(1,2));
				characPotion.setPreferredSize(new Dimension(210,40));
				characPotion.add(namePotion);
				characPotion.add(defPotion);
				characPotion.setOpaque(false);
				characPotion.setBorder(BorderFactory.createLineBorder(Color.WHITE));
				potion.add(characPotion);
				potion.add(buttonsHeal[i]);
				listPotionKey.add(potion);
				try{
					GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
					Font font = Font.createFont(Font.TRUETYPE_FONT,this.getClass().getResourceAsStream("Font/feast_of_flesh_bb/FEASFBI_.TTF"));
					ge.registerFont(font);
					font = font.deriveFont(Font.TRUETYPE_FONT,20);
					if(buttonsHeal[i] != null)
						buttonsHeal[i].setFont(font);
					namePotion.setFont(font);
					defPotion.setFont(font);
				}
				catch(IOException e){
				}catch(FontFormatException e){          
				}catch(IllegalArgumentException e){
				}
			}
			else{
				JLabel characPotion = new JLabel();
				characPotion.setBorder(BorderFactory.createLineBorder(Color.WHITE));
				characPotion.setText("  "+potionKey.get(i).getName());
				characPotion.setForeground(Color.WHITE);
				listPotionKey.add(characPotion);
				try{
					GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
					Font font = Font.createFont(Font.TRUETYPE_FONT,this.getClass().getResourceAsStream("Font/feast_of_flesh_bb/FEASFBI_.TTF"));
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
			
		}
		inventoryPotionKey.add(headerPotionKey,BorderLayout.NORTH);
		inventoryPotionKey.add(listPotionKey,BorderLayout.CENTER);

		
		try{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font font = Font.createFont(Font.TRUETYPE_FONT,this.getClass().getResourceAsStream("Font/feast_of_flesh_bb/FEASFBI_.TTF"));
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
		
		this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                  WindowInventory.this.windowGame.setEnabled(true);
            }
		});
	}

	public void equipPlayer(Item itemToEquip) {
		this.theGame.getPlayer().equipItem(itemToEquip);
		this.windowGame.checkItem();
		this.dispose();
		this.windowGame.setEnabled(true);
	}

	public void heal(Item itemToEquip) {
		if(this.theGame.getPlayer().getHealth() != this.theGame.getPlayer().getNbMaxHealth()){
			this.theGame.getPlayer().heal((Potion) itemToEquip);
			this.windowGame.checkItem();
			this.windowGame.setCharac();
			this.dispose();
			this.windowGame.setEnabled(true);
		}
		else
			new WindowDisplayMessage("You already have your whole life",this.windowGame);
	}
}
