package package_Display;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class WindowCreatePlayer extends JFrame {
	private JFormattedTextField nomPlayer;
	private JFormattedTextField descriptionPlayer;
	private StartingWindow windowOrigin;
	
	public WindowCreatePlayer(StartingWindow windowOrigin){
		this.windowOrigin = windowOrigin;
		this.setTitle("Create a player");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		this.setUndecorated(true);
		
		JPanel saisie = new JPanel();
		saisie.setLayout(new GridLayout(1,2));
		saisie.setBackground(Color.BLACK);
		
		JPanel label = new JPanel();
		label.setLayout(new GridLayout(2,1));
		JLabel labelNom = new JLabel("Name :");
		labelNom.setForeground(Color.WHITE);
		JLabel labelDescription = new JLabel("Description :");
		labelDescription.setForeground(Color.WHITE);
		label.add(labelNom);
		label.add(labelDescription);
		label.setOpaque(false);
		
		JPanel jText = new JPanel();
		jText.setLayout(new GridLayout(2,1));
		nomPlayer = new JFormattedTextField();
		nomPlayer.setBackground(Color.BLACK);
		nomPlayer.setForeground(Color.WHITE);
		descriptionPlayer = new JFormattedTextField();
		descriptionPlayer.setBackground(Color.BLACK);
		descriptionPlayer.setForeground(Color.WHITE);
		jText.add(nomPlayer);
		jText.add(descriptionPlayer);
		jText.setOpaque(false);
		
		saisie.add(label);
		saisie.add(jText);
		
		JButton validate = new JButton("Validate");
		validate.addActionListener(new Actions(this,"infoPlayer"));
		validate.setBackground(Color.BLACK);
		validate.setForeground(Color.RED);
		
		try{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font font = Font.createFont(Font.TRUETYPE_FONT,this.getClass().getResourceAsStream("Font/feast_of_flesh_bb/FEASFBI_.TTF"));
			ge.registerFont(font);
			font = font.deriveFont(Font.TRUETYPE_FONT,25);
			validate.setFont(font);
			nomPlayer.setFont(font);
			descriptionPlayer.setFont(font);
			labelNom.setFont(font);
			labelDescription.setFont(font);
		}
		catch(IOException e){
		}catch(FontFormatException e){          
		}catch(IllegalArgumentException e){
		}
		
		this.add(saisie,BorderLayout.CENTER);
		this.add(validate,BorderLayout.SOUTH);
		this.pack();
		this.setResizable(false);
		this.setVisible(true); 
		this.setLocationRelativeTo(this.windowOrigin);
	}
	
	public void recupInfo(){
		this.dispose();
		ArrayList<String> infoPlayer = new ArrayList<String>();
		infoPlayer.add(nomPlayer.getText());
		infoPlayer.add(descriptionPlayer.getText());
		windowOrigin.recupInfo(infoPlayer);
	}
}
