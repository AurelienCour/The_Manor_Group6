package the_Manor;

public class Parser {
	
private String command; //The command entered 
	
	/**
	 * The constructor of the Parser
	 * @param newCommand The command entered
	 */
	public Parser(String newCommand) {
		command = newCommand;
	}
	
	/**
	 * Returns the command entered
	 * @return command
	 */
	public String getCommand() {
		return command;
	}
	
}
