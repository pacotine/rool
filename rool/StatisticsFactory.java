package rool;

import java.util.ArrayList;
import java.util.List;

public class StatisticsFactory extends CommandTool {
	
	private List<Double> data;

	public StatisticsFactory(List<String[]> parameters) {
		super(parameters);
		this.data = new ArrayList<Double>();
	}
	
	public void addData(String data, String delimiter) {
		for(String element : data.split(delimiter)) {
			this.data.add(Double.valueOf(element));
		}
		System.out.println(this.data.size());
	}
	
	private double mean() {
		double sum = 0.0;
		for(double e : this.data) {
			sum += e;
		}
		return sum/this.data.size();
	}

	@Override
	void help() {
		System.err.println("Performs statistical calculations on data entered online, one by one, or saved in a file.");
		System.err.println("Syntax :");
		System.err.println("		stats --type [mean|min|max|var|q1|q3|med|sum|(default) all] --round [int|(default) 2] --delim [your delimiter (default comma)] (VALUES)");
		System.out.println("Note : if no value is entered, the program will ask you for each value one by one (type enter without entering a value to stop).");
		//TODO: data files
		System.out.println("Example :");
		System.out.println("		'stats --type mean --round 3 7,4,1,2,4,8,5,6,3,7' --> returns 4.7");
	}

	@Override
	void execute() {
		String type = "all";
		for(String[] param : this.parameters) {
			if(param[0].equals("--type")) type = param[1];
		}
		switch (type) {
		case "mean":
			System.out.println("Mean : " + mean());
			break;

		default:
			break;
		}
	}
	
}
