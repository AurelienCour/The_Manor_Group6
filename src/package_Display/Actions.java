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
    private Window window;

    /**
     * Constructor for objects of class Actions
     * @param match The match where is the button
     * @param team The team where is the button
     * @param idAct The id of the button
     */
    public Actions(Window window,String idAct)
    {
        this.idAction = idAct;
        this.window = window;
    }
    
    /**
     * The methods to manage the different action
     * @param The action event
     */
    public void actionPerformed(ActionEvent ae) {
        if(idAction.equals("controlDroit")){
            this.window.gameMove("controlDroit");
        }
        else if(idAction.equals("controlGauche")){
        	this.window.gameMove("controlGauche");
        }
        else if(idAction.equals("controlHaut")){
        	this.window.gameMove("controlHaut");
        }
        else if(idAction.equals("controlBas")){
        	this.window.gameMove("controlBas");
        }
        else if(idAction.equals("search")){
        	this.window.gameSearch();
        }
    }

}
