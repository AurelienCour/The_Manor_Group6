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
		this.notreJoueur = new Player("Try", "Our player");
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
        
        outside = new Room("Victory","fond.png");
        
        hall = new Room("Hall","hall.jpg");
        salon = new Room("Living room","salon.jpg");
        cuisine = new Room("The kitchen","cuisine.jpg");
        cave = new Room("The cellar","cave.jpg");
        bureau = new Room("Father office","bureau.jpg");
        
        etage1 = new Room("First floor","escalier1.png");
        chambreParent1 = new Room("Parents bedroom","chambreParent.jpg");
        salleDeBain1 = new Room("Bathroom, premier etage","salleDeBain.jpg");
        dressingParent1 = new Room("Parents dressing room","dressing.jpg");
        pieceCollection1 = new Room("Trophee room","armurerie.jpg");
        
        etage2 = new Room("Second floor","escalier2.JPG");
        chambreAmi2 = new Room("Friend bedroom","chambre_ami.jpg");
        couloir2_1 = new Room("Corridor one, second floor","couloir_1.jpg");
        salleDeBain2 = new Room("Bathroom, second floor","salleDeBain2.jpg");
        salleJeux2 = new Room("Playroom","salleDeJeux.jpg");
        couloir2_2 = new Room("Corridor two, second floor","couloir_2.jpg");
        couloir2_3 = new Room("Corridor three, second floor","couloir_3.jpg");
        chambreSoeur2 = new Room("Sister bedroom","chambre_soeur.jpg");
        dressingSoeur2 = new Room("Sister dressing room","dressingSoeur.jpg");
        
        grenier3 = new Room("The attic","grenier.jpg");
        
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
        
        this.notreJoueur.setCurrentRoom(chambreAmi2);
    }
    
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
    
    public Player getPlayer(){
    	return this.notreJoueur;
    }
    

	
	
	
	
}