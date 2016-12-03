package package_Display;

import java.awt.*;
import javax.swing.*;

public class WindowEnigma extends JFrame {
	private JFormattedTextField jTextf;
	private Window windowGame;
	private String directionDoor;
	
	public WindowEnigma(Window windowGame,String Enigma, String directionDoor){
		this.windowGame = windowGame;
		this.directionDoor = directionDoor;
		this.setTitle("Enigmatic Door");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		jTextf = new JFormattedTextField();
		Font police = new Font("Serif", Font.PLAIN, 14);
		JTextArea enigma = new JTextArea("Enigma :\n"+Enigma);
		enigma.setColumns(30);
		enigma.setLineWrap(true);
		enigma.setRows((Enigma.length()/30)+1);
		enigma.setWrapStyleWord(true);
		enigma.setLineWrap(true);
		enigma.setEditable(false);
		enigma.setFont(police);
		jTextf.setFont(police);
		jTextf.setPreferredSize(new Dimension(150, 30));
		JPanel responseAndButton = new JPanel();
		JButton validate = new JButton("Validate");
		validate.addActionListener(new Actions(this,"enigma"));
		responseAndButton.setLayout(new BorderLayout());
		responseAndButton.add(jTextf,BorderLayout.CENTER);
		responseAndButton.add(validate,BorderLayout.EAST);
		this.add(enigma,BorderLayout.CENTER);
		this.add(responseAndButton,BorderLayout.SOUTH);
		this.pack();
		this.setResizable(false);
		this.setVisible(true); 
		this.setLocationRelativeTo(this.windowGame);
	}
	
	public String getDirection(){
		return this.directionDoor;
	}
	
	public void recupResponse(){
		this.dispose();
		this.windowGame.verifResponse(this.jTextf.getText(), this.directionDoor);
	}
}