package rool;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.err.println("Welcome to # rool #");
		Pattern pattern = Pattern.compile("--\\w+ *[^\\s]*");
		Matcher matcher = null;
		String line, command = "";
		List<String[]> parameters = new ArrayList<String[]>();
		
		boolean isRunning = true;
		while(isRunning) {
			System.out.print(">>> ");
			Scanner scanner = new Scanner(System.in);
			parameters.clear();
			line = scanner.nextLine();
			command = line.split(" ")[0];
			matcher = pattern.matcher(line);
			while(matcher.find()) {
				String str = matcher.group();
				if(str.split(" ").length == 1) {
					parameters.add(new String[] {str, null});
				} else {
					String[] split = str.split("\\s+");
					parameters.add(new String[] {split[0], split[1]});
				}
			}
			System.out.println("command '" + command + "' with params :");
			for(String[] param : parameters) {
				System.out.println(param[0] + " / " + param[1]);
			}
			
			switch (command) {
			case "stats":
				StatisticsFactory stats = new StatisticsFactory(parameters);
				String delimiter = ",";
				for(String[] param : parameters) {
					if(param[0].equals("--delim")) delimiter = param[1];
				}
				String data = null;
				Matcher dataMatcher = Pattern.compile("[\\d+\\s*" + delimiter + "\\s*\\d+]+").matcher(line.replace(" ", ""));
				if(dataMatcher.find()) {
					data = dataMatcher.group(); 
				}
				stats.addData(data, delimiter);
				stats.execute();
				break;

			default:
				System.out.println("Unknown command...");
				break;
			}
			
		}
		
		System.err.println("End of program");
	}

}
