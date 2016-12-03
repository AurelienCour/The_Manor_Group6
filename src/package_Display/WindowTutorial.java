package package_Display;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.*;

public class WindowTutorial extends JFrame{

	final int WIDTH_WINDOW =950;
	final int HEIGHT_WINDOW = (WIDTH_WINDOW*75)/100;
	
	public WindowTutorial (){
		this.setLayout(new BorderLayout());
		this.setTitle(" The  tutorial ");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel tutoriel = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Background/Tutorial.png").getImage().getScaledInstance(WIDTH_WINDOW, HEIGHT_WINDOW, Image.SCALE_DEFAULT)));
		this.add(tutoriel);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
		this.setLocationRelativeTo(null);
	}
}
