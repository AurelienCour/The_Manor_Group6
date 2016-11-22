package the_Manor;

public class EnigmaticDoor extends Door{

	/**
	 * Constructor 
	 * @param enigma
	 * @param response
	 * @param nextRoom
	 */
	public EnigmaticDoor(String enigma, String response, Room nextRoom) {
		super(nextRoom);
	}

}
