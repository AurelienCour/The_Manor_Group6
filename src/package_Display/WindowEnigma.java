package package_Display;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

/**
 * The window to display an enigma with the Jtextfield to recup the response of the player
 * @author Group6
 *
 */
public class WindowEnigma extends JFrame {
	
	/**
	 * The serial ID for the version of the 5/12/2016
	 */
	private static final long serialVersionUID = 5122016L;
	private JFormattedTextField jTextf; // To recup the response of the player
	private Window windowGame; // The game window to center the frame
	private String directionDoor; // The direction of the door
	
	/**
	 * The constructor of the class WindowEnigma
	 * @param windowGame The window of the game
	 * @param Enigma The enigma to display on the window
	 * @param directionDoor The direction of the door
	 */
	public WindowEnigma(Window windowGame,String Enigma, String directionDoor){
		this.windowGame = windowGame;
		this.windowGame.setEnabled(false);
		this.directionDoor = directionDoor;
		this.setTitle("Enigmatic Door");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBackground(Color.white);
		this.setUndecorated(true);
		this.requestFocusInWindow();
		this.setLayout(new BorderLayout());
		
		// The JTextField with his label
		jTextf = new JFormattedTextField();
		JLabel enigma = new JLabel("<html><body align=\"center\"><font color=\"red\">Enigma</font><br/><br/>"+Enigma+"</body>");
		jTextf.setPreferredSize(new Dimension(150, 30));
		
		// The button to validate the response
		JButton validate = new JButton("Validate");
		validate.setFocusPainted(false);
		JPanel responseAndButton = new JPanel();
		
		// Assign the font to the label
		try{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font font = Font.createFont(Font.TRUETYPE_FONT,this.getClass().getResourceAsStream("Font/feast_of_flesh_bb/FEASFBI_.TTF"));
			ge.registerFont(font);
			font = font.deriveFont(Font.TRUETYPE_FONT,20);
			enigma.setFont(font);
			validate.setFont(font);
			jTextf.setFont(font);
		}
		catch(IOException e){
		}catch(FontFormatException e){          
		}catch(IllegalArgumentException e){
		}
		
		validate.addActionListener(new Actions(this,"enigma"));
		responseAndButton.setLayout(new BorderLayout());
		responseAndButton.add(jTextf,BorderLayout.CENTER);
		responseAndButton.add(validate,BorderLayout.EAST);
		this.add(enigma,BorderLayout.CENTER);
		this.add(responseAndButton,BorderLayout.SOUTH);
		this.setSize(new Dimension(300,250));
		this.setResizable(false);
		this.setVisible(true); 
		this.setLocationRelativeTo(this.windowGame);
	}
	
	/**
	 * Allow to recup the response in the JTextField
	 */
	public void recupResponse(){
		this.windowGame.setEnabled(true);
		this.dispose();
		this.windowGame.verifResponse(this.jTextf.getText(), this.directionDoor);
	}
}