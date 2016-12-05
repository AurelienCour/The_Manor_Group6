package package_Display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class WindowDisplayMessage extends JFrame {
	/**
	 * The constructor of the class WindowDisplayMessage
	 * @param message The message to display
	 * @param window 
	 * @param win The window to center the message
	 */
	private Window window;
	public WindowDisplayMessage(String message, Window window){
		this.window = window;
		this.window.setEnabled(false);
		this.setTitle("Message Box");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBackground(Color.GRAY);
		this.setUndecorated(true);
		this.requestFocusInWindow();
		this.setLayout(new BorderLayout(4,4));
		Font police = new Font("Serif", Font.BOLD, 14);
		JLabel mess = new JLabel("   "+message+"   ");
		mess.setHorizontalAlignment(JLabel.CENTER);
		mess.setFont(police);
		JButton validate = new JButton("OK");
		validate.setFocusPainted(false);
		validate.setFont(police);
		validate.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				WindowDisplayMessage.this.dispose();
				WindowDisplayMessage.this.window.setEnabled(true);
            }
		});
		
		try{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font font = Font.createFont(Font.TRUETYPE_FONT,this.getClass().getResourceAsStream("Font/feast_of_flesh_bb/FEASFBI_.TTF"));
			ge.registerFont(font);
			font = font.deriveFont(Font.TRUETYPE_FONT,20);
			validate.setFont(font);
			mess.setFont(font);
			validate.setFont(font);
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
