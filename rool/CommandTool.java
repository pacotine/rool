package rool;

import java.util.List;

public abstract class CommandTool {
	
	protected List<String[]> parameters;
	
	public CommandTool(List<String[]> parameters) {
		this.parameters = parameters;
		if(parameters.size() == 0 || (parameters.size() == 1 && parameters.get(0)[0].equalsIgnoreCase("--help"))) help();
	}
	
	abstract void help();
	abstract void execute();

}
