import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Day8_Part2 {

	// initialise array list of array lists (assuming we don't know size of grid)
	public static ArrayList<ArrayList<Integer>> vertical = new ArrayList<ArrayList<Integer>>();

	public static void populate() {

		try {
			// load input
			File file = new File("/Users/Han/eclipse-workspace/AdventOfCode22/src/Day8_input.txt");

			// initialise scanner
			Scanner scanner = new Scanner(file);
			int lineNumber = 0;

			do {
				String nextLine = scanner.nextLine();
				lineNumber++;

				ArrayList<Integer> currentLineList = new ArrayList<Integer>();

				// iterate over each element in the line
				for (int i = 0; i < nextLine.length(); i++) {
					currentLineList.add(Character.getNumericValue(nextLine.charAt(i)));
				}

				vertical.add(currentLineList);

			} while (scanner.hasNextLine());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static int getHighestScore() {
		int highestViewingScore = 0;
		int forrestWidth = vertical.get(0).size();
		int forrestLength = vertical.size();

		// iterate over all inner trees (all outer have a score of 0)
		for (int x = 1; x < forrestWidth - 1; x++) {
			for (int y = 1; y < forrestLength - 1; y++) {
				int treeHeight = vertical.get(y).get(x);

				// check left visibility
				int visibilityLeft = 0;

				for (int i = (x - 1); i >= 0; i--) {
					visibilityLeft++;

					int adjacentTreeHeight = vertical.get(y).get(i);

					if (adjacentTreeHeight >= treeHeight) {
						break;
					}
				}

				// check right visibility
				int visibilityRight = 0;

				for (int i = x + 1; i < forrestWidth; i++) {
					visibilityRight++;
					int adjacentTreeHeight = vertical.get(y).get(i);
					if (adjacentTreeHeight >= treeHeight) {
						break;
					}
				}

				// check up visibility
				int visibilityUp = 0;

				for (int i = y-1; i >= 0; i--) {
					visibilityUp++;
					int adjacentTreeHeight = vertical.get(i).get(x);
					if (adjacentTreeHeight >= treeHeight) {
						break;
					}
				}

				// check down visibility
				int visibilityDown = 0;

				for (int i = y + 1; i < forrestLength; i++) {
					visibilityDown++;
					int adjacentTreeHeight = vertical.get(i).get(x);
					if (adjacentTreeHeight >= treeHeight) {
						break;
					}
				}

				// evaluate visibility
				int visibilityScore = visibilityLeft * visibilityRight * visibilityUp * visibilityDown;

				System.out.println("TREE HEIGHT: " + treeHeight);
				System.out.println("Left: " + visibilityLeft);
				System.out.println("Right: " + visibilityRight);
				System.out.println("Up: " + visibilityUp);
				System.out.println("Down: " + visibilityDown);
				System.out.println("SCORE " + visibilityScore);
				System.out.println();

				if (visibilityScore > highestViewingScore) {
					highestViewingScore = visibilityScore;
				}

			}
		}

		return highestViewingScore;
	}

	public static void main(String[] args) {
		populate();
		System.out.println(getHighestScore());

	}

}
