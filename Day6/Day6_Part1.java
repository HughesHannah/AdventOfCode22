import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day6_Part1 {

	public static int getUniqueFourLocation() {
		int pointer = 4;

		try {
			// load input
			File file = new File("/Users/Han/eclipse-workspace/AdventOfCode22/src/Day6_input.txt");

			// initialise scanner
			Scanner scanner = new Scanner(file);
			String input = scanner.next();

			// load the first 3 characters
			char charOne = input.charAt(0);
			char charTwo = input.charAt(1);
			char charThree = input.charAt(2);

			// I think it would be better to do a loop with a hasNextChar() function
			// then you wouldn't need to store the whole input in memory
			// ie only storing 4 characters and a pointer at any time
			for (int i = 3; i < input.length(); i++) {
				char charFour = input.charAt(i);

				boolean checkUnique = true;
				if (charOne == charTwo || charOne == charThree || charOne == charFour) {
					checkUnique = false;
				}
				if (charTwo == charThree || charTwo == charFour) {
					checkUnique = false;
				}
				if (charThree == charFour) {
					checkUnique = false;
				}

				if (checkUnique) {
					return pointer;
				}

				// 'reset' for next loop
				charOne = charTwo;
				charTwo = charThree;
				charThree = charFour;
				pointer++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return pointer;

	}

	public static void main(String[] args) {
		System.out.println(getUniqueFourLocation());

	}

}
