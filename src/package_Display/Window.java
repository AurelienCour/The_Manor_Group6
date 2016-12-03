package package_Display;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import the_Manor.Enemy;
import the_Manor.Fight;
import the_Manor.Game;
import the_Manor.Player;

public class Window extends JFrame{
	
	final int WIDTH_WINDOW =800;
	final int HEIGHT_WINDOW = (WIDTH_WINDOW*86)/100;
	private JLabel iconeEpee;
	private JLabel iconeBouclier;
	private JLabel iconePotion;
	private JLabel iconeClef;
	private JLabel windowGame;
	private JLabel lifePoint;
	private JLabel staminaPoint;
	private JLabel attackPoint;
	private JLabel defensePoint;
	private JButton controlHaut,controlBas,controlGauche,controlDroit;
	private Game newGame;
	
	
	public Window(String name, String description){
		newGame = new Game(this,name,description);
		this.setTitle("The_Manor    Player : "+this.newGame.getPlayer().getName()+"    Room : "+this.newGame.getPlayer().getCurrentRoom().getName());
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel objectAndGame = new JPanel();
		objectAndGame.setLayout(new BorderLayout());
		JPanel playerObject = new JPanel();
		playerObject.setLayout(new GridLayout(4,1));
		playerObject.setPreferredSize(new Dimension((WIDTH_WINDOW*14)/100,0));
		
		// Les différents icones d'objet
		iconeEpee = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icon/Icone_Epee.png").getImage().getScaledInstance((WIDTH_WINDOW*11)/100, (WIDTH_WINDOW*11)/100, Image.SCALE_DEFAULT)));
		iconeBouclier = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icon/Icone_Bouclier.png").getImage().getScaledInstance((WIDTH_WINDOW*11)/100, (WIDTH_WINDOW*11)/100, Image.SCALE_DEFAULT)));
		iconePotion = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icon/Icone_Potion.png").getImage().getScaledInstance((WIDTH_WINDOW*11)/100, (WIDTH_WINDOW*11)/100, Image.SCALE_DEFAULT)));
		iconeClef = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icon/Icone_Clef.png").getImage().getScaledInstance((WIDTH_WINDOW*11)/100, (WIDTH_WINDOW*11)/100, Image.SCALE_DEFAULT)));
		
		playerObject.setBackground(Color.black);
		playerObject.add(this.iconeEpee);
		playerObject.add(this.iconeBouclier);
		playerObject.add(this.iconePotion);
		playerObject.add(this.iconeClef);
		iconeEpee.setVisible(false);
		iconeBouclier.setVisible(false);
		iconePotion.setVisible(false);
		iconeClef.setVisible(false);
		
		// Notre image "THE MANOR"
		windowGame = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Background/"+newGame.getPlayer().getCurrentRoom().getBackground()).getImage().getScaledInstance((WIDTH_WINDOW*87)/100, (HEIGHT_WINDOW*84)/100, Image.SCALE_DEFAULT)));
		
		objectAndGame.add(playerObject,BorderLayout.WEST);
		objectAndGame.add(this.windowGame,BorderLayout.CENTER);
		
		JPanel characAndControl = new JPanel();
		characAndControl.setLayout(new BoxLayout(characAndControl, BoxLayout.X_AXIS));
		
		JPanel control = new JPanel();
		control.setLayout(new GridLayout(1,3));
		control.setPreferredSize(new Dimension((WIDTH_WINDOW*22)/100, (HEIGHT_WINDOW*16)/100));
		JPanel controlHorizontal = new JPanel();
		controlHorizontal.setLayout(new GridLayout(2,1));
		controlHaut = new JButton(new ImageIcon(new ImageIcon("src/package_Display/Image/Icon/direction_haut.png").getImage().getScaledInstance((WIDTH_WINDOW*5)/100, (WIDTH_WINDOW*5)/100, Image.SCALE_DEFAULT)));
		controlBas = new JButton(new ImageIcon(new ImageIcon("src/package_Display/Image/Icon/direction_bas.png").getImage().getScaledInstance((WIDTH_WINDOW*5)/100, (WIDTH_WINDOW*5)/100, Image.SCALE_DEFAULT)));
		controlGauche = new JButton((new ImageIcon(new ImageIcon("src/package_Display/Image/Icon/direction_gauche.png").getImage().getScaledInstance((WIDTH_WINDOW*5)/100, (WIDTH_WINDOW*5)/100, Image.SCALE_DEFAULT))));
		controlDroit = new JButton(new ImageIcon(new ImageIcon("src/package_Display/Image/Icon/direction_droite.png").getImage().getScaledInstance((WIDTH_WINDOW*5)/100, (WIDTH_WINDOW*5)/100, Image.SCALE_DEFAULT)));
		controlHaut.setBackground(Color.BLACK);
		controlHaut.addActionListener(new Actions(this,"controlHaut"));
		controlHaut.setFocusPainted(false);
		controlBas.setBackground(Color.BLACK);
		controlBas.addActionListener(new Actions(this,"controlBas"));
		controlBas.setFocusPainted(false);
		controlGauche.setBackground(Color.BLACK);
		controlGauche.addActionListener(new Actions(this,"controlGauche"));
		controlGauche.setFocusPainted(false);
		controlDroit.setBackground(Color.BLACK);
		controlDroit.addActionListener(new Actions(this,"controlDroit"));
		controlDroit.setFocusPainted(false);
		controlHorizontal.add(controlHaut);
		controlHorizontal.add(controlBas);
		control.add(controlGauche);
		control.add(controlHorizontal);
		control.add(controlDroit);
		JPanel charac = new JPanel();
		charac.setLayout(new BorderLayout(5,5));//20,20
		charac.setBackground(Color.black);
		
		JButton search = new JButton(new ImageIcon(new ImageIcon("src/package_Display/Image/Icon/Icone_Loupe.png").getImage().getScaledInstance((WIDTH_WINDOW*10)/100, (WIDTH_WINDOW*10)/100, Image.SCALE_DEFAULT)));
		search.setBackground(Color.BLACK);
		search.setPreferredSize(new Dimension((WIDTH_WINDOW*14)/100, 0));
		search.setBorder(null);
		search.addActionListener(new Actions(this,"search"));
		search.setFocusPainted(false);
		
		charac.add(search,BorderLayout.WEST);
		JPanel durability = new JPanel();
		durability.setLayout(new GridLayout(2,1,4,4));
		durability.setBackground(Color.BLACK);
		Font police = new Font("Serif", Font.PLAIN, (WIDTH_WINDOW*2)/100);
		lifePoint = new JLabel("PV   "+newGame.getPlayer().getHealth()+" / "+newGame.getPlayer().getNbMaxHealth());
		lifePoint.setForeground(Color.RED);
		lifePoint.setFont(police);
		staminaPoint = new JLabel("STAMINA   "+newGame.getPlayer().getStamina()+" / "+newGame.getPlayer().getNbMaxStamina());
		staminaPoint.setForeground(Color.GREEN);
		staminaPoint.setFont(police);
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
		JButton inventory = new JButton(new ImageIcon(new ImageIcon("src/package_Display/Image/Icon/Icone_inventaire.png").getImage().getScaledInstance((WIDTH_WINDOW*10)/100, (WIDTH_WINDOW*10)/100, Image.SCALE_DEFAULT)));
		inventory.setBackground(Color.BLACK);
		inventory.setFocusPainted(false);
		inventory.setBorder(null);
		inventory.setFocusPainted(false);
		inventory.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				new WindowInventory(Window.this.newGame,Window.this);
            }
		});
		
		try{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font font = Font.createFont(Font.TRUETYPE_FONT,new File("src/package_Display/Font/feast_of_flesh_bb/FEASFBI_.TTF"));
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
		checkDirection();
	}
	
	/**
	 * Allows to move in the game
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
    	this.windowGame.setIcon(new ImageIcon(new ImageIcon("src/package_Display/Image/Background/"+newGame.getPlayer().getCurrentRoom().getBackground()).getImage().getScaledInstance((WIDTH_WINDOW*87)/100, (HEIGHT_WINDOW*84)/100, Image.SCALE_DEFAULT)));
    	this.setTitle("The_Manor    Player : "+this.newGame.getPlayer().getName()+"    Room : "+this.newGame.getPlayer().getCurrentRoom().getName());
    	checkDirection();
	}
	
	/**
	 * Allows to search
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
	 * Check if a player have an item
	 */
	public void checkItem(){
		if(this.newGame.getPlayer().haveKey())
			this.iconeClef.setVisible(true);
		else
			this.iconeClef.setVisible(false);
		if(this.newGame.getPlayer().havePotion())
			this.iconePotion.setVisible(true);
		else
			this.iconePotion.setVisible(false);
		if(this.newGame.getPlayer().haveShield())
			this.iconeBouclier.setVisible(true);
		else
			this.iconeBouclier.setVisible(false);
		if(this.newGame.getPlayer().haveWeapon())
			this.iconeEpee.setVisible(true);
		else
			this.iconeEpee.setVisible(false);
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
	 * If the response of the enigma is false display a message
	 * @param response The response of the users
	 * @param direction The direction of the door in the room
	 */
	public void verifResponse(String response,String direction){
		if(!this.newGame.verifyResponseForEnigma(response,direction))
			new WindowDisplayMessage("The response is incorrect", this);
		else
			new WindowDisplayMessage("The door is unlocked", this);	
	}
	
	public void lockDoor (boolean locked){
		checkItem();
		if(locked)
			new WindowDisplayMessage("The door is locked you need a key", this);	
		else
			new WindowDisplayMessage("The door is unlocked", this);
		
	}
	
	/**
	 * Check if the player can go in a specific direction
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
	
	public void setCharac(){
		this.lifePoint.setText("PV   "+this.newGame.getPlayer().getHealth()+" / "+this.newGame.getPlayer().getNbMaxHealth());
		this.staminaPoint.setText("STAMINA   "+this.newGame.getPlayer().getStamina()+" / "+this.newGame.getPlayer().getNbMaxStamina());
	}
	
	public static void main(String[] args){
		new StartingWindow();
		//new WindowGameOver(new Window("", ""));
		//Fight f = new Fight(new Player("Paul", ""),new Enemy("Zombie", "", 60, 60, 50, 5));
		//new WindowFight(f,new Window("",""), null);
	}
}
