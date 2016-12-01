package package_Display;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import the_Manor.Game;
import the_Manor.Item;
import the_Manor.Shield;
import the_Manor.Weapon;

public class WindowInventory extends JFrame{
	
	private Game theGame;
	private Window windowGame;
	
	public WindowInventory (Game game,Window win){
		this.windowGame = win;
		this.theGame = game;
		this.setTitle("Inventory");
		this.setBackground(Color.GRAY);
		this.setLayout(new BorderLayout(20,20));
		
		JPanel inventory = new JPanel();
		inventory.setLayout(new GridLayout(0,2));
		JPanel weapon = new JPanel();
		weapon.setLayout(new GridLayout(0,1));
		JPanel shield = new JPanel();
		shield.setLayout(new GridLayout(0,1));
		ArrayList<Weapon> allWeapon;
		ArrayList<Shield> allShield;
		allWeapon = this.theGame.getPlayer().getWeapon();
		allShield = this.theGame.getPlayer().getShield();
		
		JPanel header = new JPanel();
		header.setLayout(new GridLayout(1,2));
		header.add(new JLabel("Weapon"));
		header.add(new JLabel("Shield"));
		
		JButton[] buttonsWeapon = new JButton[allWeapon.size()];
		for (int i=0; i<allWeapon.size(); i++)
		{
		    buttonsWeapon[i] = new JButton("equip");
		    buttonsWeapon[i].addActionListener(new Actions(this,allWeapon.get(i),"equip"));
		    JPanel test = new JPanel();
		    test.setLayout(new GridLayout(1,2,5,5));
		    test.add(new JLabel(allWeapon.get(i).getName().toUpperCase()+" Attack :"+allWeapon.get(i).getAttack()));
		    test.add(buttonsWeapon[i]);
		    weapon.add(test);
		}
		JButton[] buttonsShield = new JButton[allShield.size()];
		for (int i=0; i<allShield.size(); i++)
		{
			buttonsShield[i] = new JButton("equip");
			buttonsShield[i].addActionListener(new Actions(this,allShield.get(i),"equip"));
			JPanel test = new JPanel();
		    test.setLayout(new GridLayout(1,2,5,5));
		    test.add(new JLabel(allShield.get(i).getName().toUpperCase()+" Defense :"+allShield.get(i).getDefense()));
		    test.add(buttonsShield[i]);
			shield.add(test);
		}
		
		this.add(header,BorderLayout.NORTH);
		inventory.add(weapon);
		inventory.add(shield);
		this.add(inventory,BorderLayout.CENTER);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(windowGame);
		this.pack();
	}

	public void equipPlayer(Item itemToEquip) {
		this.theGame.getPlayer().equipItem(itemToEquip);
		this.windowGame.checkItem();
		this.dispose();
	}
}
