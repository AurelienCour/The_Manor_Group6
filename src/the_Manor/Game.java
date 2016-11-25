package the_Manor;

import package_Display.Window;

public class Game {
	
	private Player notreJoueur;
	
	/**
	 * The constructor of the class Game	 
	 */	
	public Game() {
		this.notreJoueur = new Player("Test", "Notre Joueur", null);
		createRooms();
		
	}
	
	/**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theatre, pub, lab, office;
      
        // create the rooms
        outside = new Room("outside","fond.png");
        theatre = new Room("lecture theatre","direction_haut.png");
        pub = new Room("campus pub","direction_gauche.png");
        lab = new Room("computing lab","direction_droite.png");
        
        office = new Room("computing admin office","direction_droite.png");
        
        outside.addExit("NORD", false, theatre);
        outside.addExit("EST", false, lab);
        outside.addExit("OUEST", false, pub);
        
        lab.addExit("OUEST", false, outside);
        
        pub.addExit("EST", false, outside);
        
        theatre.addExit("SUD", false, outside);
        this.notreJoueur.setCurrentRoom(outside);
        System.out.println("Vous êtes maintenant dans : "+this.notreJoueur.getCurrentRoom().getName());
    }
    
    public String goEst(){
    	if(this.notreJoueur.getCurrentRoom().getDoor("EST") != null)
    		this.notreJoueur.setCurrentRoom(this.notreJoueur.getCurrentRoom().getDoor("EST").goNextRoom());
    	return this.notreJoueur.getCurrentRoom().getName();
    }
    
    public String goOuest(){
    	if(this.notreJoueur.getCurrentRoom().getDoor("OUEST") != null)
    		this.notreJoueur.setCurrentRoom(this.notreJoueur.getCurrentRoom().getDoor("OUEST").goNextRoom());
    	return this.notreJoueur.getCurrentRoom().getName();
    }
    
    public String goNord(){
    	if(this.notreJoueur.getCurrentRoom().getDoor("NORD") != null)
    		this.notreJoueur.setCurrentRoom(this.notreJoueur.getCurrentRoom().getDoor("NORD").goNextRoom());
    	return this.notreJoueur.getCurrentRoom().getName();
    }
    
    public String goSud(){
    	if(this.notreJoueur.getCurrentRoom().getDoor("SUD") != null)
    		this.notreJoueur.setCurrentRoom(this.notreJoueur.getCurrentRoom().getDoor("SUD").goNextRoom());
    	return this.notreJoueur.getCurrentRoom().getName();
    }
    
    public Player getPlayer(){
    	return this.notreJoueur;
    }
    

	
	
	
	
}