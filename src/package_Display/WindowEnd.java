package package_Display;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import javax.swing.*;

/**
 * The window when the player loose or win the game
 * 
 * @author Group 6
 * @version 06/12/16
 */
public class WindowEnd extends JFrame{

	/**
	 * The serial ID for the version of the 5/12/2016
	 */
	private static final long serialVersionUID = 5122016L;
	final int WIDTH_WINDOW = 850; // The width of the window
	final int HEIGHT_WINDOW = (WIDTH_WINDOW*86)/100; // The height of the window
	
	/**
	 * The constructor of the class WindowEnd
	 * @param windowGame The window of the game
	 * @param imageFinish The name of the image to display
	 */
	public WindowEnd (Window windowGame, String imageFinish){
		windowGame.dispose();
		this.setTitle("END");
		this.setLayout(new BorderLayout());
		this.setUndecorated(true);
		
		// The button to quit the game
		JButton quit = new JButton("Quit");
		quit.setPreferredSize(new Dimension(90,40));
		quit.setBackground(Color.BLACK);
		quit.setForeground(Color.WHITE);
		quit.setFocusPainted(false);
		quit.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				WindowEnd.this.dispose();
				new StartingWindow();
            }
		});
		
		// Gets back the icon for the background
		URL url = StartingWindow.class.getResource("Image/Background/"+imageFinish);
		ImageIcon icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(WIDTH_WINDOW, HEIGHT_WINDOW, Image.SCALE_DEFAULT));
		
		// The label for the background and the button
		JLabel image = new JLabel(icon);
		image.setLayout(new FlowLayout());
		image.add(quit);
		
		// Assign the font to the button
		try{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font font = Font.createFont(Font.TRUETYPE_FONT,this.getClass().getResourceAsStream("Font/feast_of_flesh_bb/FEASFBI_.TTF"));
			ge.registerFont(font);
			font = font.deriveFont(Font.TRUETYPE_FONT,30);
			quit.setFont(font);
		}
		catch(IOException e){
		}catch(FontFormatException e){          
		}catch(IllegalArgumentException e){
		}
		
		this.add(image);
		this.setVisible(true);
		this.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
		this.setLocationRelativeTo(null);
	}
}
