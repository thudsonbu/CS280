/** ObjectInfo.java  - class for use in object read/write example */

import java.io.*;   

public class ObjectInfo implements Serializable {

	private String name, rank;
	private int serialNo;

	/** 3-arg constructor for creating new ObjectInfo object */
	public ObjectInfo(String n, String r, int s) {

		name = n;
		rank = r;
		serialNo = s;
	}

	/** Return string describing ObjectInfo instance */
	public String toString() {
		return "Name: " + name + " \tRank: " + rank + "\tSerialNumber: "
				+ serialNo;
	}
}
