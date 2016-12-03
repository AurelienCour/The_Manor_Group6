package the_Manor;

import package_Display.Window;
import package_Display.WindowFight;

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
        office = new Room("Father office","office.png");
        
        floor1 = new Room("First floor","etage_1.png");
        parentRoom2 = new Room("Parents bedroom","ParentRoom.png");
        bathroom1 = new Room("Bathroom, first floor","Bathroom.png");
        dressingParent1 = new Room("Parents dressing room","Dressing_parent.png");
        tropheRoom1 = new Room("Trophee room","armurerie.png");
        
        floor2 = new Room("Second floor","escalier2.JPG");
        friendRoom2 = new Room("Friend bedroom","friendRoom.png");
        corridor2_1 = new Room("Corridor one, second floor","Hallway1.png");
        bathroom2 = new Room("Bathroom, second floor","Bathroom2.png");
        gameRoom2 = new Room("Playroom","Game_room.png");
        corridor2_2 = new Room("Corridor two, second floor","Hallway2.png");
        corridor2_3 = new Room("Corridor three, second floor","Hallway3.png");
        sisterRoom2 = new Room("Sister bedroom","chambre_soeur.png");
        dressingSister2 = new Room("Sister dressing room","Dressing_sister.png");
        
        attic = new Room("The attic","attic.png");
        
        Key keyHall = new Key("Hall Key");
        Key keyAttic = new Key("Attic Key");
        Key keyTrophe = new Key("Collection Key");
        Key keyFloor2 = new Key("Floor one Key");
        Key keyCellar = new Key("Cellar key");
        //Ground floor	
        outside.addExit("NORD", null, hall);
        
        hall.addExit("OUEST", null, kitchen);
        hall.addExit("EST", null, living);
        hall.addExit("NORD", null, floor1);
        hall.addExit("SUD", keyHall, outside);
        
        
        kitchen.addExit("EST", null, living);
        kitchen.addExit("SUD", null, hall);
        kitchen.addExit("OUEST",keyCellar,cellar);
        
        //"I grow up when I am fed, I die when I am given water. Who am I?","fire"
        cellar.addExit("EST", null, kitchen);
        
        living.addExit("NORD", null, kitchen);
        living.addExit("OUEST", null, hall);
        
        office.addExit("NORD", null, living);
        
        //Floor 1
        floor1.addExit("SUD", null, hall);
        floor1.addExit("NORD", null, floor2);
        
        parentRoom2.addExit("EST", null, floor1);
        parentRoom2.addExit("SUD", null, bathroom1);
        
        bathroom1.addExit("NORD", null, parentRoom2);
        
        dressingParent1.addExit("OUEST", null, floor1);
        dressingParent1.addExit("SUD", keyTrophe, tropheRoom1);
        
        tropheRoom1.addExit("NORD", null, dressingParent1);
        
        //Floor 2
        floor2.addExit("SUD", keyFloor2, floor1);
        floor2.addExit("NORD", null, corridor2_2);

        corridor2_2.addExit("SUD", null, floor2);
        corridor2_2.addExit("EST", null, corridor2_1);
        corridor2_2.addExit("OUEST", null, corridor2_3);
        
        gameRoom2.addExit("SUD", null, corridor2_2);

        corridor2_3.addExit("SUD", null, dressingSister2);
        corridor2_3.addExit("EST", null, corridor2_2);
        corridor2_3.addExit("OUEST", keyAttic, attic);
        
        dressingSister2.addExit("NORD", null, corridor2_3);
        
        sisterRoom2.addExit("SUD", null, corridor2_3);
        
        corridor2_1.addExit("NORD", null, friendRoom2);
        corridor2_1.addExit("EST", null, corridor2_1);
        corridor2_1.addExit("OUEST", null, corridor2_2);
        
        bathroom2.addExit("NORD", null, corridor2_1);
		
        //Last floor
        attic.addExit("EST", null, corridor2_3);
		
        friendRoom2.addEnigmaticExit("SUD", "I usually have streets without paving stones, cities without building, forests without tree, river without water. What am I ?", "Map", corridor2_1);
		
		//floor
		living.addEnigmaticExit("SUD","I am powerful than God. I am more wicked than the Devil. The poor have it. The rich lacks it. If you eat me, you will die. Who am I?","Nothing",office);
		
		//floor 1
		floor1.addEnigmaticExit("EST","Like a fruit I have a core, but you can't eat me. Like a women I have a lot of coats but I am not Human. Who am I?","Earth",dressingParent1);
		floor1.addEnigmaticExit("OUEST","I have a mouse for a year. Knowing that a mouse can have 18 mice every month from 2 months, how many mice will I have after 10 months?","One",parentRoom2);
		//floor 2
		corridor2_1.addEnigmaticExit("SUD","I have something in my pocket, but my pocket is empty. What is it?","hole",bathroom2);
		corridor2_2.addEnigmaticExit("NORD","Who is the supreme commander of The Manor?","Aurelien",gameRoom2);
        corridor2_3.addEnigmaticExit("NORD","I have a father but I am not his son. I have a mother but I am not her son. Who am I?","daughter",sisterRoom2);
		

        // ITEM AND CHARACTER
        friendRoom2.addItem(new Shield ("Chair",2));
        friendRoom2.addItem(new Shield ("Computer",1));
        corridor2_2.addItem(new Shield ("Paper",0));
        kitchen.addItem(new Shield ("Plate",25));
        parentRoom2.addItem(new Shield("Tablet",6));
        
        friendRoom2.addItem(new Weapon ("Pen",2));
        friendRoom2.addItem(new Weapon ("Light",1));
        living.addItem(new Weapon ("Bottle",5));
        gameRoom2.addItem(new Weapon ("Bat",10));
        dressingParent1.addItem(new Weapon ("Hanger",8));
		tropheRoom1.addItem(new Weapon ("Katana",30));
        
        
		friendRoom2.addItem(new Potion ("Water",10));
		friendRoom2.addItem(new Potion ("Water",10));
		kitchen.addItem(new Potion ("Bred",5));
		bathroom2.addItem(new Potion ("Alcohol",20));
		bathroom1.addItem(new Potion ("Medikit",50));
		
		dressingSister2.addItem(keyFloor2);
		office.addItem(keyTrophe);
		cellar.addItem(keyAttic);
		attic.addItem(keyHall);
		tropheRoom1.addItem(keyCellar);
		
        corridor2_1.addCharacter(new Enemy("Laurel","Friend's girlfriend", 50, 60, 5, 10));
        dressingSister2.addCharacter(new Enemy("Moira","Friend's mother", 60, 60, 5, 10));
        floor1.addCharacter(new Enemy("Malcolm","Mother's lover", 75, 60, 10, 10));
        cellar.addCharacter(new Enemy("Slade","Friend's oncle", 85, 60, 10, 10));
        office.addCharacter(new Enemy("Robert","Friend's father", 85, 60, 10, 10));
        attic.addCharacter(new Enemy("Tommy","Friend", 125, 60, 30, 20));
        sisterRoom2.addCharacter(new Ally("Thea","Friend's sister",new Shield ("Board",15)));
        kitchen.addCharacter(new Ally("Mer","Maid",new Potion ("Milk",25)));

		this.notreJoueur.setCurrentRoom(friendRoom2);
    }
    
    /**
     * Allows to move in a specific direction
     * @param direction The direction to move
     */
    public void move(String direction){
		if(this.notreJoueur.getCurrentRoom().getDoor(direction) != null){
			Room current = this.notreJoueur.getCurrentRoom();
			Room temp = this.notreJoueur.getCurrentRoom().getDoor(direction).goNextRoom();
			if(temp != null){
				this.notreJoueur.setCurrentRoom(temp);
				if(this.notreJoueur.getCurrentRoom().numberOfChararacterInRoom() != 0){
					if(this.notreJoueur.getCurrentRoom().getEnemy() != null && this.notreJoueur.getCurrentRoom().getEnemy().isAlive()){
						Fight fight = new Fight(this.notreJoueur,this.notreJoueur.getCurrentRoom().getEnemy());
						new WindowFight(fight,this.windowGame,current);
					}
				}
			}
			else if(this.notreJoueur.getCurrentRoom().getDoor(direction) instanceof EnigmaticDoor){
					EnigmaticDoor temp2 = (EnigmaticDoor) this.notreJoueur.getCurrentRoom().getDoor(direction);
					this.windowGame.enigmaticMove(temp2.getEnigma(),direction);
			}
			else if(this.notreJoueur.getCurrentRoom().getDoor(direction) instanceof LockedDoor){
				LockedDoor temp2 = (LockedDoor) this.notreJoueur.getCurrentRoom().getDoor(direction);
				if(temp2.unlock(this.notreJoueur)){
					this.notreJoueur.removeKey(temp2.getKey());
					this.windowGame.lockDoor(false,temp2.getKey());
				}
				else
					this.windowGame.lockDoor(true,temp2.getKey());
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