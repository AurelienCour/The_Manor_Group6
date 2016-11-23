package the_Manor;

/**
 * <p>This class represents the character. It's an abstract class that will be the super-class, and thus will be inherited by the sub-classes.</p>
 * <p>A character has :</p>
 * </ul>
 * <li>A name : a string that will be defined</li>
 * <li>A description : a small description of the character (string)</li>
 * </ul>
 * 
 * @author Astemir Bekanov 
 * @version 22/11/2016
 */

public abstract class Character {

	protected String name; // the name of the Character
	protected String description; // a small description of the character
	
	/**
	 * If the name is empty give a default name "Character" to the character
	 * @param newName The name of the character
	 * @param InitialRoom The starting room of the character
	 */
	public Character (String newName, String description){
		if(newName.isEmpty())
			this.name="Character";
		else
			this.name = newName;
		this.description = description;
	}
	
	/**
	 * This method allows to return the name of the character
	 * @return name 
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * This method allows to return the description of the character
	 * @return description 
	 */
	public String getDescription(){
		return this.description;
	}
}
