package package_Display;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import package_Display.Window;
import the_Manor.Game;

public class StartingWindow extends JFrame{
	
	final int WIDTH_WINDOW = 800;
	final int LENGTH_WINDOW = (WIDTH_WINDOW*86)/100;
	private JLabel theManorBackground;
	
	public StartingWindow(){
		this.setLayout(new BorderLayout());
		this.setTitle(" The  Manor ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// The label with the background 
		this.theManorBackground = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/fond.png").getImage().getScaledInstance(this.WIDTH_WINDOW, this.LENGTH_WINDOW, Image.SCALE_DEFAULT)));
		this.theManorBackground.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		// Buttons 
		JButton start = new JButton("Start");
		start.addActionListener(new Actions(this,"createPlayer"));
		JButton tutorial = new JButton("Tutorial");
		JButton quit = new JButton("Quit");
		quit.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				System.exit(0);
            }
		});
		
		//Adding the buttons to the label 
		theManorBackground.add(start);
		theManorBackground.add(tutorial);
		theManorBackground.add(quit);
		
		
		// Window settings
		this.add(theManorBackground, BorderLayout.CENTER);
		this.setSize(WIDTH_WINDOW, LENGTH_WINDOW);;
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	/**
	 * Allows to create the player before starting a new game
	 * @param name
	 * @param description
	 */
	public void createPlayer (){
		new WindowCreatePlayer(this); // récupère les deux JTextField
	}
	
	public void recupInfo (ArrayList<String> nosInfos){
		new Window(nosInfos.get(0),nosInfos.get(1));
		this.dispose();
	}
	
	
	public static void main(String[] args) {
		new StartingWindow();
	}
	
	
}
