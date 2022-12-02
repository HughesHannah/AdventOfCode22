import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day2_Part2 {

	public static int getPartTwoScore() {
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
		
		HashMap<Character, Character> losingCombos = new HashMap<Character, Character>();
		losingCombos.put('A', 'Z'); // Scissors loses against Rock
		losingCombos.put('B', 'X'); // Rock loses against Paper
		losingCombos.put('C', 'Y'); // Paper loses against Scissors

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
				char suggestedOutcome = nextLine.charAt(2);
				
				char myChoice;
				if (suggestedOutcome == 'Z') { //I should win
					myChoice = winningCombos.get(opponentChoice);
					
				}else if (suggestedOutcome == 'Y') { // I should Draw
					myChoice = matchingCombos.get(opponentChoice);
					
				}else { // I should lose 
					myChoice = losingCombos.get(opponentChoice);
					
				}
				
				// find game result
				// if its a draw, both players guess the same
				if(myChoice == matchingCombos.get(opponentChoice)) {
					// points for the shape I played plus 3 for the draw
					score += pointsForShapes.get(myChoice)+3;
					
				// if I win	
				}else if (myChoice == winningCombos.get(opponentChoice)) {
					// points for the shape I played plus 6 for the win
					score += pointsForShapes.get(myChoice)+6;
					
				// otherwise I lost	
				}else {
					// points for the shape I played only
					score += pointsForShapes.get(myChoice);
				}

			} while (scanner.hasNextLine());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return score;
	}

	public static void main(String[] args) {
		System.out.println(getPartTwoScore());

	}

}
