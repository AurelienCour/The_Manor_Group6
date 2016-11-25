package package_Display;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Window extends JFrame{
	
	private JLabel iconeEpee;
	private JLabel iconeBouclier;
	private JLabel iconePotion;
	private JLabel iconeClef;
	private JLabel windowGame;
	private JLabel lifePoint;
	private JLabel staminaPoint;
	
	
	public Window(){
		this.setTitle("The_Manor");
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel objectAndGame = new JPanel();
		objectAndGame.setLayout(new BorderLayout());
		JPanel playerObject = new JPanel();
		playerObject.setLayout(new GridLayout(4,1));
		playerObject.setPreferredSize(new Dimension(100, 50));
		
		
		// Les différents icones d'objet
		iconeEpee = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Epee.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		iconeBouclier = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Bouclier.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		iconePotion = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Potion.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		iconeClef = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Clef.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		
		
		
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
		windowGame = new JLabel(new ImageIcon("src/package_Display/Image/fond.png"));
		
		
		
		objectAndGame.add(playerObject,BorderLayout.WEST);
		objectAndGame.add(windowGame,BorderLayout.CENTER);
		
		JPanel characAndControl = new JPanel();
		characAndControl.setLayout(new BoxLayout(characAndControl, BoxLayout.X_AXIS));
		
		JPanel control = new JPanel();
		control.setLayout(new GridLayout(1,3));
		JPanel controlHorizontal = new JPanel();
		controlHorizontal.setLayout(new GridLayout(2,1));
		JButton controlHaut = new JButton(new ImageIcon(new ImageIcon("src/package_Display/Image/direction_haut.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		JButton controlBas = new JButton(new ImageIcon(new ImageIcon("src/package_Display/Image/direction_bas.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		JButton controlGauche = new JButton((new ImageIcon(new ImageIcon("src/package_Display/Image/direction_gauche.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT))));
		JButton controlDroit = new JButton(new ImageIcon(new ImageIcon("src/package_Display/Image/direction_droite.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
		controlHaut.setBackground(Color.BLACK);
		
		controlBas.setBackground(Color.BLACK);
		controlGauche.setBackground(Color.BLACK);
		controlDroit.setBackground(Color.BLACK);
		controlHorizontal.add(controlHaut);
		controlHorizontal.add(controlBas);
		control.add(controlGauche);
		control.add(controlHorizontal);
		control.add(controlDroit);
		
		
		JPanel charac = new JPanel();
		charac.setLayout(new BorderLayout(30,30));
		charac.setBackground(Color.black);
		charac.setPreferredSize(new Dimension(500, 60));
		JButton search = new JButton(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Loupe.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT)));
		search.setBackground(Color.BLACK);
		search.setPreferredSize(new Dimension(99, 95));
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
		lifePoint = new JLabel("PV");
		lifePoint.setForeground(Color.RED);
		lifePoint.setBackground(Color.BLACK);
		
		staminaPoint = new JLabel("STAMINA");
		staminaPoint.setForeground(Color.GREEN);
		staminaPoint.setBackground(Color.GREEN);
		durability.add(lifePoint);
		durability.add(staminaPoint);
		charac.add(durability);
		
		
		characAndControl.setBackground(Color.black);
		characAndControl.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		characAndControl.add(charac);
		characAndControl.add(control);
		this.add(objectAndGame,BorderLayout.CENTER);
		this.add(characAndControl,BorderLayout.SOUTH);
		this.setSize(750, 650);
		this.setResizable(false);
		this.setVisible(true);
	}
}
