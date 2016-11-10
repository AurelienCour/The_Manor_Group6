package the_Manor;

public class CommandWords {
	
private Boolean validCommand;
	
	/**
	 * The constructor of CommandWords
	 * @param newCommand The command entered
	 */
	public CommandWords(Boolean newCommand) {
		validCommand = newCommand;
	}
	
	/**
	 * This methods says is a command is true or not
	 * @return validCommand The command 
	 */
	public Boolean isCommand() {
		return validCommand;
	}

}
