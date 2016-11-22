package the_Manor;

/**
 * This EnigmaticDoor class stands for a door that is locked by an enigma. </br>
 * This enigma can be solved if the player propose the right solution.
 * @author Simon Hay
 * @version 22/11/2016
 */

public class EnigmaticDoor extends Door{
	
	// enigma that has to be solved
	private String enigma;
	// answer of the enigma
	private String response;
	// next room the player is going to enter
	private Room nextRoom;

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
		this.nextRoom = nextRoom;				
	}
	
	/**
	 * This method allows the player to propose an answer to the enigma that keep the door locked.
	 * @param responseOfThePlayer The response the player is proposing
	 * @return True if the answer is good, false if it is not.
	 */
	public Boolean solveEnigma(String responseOfThePlayer){
		if(responseOfThePlayer == response){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Function allowing the player to go in another room.
	 * @param nextRoom The next room the player is going to enter. 
	 * @return The next room the player is going to enter. 
	 */
	public Room goNextRoom(Room nextRoom){
		return nextRoom;
	}

}
