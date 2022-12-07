import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Day6_Part2 {

	public static int getUniqueFourLocation() {
		int pointer = 15;

		try {
			// load input
			File file = new File("/Users/Han/eclipse-workspace/AdventOfCode22/src/Day6_input.txt");

			// initialise scanner
			Scanner scanner = new Scanner(file);
			String input = scanner.next();

			// I think it would be better to do a loop with a hasNextChar() function
			// then you wouldn't need to store the whole input in memory
			// ie only storing 4 characters and a pointer at any time
			for (int i = 14; i < input.length(); i++) {

				// create hashSet to check for unique characters
				HashSet<Character> uniqueSet = new HashSet<Character>();

				// populate fourteen to check
				for (int j = 0; j < 14; j++) {
					uniqueSet.add(input.charAt(i - j));
				}

				if (uniqueSet.size() == 14) {
					// all are unique!
					return pointer;
				}

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
