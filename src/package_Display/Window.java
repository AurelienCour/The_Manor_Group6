package package_Display;

import java.awt.*;
import javax.swing.*;

public class Window extends JFrame{
	public Window(){
		this.setTitle("The_Manor");
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel objectAndGame = new JPanel();
		objectAndGame.setLayout(new BorderLayout());
		JPanel playerObject = new JPanel();
		playerObject.setLayout(new GridLayout(4,1));
		playerObject.setPreferredSize(new Dimension(100, 50));
		JLabel iconeEpee = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Epee.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		JLabel iconeBouclier = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Bouclier.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		JLabel iconePotion = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Potion.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		JLabel iconeClef = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Clef.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		iconeEpee.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		iconeBouclier.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		iconePotion.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		iconeClef.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		playerObject.setBackground(Color.black);
		playerObject.add(iconeEpee);
		playerObject.add(iconeBouclier);
		playerObject.add(iconePotion);
		playerObject.add(iconeClef);
		JLabel windowGame = new JLabel(new ImageIcon("src/package_Display/Image/fond.png"));
		objectAndGame.add(playerObject,BorderLayout.WEST);
		objectAndGame.add(windowGame,BorderLayout.CENTER);
		
		JPanel characAndControl = new JPanel();
		characAndControl.setLayout(new BoxLayout(characAndControl, BoxLayout.X_AXIS));
		
		JPanel control = new JPanel();
		control.setLayout(new GridLayout(1,3));
		
		JPanel controlHorizontal = new JPanel();
		controlHorizontal.setLayout(new GridLayout(2,1));
		controlHorizontal.add(new JButton(new ImageIcon(new ImageIcon("src/package_Display/Image/direction_haut.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT))));
		controlHorizontal.add(new JButton(new ImageIcon(new ImageIcon("src/package_Display/Image/direction_bas.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT))));
		control.add(new JButton(new ImageIcon(new ImageIcon("src/package_Display/Image/direction_gauche.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT))));
		control.add(controlHorizontal);
		control.add(new JButton(new ImageIcon(new ImageIcon("src/package_Display/Image/direction_droite.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT))));
		
		JLabel charac = new JLabel("LES CHARACTERISTIQUES");
		charac.setPreferredSize(new Dimension(400, 60));
		charac.setForeground(Color.WHITE);
		charac.setHorizontalAlignment(JLabel.CENTER);
		characAndControl.setBackground(Color.black);
		characAndControl.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		characAndControl.add(charac);
		characAndControl.add(control);
		this.add(objectAndGame,BorderLayout.CENTER);
		this.add(characAndControl,BorderLayout.SOUTH);
		this.setSize(700, 650);
		this.setResizable(false);
		this.setVisible(true);
	}
}
