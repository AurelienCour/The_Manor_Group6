package package_Display;

import java.awt.event.*;

/**
 * To manage the action on the buttons
 * 
 * @author Aurelien Courtillat
 * @version 25/10/2016
 */
public class Actions implements ActionListener
{
    private String idAction; // To know the button
    private Window windowGame;
    private WindowEnigma windowEnigma;
    private StartingWindow startingWindow;

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
    
    public Actions(WindowEnigma window,String idAct)
    {
        this.idAction = idAct;
        this.windowEnigma = window;
    }
    
    
   public Actions(StartingWindow startingWindow, String idAct)
   {
       this.idAction = idAct;
       this.startingWindow = startingWindow;
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
        	this.startingWindow.createPlayer(idAction, idAction);
        
        }
    }

    

}
