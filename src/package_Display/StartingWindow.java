package package_Display;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import the_Manor.Game;

public class StartingWindow extends JFrame{
	
	final int WIDTH_WINDOW = 684;
	final int LENGTH_WINDOW = 536;
	private JLabel theManorBackground;
	private JButton start, tutorial, quit;
	private Game newGame;
	
	public StartingWindow(){
		this.setLayout(new BorderLayout());
		this.setTitle(" The  Manor ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// The label with the background 
		this.theManorBackground = new JLabel(new ImageIcon("src/package_Display/Image/fond.png"));
		this.theManorBackground.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		// Buttons 
		this.start = new JButton("Start");
		this.start.addActionListener(new Actions(this,"createPlayer"));
		this.tutorial = new JButton("Titorial");
		this.quit = new JButton("Quit");
		
		//Adding the buttons to the label 
		theManorBackground.add(start);
		theManorBackground.add(tutorial);
		theManorBackground.add(quit);
		
		
		// Window settings
		this.add(theManorBackground, BorderLayout.CENTER);
		this.setSize(WIDTH_WINDOW, LENGTH_WINDOW);;
		this.setVisible(true);
		this.setResizable(false);
	}
	/**
	 * Allows to create the player before starting a new game
	 * @param name
	 * @param description
	 */
	public void createPlayer (String name, String description){
		this.dispose();
		new WindowCreatePlayer(this); // récupère les deux JTextField
	}
	
	public void recupInfo (ArrayList<String> nosInfos){
		new Window(nosInfos.get(0),nosInfos.get(1));
	}
	
	
	public static void main(String[] args) {
		new StartingWindow();
	}
	
	
}
