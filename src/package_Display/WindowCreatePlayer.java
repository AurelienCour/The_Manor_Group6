package package_Display;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

/**
 * The window to recup the informations about the player (name and description)
 * @author Group6
 *
 */
public class WindowCreatePlayer extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5122016L;
	private JFormattedTextField playerName; // The field to recup the name of the player
	private JFormattedTextField descriptionPlayer; // The field to recup the description of the player
	private StartingWindow windowOrigin; // The previous window to center the frame
	
	/**
	 * The constructor of the class WindowCreatePlayer
	 * @param windowOrigin The previous window
	 */
	public WindowCreatePlayer(StartingWindow windowOrigin){
		this.windowOrigin = windowOrigin;
		this.setTitle("Create a player");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		this.setUndecorated(true);
		this.requestFocusInWindow();
		// The Panel to recup the date
		JPanel seizure = new JPanel();
		seizure.setLayout(new GridLayout(1,2));
		seizure.setBackground(Color.BLACK);
		// The label before the textField
		JPanel label = new JPanel();
		label.setLayout(new GridLayout(2,1));
		JLabel labelName = new JLabel(" Name : ");
		labelName.setForeground(Color.WHITE);
		JLabel labelDescription = new JLabel(" Description : ");
		labelDescription.setForeground(Color.WHITE);
		label.add(labelName);
		label.add(labelDescription);
		label.setOpaque(false);
		
		// The text fields
		JPanel jText = new JPanel();
		jText.setLayout(new GridLayout(2,1));
		playerName = new JFormattedTextField();
		playerName.setBackground(Color.BLACK);
		playerName.setForeground(Color.WHITE);
		descriptionPlayer = new JFormattedTextField();
		descriptionPlayer.setBackground(Color.BLACK);
		descriptionPlayer.setForeground(Color.WHITE);
		jText.add(playerName);
		jText.add(descriptionPlayer);
		jText.setOpaque(false);
		
		seizure.add(label);
		seizure.add(jText);
		// The button to validate the seizure
		JButton validate = new JButton("Validate");
		validate.addActionListener(new Actions(this,"infoPlayer"));
		validate.setBackground(Color.BLACK);
		validate.setForeground(Color.RED);
		
		try{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font font = Font.createFont(Font.TRUETYPE_FONT,this.getClass().getResourceAsStream("Font/feast_of_flesh_bb/FEASFBI_.TTF"));
			ge.registerFont(font);
			font = font.deriveFont(Font.TRUETYPE_FONT,25);
			validate.setFont(font);
			playerName.setFont(font);
			descriptionPlayer.setFont(font);
			labelName.setFont(font);
			labelDescription.setFont(font);
		}
		catch(IOException e){
		}catch(FontFormatException e){          
		}catch(IllegalArgumentException e){
		}
		
		this.add(seizure,BorderLayout.CENTER);
		this.add(validate,BorderLayout.SOUTH);
		this.pack();
		this.setResizable(false);
		this.setVisible(true); 
		this.setLocationRelativeTo(this.windowOrigin);
	}
	
	public void recupInfo(){
		this.dispose();
		ArrayList<String> infoPlayer = new ArrayList<String>();
		infoPlayer.add(playerName.getText());
		infoPlayer.add(descriptionPlayer.getText());
		windowOrigin.recupInfo(infoPlayer);
	}
}
