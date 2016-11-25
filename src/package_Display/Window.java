package package_Display;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.*;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac.IntegrityHmacSHA512;

import the_Manor.Game;

public class Window extends JFrame{
	
	final int WIDTH_WINDOW = 850;
	final int LENGTH_WINDOW = (WIDTH_WINDOW*86)/100;
	private JLabel iconeEpee;
	private JLabel iconeBouclier;
	private JLabel iconePotion;
	private JLabel iconeClef;
	private JLabel windowGame;
	private JLabel lifePoint;
	private JLabel staminaPoint;
	private JLabel attackPoint;
	private JLabel defensePoint;
	
	private Game newGame;
	
	
	public Window(){
		this.newGame = new Game();
		this.setTitle("The_Manor    Player : "+this.newGame.getPlayer().getName()+"    Room : "+this.newGame.getPlayer().getCurrentRoom().getName());
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel objectAndGame = new JPanel();
		objectAndGame.setLayout(new BorderLayout());
		JPanel playerObject = new JPanel();
		playerObject.setLayout(new GridLayout(4,1));
		playerObject.setPreferredSize(new Dimension((WIDTH_WINDOW*14)/100,0));
		
		
		// Les différents icones d'objet
		iconeEpee = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Epee.png").getImage().getScaledInstance((WIDTH_WINDOW*11)/100, (WIDTH_WINDOW*11)/100, Image.SCALE_DEFAULT)));
		iconeBouclier = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Bouclier.png").getImage().getScaledInstance((WIDTH_WINDOW*11)/100, (WIDTH_WINDOW*11)/100, Image.SCALE_DEFAULT)));
		iconePotion = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Potion.png").getImage().getScaledInstance((WIDTH_WINDOW*11)/100, (WIDTH_WINDOW*11)/100, Image.SCALE_DEFAULT)));
		iconeClef = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Clef.png").getImage().getScaledInstance((WIDTH_WINDOW*11)/100, (WIDTH_WINDOW*11)/100, Image.SCALE_DEFAULT)));
		
		
		
		playerObject.setBackground(Color.black);
		playerObject.add(iconeEpee);
		playerObject.add(iconeBouclier);
		playerObject.add(iconePotion);
		playerObject.add(iconeClef);
		iconeEpee.setVisible(false);
		iconeBouclier.setVisible(false);
		iconePotion.setVisible(false);
		iconeClef.setVisible(false);
		
		
		// Notre image "THE MANOR"
		windowGame = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/fond.png").getImage().getScaledInstance((WIDTH_WINDOW*87)/100, (LENGTH_WINDOW*84)/100, Image.SCALE_DEFAULT)));
		
		
		
		objectAndGame.add(playerObject,BorderLayout.WEST);
		objectAndGame.add(windowGame,BorderLayout.CENTER);
		
		JPanel characAndControl = new JPanel();
		characAndControl.setLayout(new BoxLayout(characAndControl, BoxLayout.X_AXIS));
		
		JPanel control = new JPanel();
		control.setLayout(new GridLayout(1,3));
		JPanel controlHorizontal = new JPanel();
		controlHorizontal.setLayout(new GridLayout(2,1));
		JButton controlHaut = new JButton(new ImageIcon(new ImageIcon("src/package_Display/Image/direction_haut.png").getImage().getScaledInstance((WIDTH_WINDOW*5)/100, (WIDTH_WINDOW*5)/100, Image.SCALE_DEFAULT)));
		JButton controlBas = new JButton(new ImageIcon(new ImageIcon("src/package_Display/Image/direction_bas.png").getImage().getScaledInstance((WIDTH_WINDOW*5)/100, (WIDTH_WINDOW*5)/100, Image.SCALE_DEFAULT)));
		JButton controlGauche = new JButton((new ImageIcon(new ImageIcon("src/package_Display/Image/direction_gauche.png").getImage().getScaledInstance((WIDTH_WINDOW*5)/100, (WIDTH_WINDOW*5)/100, Image.SCALE_DEFAULT))));
		JButton controlDroit = new JButton(new ImageIcon(new ImageIcon("src/package_Display/Image/direction_droite.png").getImage().getScaledInstance((WIDTH_WINDOW*5)/100, (WIDTH_WINDOW*5)/100, Image.SCALE_DEFAULT)));
		controlHaut.setBackground(Color.BLACK);
		controlHaut.addActionListener(new ActionListener (){
            public void actionPerformed (ActionEvent e){
            	String nameRoom = Window.this.newGame.goNord();
            	Window.this.windowGame.setIcon(new ImageIcon(new ImageIcon("src/package_Display/Image/"+Window.this.newGame.getPlayer().getCurrentRoom().getBackground()).getImage().getScaledInstance((Window.this.WIDTH_WINDOW*87)/100, (Window.this.LENGTH_WINDOW*84)/100, Image.SCALE_DEFAULT)));
            	Window.this.setTitle("The_Manor    Player : "+Window.this.newGame.getPlayer().getName()+"    Room : "+Window.this.newGame.getPlayer().getCurrentRoom().getName());
            }	
        });
		controlBas.setBackground(Color.BLACK);
		controlBas.addActionListener(new ActionListener (){
            public void actionPerformed (ActionEvent e){
            	Window.this.newGame.goSud();
            	Window.this.windowGame.setIcon(new ImageIcon(new ImageIcon("src/package_Display/Image/"+Window.this.newGame.getPlayer().getCurrentRoom().getBackground()).getImage().getScaledInstance((Window.this.WIDTH_WINDOW*87)/100, (Window.this.LENGTH_WINDOW*84)/100, Image.SCALE_DEFAULT)));
            	Window.this.setTitle("The_Manor    Player : "+Window.this.newGame.getPlayer().getName()+"    Room : "+Window.this.newGame.getPlayer().getCurrentRoom().getName());
            }	
        });
		controlGauche.setBackground(Color.BLACK);
		controlGauche.addActionListener(new ActionListener (){
            public void actionPerformed (ActionEvent e){
            	Window.this.newGame.goOuest();
            	Window.this.windowGame.setIcon(new ImageIcon(new ImageIcon("src/package_Display/Image/"+Window.this.newGame.getPlayer().getCurrentRoom().getBackground()).getImage().getScaledInstance((Window.this.WIDTH_WINDOW*87)/100, (Window.this.LENGTH_WINDOW*84)/100, Image.SCALE_DEFAULT)));
            	Window.this.setTitle("The_Manor    Player : "+Window.this.newGame.getPlayer().getName()+"    Room : "+Window.this.newGame.getPlayer().getCurrentRoom().getName());
            }	
        });
		controlDroit.setBackground(Color.BLACK);
		controlDroit.addActionListener(new ActionListener (){
            public void actionPerformed (ActionEvent e){
            	Window.this.newGame.goEst();
            	Window.this.windowGame.setIcon(new ImageIcon(new ImageIcon("src/package_Display/Image/"+Window.this.newGame.getPlayer().getCurrentRoom().getBackground()).getImage().getScaledInstance((Window.this.WIDTH_WINDOW*87)/100, (Window.this.LENGTH_WINDOW*84)/100, Image.SCALE_DEFAULT)));
            	Window.this.setTitle("The_Manor    Player : "+Window.this.newGame.getPlayer().getName()+"    Room : "+Window.this.newGame.getPlayer().getCurrentRoom().getName());
            }	
        });
		controlHorizontal.add(controlHaut);
		controlHorizontal.add(controlBas);
		control.add(controlGauche);
		control.add(controlHorizontal);
		control.add(controlDroit);
		
		
		JPanel charac = new JPanel();
		charac.setLayout(new BorderLayout(20,20));
		charac.setBackground(Color.black);
		charac.setPreferredSize(new Dimension((WIDTH_WINDOW*80)/100, 60));
		JButton search = new JButton(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Loupe.png").getImage().getScaledInstance((WIDTH_WINDOW*10)/100, (WIDTH_WINDOW*10)/100, Image.SCALE_DEFAULT)));
		search.setBackground(Color.BLACK);
		search.setPreferredSize(new Dimension((WIDTH_WINDOW*14)/100, 0));
		search.setBorder(null);
		search.addActionListener(new ActionListener (){
            public void actionPerformed (ActionEvent e){
            	if(Window.this.iconeEpee.isVisible()){
            		Window.this.iconeEpee.setVisible(false);
	            	Window.this.iconeBouclier.setVisible(false);
	            	Window.this.iconePotion.setVisible(false);
	            	Window.this.iconeClef.setVisible(false);
            	}
            	else{
            		Window.this.iconeEpee.setVisible(true);
	            	Window.this.iconeBouclier.setVisible(true);
	            	Window.this.iconePotion.setVisible(true);
	            	Window.this.iconeClef.setVisible(true);
            	}
            }	
        });
		charac.add(search,BorderLayout.WEST);
		charac.add(Box.createGlue());
		
		JPanel durability = new JPanel();
		durability.setLayout(new GridLayout(2,1));
		durability.setBackground(Color.BLACK);
		lifePoint = new JLabel("PV   "+Integer.toString(this.newGame.getPlayer().getHealth())+" / "+Integer.toString(this.newGame.getPlayer().getNbMaxHealth()));
		lifePoint.setForeground(Color.RED);
		
		staminaPoint = new JLabel("STAMINA   "+Integer.toString(this.newGame.getPlayer().getStamina())+" / "+Integer.toString(this.newGame.getPlayer().getNbMaxStamina()));
		staminaPoint.setForeground(Color.GREEN);
		
		JPanel characteristics = new JPanel();
		characteristics.setLayout(new GridLayout(2,1));
		characteristics.setBackground(Color.BLACK);
		attackPoint = new JLabel("ATTACK   "+Integer.toString(this.newGame.getPlayer().getAttack())+"          ");
		attackPoint.setForeground(Color.BLUE);
		defensePoint = new JLabel("DEFENSE   "+Integer.toString(this.newGame.getPlayer().getDefense())+"          ");
		defensePoint.setForeground(Color.BLUE);
		
		characteristics.add(attackPoint);
		characteristics.add(defensePoint);
		
		durability.add(lifePoint);
		durability.add(staminaPoint);
		charac.add(durability,BorderLayout.CENTER);
		charac.add(characteristics,BorderLayout.EAST);
		
		
		characAndControl.setBackground(Color.black);
		characAndControl.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		characAndControl.add(charac);
		characAndControl.add(control);
		this.add(objectAndGame,BorderLayout.CENTER);
		this.add(characAndControl,BorderLayout.SOUTH);
		this.setSize(WIDTH_WINDOW, LENGTH_WINDOW);
		this.setResizable(false);
		this.setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		Window w = new Window();
	}
}
