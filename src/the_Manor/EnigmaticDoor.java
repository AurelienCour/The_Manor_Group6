package the_Manor;

/**
 * <p>This EnigmaticDoor class stands for a door that is locked by an enigma. </p>
 * <p>This enigma can be solved if the player propose the right solution.</p>
 * @author Simon Hay
 * @version 22/11/2016
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
	 */
	public EnigmaticDoor(String enigma, String response, Room nextRoom) {
		super(nextRoom);
		this.enigma = enigma;
		this.response = response;	
		this.locked = true;
	}
	
	/**
	 * This method allows the player to propose an answer to the enigma that keep the door locked.
	 * If the response is right, the door is unlocked.
	 * @param responseOfThePlayer The response the player is proposing
	 */
	public void solveEnigma(String responseOfThePlayer){
		if(responseOfThePlayer.equals(this.response))
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
		else
			return this.nextRoom;
	}
	
	/**
	 * Function to know if the door is locked
	 * @return A boolean to know if the door is locked or not (true if is locked; false if is open)
	 */
	public boolean isLocked(){
		return this.locked;
	}

}
