package the_Manor;

import package_Display.Window;

/**
 * <p>The Game class is a superclass interacting with all other classes.
 * It is called within the windows class for graphic interactions</p>
 * 
 * @author Group 6
 * @version 30/11/2016
 */

public class Game {
	
	private Player notreJoueur;
	
	/**
	 * The constructor of the class Game	 
	 */	
	public Game() {
		this.notreJoueur = new Player("Test", "Notre Joueur");
		createRooms();
		
	}
	
	/**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
    	Room hall,salon,cuisine,bureau,cave,sortie,outside;
    	Room etage1,chambreParent1,salleDeBain1,dressingParent1,pieceCollection1;
        Room etage2,chambreAmi2,couloir2_1,salleDeBain2,salleJeux2,couloir2_2,couloir2_3,chambreSoeur2,dressingSoeur2;
        Room grenier3;
        
        outside = new Room("Victoire","fond.png");
        
        hall = new Room("Le hall","hall.jpg");
        salon = new Room("Le salon","salon.jpg");
        cuisine = new Room("La cuisine","cuisine.jpg");
        cave = new Room("La cave","cave.jpg");
        bureau = new Room("Le bureau","bureau.jpg");
        
        etage1 = new Room("Premier etage","escalier1.png");
        chambreParent1 = new Room("Chambre des parents","chambreParent.jpg");
        salleDeBain1 = new Room("Salle de bain, premier etage","salleDeBain.jpg");
        dressingParent1 = new Room("Dressing des parents","dressing.jpg");
        pieceCollection1 = new Room("Collection des parents","armurerie.jpg");
        
        etage2 = new Room("Deuxieme etage","escalier2.JPG");
        chambreAmi2 = new Room("Chambre d'ami","chambre_ami.jpg");
        couloir2_1 = new Room("Couloir, deuxieme etage","couloir_1.jpg");
        salleDeBain2 = new Room("Salle de bain, deuxieme etage","salleDeBain2.jpg");
        salleJeux2 = new Room("Salle de jeux","salleDeJeux.jpg");
        couloir2_2 = new Room("Couloir, deuxieme etage","couloir_2.jpg");
        couloir2_3 = new Room("Couloir, deuxieme etage","couloir_3.jpg");
        chambreSoeur2 = new Room("Chambre de la soeur","chambre_soeur.jpg");
        dressingSoeur2 = new Room("Dressing de la soeur","dressingSoeur.jpg");
        
        grenier3 = new Room("Le grenier","grenier.jpg");
        
        //Rez-de-chaussez
        outside.addExit("NORD", false, hall);
        
        hall.addExit("OUEST", false, cuisine);
        hall.addExit("EST", false, salon);
        hall.addExit("NORD", false, etage1);
        hall.addExit("SUD", false, outside);
        
        
        cuisine.addExit("EST", false, salon);
        cuisine.addExit("OUEST", false, cave);
        cuisine.addExit("SUD", false, hall);
        
        cave.addExit("EST", false, cuisine);
        
        salon.addExit("NORD", false, cuisine);
        salon.addExit("OUEST", false, hall);
        salon.addExit("SUD", false, bureau);
        
        bureau.addExit("NORD", false, salon);
        
        //Premier etage
        etage1.addExit("SUD", false, hall);
        etage1.addExit("NORD", false, etage2);
        etage1.addExit("EST", false, dressingParent1);
        etage1.addExit("OUEST", false, chambreParent1);
        
        chambreParent1.addExit("EST", false, etage1);
        chambreParent1.addExit("SUD", false, salleDeBain1);
        
        salleDeBain1.addExit("NORD", false, chambreParent1);
        
        dressingParent1.addExit("OUEST", false, etage1);
        dressingParent1.addExit("SUD", false, pieceCollection1);
        
        pieceCollection1.addExit("NORD", false, dressingParent1);
        
        //Deuxieme etage
        etage2.addExit("SUD", false, etage1);
        etage2.addExit("NORD", false, couloir2_2);
        
        couloir2_2.addExit("NORD", false, salleJeux2);
        couloir2_2.addExit("SUD", false, etage2);
        couloir2_2.addExit("EST", false, couloir2_1);
        couloir2_2.addExit("OUEST", false, couloir2_3);
        
        salleJeux2.addExit("SUD", false, couloir2_2);
        
        couloir2_3.addExit("NORD", false, chambreSoeur2);
        couloir2_3.addExit("SUD", false, dressingSoeur2);
        couloir2_3.addExit("EST", false, couloir2_2);
        couloir2_3.addExit("OUEST", false, grenier3);
        
        dressingSoeur2.addExit("NORD", false, couloir2_3);
        
        chambreSoeur2.addExit("SUD", false, couloir2_3);
        
        couloir2_1.addExit("NORD", false, chambreAmi2);
        couloir2_1.addExit("SUD", false, salleDeBain2);
        couloir2_1.addExit("EST", false, couloir2_1);
        couloir2_1.addExit("OUEST", false, couloir2_2);
        
        salleDeBain2.addExit("NORD", false, couloir2_1);
        
        chambreAmi2.addExit("SUD", false, couloir2_1);
        
        //Dernier etage
        grenier3.addExit("EST", false, couloir2_3);
        
        chambreAmi2.addItem(new Weapon("Epee", 15));
        
        this.notreJoueur.setCurrentRoom(chambreAmi2);
    }
    
    /**
     * Allows to move in a specific direction
     * @param direction
     */
    public void move(String direction){
    	switch (direction) {
		case "SUD":
			if(this.notreJoueur.getCurrentRoom().getDoor("SUD") != null)
	    		this.notreJoueur.setCurrentRoom(this.notreJoueur.getCurrentRoom().getDoor("SUD").goNextRoom());
			break;
		case "NORD":
			if(this.notreJoueur.getCurrentRoom().getDoor("NORD") != null)
	    		this.notreJoueur.setCurrentRoom(this.notreJoueur.getCurrentRoom().getDoor("NORD").goNextRoom());
			break;
		case "EST":
			if(this.notreJoueur.getCurrentRoom().getDoor("EST") != null)
	    		this.notreJoueur.setCurrentRoom(this.notreJoueur.getCurrentRoom().getDoor("EST").goNextRoom());
			break;
		case "OUEST":
			if(this.notreJoueur.getCurrentRoom().getDoor("OUEST") != null)
	    		this.notreJoueur.setCurrentRoom(this.notreJoueur.getCurrentRoom().getDoor("OUEST").goNextRoom());
			break;
		default:
			break;
		}
    }
    
    /**
     * Allow to search in a room
     */
    public void search(){
    	if(this.notreJoueur.getCurrentRoom().numberOfItemInRoom() == 0)
			System.out.println("Pas d'objet dans la pièce");
		else{
			System.out.println("Vous avez trouvé : "+this.notreJoueur.getCurrentRoom().getItem().getName());
			this.notreJoueur.pickUp(this.notreJoueur.getCurrentRoom().getItem());
			this.notreJoueur.getCurrentRoom().removeItem(this.notreJoueur.getCurrentRoom().getItem());
		}
    }
    
    public Player getPlayer(){
    	return this.notreJoueur;
    }
    

	
	
	
	
}