package package_Display;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

/**
 * A window to display a message
 * @author Group6
 *
 */
public class WindowDisplayMessage extends JFrame {
	
	/**
	 * The serial ID for the version of the 5/12/2016
	 */
	private static final long serialVersionUID = 5122016L;
	private Window window; // The window of the game
	
	/**
	 * The constructor of the class WindowDisplayMessage
	 * @param message The message to display
	 * @param window The window of the game to center the message
	 */
	public WindowDisplayMessage(String message, Window window){
		this.window = window;
		this.window.setEnabled(false);
		this.setTitle("Message Box");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBackground(Color.GRAY);
		this.setUndecorated(true);
		this.requestFocusInWindow();
		this.setLayout(new BorderLayout(4,4));

		// The label with the message
		JLabel mess = new JLabel("   "+message+"   ");
		mess.setHorizontalAlignment(JLabel.CENTER);
		
		// The button to close the frame
		JButton validate = new JButton("OK");
		validate.setFocusPainted(false);
		validate.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				WindowDisplayMessage.this.dispose();
				WindowDisplayMessage.this.window.setEnabled(true);
            }
		});
		
		// Assign the font to the label
		try{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font font = Font.createFont(Font.TRUETYPE_FONT,this.getClass().getResourceAsStream("Font/feast_of_flesh_bb/FEASFBI_.TTF"));
			ge.registerFont(font);
			font = font.deriveFont(Font.TRUETYPE_FONT,20);
			validate.setFont(font);
			mess.setFont(font);
		}
		catch(IOException e){
		}catch(FontFormatException e){          
		}catch(IllegalArgumentException e){
		}
		
		
		this.add(mess,BorderLayout.CENTER);
		this.add(validate, BorderLayout.SOUTH);
		this.setVisible(true); 
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(null);
	}
}
