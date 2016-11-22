package the_Manor;
/**
 * This class represents the Character. It's an abstract class that will be the super-class, and thus will be inherited by the sub-classes.</br>
 * <ul>A character has : </ul>
 * <li> a name : a string that will be defined
 * <li> a description : a small description of the character (string)
 * @author astem
 * @version 22/11/2016
 *
 */

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
