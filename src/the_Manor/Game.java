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
	private Window windowGame;
	/**
	 * The constructor of the class Game
	 * @param windowGame The window to display the game	 
	 */	
	public Game(Window windowGame,String name, String description) { // Ajout deux paramètre info joueur
		this.notreJoueur = new Player(name, description); // Instancie les paramètre à notre joueur
		createRooms();
		this.windowGame = windowGame;
	}
	
	/**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
    	Room hall,living,kitchen,office,cellar,outside;
    	Room floor1,parentRoom2,bathroom1,dressingParent1,tropheRoom1;
        Room floor2,friendRoom2,corridor2_1,bathroom2,gameRoom2,corridor2_2,corridor2_3,sisterRoom2,dressingSister2;
        Room attic;
        
        outside = new Room("Victory","fond.png");
        
        hall = new Room("Hall","Hall.png");
        living = new Room("Living room","salon.jpg");
        kitchen = new Room("The kitchen","Cuisine.png");
        cellar = new Room("The cellar","Cellar.png");
        office = new Room("Father office","bureau.jpg");
        
        floor1 = new Room("First floor","etage_1.png");
        parentRoom2 = new Room("Parents bedroom","chambreParent.jpg");
        bathroom1 = new Room("Bathroom, first floor","bathroom.png");
        dressingParent1 = new Room("Parents dressing room","Dressing_parent.png");
        tropheRoom1 = new Room("Trophee room","armurerie.png");
        
        floor2 = new Room("Second floor","escalier2.JPG");
        friendRoom2 = new Room("Friend bedroom","friendRoom.png");
        corridor2_1 = new Room("Corridor one, second floor","Hallway1.png");
        bathroom2 = new Room("Bathroom, second floor","Bathroom2.png");
        gameRoom2 = new Room("Playroom","Game_room.png");
        corridor2_2 = new Room("Corridor two, second floor","Hallway2.png");
        corridor2_3 = new Room("Corridor three, second floor","Hallway3.png");
        sisterRoom2 = new Room("Sister bedroom","chambre_soeur.jpg");
        dressingSister2 = new Room("Sister dressing room","Dressing_sister.png");
        
        attic = new Room("The attic","attic.png");
        
        //Ground floor
        outside.addExit("NORD", false, hall);
        
        hall.addExit("OUEST", false, kitchen);
        hall.addExit("EST", false, living);
        hall.addExit("NORD", false, floor1);
        hall.addExit("SUD", true, outside);
        
        
        kitchen.addExit("EST", false, living);
        //kitchen.addExit("OUEST", false, cellar);
        kitchen.addExit("SUD", false, hall);
        
        cellar.addExit("EST", false, kitchen);
        
        living.addExit("NORD", false, kitchen);
        living.addExit("OUEST", false, hall);
        //living.addExit("SUD", false, office);
        
        office.addExit("NORD", false, living);
        
        //Floor 1
        floor1.addExit("SUD", false, hall);
        floor1.addExit("NORD", false, floor2);
        //floor1.addExit("EST", false, dressingParent1);
        //floor1.addExit("OUEST", false, parentRoom2);
        
        parentRoom2.addExit("EST", false, floor1);
        parentRoom2.addExit("SUD", false, bathroom1);
        
        bathroom1.addExit("NORD", false, parentRoom2);
        
        dressingParent1.addExit("OUEST", false, floor1);
        dressingParent1.addExit("SUD", true, tropheRoom1);
        
        tropheRoom1.addExit("NORD", false, dressingParent1);
        
        //Floor 2
        floor2.addExit("SUD", false, floor1);
        floor2.addExit("NORD", false, corridor2_2);
        
        //corridor2_2.addExit("NORD", false, gameRoom2);
        corridor2_2.addExit("SUD", false, floor2);
        corridor2_2.addExit("EST", false, corridor2_1);
        corridor2_2.addExit("OUEST", false, corridor2_3);
        
        gameRoom2.addExit("SUD", false, corridor2_2);
        
        //corridor2_3.addExit("NORD", false, sisterRoom2);
        corridor2_3.addExit("SUD", false, dressingSister2);
        corridor2_3.addExit("EST", false, corridor2_2);
        corridor2_3.addExit("OUEST", true, attic);
        
        dressingSister2.addExit("NORD", false, corridor2_3);
        
        sisterRoom2.addExit("SUD", false, corridor2_3);
        
        corridor2_1.addExit("NORD", false, friendRoom2);
        //corridor2_1.addExit("SUD", false, bathroom2);
        corridor2_1.addExit("EST", false, corridor2_1);
        corridor2_1.addExit("OUEST", false, corridor2_2);
        
        bathroom2.addExit("NORD", false, corridor2_1);
		
        //Last floor
        attic.addExit("EST", false, corridor2_3);
		
        //friendRoom2.addExit("SUD", false, corridor2_1);
        friendRoom2.addEnigmaticExit("SUD", "Qui est le plus beau entre toi et moi ?", "toi", corridor2_1);
		
		//floor
		living.addEnigmaticExit("SUD","I am powerful than God. I am more wicked than the Devil. The poor have it. The rich lacks it. If you eat me, you will die. Who am I?","Nothing",office);
		kitchen.addEnigmaticExit("OUEST","I grow up when I am fed, I die when I am given water. Who am I?","fire",cellar);
		//floor 1
		floor1.addEnigmaticExit("EST","Like a fruit I have a core, but you can't eat me. Like a women I have a lot of coats but I am not Human. Who am I?","Earth",dressingParent1);
		floor1.addEnigmaticExit("OUEST","I have a mouse for a year. Knowing that a mouse can have 18 mice every month from 2 months, how many mice will I have after 10 months?","One",parentRoom2);
		//floor 2
		corridor2_1.addEnigmaticExit("SUD","I have something in my pocket, but my pocket is empty. What is it?","hole",bathroom2);
		corridor2_2.addEnigmaticExit("NORD","Who is the supreme commander of The Manor?","Aurelien",gameRoom2);
        corridor2_3.addEnigmaticExit("NORD","I have a father but I am not his son and I have a mother but I am not her son. Who am I?","daughter",sisterRoom2);
		

        living.addItem(new Weapon ("extinguisher",5));
		kitchen.addItem(new Shield ("plateau",15));
		cellar.addItem(new Key("attic"));
		office.addItem(new Key ("chestKey"));// Need to find the secret code
				
		bathroom1.addItem(new Potion ("kit",50));
		tropheRoom1.addItem(new Weapon ("katana",30));
			   

		friendRoom2.addItem(new Shield ("chair",2));
		friendRoom2.addItem(new Key ("Key"));
		bathroom2.addItem(new Potion ("alcohol",10));
		gameRoom2.addItem(new Weapon ("bat",10));
		//sisterRoom2.addItem(new Shield ("Wooden shield",15));
		attic.addItem(new Key ("hallKey"));// disponible quand le boss est mort
		
		// creation ally 
		sisterRoom2.addCharacter(new Ally("Thea","Friend's sister",new Shield ("Wooden shield",15)));

		kitchen.addCharacter(new Ally("Mer","Maid",new Potion ("bandage",10)));
		// creation enemy
		corridor2_1.addCharacter(new Enemy("Laurel","Friend's girlfriend", 10, 60, 5, 3));
		dressingSister2.addCharacter(new Enemy("Moira","Friend's mother", 15, 60, 5, 3));
		floor1.addCharacter(new Enemy("Malcolm","Mother's lover", 25, 60, 10, 3));
		cellar.addCharacter(new Enemy("Slade","Friend's oncle", 40, 60, 10, 3));
		office.addCharacter(new Enemy("Robert","Friend's father", 40, 60, 10, 3));
		attic.addCharacter(new Enemy("Tommy","Friend", 100, 60, 20, 3));
        this.notreJoueur.setCurrentRoom(friendRoom2);
    }
    
    /**
     * Allows to move in a specific direction
     * @param direction The direction to move
     */
    public void move(String direction){
		if(this.notreJoueur.getCurrentRoom().getDoor(direction) != null){
			Room temp = this.notreJoueur.getCurrentRoom().getDoor(direction).goNextRoom();
			if(temp != null)
				this.notreJoueur.setCurrentRoom(temp);
			else if(this.notreJoueur.getCurrentRoom().getDoor(direction) instanceof EnigmaticDoor){
					EnigmaticDoor temp2 = (EnigmaticDoor) this.notreJoueur.getCurrentRoom().getDoor(direction);
					this.windowGame.enigmaticMove(temp2.getEnigma(),direction);
			}
			else if(this.notreJoueur.getCurrentRoom().getDoor(direction) instanceof LockedDoor){
				LockedDoor temp2 = (LockedDoor) this.notreJoueur.getCurrentRoom().getDoor(direction);
				if(temp2.unlock(this.notreJoueur)){
					this.notreJoueur.removeKey();
					this.windowGame.lockDoor(false);
				}
				else
					this.windowGame.lockDoor(true);
			}
		}
    }
    
    public boolean verifyResponseForEnigma(String response,String direction){
    	EnigmaticDoor temp =(EnigmaticDoor) this.notreJoueur.getCurrentRoom().getDoor(direction);
    	if(temp.solveEnigma(response))
    		return true;
    	else
    		return false;
    }
    
    /**
     * Allow to search in a room
     * @return The name of the item
     */
    public String search(){
    	if(this.notreJoueur.getCurrentRoom().numberOfItemInRoom() == 0)
			return "";
		else{
			String name = this.notreJoueur.getCurrentRoom().getItem().getName();
			this.notreJoueur.pickUp(this.notreJoueur.getCurrentRoom().getItem());
			this.notreJoueur.getCurrentRoom().removeItem(this.notreJoueur.getCurrentRoom().getItem());
			return name;
		}
    }
    
    public Player getPlayer(){
    	return this.notreJoueur;
    }
    	
}