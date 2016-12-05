package package_Display;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import the_Manor.Game;
import the_Manor.Item;
import the_Manor.Key;
import the_Manor.Potion;
import the_Manor.Shield;
import the_Manor.Weapon;

/**
 * The window to manage the inventory
 * @author Group6
 *
 */
public class WindowInventory extends JFrame{
	
	/**
	 * The serial ID for the version of the 5/12/2016
	 */
	private static final long serialVersionUID = 5122016L;
	private Game theGame; // The game
	private Window windowGame; // The window of the game
	private JButton[] buttonsShield,buttonsWeapon,buttonsHeal; // The buttons to equip an equipment or to use a potion
	
	public WindowInventory (Game theGame,Window windowGame){
		this.windowGame = windowGame;
		this.windowGame.setEnabled(false);
		this.theGame = theGame;
		this.setTitle("Inventory");
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		this.requestFocusInWindow();

		///// WEAPONS
		// The header for the weapon
		JLabel headerWeapon = new JLabel("Weapon");
		headerWeapon.setHorizontalAlignment(SwingConstants.CENTER);
		headerWeapon.setForeground(Color.RED);
		headerWeapon.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		// The panel for the weapon
		JPanel weapon = new JPanel();
		weapon.setLayout(new GridLayout(0,1));
		weapon.setBackground(Color.BLACK);
		
		// All the weapon who has the player
		ArrayList<Weapon> allWeapon;
		allWeapon = this.theGame.getPlayer().getWeapon();
		
		// All the buttons to manage the weapon
		buttonsWeapon = new JButton[allWeapon.size()];
		for (int i=0; i<allWeapon.size(); i++)
		{
			// If the weapon is currently equipped by the player
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
			// If not
			else{
				buttonsWeapon[i] = new JButton("equip");
				buttonsWeapon[i].addActionListener(new Actions(this,allWeapon.get(i),"equip"));
			}
			buttonsWeapon[i].setBackground(Color.BLACK);
			buttonsWeapon[i].setForeground(Color.RED);
			buttonsWeapon[i].setFocusPainted(false);
			
		    // The label for the name of the weapon
		    JLabel nameWeapon = new JLabel("  "+allWeapon.get(i).getName().toUpperCase());
		    nameWeapon.setHorizontalAlignment(SwingConstants.LEFT);
		    nameWeapon.setForeground(Color.WHITE);
		    
		    // The label for the attack of the weapon
			JLabel attckWeapon = new JLabel("Attack : "+allWeapon.get(i).getAttack()+"  ");
			attckWeapon.setHorizontalAlignment(SwingConstants.RIGHT);
			attckWeapon.setForeground(Color.WHITE);
			
			// The panel for the name and the attack of the weapon
			JPanel characWeapon = new JPanel();
			characWeapon.setLayout(new GridLayout(1,2));
			characWeapon.setOpaque(false);
			characWeapon.setPreferredSize(new Dimension(210,40));
		    characWeapon.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			characWeapon.add(nameWeapon);
			characWeapon.add(attckWeapon);
			
			// The panel for the label of the weapon and his button
		    JPanel weaponInventory = new JPanel();
		    weaponInventory.setLayout(new GridLayout(1,2));
		    weaponInventory.setBackground(Color.BLACK);
		    weaponInventory.add(characWeapon);
		    weaponInventory.add(buttonsWeapon[i]);
		    weapon.add(weaponInventory);
		    
		    // Assign the font to the labels
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
		
		
		///// SHIELDS
		// The header for the shield
		JLabel headerShield = new JLabel("Shield");
		headerShield.setHorizontalAlignment(SwingConstants.CENTER);
		headerShield.setForeground(Color.RED);
		headerShield.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		// The panel for the shield
		JPanel shield = new JPanel();
		shield.setLayout(new GridLayout(0,1));
		shield.setBackground(Color.BLACK);
		
		// All the shield who has the player
		ArrayList<Shield> allShield;
		allShield = this.theGame.getPlayer().getShield();
		
		// All the buttons to manage the shields
		buttonsShield = new JButton[allShield.size()];
		for (int i=0; i<allShield.size(); i++)
		{
			// If the shield is currently equipped
			if(this.theGame.getPlayer().haveThisShield(allShield.get(i))){
				buttonsShield[i] = new JButton("unequip");
				buttonsShield[i].addActionListener(new ActionListener(){
					public void actionPerformed (ActionEvent e){
						WindowInventory.this.theGame.getPlayer().desequipShield();
						WindowInventory.this.windowGame.checkItem();
						WindowInventory.this.dispose();
						WindowInventory.this.windowGame.setEnabled(true);
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
			
			// The label for the name of each shield
			JLabel nameShield = new JLabel("  "+allShield.get(i).getName().toUpperCase());
			nameShield.setHorizontalAlignment(SwingConstants.LEFT);
			nameShield.setForeground(Color.WHITE);
			
			// The label for the defense of each shield
			JLabel defShield = new JLabel("Defense : "+allShield.get(i).getDefense()+"  ");
			defShield.setHorizontalAlignment(SwingConstants.RIGHT);
			defShield.setForeground(Color.WHITE);
			
			// The panel for the name and the defense of each shield
			JPanel characShield = new JPanel();
			characShield.setLayout(new GridLayout(1,2));
			characShield.add(nameShield);
			characShield.add(defShield);
			characShield.setOpaque(false);
			characShield.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			
			// The panel for the label and the buttons of each shield
			JPanel shieldInventory = new JPanel();
			shieldInventory.setLayout(new GridLayout(1,2));
			shieldInventory.setBackground(Color.BLACK);
			shieldInventory.add(characShield);
			shieldInventory.add(buttonsShield[i]);
			shield.add(shieldInventory);
			
			// Assign the font to the panel
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
		
		
		//// POTION AND KEY
		// The header for the potion and the keys
		JLabel headerPotionKey = new JLabel("Potion & Key");
		headerPotionKey.setHorizontalAlignment(SwingConstants.CENTER);
		headerPotionKey.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		headerPotionKey.setForeground(Color.RED);
		
		// The panel for the potion and his button and the key
		JPanel listPotionKey = new JPanel();
		listPotionKey.setLayout(new GridLayout(0,1));
		listPotionKey.setBackground(Color.BLACK);
		
		// All the potion and the key who has the player
		ArrayList<Item> potionKey;
		potionKey = this.theGame.getPlayer().getPotionKey();
		
		// All the buttons to use a potion
		buttonsHeal = new JButton[potionKey.size()];
		for (int i=0; i<potionKey.size(); i++)
		{
			// If the item is a potion
			if(potionKey.get(i) instanceof Potion){
				// Create the button to use the potion
				buttonsHeal[i] = new JButton("Use");
				buttonsHeal[i].addActionListener(new Actions(this,potionKey.get(i),"healInv"));
				buttonsHeal[i].setBackground(Color.BLACK);
				buttonsHeal[i].setForeground(Color.RED);
				buttonsHeal[i].setFocusPainted(false);
				
				// The label for the name of the potion
				JLabel namePotion = new JLabel("  "+potionKey.get(i).getName());
				namePotion.setHorizontalAlignment(SwingConstants.LEFT);
				namePotion.setForeground(Color.WHITE);
				
				// The label for the benefit of the potion
				JLabel healthPotion = new JLabel("Health :"+((Potion) potionKey.get(i)).getHealth()+"  ");
				healthPotion.setHorizontalAlignment(SwingConstants.RIGHT);
				healthPotion.setForeground(Color.WHITE);
				
				// The panel for the name and the benefit of the potion
				JPanel characPotion = new JPanel();
				characPotion.setLayout(new GridLayout(1,2));
				characPotion.setPreferredSize(new Dimension(210,40));
				characPotion.setOpaque(false);
				characPotion.setBorder(BorderFactory.createLineBorder(Color.WHITE));
				characPotion.add(namePotion);
				characPotion.add(healthPotion);
				
				// The panel for the potion and his button
				JPanel potion = new JPanel();
				potion.setLayout(new GridLayout(1,2));
				potion.setOpaque(false);
				potion.add(characPotion);
				potion.add(buttonsHeal[i]);
				listPotionKey.add(potion);
				
				// Assign the font to the label
				try{
					GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
					Font font = Font.createFont(Font.TRUETYPE_FONT,this.getClass().getResourceAsStream("Font/feast_of_flesh_bb/FEASFBI_.TTF"));
					ge.registerFont(font);
					font = font.deriveFont(Font.TRUETYPE_FONT,20);
					buttonsHeal[i].setFont(font);
					namePotion.setFont(font);
					healthPotion.setFont(font);
				}
				catch(IOException e){
				}catch(FontFormatException e){          
				}catch(IllegalArgumentException e){
				}
			}
			// If the item is a key
			else if(potionKey.get(i) instanceof Key){
				// The label with the name of the key
				JLabel characPotion = new JLabel();
				characPotion.setBorder(BorderFactory.createLineBorder(Color.WHITE));
				characPotion.setText("  "+potionKey.get(i).getName());
				characPotion.setForeground(Color.WHITE);
				listPotionKey.add(characPotion);
				
				// Assign the font to the label
				try{
					GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
					Font font = Font.createFont(Font.TRUETYPE_FONT,this.getClass().getResourceAsStream("Font/feast_of_flesh_bb/FEASFBI_.TTF"));
					ge.registerFont(font);
					font = font.deriveFont(Font.TRUETYPE_FONT,20);
					characPotion.setFont(font);
				}
				catch(IOException e){
				}catch(FontFormatException e){          
				}catch(IllegalArgumentException e){
				}
			}
		}

		// Assign the font to the header
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
		
		// The panel to manage all the potions and the keys and his header
		JPanel inventoryPotionKey = new JPanel();
		inventoryPotionKey.setLayout(new BorderLayout());
		inventoryPotionKey.setBackground(Color.BLACK);
		inventoryPotionKey.add(headerPotionKey,BorderLayout.NORTH);
		inventoryPotionKey.add(listPotionKey,BorderLayout.CENTER);
		
		// The header of the inventory
		JPanel header = new JPanel();
		header.setLayout(new GridLayout(1,2));
		header.setBackground(Color.BLACK);
		header.add(headerWeapon);
		header.add(headerShield);
		
		// The panel of the inventory for the weapon and the shield without the header
		JPanel inventory = new JPanel();
		inventory.setLayout(new GridLayout(0,2));
		inventory.setBackground(Color.BLACK);
		inventory.add(weapon);
		inventory.add(shield);
		
		// The panel of the inventory for the weapon and the shield with the header
		JPanel inventoryWeaponShield = new JPanel();
		inventoryWeaponShield.setLayout(new BorderLayout());
		inventoryWeaponShield.add(header,BorderLayout.NORTH);
		inventoryWeaponShield.add(inventory,BorderLayout.CENTER);
		
		this.add(inventoryWeaponShield,BorderLayout.CENTER);
		this.add(inventoryPotionKey,BorderLayout.SOUTH);
		this.setVisible(true);
		this.setResizable(true);
		this.pack();
		this.setLocationRelativeTo(this.windowGame);
		
		// When the windowInventory is closed
		this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                  WindowInventory.this.windowGame.setEnabled(true);
            }
		});
	}

	/**
	 * Allows to equip the player when he click on the button Equip
	 * @param itemToEquip The item to equip
	 */
	public void equipPlayer(Item itemToEquip) {
		this.theGame.getPlayer().equipItem(itemToEquip);
		this.windowGame.checkItem();
		this.dispose();
		this.windowGame.setEnabled(true);
	}

	/**
	 * Allow to heal the player when he click on the button heal
	 * @param potion The potion to used 
	 */
	public void heal(Potion potion) {
		// If the player has already all these life point
		if(this.theGame.getPlayer().getHealth() == this.theGame.getPlayer().getNbMaxHealth())
			new WindowDisplayMessage("You already have your whole life",this.windowGame);
		else {
			this.theGame.getPlayer().heal(potion);
			this.windowGame.checkItem();
			this.windowGame.setCharac();
			this.dispose();
			this.windowGame.setEnabled(true);
		}
			
	}
}
