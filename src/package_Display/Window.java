package package_Display;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;

import the_Manor.Ally;
import the_Manor.Game;
import the_Manor.Key;

/**
 * The class of the main window of the game
 * @author Group 6
 *
 */
public class Window extends JFrame{
	
	final int WIDTH_WINDOW =850; // The width of the window
	final int HEIGHT_WINDOW = (WIDTH_WINDOW*86)/100; // the height of the window
	private JLabel iconSword; // The icon if the player equips a sword
	private JLabel iconShield; // The icon if the player equips a shield 
	private JLabel iconPotion; // The icon if the player has a potion
	private JLabel iconKey; // The icon if the player has a key
	private JLabel windowGame; // The window where the background is display
	private JLabel lifePoint; // The label for the life point of the player
	private JLabel staminaPoint; // The label for the stamina point of the player
	private JLabel attackPoint; // The label for the attack point of the player
	private JLabel defensePoint; // The label for the defense point of the player
	private JButton controlHaut,controlBas,controlGauche,controlDroit; // All the control buttons
	private Game newGame; // The game
	
	/**
	 * The constructor of the class Window
	 * @param name The name of the player
	 * @param description The description of the player
	 */
	public Window(String name, String description){
		newGame = new Game(this,name,description);
		this.setTitle("The_Manor    Player : "+this.newGame.getPlayer().getName()+"    Room : "+this.newGame.getPlayer().getCurrentRoom().getName());
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Icon of the objects and the background
		JPanel objectAndGame = new JPanel();
		objectAndGame.setLayout(new BorderLayout());
		// All the icons for the objects
		JPanel playerObject = new JPanel();
		playerObject.setLayout(new GridLayout(4,1));
		playerObject.setPreferredSize(new Dimension((WIDTH_WINDOW*14)/100,0));
		
		// The different icon
		// Create the URL to recup the icon
		URL url = StartingWindow.class.getResource("Image/Icon/Icone_Epee.png");
		// declare the icon
		ImageIcon icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance((WIDTH_WINDOW*11)/100, (WIDTH_WINDOW*11)/100, Image.SCALE_DEFAULT));
		// affect the icon
		iconSword = new JLabel(icon);
		url = StartingWindow.class.getResource("Image/Icon/Icone_Bouclier.png");
		icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance((WIDTH_WINDOW*11)/100, (WIDTH_WINDOW*11)/100, Image.SCALE_DEFAULT));
		iconShield = new JLabel(icon);
		url = StartingWindow.class.getResource("Image/Icon/Icone_Potion.png");
		icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance((WIDTH_WINDOW*11)/100, (WIDTH_WINDOW*11)/100, Image.SCALE_DEFAULT));
		iconPotion = new JLabel(icon);
		// Allow to heal the player with the icon of the potion if the player has a potion
		iconPotion.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				if(Window.this.newGame.getPlayer().havePotion()){
					if(Window.this.newGame.getPlayer().getHealth() != Window.this.newGame.getPlayer().getNbMaxHealth()){
						Window.this.newGame.getPlayer().heal(Window.this.newGame.getPlayer().getPotion());
						Window.this.checkItem();
						Window.this.setCharac();
					}
					else
						new WindowDisplayMessage("You already have your whole life",Window.this);
				}
				else	
					new WindowDisplayMessage("You need food to take care of yourself",Window.this);
			}
		});
		url = StartingWindow.class.getResource("Image/Icon/Icone_Clef.png");
		icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance((WIDTH_WINDOW*11)/100, (WIDTH_WINDOW*11)/100, Image.SCALE_DEFAULT));
		iconKey = new JLabel(icon);
		
		// Add the icon to the panel
		playerObject.setBackground(Color.black);
		playerObject.add(this.iconSword);
		playerObject.add(this.iconShield);
		playerObject.add(this.iconPotion);
		playerObject.add(this.iconKey);
		iconSword.setVisible(false);
		iconShield.setVisible(false);
		iconPotion.setVisible(false);
		iconKey.setVisible(false);
		
		// Initializes the background with the current room of the player
		url = StartingWindow.class.getResource("Image/Background/"+newGame.getPlayer().getCurrentRoom().getBackground());
		icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance((WIDTH_WINDOW*87)/100, (HEIGHT_WINDOW*84)/100, Image.SCALE_DEFAULT));
		windowGame = new JLabel(icon);
		// Add the icon and the background to the panel
		objectAndGame.add(playerObject,BorderLayout.WEST);
		objectAndGame.add(this.windowGame,BorderLayout.CENTER);
		
		//The panel for the conrols button, the characteristics and the buttons search and inventory
		JPanel characAndControl = new JPanel();
		characAndControl.setLayout(new BoxLayout(characAndControl, BoxLayout.X_AXIS));
		// The panel for the control buttons
		JPanel control = new JPanel();
		control.setLayout(new GridLayout(1,3));
		control.setPreferredSize(new Dimension((WIDTH_WINDOW*22)/100, (HEIGHT_WINDOW*16)/100));
		JPanel controlHorizontal = new JPanel();
		controlHorizontal.setLayout(new GridLayout(2,1));
		url = StartingWindow.class.getResource("Image/Icon/direction_haut.png");
		icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance((WIDTH_WINDOW*5)/100, (WIDTH_WINDOW*5)/100, Image.SCALE_DEFAULT));
		controlHaut = new JButton(icon);
		controlHaut.setBackground(Color.BLACK);
		controlHaut.addActionListener(new Actions(this,"controlHaut"));
		controlHaut.setFocusPainted(false);
		url = StartingWindow.class.getResource("Image/Icon/direction_bas.png");
		icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance((WIDTH_WINDOW*5)/100, (WIDTH_WINDOW*5)/100, Image.SCALE_DEFAULT));
		controlBas = new JButton(icon);
		controlBas.setBackground(Color.BLACK);
		controlBas.addActionListener(new Actions(this,"controlBas"));
		controlBas.setFocusPainted(false);
		url = StartingWindow.class.getResource("Image/Icon/direction_gauche.png");
		icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance((WIDTH_WINDOW*5)/100, (WIDTH_WINDOW*5)/100, Image.SCALE_DEFAULT));
		controlGauche = new JButton(icon);
		controlGauche.setBackground(Color.BLACK);
		controlGauche.addActionListener(new Actions(this,"controlGauche"));
		controlGauche.setFocusPainted(false);
		url = StartingWindow.class.getResource("Image/Icon/direction_droite.png");
		icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance((WIDTH_WINDOW*5)/100, (WIDTH_WINDOW*5)/100, Image.SCALE_DEFAULT));
		controlDroit = new JButton(icon);
		controlDroit.setBackground(Color.BLACK);
		controlDroit.addActionListener(new Actions(this,"controlDroit"));
		controlDroit.setFocusPainted(false);
		controlHorizontal.add(controlHaut);
		controlHorizontal.add(controlBas);
		control.add(controlGauche);
		control.add(controlHorizontal);
		control.add(controlDroit);
		
		// The characteristics panel
		JPanel charac = new JPanel();
		charac.setLayout(new BorderLayout(5,5));//20,20
		charac.setBackground(Color.black);
		url = StartingWindow.class.getResource("Image/Icon/Icone_Loupe.png");
		icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance((WIDTH_WINDOW*10)/100, (WIDTH_WINDOW*10)/100, Image.SCALE_DEFAULT));
		// The buttons to search in the room
		JButton search = new JButton(icon);
		search.setBackground(Color.BLACK);
		search.setPreferredSize(new Dimension((WIDTH_WINDOW*14)/100, 0));
		search.setBorder(null);
		search.addActionListener(new Actions(this,"search"));
		search.setFocusPainted(false);
		charac.add(search,BorderLayout.WEST);
		// The characteristics of the player (life and stamina)
		JPanel durability = new JPanel();
		durability.setLayout(new GridLayout(2,1,4,4));
		durability.setBackground(Color.BLACK);
		Font police = new Font("Serif", Font.PLAIN, (WIDTH_WINDOW*2)/100);
		lifePoint = new JLabel("LP   "+newGame.getPlayer().getHealth()+" / "+newGame.getPlayer().getNbMaxHealth());
		lifePoint.setForeground(Color.RED);
		lifePoint.setFont(police);
		staminaPoint = new JLabel("STAMINA   "+newGame.getPlayer().getStamina()+" / "+newGame.getPlayer().getNbMaxStamina());
		staminaPoint.setForeground(Color.GREEN);
		staminaPoint.setFont(police);
		// The other characteristics (attack and defense)
		JPanel characteristics = new JPanel();
		characteristics.setLayout(new GridLayout(2,1));
		characteristics.setBackground(Color.BLACK);
		attackPoint = new JLabel("ATTACK   "+newGame.getPlayer().getAttack()+"  ");
		attackPoint.setForeground(Color.BLUE);
		attackPoint.setFont(police);
		defensePoint = new JLabel("DEFENSE   "+newGame.getPlayer().getDefense()+"  ");
		defensePoint.setForeground(Color.BLUE);
		defensePoint.setFont(police);		
		characteristics.add(this.attackPoint);
		characteristics.add(this.defensePoint);
		durability.add(this.lifePoint);
		durability.add(this.staminaPoint);
		url = StartingWindow.class.getResource("Image/Icon/Icone_inventaire.png");
		icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance((WIDTH_WINDOW*10)/100, (WIDTH_WINDOW*10)/100, Image.SCALE_DEFAULT));
		JButton inventory = new JButton(icon);
		inventory.setBackground(Color.BLACK);
		inventory.setFocusPainted(false);
		inventory.setBorder(null);
		inventory.setFocusPainted(false);
		// Open the inventory when the player click on the bag
		inventory.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				new WindowInventory(Window.this.newGame,Window.this);
            }
		});
		
		// Assign the font to the label
		try{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font font = Font.createFont(Font.TRUETYPE_FONT,this.getClass().getResourceAsStream("Font/feast_of_flesh_bb/FEASFBI_.TTF"));
			ge.registerFont(font);
			font = font.deriveFont(Font.TRUETYPE_FONT,20);
			lifePoint.setFont(font);
			staminaPoint.setFont(font);
			attackPoint.setFont(font);
			defensePoint.setFont(font);
		}
		catch(IOException e){
		}catch(FontFormatException e){          
		}catch(IllegalArgumentException e){
		}

		// Add the element to the JFrame
		charac.add(durability,BorderLayout.CENTER);
		charac.add(characteristics,BorderLayout.EAST);
		characAndControl.setBackground(Color.black);
		characAndControl.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		characAndControl.add(charac);
		characAndControl.add(inventory);
		characAndControl.add(control);
		this.add(objectAndGame,BorderLayout.CENTER);
		this.add(characAndControl,BorderLayout.SOUTH);
		this.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		// Chek the possible direction of the room
		checkDirection();
	}
	
	/**
	 * Allows to move in the game when the player click on the arrow
	 * @param idMove The direction of the move
	 */
	public void gameMove (String idMove){
		switch (idMove) {
			case "controlDroit":
				this.newGame.move("EST");
				break;
			case "controlGauche" :
				this.newGame.move("OUEST");
				break;
			case "controlHaut":
				this.newGame.move("NORD");
				break;
			case "controlBas":
				this.newGame.move("SUD");
				break;
			default:
				break;
		}
		if(newGame.getPlayer().getCurrentRoom().getName().equals("Victory"))
			new WindowGameOver(this);
		else{
		// Change the background
		URL url = StartingWindow.class.getResource("Image/Background/"+this.newGame.getPlayer().getCurrentRoom().getBackground());
		ImageIcon icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance((WIDTH_WINDOW*87)/100, (HEIGHT_WINDOW*84)/100, Image.SCALE_DEFAULT));
    	this.windowGame.setIcon(icon);
    	// Change the title of the JFrame
    	this.setTitle("The_Manor    Player : "+this.newGame.getPlayer().getName()+"    Room : "+this.newGame.getPlayer().getCurrentRoom().getName());
    	checkDirection();
		}
	}
	
	/**
	 * Allows to search in a room
	 */
	public void gameSearch(){
		String name = this.newGame.search();
		if(name.isEmpty())
			new WindowDisplayMessage("There is nothing in the room",this);
		else
			new WindowDisplayMessage("You found : "+name, this);
		checkItem();
	}
	
	/**
	 * Check if a player have an item and display the icon
	 */
	public void checkItem(){
		if(this.newGame.getPlayer().haveAnyKey())
			this.iconKey.setVisible(true);
		else
			this.iconKey.setVisible(false);
		if(this.newGame.getPlayer().havePotion())
			this.iconPotion.setVisible(true);
		else
			this.iconPotion.setVisible(false);
		if(this.newGame.getPlayer().haveShield())
			this.iconShield.setVisible(true);
		else
			this.iconShield.setVisible(false);
		if(this.newGame.getPlayer().haveWeapon())
			this.iconSword.setVisible(true);
		else
			this.iconSword.setVisible(false);
		// Change the value with the item equiped
		this.attackPoint.setText("ATTACK   "+this.newGame.getPlayer().getAttack()+"  ");
		this.defensePoint.setText("DEFENSE   "+this.newGame.getPlayer().getDefense()+"  ");
	}
	
	/**
	 * Allow to create the window to recup the response of the user
	 * @param enigma The enigma to open the door
	 * @param direction The direction of the door in the room
	 */
	public void enigmaticMove(String enigma,String direction){
		new WindowEnigma(this,enigma,direction);
	}
	
	/**
	 * If the response of the enigma is good display a message
	 * If the response of the enigma is false display an other message
	 * @param response The response of the users
	 * @param direction The direction of the door in the room
	 */
	public void verifResponse(String response,String direction){
		if(!this.newGame.verifyResponseForEnigma(response,direction))
			new WindowDisplayMessage("The response is incorrect", this);
		else
			new WindowDisplayMessage("The door is unlocked", this);	
	}
	
	/**
	 * Chek if the room is locked or not and display a message
	 * @param lock A boolean to know if the door is locked
	 * @param key The key to unlock the door
	 */
	public void lockDoor (boolean lock, Key key){
		checkItem();
		if(lock)
			new WindowDisplayMessage("The door is locked you need the : "+key.getName(), this);	
		else
			new WindowDisplayMessage("The door is unlocked, you used your "+key.getName(), this);
		
	}
	
	/**
	 * Check if the player can go in a specific direction
	 * to enable the good arrow
	 */
	private void checkDirection(){
		if(this.newGame.getPlayer().getCurrentRoom().getDoor("OUEST") == null)
			this.controlGauche.setEnabled(false);
		else
			this.controlGauche.setEnabled(true);
		if(this.newGame.getPlayer().getCurrentRoom().getDoor("EST") == null)
			this.controlDroit.setEnabled(false);
		else
			this.controlDroit.setEnabled(true);
		if(this.newGame.getPlayer().getCurrentRoom().getDoor("NORD") == null)
			this.controlHaut.setEnabled(false);
		else
			this.controlHaut.setEnabled(true);
		if(this.newGame.getPlayer().getCurrentRoom().getDoor("SUD") == null)
			this.controlBas.setEnabled(false);
		else
			this.controlBas.setEnabled(true);
	}
	
	/**
	 * Allows to change the durability of the player with the new value
	 */
	public void setCharac(){
		this.lifePoint.setText("LP   "+this.newGame.getPlayer().getHealth()+" / "+this.newGame.getPlayer().getNbMaxHealth());
		this.staminaPoint.setText("STAMINA   "+this.newGame.getPlayer().getStamina()+" / "+this.newGame.getPlayer().getNbMaxStamina());
	}
	
	/**
	 * If an ally is in the room, display the window for the dialog
	 * @param ally
	 */
	public void ally(Ally ally) {
		new WindowDisplayAlly(ally, this, this.newGame.getPlayer());
		
	}
	
	/**
	 * The main methods of the game
	 * @param args
	 */
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new MetalLookAndFeel());
					new StartingWindow();
				} catch (UnsupportedLookAndFeelException e) {
					throw new RuntimeException(e);
				}
			}
		
		});
	}
}
