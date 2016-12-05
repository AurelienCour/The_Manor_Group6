package package_Display;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import the_Manor.Ally;
import the_Manor.Player;

public class WindowDisplayAlly extends JFrame {
	
	private Ally ally;
	private Window windowGame;
	private Player player;

	public WindowDisplayAlly (Ally ally, Window windowGame,Player player) {
		this.ally = ally;
		this.player = player;
		this.windowGame = windowGame;
		this.windowGame.setEnabled(false);
		this.requestFocusInWindow();
		this.setBackground(Color.white);
		this.setUndecorated(true);
		this.setLayout(new BorderLayout());
		JLabel allyLabel = new JLabel("<html><body><br/><div align=\"center\"><font color=\"red\">"+this.ally.getDescription()+" : "+this.ally.getName()+"</font></div>"+this.ally.getMessage()+"</body>");
		JButton validate = new JButton("Validate");
		validate.setFocusPainted(false);
		validate.addActionListener(new Actions(this,"messageAlly"));
		try{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font font = Font.createFont(Font.TRUETYPE_FONT,this.getClass().getResourceAsStream("Font/friday13/Friday13v12.ttf"));
			ge.registerFont(font);
			font = font.deriveFont(Font.TRUETYPE_FONT,18);
			allyLabel.setFont(font);
			validate.setFont(font);
		}
		catch(IOException e){
		}catch(FontFormatException e){          
		}catch(IllegalArgumentException e){
		}
		this.add(allyLabel,BorderLayout.CENTER);
		this.add(validate,BorderLayout.SOUTH);
		this.setSize(new Dimension(600,450));
		this.setResizable(false);
		this.setVisible(true); 
		this.setLocationRelativeTo(this.windowGame);
	}

	public void message() {
		this.dispose();
		if(this.ally.haveItem()){
			new WindowDisplayMessage(this.ally.getName()+" give you "+this.ally.getItem().getName(), this.windowGame);
			this.ally.giveItem(this.player);
		}
		else
			this.windowGame.setEnabled(true);
	}

}
