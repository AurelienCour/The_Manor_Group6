package package_Display;

import java.awt.*;
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
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		this.nomPlayer = new JFormattedTextField();
		this.descriptionPlayer = new JFormattedTextField();
		JPanel labelAndJtextName = new JPanel();
		labelAndJtextName.setLayout(new BoxLayout(labelAndJtextName, BoxLayout.X_AXIS));
		JPanel labelAndJtextDescription = new JPanel();
		labelAndJtextDescription.setLayout(new BoxLayout(labelAndJtextDescription, BoxLayout.X_AXIS));
		Font police = new Font("Serif", Font.PLAIN, 14);
		JLabel labelNom = new JLabel("Name :");
		JLabel labelDescription = new JLabel("Description :");
		this.nomPlayer.setFont(police);
		this.nomPlayer.setPreferredSize(new Dimension(150, 30));
		this.descriptionPlayer.setFont(police);
		this.descriptionPlayer.setPreferredSize(new Dimension(150, 30));
		labelAndJtextName.add(labelNom);
		labelAndJtextName.add(this.nomPlayer);
		labelAndJtextDescription.add(labelDescription);
		labelAndJtextDescription.add(this.descriptionPlayer);
		JPanel saisie = new JPanel();
		saisie.setLayout(new GridLayout(2,1));
		saisie.add(labelAndJtextName);
		saisie.add(labelAndJtextDescription);

		JButton validate = new JButton("Validate");
		validate.addActionListener(new Actions(this,"infoPlayer"));
		this.add(saisie,BorderLayout.CENTER);
		this.add(validate,BorderLayout.SOUTH);
		this.pack();
		this.setResizable(false);
		this.setVisible(true); 
		this.setLocationRelativeTo(null);
	}
	
	public void recupInfo(){
		ArrayList<String> infoPlayer = new ArrayList<String>();
		infoPlayer.add(nomPlayer.getText());
		infoPlayer.add(descriptionPlayer.getText());
		this.windowOrigin.recupInfo(infoPlayer);
		this.dispose();
	}
}
