package Day7;

import java.util.HashSet;
import java.util.Set;

public class Directory implements Component {
	// Variables
	private String name;
	private HashSet<Component> set;

	// Constructor
	public Directory(String name) {
		set = new HashSet<Component>();
		this.name = name;
	}

	public String getName() {
		// Return the Directory name.
		return name;
	}

	public int getSize() {
		// Initialise variable.
		int size = 0;

		// Iterate over the set and retrieve the size of each Component
		// add each of these to the size variable.
		for (Component s : set) {
			size += s.getSize();
		}
		return size;
	}
	
//	public int getSizeBelow(int sizeNumber) {
//		// Initialise variable.
//		int sizeBelow = 0;
//
//		// Iterate over the set and retrieve the size of each Component
//		// add each of these to the size variable.
//		for (Component s : set) {
//			if (s.getSize()<= sizeNumber){
//				sizeBelow += s.getSize();
//			}
//		}
//		return sizeBelow;
//	}

	// Add components from the HashSet
	public void add(Component a) {
		set.add(a);
	}

	// Remove components from the HashSet
	public void remove(Component a) {
		set.remove(a);
	}

	// Override toString method to return the directory name.
	public String toString() {
		return name;
	}

	public Component searchDirectory(String name) {
		// Search each component in the set
		for (Component a : set) {
			// If we find the directory, return the directory
			if (a.getName().equals(name)) {
				return a;
			}
		}
		// If we don't find the directory, return the current directory.
		return this;
	}

	public boolean contains(String name) {
		// Search each component in the set
		for (Component a : set) {
			if (a.getName() == name) {
				return true;
			}
		}
		return false;
	}

}
