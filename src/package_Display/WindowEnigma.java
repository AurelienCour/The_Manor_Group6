package package_Display;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class WindowEnigma extends JFrame {
	private JFormattedTextField jTextf;
	private Window windowGame;
	private String directionDoor;
	
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
		jTextf = new JFormattedTextField();
		JLabel enigma = new JLabel("<html><body align=\"center\"><font color=\"red\">Enigma</font><br/><br/>"+Enigma+"</body>");
		jTextf.setPreferredSize(new Dimension(150, 30));
		JPanel responseAndButton = new JPanel();
		JButton validate = new JButton("Validate");
		validate.setFocusPainted(false);
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
	
	public String getDirection(){
		return this.directionDoor;
	}
	
	public void recupResponse(){
		this.windowGame.setEnabled(true);
		this.dispose();
		this.windowGame.verifResponse(this.jTextf.getText(), this.directionDoor);
	}
}