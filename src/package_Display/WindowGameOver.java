package package_Display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class WindowGameOver extends JFrame{

	public WindowGameOver (){
		this.setLayout(new BorderLayout());
		this.setTitle("Game Over");
		this.setUndecorated(true);
		this.setBackground(Color.BLACK);
		JLabel gameOver = new JLabel("Game Over");
		gameOver.setOpaque(false);
		gameOver.setForeground(Color.RED);
		
		try{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font font = Font.createFont(Font.TRUETYPE_FONT,new File("src/package_Display/Font/blood_lust/BloodLust.ttf"));
			ge.registerFont(font);
			font = font.deriveFont(Font.TRUETYPE_FONT,60);
			gameOver.setFont(font);
		}
		catch(IOException e){
		}catch(FontFormatException e){          
		}catch(IllegalArgumentException e){
		}
		this.add(gameOver);
		this.setVisible(true);
		this.setSize(900, 900);
	}
}
