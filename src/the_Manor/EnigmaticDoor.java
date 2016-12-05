package the_Manor;

/**
 * <p>This EnigmaticDoor class stands for a door that is locked by an enigma. </p>
 * <p>This enigma can be solved if the player proposes the right solution.</p>
 *
 * @author Group 6
 * @version 05/12/16
 */

public class EnigmaticDoor extends Door{	
	
	private String enigma; // the enigma that has to be solved	
	private String response; // the answer of the enigma
	private boolean locked; // the lock status of the door

	/**
	 * Constructor of the class EnigmaticDoor. 	 
	 * @param enigma The enigma that has to be solved to cross the door
	 * @param response The response of the enigma
	 * @param nextRoom The next room the player is going to enter after having solved the enigma
	 * @param previousRoom The previous room
	 */
	public EnigmaticDoor(String enigma, String response, Room nextRoom, Room previousRoom) {
		super(nextRoom,previousRoom); // Uses the Door super-class
		if(enigma == null || enigma.isEmpty()){
			System.out.println("Default enigma"); // default value
			this.enigma = "No enigma, response : No enigma"; // default value
		}
		else
			this.enigma = enigma;
		if(response == null || response.isEmpty()){
			System.out.println("Default response"); // default value
			this.response = "NO ENIGMA"; // default value
		}
		else
			this.response = response.toUpperCase();	
		this.locked = true; // The door is locked by the enigma
	}

	/**
	 * This method allows the player to propose an answer to the enigma that keep the door locked.
	 * If the response is right, the door is unlocked.
	 * @param responseOfThePlayer The response the player is proposing
	 * @return A boolean to know if the response is good or not
	 */
	public boolean solveEnigma(String responseOfThePlayer){
		if(responseOfThePlayer.toUpperCase().equals(this.response)){
			this.locked = false;
			return true;
		}
		else{
			this.locked = true;
			return false;
		}
	}
	
	/**
	 * Function allowing the player to go in another room if the door is unlocked.
	 * @return The next room the player is going to enter. 
	 */
	public Room getNextRoom(){
		if(this.locked){
			return null;
		}
		else
			return this.nextRoom;
	}
	
	/**
	 * Function to know if the door is locked.
	 * @return A boolean to know if the door is locked or not (true if it is locked ; false if it is open)
	 */
	public boolean isLocked(){
		return this.locked;
	}
	
	/**
	 * Allows to knows the enigma for the enigmatic door
	 * @return The enigma of the enigmatic door
	 */
	public String getEnigma(){
		return this.enigma;
	}
	
	/**
	 * Allows to knows the answer of the enigma for the enigmatic door.
	 * @return The response of the enigma.
	 */
	public String getResponse(){
		return this.response;
	}

}
