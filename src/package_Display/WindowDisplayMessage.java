package package_Display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class WindowDisplayMessage extends JFrame {
	/**
	 * The constructor of the class WindowDisplayMessage
	 * @param message The message to display
	 * @param win The window to center the message
	 */
	public WindowDisplayMessage(String message){
		this.setTitle("Message Box");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBackground(Color.GRAY);
		this.setUndecorated(true);
		this.setLayout(new BorderLayout());
		Font police = new Font("Serif", Font.BOLD, 14);
		JLabel mess = new JLabel(message);
		mess.setHorizontalAlignment(JLabel.CENTER);
		mess.setFont(police);
		JButton validate = new JButton("OK");
		validate.setFont(police);
		validate.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				WindowDisplayMessage.this.dispose();
            }
		});
		this.add(mess,BorderLayout.CENTER);
		this.add(validate, BorderLayout.SOUTH);
		this.setVisible(true); 
		this.setResizable(false);
		this.setSize(250, 100);
		this.setLocationRelativeTo(null);
	}
}
