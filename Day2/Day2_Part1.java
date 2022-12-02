import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day2_Part1 {

	public static int getPartOneScore() {
		// store matching combinations (result ends in draw)
		HashMap<Character, Character> matchingCombos = new HashMap<Character, Character>();
		matchingCombos.put('A', 'X'); // Rock
		matchingCombos.put('B', 'Y'); // Paper
		matchingCombos.put('C', 'Z'); // Scissors
		
		// store winning results
		HashMap<Character, Character> winningCombos = new HashMap<Character, Character>();
		winningCombos.put('A', 'Y'); // Paper wins against Rock
		winningCombos.put('B', 'Z'); // Scissors wins against Paper
		winningCombos.put('C', 'X'); // Rock wins against Scissors

		// store points for shapes I play
		HashMap<Character, Integer> pointsForShapes = new HashMap<Character, Integer>();
		pointsForShapes.put('Y', 2);
		pointsForShapes.put('X', 1);
		pointsForShapes.put('Z', 3);
		// plus 6 for win, plus 3 for draw

		int score = 0;
		File file = new File("/Users/Han/eclipse-workspace/AdventOfCode22/src/Day2_input.txt");

		try {
			// initialise scanner
			Scanner scanner = new Scanner(file);

			//loop over all games
			do {
				// load each game
				String nextLine = scanner.nextLine();

				// extract choices from input
				char opponentChoice = nextLine.charAt(0);
				char suggestedChoice = nextLine.charAt(2);
				
				// find game result
				// if its a draw, both players guess the same
				if(suggestedChoice == matchingCombos.get(opponentChoice)) {
					// points for the shape I played plus 3 for the draw
					score += pointsForShapes.get(suggestedChoice)+3;
					
				// if I win	
				}else if (suggestedChoice == winningCombos.get(opponentChoice)) {
					// points for the shape I played plus 6 for the win
					score += pointsForShapes.get(suggestedChoice)+6;
					
				// otherwise I lost	
				}else {
					// points for the shape I played only
					score += pointsForShapes.get(suggestedChoice);
				}

			} while (scanner.hasNextLine());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return score;
	}

	public static void main(String[] args) {
		System.out.println(getPartOneScore());

	}

}
