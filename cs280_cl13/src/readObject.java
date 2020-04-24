/* Read objects from a file.   
 * Need to downcast to get correct type.   */

import java.io.*;

public class readObject {

	/** Read objects of class ObjectInfo from a binary file and print them */
	public static void main(String[] args) throws Exception {

		ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(
				"C:\\CS280\\objects.dat"));
		ObjectInfo[] objs = new ObjectInfo[3];

		// Read and print the objects
		System.out.println("Print output:");
		for (int i = 0; i < objs.length; i++) {
			objs[i] = (ObjectInfo) inStream.readObject(); // returns Object-
															// downcast!
			System.out.println(objs[i]);
		}
		inStream.close();
	}
}
