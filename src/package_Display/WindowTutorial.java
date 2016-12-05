package package_Display;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class WindowTutorial extends JFrame{

	/**
	 * The serial ID for the version of the 5/12/2016
	 */
	private static final long serialVersionUID = 5122016L;
	final int WIDTH_WINDOW =1000;
	final int HEIGHT_WINDOW = (WIDTH_WINDOW*73)/100;
	
	public WindowTutorial (){
		this.setLayout(new BorderLayout());
		this.setTitle(" The  tutorial ");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		URL url = StartingWindow.class.getResource("Image/Background/Tutorial.jpg");
		ImageIcon icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(WIDTH_WINDOW, HEIGHT_WINDOW, Image.SCALE_DEFAULT));
		JLabel tutoriel = new JLabel(icon);
		this.add(tutoriel);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
		this.setLocationRelativeTo(null);
	}
}
