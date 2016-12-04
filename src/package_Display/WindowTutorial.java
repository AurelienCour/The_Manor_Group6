package package_Display;

import java.awt.BorderLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.*;

public class WindowTutorial extends JFrame{

	final int WIDTH_WINDOW =1000;
	final int HEIGHT_WINDOW = (WIDTH_WINDOW*75)/100;
	
	public WindowTutorial (){
		this.setLayout(new BorderLayout());
		this.setTitle(" The  tutorial ");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		URL url = StartingWindow.class.getResource("Image/Background/Tutorial.png");
		ImageIcon icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(WIDTH_WINDOW, HEIGHT_WINDOW, Image.SCALE_DEFAULT));
		JLabel tutoriel = new JLabel(icon);
		this.add(tutoriel);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
		this.setLocationRelativeTo(null);
	}
}
