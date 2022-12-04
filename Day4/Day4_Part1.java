import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Day4_Part1 {

	public static int getOverlapCount() {
		int count = 0;

		try {
			// load input
			File file = new File("/Users/Han/eclipse-workspace/AdventOfCode22/src/Day4_input.txt");

			// initialise scanner
			Scanner scanner = new Scanner(file);

			// loop over all bags
			do {
				// load first pair
				String pair = scanner.nextLine();

				// split into range one and range two
				String[] pairRanges = pair.split(",");

				String[] elfOneSegments = pairRanges[0].split("-");
				String[] elfTwoSegments = pairRanges[1].split("-");

				// split each elf range into high and low
				int elfOneLow = Integer.parseInt(elfOneSegments[0]);
				int elfOneHigh = Integer.parseInt(elfOneSegments[1]);
				int elfTwoLow = Integer.parseInt(elfTwoSegments[0]);
				int elfTwoHigh = Integer.parseInt(elfTwoSegments[1]);

				// is elf one a subset of elf two tasks
				if (elfOneLow >= elfTwoLow && elfOneHigh <= elfTwoHigh) {
					count++;

					// or is elf two a subset of elf one tasks
				} else if (elfTwoLow >= elfOneLow && elfTwoHigh <= elfOneHigh) {
					count++;
				}

			} while (scanner.hasNextLine());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(getOverlapCount());

	}

}
