package package_Display;

import java.awt.event.*;
import the_Manor.Item;

/**
 * To manage the action of the buttons
 * 
 * @author Group6
 * @version 25/10/2016
 */
public class Actions implements ActionListener
{
    private String idAction; // To know the button
    // The different window where the button is
    private Window windowGame;
    private WindowEnigma windowEnigma;
    private StartingWindow startingWindow;
    private WindowCreatePlayer infoPlayer;
    private WindowInventory inventory;
    private Item itemToEquip;
	private WindowFight windowFight;
	private WindowDisplayAlly windowDisplayAlly;

     /**
      * Constructor for objects of class Actions
      * @param window The window where is the button
      * @param idAct The id of the button
      */
    public Actions(Window window,String idAct)
    {
        this.idAction = idAct;
        this.windowGame = window;
    }
    
    /**
     * Constructor for objects of class Actions
     * @param window The window where is the button
     * @param idAct The id of the button
     */
    public Actions(WindowEnigma window,String idAct)
    {
        this.idAction = idAct;
        this.windowEnigma = window;
    }  
    
    /**
     * Constructor for objects of class Actions
     * @param startingWindow The window where is the button
     * @param idAct The id of the button
     */
    public Actions(StartingWindow startingWindow, String idAct)
    {
       this.idAction = idAct;
       this.startingWindow = startingWindow;
    }
   
    /**
     * Constructor for objects of class Actions
     * @param infoWindow The window where is the button
     * @param idAct The id of the button
     */
    public Actions(WindowCreatePlayer infoWindow, String idAct)
    {
       this.idAction = idAct;
       this.infoPlayer = infoWindow;
    }
    
    /**
     * Constructor for objects of class Actions
     * @param theInventory The window where is the button
     * @param Item The item in the inventory
     * @param idAct The id of the button
     */
    public Actions(WindowInventory theInventory, Item item, String idAct) {
    	this.inventory = theInventory;
    	this.itemToEquip = item;
    	this.idAction = idAct;
    }
    
    /**
     * Constructor for objects of class Actions
     * @param windowFight The window where is the button
     * @param idAct The id of the button
     */
    public Actions(WindowFight windowFight, String idAct) {
    	this.windowFight = windowFight;
    	this.idAction = idAct;
    }

    /**
     * Constructor for objects of class Actions
     * @param windowDisplayAlly The window where is the button
     * @param idAct The id of the button
     */
	public Actions(WindowDisplayAlly windowDisplayAlly, String idAct) {
		this.windowDisplayAlly = windowDisplayAlly;
		this.idAction = idAct;
	}

	/**
     * The methods to manage the different action
     * @param ae The action event
     */
    public void actionPerformed(ActionEvent ae) {
        if(idAction.equals("controlDroit")){
            this.windowGame.gameMove("controlDroit");
        }
        else if(idAction.equals("controlGauche")){
        	this.windowGame.gameMove("controlGauche");
        }
        else if(idAction.equals("controlHaut")){
        	this.windowGame.gameMove("controlHaut");
        }
        else if(idAction.equals("controlBas")){
        	this.windowGame.gameMove("controlBas");
        }
        else if(idAction.equals("search")){
        	this.windowGame.gameSearch();
        }
        else if(idAction.equals("enigma")){
        	this.windowEnigma.recupResponse();
        }
        else if(idAction.equals("createPlayer")){
        	this.startingWindow.createPlayer();
        }
        else if(idAction.equals("infoPlayer")){
        	this.infoPlayer.recupInfo();
        }
        else if(idAction.equals("equip")){
        	this.inventory.equipPlayer(itemToEquip);
        }
        else if(idAction.equals("attack")){
        	this.windowFight.attack();
        }
        else if(idAction.equals("recup")){
        	this.windowFight.recup();
        }
        else if(idAction.equals("heal")){
        	this.windowFight.heal();
        }
        else if(idAction.equals("escape")){
        	this.windowFight.escape();
        }
        else if(idAction.equals("healInv")){
        	this.inventory.heal(itemToEquip);
        }
        else if(idAction.equals("messageAlly")){
        	this.windowDisplayAlly.message();
        }
    }
}
