package generics;

import java.util.ArrayList;

public class Generics101 {

	public static void main(String[] args) {

		ArrayList list = new ArrayList();
		list.add(1);
		list.add("one");
		list.add(2);

		// in normal list elements are saved as Object, hence compulsory required
		// Type-casting
		String s = (String) list.get(1);

		// but there is no guaranty that all object can cast in same way
		String s1 = (String) list.get(0);// here we will get class cast exception 

		// using generics ArrayList<String>
		ArrayList<String> list2 = new ArrayList<>();
//		list2.add(2); // The method add(int, String) in the type ArrayList<String> is not applicable for the arguments (int)
		list2.add("hello");
		String s3 = list2.get(0);

		/*
		 * In ArrayList<String> we can add only String type of objects. By mistake if we
		 * are trying to add any other type we will get compile time error. Hence
		 * through generics we are getting type-safety. The return type of get() method
		 * is String & hence at the time of retrival we are not required to perform
		 * type-casting.
		 * 
		 */
		
		ArrayList<Double> dlist = new ArrayList<>();
//		dlist.add(1);// the method add(int, Double) in the type ArrayList<Double> is not applicable for the arguments (int)

	}

}
