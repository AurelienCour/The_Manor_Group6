package package_Display;

import java.awt.*;
import javax.swing.*;

public class Window extends JFrame{
	public Window(){
		this.setTitle("The_Manor");
		this.setLayout(new BorderLayout());
		
		
		JPanel playerObject = new JPanel();
		playerObject.setLayout(new GridLayout(4,1));
		JLabel iconeEpee = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Epee.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		JLabel iconeBouclier = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Bouclier.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		JLabel iconePotion = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Potion.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		JLabel iconeClef = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Icone_Clef.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
		playerObject.setBackground(Color.black);
		playerObject.add(iconeEpee);
		playerObject.add(iconeBouclier);
		playerObject.add(iconePotion);
		playerObject.add(iconeClef);
		
		JLabel windowGame = new JLabel(new ImageIcon("src/package_Display/Image/fond.png"));
		
		this.add(playerObject,BorderLayout.WEST);
		this.add(windowGame,BorderLayout.CENTER);
		this.setSize(600, 500);
		this.setResizable(false);
		this.setVisible(true);
//		// Ma fenetre
//        JFrame myFrame = new JFrame("Calculator");
//        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        myFrame.setLayout(new BorderLayout());
//        myFrame.setResizable(false); // Empeche le redimenssionement
//        
//        JLabel myScreen; // Mon ecran
//        myScreen = new JLabel("0");
//        myScreen.setFont(new Font("Serif", Font.PLAIN, 20)); // Change la taille de la police
//        myScreen.setHorizontalAlignment(JLabel.RIGHT); // Aligne le texte a droite
//
//        // Premiere ligne d'option
//        JPanel myOption = new JPanel();
//        myOption.setLayout(new GridLayout(1,0));
//        myOption.add(new JButton("m+"));
//        myOption.add(new JButton("m-"));
//        myOption.add(new JButton("mc"));
//        myOption.add(new JButton("mr"));
//        myOption.add(new JButton("/"));
//
//        // Numero
//        JPanel myNumber = new JPanel();
//        myNumber.setLayout(new GridLayout(4,3,3,3));
//        JButton test = new JButton("7");
//        test.setPreferredSize(new Dimension(64, 40));
//        myNumber.add(test);
//        myNumber.add(new JButton("8"));
//        myNumber.add(new JButton("9"));
//        myNumber.add(new JButton("4"));
//        myNumber.add(new JButton("5"));
//        myNumber.add(new JButton("6"));
//        myNumber.add(new JButton("1"));
//        myNumber.add(new JButton("2"));
//        myNumber.add(new JButton("3"));
//        myNumber.add(new JButton("0"));
//        myNumber.add(new JButton(","));
//        myNumber.add(new JButton("C"));
//
//        // Ligne d'option a droite
//        JPanel operation1 = new JPanel();
//        operation1.setLayout(new GridLayout(0,1));
//        operation1.add(new JButton("*"));
//        operation1.add(new JButton("-"));
//        operation1.add(new JButton("+"));
//        JPanel myOperation = new JPanel();
//        myOperation.setLayout(new GridLayout(0,1));
//        myOperation.add(operation1);
//        myOperation.add(new JButton("="));
//        
//        // Numero et option de droite
//        JPanel bodyCalculator = new JPanel();
//        bodyCalculator.setLayout(new BoxLayout(bodyCalculator,BoxLayout.X_AXIS));
//        bodyCalculator.add(myNumber);
//        bodyCalculator.add(myOperation);
//        
//        myFrame.add(myScreen,BorderLayout.NORTH);
//        myFrame.add(myOption,BorderLayout.CENTER);
//        myFrame.add(bodyCalculator,BorderLayout.SOUTH);
//
//        myFrame.pack();
//        myFrame.setVisible(true);
	}
}
