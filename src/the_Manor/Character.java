package the_Manor;

/**
 * <p>This class represents the character. It's an abstract class that will be the super-class, and thus will be inherited by the sub-classes.</p>
 * <p>A character has :</p>
 * <ul>
 * <li>A name : a string that will be defined</li>
 * <li>A description : a small description of the character (string)</li>
 * </ul>
 * 
 * @author Group 6 
 * @version 23/11/2016
 */

public abstract class Character {

	private String name; // the name of the Character
	private String description; // a small description of the character
	
	/**
	 * <p>If the name is empty or null give a default name "Ally" to the character if it is an ally </p>
	 * <p>If the name is empty or null give a default name "Enemy" to the character if it is an enemy </p>
	 * <p>If the name is empty or null give a default name "Player" to the character if it is an player </p>
	 * <p>If the description is null give the default description "No description"</p>
	 * @param newName The name of the character
	 * @param description The description of the character
	 */
	public Character (String newName, String description){
		if((newName == null || newName.isEmpty())  && this instanceof Ally)
			this.name="Ally";
		else if((newName == null || newName.isEmpty()) && this instanceof Enemy)
			this.name="Enemy";
		else if((newName == null || newName.isEmpty()) && this instanceof Player)
			this.name="Player";
		else
			this.name = newName;
		if(description == null || description.isEmpty())
			description = "No description";
		this.description = description;
	}
	
	/**
	 * This method allows to return the name of the character
	 * @return The name of the character 
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * This method allows to return the description of the character
	 * @return The description of the character 
	 */
	public String getDescription(){
		return this.description;
	}
	
	/**
	 * To set the name of the player
	 * @param newName The name of the player
	 */
	public void setName(String newName){
		this.name = newName;
	}
	
	/**
	 * To set the description of the player
	 * @param newDescription The description of the player
	 */
	public void setDescription(String newDescription){
		this.description = newDescription;
	}
}
