import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Day3_Part2 {
	
	public static int getTeamScores() {
		int score=0;
		
		HashMap<Character, Integer> itemScores = new HashMap<Character, Integer>();
		
		//populate scores
		char item = 'a';
		for (int i=0; i<26; i++) {
			itemScores.put(item, i+1);
			item ++;
		}
		item = 'A';
		for (int i=0; i<26; i++) {
			itemScores.put(item, i+27);
			item ++;
		}

		
		try {
			// load input
			File file = new File("/Users/Han/eclipse-workspace/AdventOfCode22/src/Day3_input.txt");
			
			// initialise scanner
			Scanner scanner = new Scanner(file);

			//loop over all bags
			do {
				// load bags for first 3 elves
				String bagOne = scanner.nextLine();
				String bagTwo = scanner.nextLine();
				String bagThree = scanner.nextLine();
				
				// hashset first bag
				HashSet<Character> itemsInBagOne = new HashSet<Character>();
				for (int i=0; i<bagOne.length(); i++) {
					char itemInBag = bagOne.charAt(i);
					itemsInBagOne.add(itemInBag);
				}
				
				// hashset second bag
				HashSet<Character> itemsInBagTwo = new HashSet<Character>();
				for (int i=0; i<bagTwo.length(); i++) {
					char itemInBag = bagTwo.charAt(i);
					itemsInBagTwo.add(itemInBag);
				}
				
				// iterate through third bag to find item in both first and second
				for (int i=0; i<bagThree.length(); i++) {
					char itemInBag = bagThree.charAt(i);
					
					if(itemsInBagOne.contains(itemInBag) && itemsInBagTwo.contains(itemInBag)) {
						// get the score of the duplicated item
						score += itemScores.get(itemInBag);
						break; // assumes only one duplicate
					}
				}
				

			} while (scanner.hasNextLine());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return score;
	}
	

	public static void main(String[] args) {
		System.out.println(getTeamScores());

	}

}
