package the_Manor;

/**
 * <p>This EnigmaticDoor class stands for a door that is locked by an enigma. </p>
 * <p>This enigma can be solved if the player propose the right solution.</p>
 * @author Group 6
 * @version 23/11/2016
 */

public class EnigmaticDoor extends Door{
	
	// the enigma that has to be solved
	private String enigma;
	// the answer of the enigma
	private String response;
	//
	private boolean locked;

	/**
	 * Constructor of the class EnigmaticDoor. 
	 * @param enigma The enigma that has to be solved to pass the door
	 * @param response The response of the enigma
	 * @param nextRoom The next room the player is going to enter after having solved the enigma
	 * @param previousRoom The previous room
	 */
	public EnigmaticDoor(String enigma, String response, Room nextRoom, Room previousRoom) {
		super(nextRoom,previousRoom);
		if(enigma == null || enigma.isEmpty()){
			System.out.println("Default enigma");
			this.enigma = "No enigma, response : No enigma";
		}
		else
			this.enigma = enigma;
		if(response == null || response.isEmpty()){
			System.out.println("Default response");
			this.response = "NO ENIGMA";
		}
		else
			this.response = response.toUpperCase();	
		this.locked = true;
	}
	
	/**
	 * This method allows the player to propose an answer to the enigma that keep the door locked.
	 * If the response is right, the door is unlocked.
	 * @param responseOfThePlayer The response the player is proposing
	 */
	public void solveEnigma(String responseOfThePlayer){
		if(responseOfThePlayer.toUpperCase().equals(this.response))
			this.locked = false;
		else
			this.locked = true;
	}
	
	/**
	 * Function allowing the player to go in another room.
	 * @return The next room the player is going to enter. 
	 */
	public Room goNextRoom(){
		if(this.locked)
			return null;
		else{
			System.out.println("The door is closed, you need a key");
			return this.nextRoom;
		}
	}
	
	/**
	 * Function to know if the door is locked
	 * @return A boolean to know if the door is locked or not (true if is locked; false if is open)
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
	 * Allows to knows the response of the enigma for the enigmatic door
	 * @return The response of the enigma
	 */
	public String getResponse(){
		return this.response;
	}

}
