/* Write objects to a binary file.   */

import java.io.*;

public class writeObject {

	/**
	 * Create several objects of type ObjectInfo, print them to the console, and
	 * then write them to a file
	 */

	public static void main(String[] args) throws IOException {

		ObjectOutputStream outStream = new ObjectOutputStream(
				new FileOutputStream("C:\\CS280\\objects.dat"));

		ObjectInfo[] objs = new ObjectInfo[3];

		objs[0] = new ObjectInfo("John", "Sargent", 1234);
		objs[1] = new ObjectInfo("Jane", "Private", 4321);
		objs[2] = new ObjectInfo("Mary", "Colonel", 1432);

		// Print and write the objects to a file
		for (int i = 0; i < objs.length; i++) {
			System.out.println(objs[i]);
			outStream.writeObject(objs[i]);
		}
		outStream.close();
	}
}
