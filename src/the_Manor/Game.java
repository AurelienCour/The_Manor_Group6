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
    	Room hall,living,kitchen,office,cave,sortie,outside;
    	Room floor1,parentRoom2,bathroom1,dressingParent1,tropheRoom1;
        Room floor2,friendRoom2,corridor2_1,bathroom2,salleJeux2,corridor2_2,corridor2_3,sisterRoom2,dressingSister2;
        Room attic;
        
        outside = new Room("Victory","fond.png");
        
        hall = new Room("Hall","hall.jpg");
        living = new Room("Living room","salon.jpg");
        kitchen = new Room("The kitchen","cuisine.jpg");
        cave = new Room("The cellar","cave.jpg");
        office = new Room("Father office","bureau.jpg");
        
        floor1 = new Room("First floor","escalier1.png");
        parentRoom2 = new Room("Parents bedroom","chambreParent.jpg");
        bathroom1 = new Room("Bathroom, first floor","salleDeBain.jpg");
        dressingParent1 = new Room("Parents dressing room","dressing.jpg");
        tropheRoom1 = new Room("Trophee room","armurerie.jpg");
        
        floor2 = new Room("Second floor","escalier2.JPG");
        friendRoom2 = new Room("Friend bedroom","chambre_ami.jpg");
        corridor2_1 = new Room("Corridor one, second floor","couloir_1.jpg");
        bathroom2 = new Room("Bathroom, second floor","salleDeBain2.jpg");
        salleJeux2 = new Room("Playroom","salleDeJeux.jpg");
        corridor2_2 = new Room("Corridor two, second floor","couloir_2.jpg");
        corridor2_3 = new Room("Corridor three, second floor","couloir_3.jpg");
        sisterRoom2 = new Room("Sister bedroom","chambre_soeur.jpg");
        dressingSister2 = new Room("Sister dressing room","dressingSoeur.jpg");
        
        attic = new Room("The attic","grenier.jpg");
        
        //Rez-de-chaussez
        outside.addExit("NORD", false, hall);
        
        hall.addExit("OUEST", false, kitchen);
        hall.addExit("EST", false, living);
        hall.addExit("NORD", false, floor1);
        hall.addExit("SUD", false, outside);
        
        
        kitchen.addExit("EST", false, living);
        kitchen.addExit("OUEST", false, cave);
        kitchen.addExit("SUD", false, hall);
        
        cave.addExit("EST", false, kitchen);
        
        living.addExit("NORD", false, kitchen);
        living.addExit("OUEST", false, hall);
        living.addExit("SUD", false, office);
        
        office.addExit("NORD", false, living);
        
        //Premier etage
        floor1.addExit("SUD", false, hall);
        floor1.addExit("NORD", false, floor2);
        floor1.addExit("EST", false, dressingParent1);
        floor1.addExit("OUEST", false, parentRoom2);
        
        parentRoom2.addExit("EST", false, floor1);
        parentRoom2.addExit("SUD", false, bathroom1);
        
        bathroom1.addExit("NORD", false, parentRoom2);
        
        dressingParent1.addExit("OUEST", false, floor1);
        dressingParent1.addExit("SUD", false, tropheRoom1);
        
        tropheRoom1.addExit("NORD", false, dressingParent1);
        
        //Deuxieme etage
        floor2.addExit("SUD", false, floor1);
        floor2.addExit("NORD", false, corridor2_2);
        
        corridor2_2.addExit("NORD", false, salleJeux2);
        corridor2_2.addExit("SUD", false, floor2);
        corridor2_2.addExit("EST", false, corridor2_1);
        corridor2_2.addExit("OUEST", false, corridor2_3);
        
        salleJeux2.addExit("SUD", false, corridor2_2);
        
        corridor2_3.addExit("NORD", false, sisterRoom2);
        corridor2_3.addExit("SUD", false, dressingSister2);
        corridor2_3.addExit("EST", false, corridor2_2);
        corridor2_3.addExit("OUEST", false, attic);
        
        dressingSister2.addExit("NORD", false, corridor2_3);
        
        sisterRoom2.addExit("SUD", false, corridor2_3);
        
        corridor2_1.addExit("NORD", false, friendRoom2);
        corridor2_1.addExit("SUD", false, bathroom2);
        corridor2_1.addExit("EST", false, corridor2_1);
        corridor2_1.addExit("OUEST", false, corridor2_2);
        
        bathroom2.addExit("NORD", false, corridor2_1);
        
        friendRoom2.addExit("SUD", false, corridor2_1);
        
        //Dernier etage
        attic.addExit("EST", false, corridor2_3);
        
        friendRoom2.addItem(new Weapon("Epee", 15));
        this.notreJoueur.setCurrentRoom(friendRoom2);
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