package rool;

import java.util.List;

public class StatisticsFactory extends CommandTool {

	public StatisticsFactory(List<String> parameters) {
		super(parameters);
		
	}

	@Override
	void help() {
		System.err.println("Performs statistical calculations on data entered online, one by one, or saved in a file.");
		System.err.println("Syntax :");
		System.err.println("		stats --type [mean|min|max|var|q1|q3|med|sum|(default) all] --round [int|(default) 2] (VALUES)");
		System.out.println("Note : if no value is entered, the program will ask you for each value one by one (type enter without entering a value to stop).");
		//TODO: data files
		System.out.println("Example :");
		System.out.println("		'stats --type mean --round 3 7,4,1,2,4,8,5,6,3,7' --> returns 4.7");
	}
	
}
