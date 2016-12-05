package package_Display;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import javax.swing.*;

public class WindowEnd extends JFrame{

	/**
	 * The serial ID for the version of the 5/12/2016
	 */
	private static final long serialVersionUID = 5122016L;
	final int WIDTH_WINDOW = 850; // The width of the window
	final int HEIGHT_WINDOW = (WIDTH_WINDOW*86)/100; // The height of the window
	
	public WindowEnd (Window windowGame, String imageFinish){
		windowGame.dispose();
		this.setTitle("Game Over");
		this.setLayout(new BorderLayout());
		this.setUndecorated(true);
		JPanel test = new JPanel();
		test.setBackground(Color.BLACK);
		test.setLayout(new BorderLayout());
		URL url = StartingWindow.class.getResource("Image/Background/"+imageFinish);
		ImageIcon icon = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(WIDTH_WINDOW, HEIGHT_WINDOW, Image.SCALE_DEFAULT));
		JLabel gameOver = new JLabel(icon);
		gameOver.setLayout(new FlowLayout());
		
		JButton quit = new JButton("Quit");
		quit.setPreferredSize(new Dimension(90,40));
		quit.setBackground(Color.BLACK);
		quit.setForeground(Color.WHITE);
		quit.setFocusPainted(false);
		quit.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				WindowEnd.this.dispose();
				new StartingWindow();
            }
		});
		gameOver.add(quit);
		try{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font font = Font.createFont(Font.TRUETYPE_FONT,this.getClass().getResourceAsStream("Font/feast_of_flesh_bb/FEASFBI_.TTF"));
			ge.registerFont(font);
			font = font.deriveFont(Font.TRUETYPE_FONT,30);
			quit.setFont(font);
		}
		catch(IOException e){
		}catch(FontFormatException e){          
		}catch(IllegalArgumentException e){
		}
		test.add(gameOver);
		this.add(test,BorderLayout.CENTER);
		this.setVisible(true);
		this.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
		this.setLocationRelativeTo(null);
	}
}