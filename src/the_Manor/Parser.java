package the_Manor;

public class Parser {
	
private CommandWords command; //The command entered 
	
	/**
	 * The constructor of the Parser
	 * @param newCommand The command entered
	 */
	public Parser(CommandWords newCommand) {
		command = newCommand;
	}
	
	/**
	 * Returns the command entered
	 * @return command
	 */
	public CommandWords getCommand() {
		return command;
	}
	
}
