package Day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;


public class Day7_Part2 {
	private static HashSet<Directory> allDirectories = new HashSet<Directory>();
	private static Directory root = new Directory("/");

	public static void populateDirectory() {
		// start at root directory
		allDirectories.add(root);

		try {
			// load input
			File file = new File("/Users/Han/eclipse-workspace/AdventOfCode22/src/Day7/Day7_input");

			// initialise scanner
			Scanner scanner = new Scanner(file);

			// initialise a 'pointer' stack to show which directory we are currently in
			Deque<Directory> currentDirectory = new ArrayDeque<Directory>();

			do {
				String nextLine = scanner.nextLine();

				if (nextLine.charAt(0) == '$') { // its an input command

					if (nextLine.charAt(2) == 'c') {

						if (nextLine.charAt(5) == '/') { // go back to root directory

							currentDirectory.clear();
							currentDirectory.add(root);

						} else if (nextLine.charAt(5) == '.') { // go up a level
							if (currentDirectory.size() > 1) { // can't go up further if in root!
								currentDirectory.pop();
							}

						} else { // go into specified directory

							String inputDirectoryName = "";

							// get directory name
							for (int i = 5; i < nextLine.length(); i++) {
								inputDirectoryName += nextLine.charAt(i);
							}

							// find the directory to enter
							Directory inputDirectory = (Directory) currentDirectory.peek()
									.searchDirectory(inputDirectoryName);

							// if it is not the current directory, enter it
							if (currentDirectory.peek() != inputDirectory) {
								currentDirectory.push(inputDirectory); 
							}
						}
					} else if (nextLine.charAt(2) == 'l') {
						//do nothing //TODO does this do anything?
					}

				} else { // its the result of a list

					if (nextLine.charAt(0) == 'd') { // its a directory

						String inputDirectoryName = "";

						// get directory name
						for (int i = 4; i < nextLine.length(); i++) {
							inputDirectoryName += nextLine.charAt(i);
						}

						// check if that directory already exists
						// if not, create it and add it
						if (!currentDirectory.peek().contains(inputDirectoryName)) {
							Directory newDirectory = new Directory(inputDirectoryName);
							allDirectories.add(newDirectory);
							currentDirectory.peek().add(newDirectory);
						}

					} else { // its a file

						// get file size
						String[] splited = nextLine.split("\\s+");
						int fileSize = Integer.valueOf(splited[0]);

						// get file name
						String fileName = splited[1];

						// check if that file exists
						// if not, add it
						if (!currentDirectory.peek().contains(fileName)) {
							PhoneFile newFile = new PhoneFile(fileName, fileSize);
							currentDirectory.peek().add(newFile);
						}

					}

				}

			} while (scanner.hasNextLine());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static int getSizesBelow(int sizeNumber) {
		// return root.getSize();
		// return root.getSizeBelow(sizeNumber);

		int sizeTotal = 0;

		for (Directory a : allDirectories) {
			System.out.println("name is " + a.getName());
			System.out.println("size is " + a.getSize());

			int directorySize = a.getSize();
			if (directorySize <= sizeNumber) {
				sizeTotal += directorySize;
			}
		}

		return sizeTotal;

	}
	
	public static int getDeleteDirectorySize() {
		int requiredSize = 70000000-30000000;
		int totalSizeBeforeDelete = root.getSize();
		
		int smallestDeletionSize = totalSizeBeforeDelete; //deleting the root is the 'biggest' so start here
		
		// iterate through each file
		for(Directory a:allDirectories) {
			int directorySize = a.getSize();
			if((totalSizeBeforeDelete-directorySize)<=requiredSize) {
				if (directorySize<smallestDeletionSize) {
					smallestDeletionSize = directorySize;
				}
			}
		}
		
		
		return smallestDeletionSize;
	}

	public static void main(String[] args) {
		populateDirectory();

		System.out.println(getDeleteDirectorySize());

	}

}
