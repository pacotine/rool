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
		
		boolean isRunning = true;
		while(isRunning) {
			System.out.print(">>> ");
			Scanner scanner = new Scanner(System.in);
			String line = scanner.nextLine();
			String command = line.split(" ")[0];
			Pattern pattern = Pattern.compile("--\\w+ *\\w*");
			Matcher matcher = pattern.matcher(line);
			List<String> parameters = new ArrayList<String>();
			while(matcher.find()) {
				parameters.add(matcher.group());
			}
			
			switch (command) {
			case "stats":
				StatisticsFactory stats = new StatisticsFactory(parameters);
				break;

			default:
				System.out.println("Unknown command...");
				break;
			}
			
		}
		
		System.err.println("End of program");
	}

}
