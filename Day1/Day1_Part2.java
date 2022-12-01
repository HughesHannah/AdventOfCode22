import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1_Part2 {

	public static int getSumThreeMostCalories() {
		int mostCaloriesOne = 0; // assume there is at least three elfs
		int mostCaloriesTwo = 0;
		int mostCaloriesThree = 0;

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

				if (nextLine.isBlank() || !scanner.hasNextLine()) { // end of an elf (and before the next
																				// one), so reset the counter

					// TODO: might be better to just store in a BST or something then get top 3, but
					// would that be more memory?
					
					if (currentElfCalories > mostCaloriesOne) { // new max has been found for any elf!
						mostCaloriesThree = mostCaloriesTwo; // bump second place down to third place
						mostCaloriesTwo = mostCaloriesOne; // bump current first place down to second place
						mostCaloriesOne = currentElfCalories;
					} else if (currentElfCalories > mostCaloriesTwo) {
						mostCaloriesThree = mostCaloriesTwo; // bump second place down to third place
						mostCaloriesTwo = currentElfCalories;
					} else if (currentElfCalories > mostCaloriesThree) {
						mostCaloriesThree = currentElfCalories;
					}
					
					currentElfCalories = 0;

				} else { // if the line is a calorie count

					int thisLineCalories = Integer.valueOf(nextLine);

					currentElfCalories += thisLineCalories;

				}

			} while (scanner.hasNextLine());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return (mostCaloriesOne + mostCaloriesTwo + mostCaloriesThree);

	};

	public static void main(String[] args) {
		System.out.println(getSumThreeMostCalories());
	}

}
