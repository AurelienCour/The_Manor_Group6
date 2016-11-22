package the_Manor;

public class Character {

	protected String name; // the name of the Character
	protected String description; // a small description of the character
	
	/**
	 * This constructor
	 * @param newName The name of the character
	 * @param InitialRoom The starting room of the character
	 */
	public Character (String newName){
		name = newName;	
	}
	
	/**
	 * This method allows to return the name of the character
	 * @return name 
	 */
	public String getName(){
		return name;
		}




}
