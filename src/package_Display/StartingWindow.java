package package_Display;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;
import package_Display.Window;

/**
 *  The first window when the game is launched
 * @author Group6
 *
 */
public class StartingWindow extends JFrame{
	
	/**
	 * The serial ID for the version of the 5/12/2016
	 */
	private static final long serialVersionUID = 5122016L;
	final int WIDTH_WINDOW = 800; // The width of the window
	final int HEIGHT_WINDOW = (WIDTH_WINDOW*86)/100; // The height of the window
	private JLabel theManorBackground; // The label with the background
	
	/**
	 * The constructor of the class StartingWindow
	 */
	public StartingWindow(){
		this.setLayout(new BorderLayout());
		this.setTitle(" The  Manor ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		
		// The label with the background 
		URL url = StartingWindow.class.getResource("Image/Background/fond.png");
		ImageIcon icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(WIDTH_WINDOW, HEIGHT_WINDOW, Image.SCALE_DEFAULT));
		theManorBackground = new JLabel(icon);
		theManorBackground.setLayout(new BorderLayout());
		
		// The button start
		JButton start = new JButton("Start");
		start.addActionListener(new Actions(this,"createPlayer"));
		start.setForeground(Color.WHITE);
		start.setBackground(Color.BLACK);
		start.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		start.setPreferredSize(new Dimension(90,40));
		start.setFocusPainted(false);
		
		// The button tutorial
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
		
		// The button Quit
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
		
		// Set the font of the label
		try{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font font = Font.createFont(Font.TRUETYPE_FONT,this.getClass().getResourceAsStream("Font/feast_of_flesh_bb/FEASFBI_.TTF"));
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
		this.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);;
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * Allows to create the player before starting a new game
	 */
	public void createPlayer (){
		new WindowCreatePlayer(this); // récupère les deux JTextField
	}
	
	/**
	 * Allows to recup the data enter by the player and create the object Window with these data
	 * @param nosInfos All the data enter by the player
	 */
	public void recupInfo (ArrayList<String> nosInfos){
		new Window(nosInfos.get(0),nosInfos.get(1));
		this.dispose();
	}
	
	
}
