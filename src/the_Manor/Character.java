package the_Manor;

public class Character {

private String name; // the name of the Character
private Room currentRoom; // the current Room position of the character
private String description; // a small description of the character

/**
 * This constructor
 * @param newName The name of the character
 * @param InitialRoom The starting room of the character
 */
public Character (String newName, Room InitialRoom){
	name = newName;
	currentRoom = InitialRoom;
	
}
	/**
	 * This method returns the current room of the character
	 * @return currentRoom 
	 */
	public Room getCurrentRoom(){
		return currentRoom;
		}
	
	/**
	 * This method allows to return the name of the character
	 * @return name 
	 */
	public String getName(){
		return name;
		}



}
