package Day7;

public class PhoneFile implements Component {

	// Variables
	private String name;
	private int size;

	// Constructor
	public PhoneFile(String name, int size) {
		this.name = name;
		this.size = size;
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	// Override toString method to return the file name.
	public String toString() {
		return name;
	}



}
