package package_Display;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.*;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac.IntegrityHmacSHA512;

import the_Manor.Game;

public class Window extends JFrame{
	
	final int WIDTH_WINDOW =800;
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
	private JButton controlHaut,controlBas,controlGauche,controlDroit;
	
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
		this.iconeEpee = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Epee.png").getImage().getScaledInstance((WIDTH_WINDOW*11)/100, (WIDTH_WINDOW*11)/100, Image.SCALE_DEFAULT)));
		this.iconeBouclier = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Bouclier.png").getImage().getScaledInstance((WIDTH_WINDOW*11)/100, (WIDTH_WINDOW*11)/100, Image.SCALE_DEFAULT)));
		this.iconePotion = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Potion.png").getImage().getScaledInstance((WIDTH_WINDOW*11)/100, (WIDTH_WINDOW*11)/100, Image.SCALE_DEFAULT)));
		this.iconeClef = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Clef.png").getImage().getScaledInstance((WIDTH_WINDOW*11)/100, (WIDTH_WINDOW*11)/100, Image.SCALE_DEFAULT)));
		
		
		
		playerObject.setBackground(Color.black);
		playerObject.add(this.iconeEpee);
		playerObject.add(this.iconeBouclier);
		playerObject.add(this.iconePotion);
		playerObject.add(this.iconeClef);
		this.iconeEpee.setVisible(false);
		this.iconeBouclier.setVisible(false);
		this.iconePotion.setVisible(false);
		this.iconeClef.setVisible(false);
		
		
		// Notre image "THE MANOR"
		this.windowGame = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/"+Window.this.newGame.getPlayer().getCurrentRoom().getBackground()).getImage().getScaledInstance((Window.this.WIDTH_WINDOW*87)/100, (Window.this.LENGTH_WINDOW*84)/100, Image.SCALE_DEFAULT)));
		
		
		
		objectAndGame.add(playerObject,BorderLayout.WEST);
		objectAndGame.add(this.windowGame,BorderLayout.CENTER);
		
		JPanel characAndControl = new JPanel();
		characAndControl.setLayout(new BoxLayout(characAndControl, BoxLayout.X_AXIS));
		
		JPanel control = new JPanel();
		control.setLayout(new GridLayout(1,3));
		control.setPreferredSize(new Dimension((WIDTH_WINDOW*22)/100, (LENGTH_WINDOW*16)/100));
		JPanel controlHorizontal = new JPanel();
		controlHorizontal.setLayout(new GridLayout(2,1));
		this.controlHaut = new JButton(new ImageIcon(new ImageIcon("src/package_Display/Image/direction_haut.png").getImage().getScaledInstance((WIDTH_WINDOW*5)/100, (WIDTH_WINDOW*5)/100, Image.SCALE_DEFAULT)));
		this.controlBas = new JButton(new ImageIcon(new ImageIcon("src/package_Display/Image/direction_bas.png").getImage().getScaledInstance((WIDTH_WINDOW*5)/100, (WIDTH_WINDOW*5)/100, Image.SCALE_DEFAULT)));
		this.controlGauche = new JButton((new ImageIcon(new ImageIcon("src/package_Display/Image/direction_gauche.png").getImage().getScaledInstance((WIDTH_WINDOW*5)/100, (WIDTH_WINDOW*5)/100, Image.SCALE_DEFAULT))));
		this.controlDroit = new JButton(new ImageIcon(new ImageIcon("src/package_Display/Image/direction_droite.png").getImage().getScaledInstance((WIDTH_WINDOW*5)/100, (WIDTH_WINDOW*5)/100, Image.SCALE_DEFAULT)));
		controlHaut.setBackground(Color.BLACK);
		controlHaut.addActionListener(new ActionListener (){
            public void actionPerformed (ActionEvent e){
            	Window.this.newGame.move("NORD");
            	Window.this.windowGame.setIcon(new ImageIcon(new ImageIcon("src/package_Display/Image/"+Window.this.newGame.getPlayer().getCurrentRoom().getBackground()).getImage().getScaledInstance((Window.this.WIDTH_WINDOW*87)/100, (Window.this.LENGTH_WINDOW*84)/100, Image.SCALE_DEFAULT)));
            	Window.this.setTitle("The_Manor    Player : "+Window.this.newGame.getPlayer().getName()+"    Room : "+Window.this.newGame.getPlayer().getCurrentRoom().getName());
            	Window.this.checkDirection();
            }	
        });
		controlBas.setBackground(Color.BLACK);
		controlBas.addActionListener(new ActionListener (){
            public void actionPerformed (ActionEvent e){
            	Window.this.newGame.move("SUD");
            	Window.this.windowGame.setIcon(new ImageIcon(new ImageIcon("src/package_Display/Image/"+Window.this.newGame.getPlayer().getCurrentRoom().getBackground()).getImage().getScaledInstance((Window.this.WIDTH_WINDOW*87)/100, (Window.this.LENGTH_WINDOW*84)/100, Image.SCALE_DEFAULT)));
            	Window.this.setTitle("The_Manor    Player : "+Window.this.newGame.getPlayer().getName()+"    Room : "+Window.this.newGame.getPlayer().getCurrentRoom().getName());
            	Window.this.checkDirection();
            }	
        });
		controlGauche.setBackground(Color.BLACK);
		controlGauche.addActionListener(new ActionListener (){
            public void actionPerformed (ActionEvent e){
            	Window.this.newGame.move("OUEST");
            	Window.this.windowGame.setIcon(new ImageIcon(new ImageIcon("src/package_Display/Image/"+Window.this.newGame.getPlayer().getCurrentRoom().getBackground()).getImage().getScaledInstance((Window.this.WIDTH_WINDOW*87)/100, (Window.this.LENGTH_WINDOW*84)/100, Image.SCALE_DEFAULT)));
            	Window.this.setTitle("The_Manor    Player : "+Window.this.newGame.getPlayer().getName()+"    Room : "+Window.this.newGame.getPlayer().getCurrentRoom().getName());
            	Window.this.checkDirection();
            }	
        });
		controlDroit.setBackground(Color.BLACK);
		controlDroit.addActionListener(new ActionListener (){
            public void actionPerformed (ActionEvent e){
            	Window.this.newGame.move("EST");
            	Window.this.windowGame.setIcon(new ImageIcon(new ImageIcon("src/package_Display/Image/"+Window.this.newGame.getPlayer().getCurrentRoom().getBackground()).getImage().getScaledInstance((Window.this.WIDTH_WINDOW*87)/100, (Window.this.LENGTH_WINDOW*84)/100, Image.SCALE_DEFAULT)));
            	Window.this.setTitle("The_Manor    Player : "+Window.this.newGame.getPlayer().getName()+"    Room : "+Window.this.newGame.getPlayer().getCurrentRoom().getName());
            	Window.this.checkDirection();
            }	
        });
		controlHorizontal.add(this.controlHaut);
		controlHorizontal.add(this.controlBas);
		control.add(this.controlGauche);
		control.add(controlHorizontal);
		control.add(this.controlDroit);
		
		
		JPanel charac = new JPanel();
		charac.setLayout(new BorderLayout(5,5));//20,20
		charac.setBackground(Color.black);
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
		
		JPanel durability = new JPanel();
		durability.setLayout(new GridLayout(2,1));
		durability.setBackground(Color.BLACK);
		this.lifePoint = new JLabel("PV   "+Integer.toString(this.newGame.getPlayer().getHealth())+" / "+Integer.toString(this.newGame.getPlayer().getNbMaxHealth()));
		this.lifePoint.setForeground(Color.RED);
		this.lifePoint.setFont(new Font("Serif", Font.PLAIN, (WIDTH_WINDOW*2)/100));
		this.staminaPoint = new JLabel("STAMINA   "+Integer.toString(this.newGame.getPlayer().getStamina())+" / "+Integer.toString(this.newGame.getPlayer().getNbMaxStamina()));
		this.staminaPoint.setForeground(Color.GREEN);
		this.staminaPoint.setFont(new Font("Serif", Font.PLAIN, (WIDTH_WINDOW*2)/100));
		JPanel characteristics = new JPanel();
		characteristics.setLayout(new GridLayout(2,1));
		characteristics.setBackground(Color.BLACK);
		this.attackPoint = new JLabel("ATTACK   "+Integer.toString(this.newGame.getPlayer().getAttack())+"          ");
		this.attackPoint.setForeground(Color.BLUE);
		this.attackPoint.setFont(new Font("Serif", Font.PLAIN, (WIDTH_WINDOW*2)/100));
		this.defensePoint = new JLabel("DEFENSE   "+Integer.toString(this.newGame.getPlayer().getDefense())+"          ");
		this.defensePoint.setForeground(Color.BLUE);
		this.defensePoint.setFont(new Font("Serif", Font.PLAIN, (WIDTH_WINDOW*2)/100));
		
		characteristics.add(this.attackPoint);
		characteristics.add(this.defensePoint);
		
		durability.add(this.lifePoint);
		durability.add(this.staminaPoint);
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

		this.checkDirection();
	}
	
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
	
	public static void main(String[] args) {
		Window w = new Window();
	}
}
