package the_Manor;

import package_Display.Window;
import package_Display.WindowFight;

/**
 * <p>The Game class is a superclass interacting with all other classes.
 * It is called within the windows class for graphic interactions</p>
 * 
 * @author Group 6
 * @version 05/12/16
 */

public class Game {
	
	private Player ourPlayer; // The player playing the game
	private Window windowGame; // The window displaying the game
	
	/**
	 * The constructor of the class Game
	 * @param windowGame The window displaying the game	
	 * @param name The name of the player that will play
	 * @param description The description of the player that will play
	 */	
	public Game(Window windowGame,String name, String description) {
		this.ourPlayer = new Player(name, description);
		createRooms(); // All the rooms of the game are created here.
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
        
        //***DOORS***
        
        // Outside
        outside = new Room("Victory","fond.png");
        
        // Ground floor
        hall = new Room("Hall","Hall.png");
        living = new Room("Living room","Living_Room.png");
        kitchen = new Room("The kitchen","Cuisine.png");
        cellar = new Room("The cellar","Cellar.png");
        office = new Room("Father office","Office.png");
        
        // Floor one
        floor1 = new Room("First floor","etage_1.png");
        parentRoom2 = new Room("Parents bedroom","ParentRoom.png");
        bathroom1 = new Room("Bathroom, first floor","Bathroom.png");
        dressingParent1 = new Room("Parents dressing room","Dressing_parent.png");
        tropheRoom1 = new Room("Trophee room","armurerie.png");
        
        // Floor two
        floor2 = new Room("Second floor","escalier2.png");
        friendRoom2 = new Room("Friend bedroom","friendRoom.png");
        corridor2_1 = new Room("Corridor one, second floor","Hallway1.png");
        bathroom2 = new Room("Bathroom, second floor","Bathroom2.png");
        gameRoom2 = new Room("Playroom","Game_room.png");
        corridor2_2 = new Room("Corridor two, second floor","Hallway2.png");
        corridor2_3 = new Room("Corridor three, second floor","Hallway3.png");
        sisterRoom2 = new Room("Sister bedroom","chambre_soeur.png");
        dressingSister2 = new Room("Sister dressing room","Dressing_sister.png");
        
        // Attic
        attic = new Room("The attic","attic.png");
        
        Key keyHall = new Key("Hall Key");
        Key keyTrophe = new Key("Collection Key");
        Key keyFloor2 = new Key("Floor one Key");
        Key keyCellar = new Key("Cellar key");
        
        //***EXITS***
        
        //Outside
        outside.addExit("NORD", null, hall);
        
        //Ground floor	
                
        hall.addExit("OUEST", null, kitchen);
        hall.addExit("EST", null, living);
        hall.addExit("NORD", null, floor1);
        hall.addExit("SUD", keyHall, outside);
       
        kitchen.addExit("EST", null, hall);
        kitchen.addExit("OUEST",keyCellar,cellar);

        cellar.addExit("EST", null, kitchen);
        
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

        dressingSister2.addExit("NORD", null, corridor2_3);
        
        sisterRoom2.addExit("SUD", null, corridor2_3);
        
        corridor2_1.addExit("NORD", null, friendRoom2);
        corridor2_1.addExit("OUEST", null, corridor2_2);
        
        bathroom2.addExit("NORD", null, corridor2_1);
		
        // Attic
        attic.addExit("EST", null, corridor2_3);
		
        friendRoom2.addEnigmaticExit("SUD", "I usually have streets without paving stones, cities without building, forests without tree, river without water. What am I ?", "Map", corridor2_1);
		
		//***ENIGMATIC EXITS***
        
        // Floor 1
		living.addEnigmaticExit("SUD","I am more powerful than God. I am more wicked than the Devil. The poor have it. The rich lacks it. If you eat me, you will die. Who am I?","Nothing",office);
		
		//floor 1
		floor1.addEnigmaticExit("EST","Like a fruit I have a core, but you can't eat me. Like a women I have a lot of coats but I am not Human. Who am I?","Earth",dressingParent1);
		floor1.addEnigmaticExit("OUEST","I have a mouse for a year. Knowing that a mouse can have 18 mice every month from 2 months, how many mice will I have after 10 months?","One",parentRoom2);
		
		//floor 2
		corridor2_1.addEnigmaticExit("SUD","I have something in my pocket, but my pocket is empty. What is it?","hole",bathroom2);
		corridor2_2.addEnigmaticExit("NORD","Who is the supreme commander of The Manor?","Aurelien",gameRoom2);
        corridor2_3.addEnigmaticExit("NORD","I have a father but I am not his son. I have a mother but I am not her son. Who am I?","daughter",sisterRoom2);
        corridor2_3.addEnigmaticExit("OUEST","What is the hidden code of the Manor ?","6904", attic);
      
        //***ITEMS AND CHARACTERS IN THE ROOMS***
        
        
        // SHIELDS        
        friendRoom2.addItem(new Shield ("Chair",2));
        friendRoom2.addItem(new Shield ("Computer",1));
        corridor2_2.addItem(new Shield ("Paper",0));
        cellar.addItem(new Shield ("Plate",25));
        parentRoom2.addItem(new Shield("Tablet",8));
        
        // WEAPONS
        friendRoom2.addItem(new Weapon ("Pen",2));
        friendRoom2.addItem(new Weapon ("Light",1));
        living.addItem(new Weapon ("Bottle",5));
        gameRoom2.addItem(new Weapon ("Bat",10));
        dressingParent1.addItem(new Weapon ("Hanger",8));
		tropheRoom1.addItem(new Weapon ("Sword",30));        
        
		// POTIONS	
		friendRoom2.addItem(new Potion ("Water",10));
		friendRoom2.addItem(new Potion ("Water",10));
		kitchen.addItem(new Potion ("Bred",5));
		cellar.addItem(new Potion ("Wine",20));
		bathroom2.addItem(new Potion ("Alcohol",20));
		bathroom1.addItem(new Potion ("Medikit",50));
		
		// KEYS
		dressingSister2.addItem(keyFloor2);
		office.addItem(keyTrophe);
		attic.addItem(keyHall);
		tropheRoom1.addItem(keyCellar);
		
		// CHARACTERS	
		gameRoom2.addCharacter(new Enemy("Laurel","Friend's girlfriend", 50, 60, 5, 10,"Laurel.png"));
        dressingSister2.addCharacter(new Enemy("Moira","Friend's mother", 60, 60, 5, 10,"Moira.png"));
        floor1.addCharacter(new Enemy("Malcolm","Mother's lover", 75, 60, 10, 10,"Malcolm.png"));
        hall.addCharacter(new Enemy("Slade","Friend's oncle", 85, 60, 10, 10,"Slade.png"));
        office.addCharacter(new Enemy("Robert","Friend's father", 85, 60, 10, 10,"Robert.png"));
        attic.addCharacter(new Enemy("Tommy","Friend", 125, 60, 30, 20,"Tommy.png"));
        sisterRoom2.addCharacter(new Ally("Thea","Friend's sister",
        		"<ul>"+
				"<li><font color=\"red\">"+this.ourPlayer.getName()+" ! You’re alive!</font></li>"+
				"<li>\"What?!\" you exclaimed with surprise. Something was wrong with that sentence.</li>"+
				"<li><font color=\"red\">Quick! Close the door!</font></li>"+
				"<li>You closed the door with a frown.</li>"+
				"<li><font color=\"red\">You seem to be oblivious of what is going on.</font></li>"+
				"<li>\"What?\" you asked with a shake of head.</li>"+
				"<li><font color=\"red\">Everyone is dead. At least that’s what I think. Now they roam the house, groaning and moaning…</font></li>"+
				"<li>\"I don’t understand…\" You whispered. Thea seemed on the verge of crying.</li>"+
				"<li><font color=\"red\">Zombies all of them. You must flee, "+this.ourPlayer.getName()+".</font></li>"+
				"<li>\"What about you?\" You replied with worry. You couldn’t leave her alone.</li>"+
				"<li><font color=\"red\">I can’t leave. They’re still my familly. Take this, it will help you. Now go!</font></li>"+
				"<li>\"Damn it!\" You exclaimed before taking what she was offering and leaving.</li>"+
				"</ul>",new Shield ("Board",15)));
        kitchen.addCharacter(new Ally("Mer","Maid",
        		"<ul>"+
		        "<li><font color=\"red\">\"Oh my god! I’m not alone!\"</font></li>"+
		        "<li>\"Quiet!\" You whispered. It was the maid. She seemed relieved to see you.</li>"+
		        "<li><font color=\"red\">\"Sorry. I’m so scared! I’ve been hiding here for hours.\"</font></li>"+
		        "<li>\"Can you help me?\" You asked, carefully looking around.</li>"+
		        "<li><font color=\"red\">\"What!? But I can’t fight!\"</font></li>"+
		        "<li>\"Not that. I need food.\"</li>"+
		        "<li><font color=\"red\">\"Of course, I can do that.  Do you need anything else?\"</font></li>"+
		        "<li>\"Yeah, I need a good weapon.\"</li>"+
		        "<li><font color=\"red\">\"I have only this.\"</font></li>"+
		        "<li>\"What?\" The maid showed you her silver plate. With a sigh, you took it from her.</li>"+
		        "<li><font color=\"red\">\"Maybe you should look around? The master has a collection room. But you need the key.\"</font></li>"+
		        "<li>\"Where can I find it?\"</li>"+
		        "<li><font color=\"red\">\"Maybe in his office?\"</font></li>"+
		        "</ul>",new Potion ("Milk",25)));
        cellar.addCharacter(new Ally("John", "A stranger",
        		"<div align=\"justify\" style=margin:10px;>Oh! Thank goodness you saved me! There are strange creatures that have arrived here."+
				"One of them attacked me and I entered this manor."+
				"However, we are blocked here and the key of the hall is in the attic and is kept in good hands... "+
				"In order to access that room, you need to discover the code that will open the door; this code is hidden in the rooms forming this manor. I have heard of several clues to find them:"+
				"<ul><li>The first part is in a room filled with clothing and a throne armchair;</li>"+
				"<li>The second part of the code is in a room adorned with a luminous ball;</li>"+
				"<li>Near a chimney, you will find the third part;</li>"+
				"<li>The last part is located in the most entertaining part of the manor.</li>"+
				"</ul>Good luck! I hope you get us out of this Manor !</div>",
        		new Shield("Amulet of luck",0)));
        
        // The first room of the player.
        hall.addItem(keyHall);
		this.ourPlayer.setCurrentRoom(hall);
    }
    
    /**
     * Allows to move in a specific direction
     * @param direction The direction to move
     */
    public void move(String direction){
		if(this.ourPlayer.getCurrentRoom().getDoor(direction) != null){
			Room current = this.ourPlayer.getCurrentRoom(); // A room object is created with the current room of the player.
			Room temp = this.ourPlayer.getCurrentRoom().getDoor(direction).goNextRoom(); // A room object is created corresponding to the next room the player is going to enter.
			if(temp != null){ // The room object representing the next room must not be null, if is null the room is lock
				this.ourPlayer.setCurrentRoom(temp); // The room object representing the next room of the player becomes the current room of the player: the player changed of room.
				if(this.ourPlayer.getCurrentRoom().numberOfChararacterInRoom() != 0){ // If there is a character in the new room of the player,
					if(this.ourPlayer.getCurrentRoom().getEnemy() != null && this.ourPlayer.getCurrentRoom().getEnemy().isAlive()){ // If this character is an alive enemy,
						Fight fight = new Fight(this.ourPlayer,this.ourPlayer.getCurrentRoom().getEnemy()); // A fight object is created representing the fight between the player and the enemy encountered.
						new WindowFight(fight,this.windowGame,current); // This fight will occur in another window
					}
					else if(this.ourPlayer.getCurrentRoom().getAlly() != null){ // If the character presents in the room is an ally,
						this.windowGame.ally(this.ourPlayer.getCurrentRoom().getAlly()); // gets this ally.
					}
				}
			}
			else if(this.ourPlayer.getCurrentRoom().getDoor(direction) instanceof EnigmaticDoor){ // If the door is an instance of an EnigmaticDoor
				EnigmaticDoor temp2 = (EnigmaticDoor) this.ourPlayer.getCurrentRoom().getDoor(direction); // Register the door in a variable
				this.windowGame.enigmaticMove(temp2.getEnigma(),direction); // Call the method enigmaticMove of the class Window to display the window with the response
			}
			else if(this.ourPlayer.getCurrentRoom().getDoor(direction) instanceof LockedDoor){ // If the door is an instance of a LockedDoor
				LockedDoor temp2 = (LockedDoor) this.ourPlayer.getCurrentRoom().getDoor(direction); // Register the door in a variable
				if(temp2.unlock(this.ourPlayer)){ // If the player can unlock the door
					this.ourPlayer.removeKey(temp2.getKey()); // Delete the key after using
					this.windowGame.lockDoor(false,temp2.getKey()); // Unlock the door
				}
				else
					this.windowGame.lockDoor(true,temp2.getKey()); // Allow to display the message with the key needed
			}
		}	
    }
    
    /**
     * Allows to checks if the answer to the enigma is true of not.
     * @param response The response given by the player.
     * @param direction The direction of the door.
     * @return A boolean to say if the answer is good (True: good ; False: not good).
     */
    public boolean verifyResponseForEnigma(String response,String direction){
    	EnigmaticDoor temp =(EnigmaticDoor) this.ourPlayer.getCurrentRoom().getDoor(direction);
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
    	if(this.ourPlayer.getCurrentRoom().numberOfItemInRoom() == 0)
			return ""; // No item presents in the room
		else{
			String name = this.ourPlayer.getCurrentRoom().getItem().getName(); // Recovery of the name of the item
			this.ourPlayer.pickUp(this.ourPlayer.getCurrentRoom().getItem()); // Addition of this item in the inventory of the player
			this.ourPlayer.getCurrentRoom().removeItem(this.ourPlayer.getCurrentRoom().getItem()); // ???
			return name;
		}
    }
    
    /**
     * Allows to have the player of the game.
     * @return The player of the game.
     */
    public Player getPlayer(){
    	return this.ourPlayer;
    }
    	
}