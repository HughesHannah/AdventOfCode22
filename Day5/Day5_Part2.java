import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Day5_Part2 {

	public static String getStackTops() {
		String stackTops = "";

		try {
			// load input
			File file = new File("/Users/Han/eclipse-workspace/AdventOfCode22/src/Day5_input.txt");

			// initialise scanner
			Scanner scanner = new Scanner(file);

			// load existing stack arrangement
			// initialise 9 stacks - maybe there is a way to do this automatically
			Deque<Character> stackOne = new ArrayDeque<Character>();
			Deque<Character> stackTwo = new ArrayDeque<Character>();
			Deque<Character> stackThree = new ArrayDeque<Character>();
			Deque<Character> stackFour = new ArrayDeque<Character>();
			Deque<Character> stackFive = new ArrayDeque<Character>();
			Deque<Character> stackSix = new ArrayDeque<Character>();
			Deque<Character> stackSeven = new ArrayDeque<Character>();
			Deque<Character> stackEight = new ArrayDeque<Character>();
			Deque<Character> stackNine = new ArrayDeque<Character>();

			// Quickest (for me) to just manually 'load' the stacks (done with multi-cursor
			// in sublime)

			stackOne.push('F');
			stackOne.push('T');
			stackOne.push('C');
			stackOne.push('L');
			stackOne.push('R');
			stackOne.push('P');
			stackOne.push('G');
			stackOne.push('Q');

			stackTwo.push('N');
			stackTwo.push('Q');
			stackTwo.push('H');
			stackTwo.push('W');
			stackTwo.push('R');
			stackTwo.push('F');
			stackTwo.push('S');
			stackTwo.push('J');

			stackThree.push('F');
			stackThree.push('B');
			stackThree.push('H');
			stackThree.push('W');
			stackThree.push('P');
			stackThree.push('M');
			stackThree.push('Q');

			stackFour.push('V');
			stackFour.push('S');
			stackFour.push('T');
			stackFour.push('D');
			stackFour.push('F');

			stackFive.push('Q');
			stackFive.push('L');
			stackFive.push('D');
			stackFive.push('W');
			stackFive.push('V');
			stackFive.push('F');
			stackFive.push('Z');

			stackSix.push('Z');
			stackSix.push('C');
			stackSix.push('L');
			stackSix.push('S');

			stackSeven.push('Z');
			stackSeven.push('B');
			stackSeven.push('M');
			stackSeven.push('V');
			stackSeven.push('D');
			stackSeven.push('F');

			stackEight.push('T');
			stackEight.push('J');
			stackEight.push('B');

			stackNine.push('Q');
			stackNine.push('N');
			stackNine.push('B');
			stackNine.push('G');
			stackNine.push('L');
			stackNine.push('S');
			stackNine.push('P');
			stackNine.push('H');

			// have a map for number to stack object
			HashMap<Integer, Deque> stackNumberstoObjects = new HashMap<Integer, Deque>();
			stackNumberstoObjects.put(1, stackOne);
			stackNumberstoObjects.put(2, stackTwo);
			stackNumberstoObjects.put(3, stackThree);
			stackNumberstoObjects.put(4, stackFour);
			stackNumberstoObjects.put(5, stackFive);
			stackNumberstoObjects.put(6, stackSix);
			stackNumberstoObjects.put(7, stackSeven);
			stackNumberstoObjects.put(8, stackEight);
			stackNumberstoObjects.put(9, stackNine);

			// do instructions
			// go to start of instructions
			for (int i = 0; i < 10; i++) {
				scanner.nextLine();
			}

			do {
				// load the line
				String instructionLine = scanner.nextLine();

				// split string on spaces
				String[] splitInstruction = instructionLine.split("\\s+");

				int quantityToMove = Integer.valueOf(splitInstruction[1]);
				int moveFromStackNumber = Integer.valueOf(splitInstruction[3]);
				int moveToStackNumber = Integer.valueOf(splitInstruction[5]);

				// temp stack to transfer
				Deque<Character> stackTemp = new ArrayDeque<Character>();

				// get relevant stacks
				Deque stackFrom = stackNumberstoObjects.get(moveFromStackNumber);
				Deque stackTo = stackNumberstoObjects.get(moveToStackNumber);

				// add stacks to move to a temp 'pile'
				for (int i = 0; i < quantityToMove; i++) {
					stackTemp.push((char) stackFrom.pop());
				}

				// add stacks from temp pile to 'to' stack
				for (int i = 0; i < quantityToMove; i++) {
					stackTo.push(stackTemp.pop());

				}

			} while (scanner.hasNextLine());

			// finally return the top of each stack
			for (int i = 0; i < 9; i++) {
				Deque stack = stackNumberstoObjects.get(i + 1);
				stackTops += stack.peek();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return stackTops;

	}

	public static void main(String[] args) {
		System.out.println(getStackTops());

	}

}
