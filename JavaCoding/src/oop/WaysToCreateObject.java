package oop;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class WaysToCreateObject {
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		// using new keyword
		ArrayList list = new ArrayList();

		// by using newInstance() method
//		ArrayList list2 = (ArrayList) Class.forName("ArrayList").newInstance(); //old
		ArrayList list2 = (ArrayList) Class.forName("ArrayList").getDeclaredConstructor().newInstance();

		// by using Factory method
		Runtime r = Runtime.getRuntime();

		// by using clone() method
		ArrayList list3 = (ArrayList) list.clone();

		// by using deserialization
		FileInputStream fis = new FileInputStream("");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList list4 = (ArrayList) ois.readObject();
	}

}
