package package_Display;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

/**
 * The window with the picture of the tutorial
 * 
 * @author Group6
 * @version 06/12/16
 */
public class WindowTutorial extends JFrame{

	/**
	 * The serial ID for the version of the 5/12/2016
	 */
	private static final long serialVersionUID = 5122016L;
	final int WIDTH_WINDOW =1000; // The width of the window
	final int HEIGHT_WINDOW = (WIDTH_WINDOW*73)/100; // The height of the window
	
	/**
	 * The constructor of the class WindowTutorial
	 */
	public WindowTutorial (){
		this.setLayout(new BorderLayout());
		this.setTitle(" The  tutorial ");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// Gets back the icon of the background
		URL url = StartingWindow.class.getResource("Image/Background/Tutorial.png");
		ImageIcon icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(WIDTH_WINDOW, HEIGHT_WINDOW, Image.SCALE_DEFAULT));
		
		// Assign the icon to the label
		JLabel tutoriel = new JLabel(icon);
		this.add(tutoriel);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
		this.setLocationRelativeTo(null);
	}
}
