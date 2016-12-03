package package_Display;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import package_Display.Window;


public class StartingWindow extends JFrame{
	
	final int WIDTH_WINDOW = 800;
	final int LENGTH_WINDOW = (WIDTH_WINDOW*86)/100;
	private JLabel theManorBackground;
	
	public StartingWindow(){
		this.setLayout(new BorderLayout());
		this.setTitle(" The  Manor ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		// The label with the background 
		theManorBackground = new JLabel(new ImageIcon(new ImageIcon("src/package_Display/Image/Background/fond.png").getImage().getScaledInstance(WIDTH_WINDOW, LENGTH_WINDOW, Image.SCALE_DEFAULT)));
		theManorBackground.setLayout(new BorderLayout());
		//True Lies.ttf
		// Buttons 
		
		JButton start = new JButton("Start");
		start.addActionListener(new Actions(this,"createPlayer"));
		start.setForeground(Color.WHITE);
		start.setBackground(Color.BLACK);
		start.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		start.setPreferredSize(new Dimension(90,40));
		
		start.setFocusPainted(false);
		JButton tutorial = new JButton("Tutorial");
		tutorial.setForeground(Color.WHITE);
		tutorial.setBackground(Color.BLACK);
		tutorial.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		tutorial.setPreferredSize(new Dimension(90,40));
		tutorial.setFocusPainted(false);
		tutorial.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				new WindowTutorial();
            }
		});
		JButton quit = new JButton("Quit");
		quit.setForeground(Color.WHITE);
		quit.setBackground(Color.BLACK);
		quit.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		quit.setPreferredSize(new Dimension(90,40));
		
		quit.setFocusPainted(false);
		quit.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				System.exit(0);
            }
		});
		try{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font font = Font.createFont(Font.TRUETYPE_FONT,new File("src/package_Display/Font/feast_of_flesh_bb/FEASFBI_.TTF"));
			ge.registerFont(font);
			font = font.deriveFont(Font.TRUETYPE_FONT,25);
			start.setFont(font);
			tutorial.setFont(font);
			quit.setFont(font);
		}
		catch(IOException e){
		}catch(FontFormatException e){          
		}catch(IllegalArgumentException e){
		}
		JPanel boutons = new JPanel();
		boutons.setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
		boutons.setOpaque(false);
		boutons.add(start);
		boutons.add(tutorial);
		boutons.add(quit);
		//Adding the buttons to the label 
		theManorBackground.add(boutons, BorderLayout.CENTER);
		
		
		// Window settings
		this.add(theManorBackground);
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
	
	
}
