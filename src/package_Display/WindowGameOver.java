package package_Display;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class WindowGameOver extends JFrame{

	public WindowGameOver (Window windowGame){
		windowGame.dispose();
		this.setTitle("Game Over");
		this.setLayout(new BorderLayout());
		this.setUndecorated(true);
		JPanel test = new JPanel();
		test.setBackground(Color.BLACK);
		test.setLayout(new BorderLayout());
		JLabel gameOver = new JLabel("Game Over");
		gameOver.setLayout(new FlowLayout());
		gameOver.setOpaque(false);
		gameOver.setForeground(Color.RED);
		gameOver.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton quit = new JButton("Quit");
		quit.setPreferredSize(new Dimension(100,50));
		quit.setBackground(Color.BLACK);
		quit.setForeground(Color.WHITE);
		quit.setFocusPainted(false);
		quit.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				WindowGameOver.this.dispose();
				new StartingWindow();
            }
		});
		gameOver.add(quit);
		try{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font font = Font.createFont(Font.TRUETYPE_FONT,new File("src/package_Display/Font/blood_lust/BloodLust.ttf"));
			ge.registerFont(font);
			font = font.deriveFont(Font.TRUETYPE_FONT,150);
			gameOver.setFont(font);
			font = Font.createFont(Font.TRUETYPE_FONT,new File("src/package_Display/Font/feast_of_flesh_bb/FEASFBI_.TTF"));
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
		this.setSize(700, 700);
		this.setLocationRelativeTo(null);
	}
}
