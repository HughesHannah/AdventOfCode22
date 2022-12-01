import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day1 {

	public static int getMostCalories() {
		int mostCalories = 0; // assume there is at least one elf

		// get input
		// TODO: get from web page
		File file = new File("/Users/Han/eclipse-workspace/AdventOfCode22/src/Day1_input.txt");

		// initialise scanner
		Scanner scanner;

		// initialise count for elf calories
		int currentElfCalories = 0;

		try {
			scanner = new Scanner(file);

			do {
				// load the next line
				String nextLine = scanner.nextLine();

				if (!nextLine.isBlank()) { // if the line is a calorie count
					int thisLineCalories = Integer.valueOf(nextLine);

					currentElfCalories += thisLineCalories;

				} else { // otherwise its the end of an elf (and before the next one), so reset the
							// counter
					currentElfCalories = 0;

				}

				if (currentElfCalories > mostCalories) { // new max has been found for an elf
					mostCalories = currentElfCalories;
				}

			} while (scanner.hasNextLine());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return mostCalories;

	};

	public static void main(String[] args) {
		System.out.println(getMostCalories());
	}

}
