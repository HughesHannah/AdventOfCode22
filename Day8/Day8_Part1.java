import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Day8_Part1 {

	// initialise array list of array lists (assuming we don't know size of grid)
	public static ArrayList<ArrayList<Character>> vertical = new ArrayList<ArrayList<Character>>();

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

				ArrayList<Character> currentLineList = new ArrayList<Character>();

				// iterate over each element in the line
				for (int i = 0; i < nextLine.length(); i++) {
					currentLineList.add(nextLine.charAt(i));
				}

				vertical.add(currentLineList);

			} while (scanner.hasNextLine());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static int getVisibleTrees() {
		int noOfVisibleTrees = 0;
		int forrestWidth = vertical.get(0).size();
		int forrestLength = vertical.size();

		// all edges are visible
		noOfVisibleTrees += forrestLength * 2;
		noOfVisibleTrees += (forrestWidth - 2) * 2;

		// check interior visibility
		// iterate over all interior trees
		for (int i = 1; i < forrestWidth - 1; i++) {
			for (int j = 1; j < forrestLength - 1; j++) {

				int treeHeight = Character.getNumericValue(vertical.get(j).get(i));

				// check left visibility
				boolean visibleLeft = true;
				for (int k = 0; k < i; k++) {
					int adjacentTreeHeight = Character.getNumericValue(vertical.get(j).get(k));
					if (adjacentTreeHeight >= treeHeight) {
						visibleLeft = false;
					}
				}

				// check right visibility
				boolean visibleRight = true;
				if (!visibleLeft) {
					for (int k = i + 1; k < forrestWidth; k++) {
						int adjacentTreeHeight = Character.getNumericValue(vertical.get(j).get(k));
						if (adjacentTreeHeight >= treeHeight) {
							visibleRight = false;
						}
					}
				}

				// check up visibility
				boolean visibleUp = true;
				if (!visibleRight) {
					for (int k = 0; k < j; k++) {
						int adjacentTreeHeight = Character.getNumericValue(vertical.get(k).get(i));
						if (adjacentTreeHeight >= treeHeight) {
							visibleUp = false;
						}
					}
				}

				// check down visibility
				boolean visibleDown = true;
				if (!visibleUp) {
					for (int k = j + 1; k < forrestLength; k++) {
						int adjacentTreeHeight = Character.getNumericValue(vertical.get(k).get(i));
						if (adjacentTreeHeight >= treeHeight) {
							visibleDown = false;
						}
					}
				}

				// evaluate visibility
				if (visibleLeft || visibleRight || visibleUp || visibleDown) {
					noOfVisibleTrees++;
				}

			}
		}

		return noOfVisibleTrees;
	}

	public static void main(String[] args) {
		populate();
		System.out.println(getVisibleTrees());

	}

}
