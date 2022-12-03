import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Day3_Part1 {
	
	public static int getBagScore() {
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
				// load each bag
				String bag = scanner.nextLine();
				
				// split into two compartments
				String compartmentOne = bag.substring(0, (bag.length()/2));
				String compartmentTwo = bag.substring((bag.length()/2));
				
				// hashset first half
				HashSet<Character> itemsInCompartmentOne = new HashSet<Character>();
				for (int i=0; i<compartmentOne.length(); i++) {
					char itemInBag = compartmentOne.charAt(i);
					itemsInCompartmentOne.add(itemInBag);
				}
				
				// iterate through second half to find letter in first
				for (int i=0; i<compartmentTwo.length(); i++) {
					char itemInBag = compartmentTwo.charAt(i);
					
					if(itemsInCompartmentOne.contains(itemInBag)) {
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
		System.out.println(getBagScore());

	}

}
