package generics;

import java.util.*;

public class WildCard {
	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList(new String[] { "2", "3", "6", "1", "4" }));
		m1(list);

		List<Integer> list2 = new ArrayList<>();
		list2.addAll(Arrays.asList(new Integer[] { 5, 7, 8, 2, 9, 1 }));
		m1(list2);

		ArrayList al2 = new ArrayList();
		al2.add("hello");
		al2.add("hi");
		al2.add("bye");
		al2.add(2);
		al2.add(3);

		String s = (String) al2.get(al2.size() - 1);   
		System.out.println(s);
	}

	public static void m1(List<?> list) {
		for (Object x : list) {
			System.out.println(x);
		}
	}

	public static <T> void m2(ArrayList<? extends Number> list) {

	}

	public static <T> void m3(ArrayList<? super Runnable> list) {

	}

	public static <T> void m4(T list) {

	}

}
