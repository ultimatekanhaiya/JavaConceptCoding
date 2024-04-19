package comparator_comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorTest implements Comparator<Integer> {
	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<>();
		l.addAll(Arrays.asList(10, 0, 15, 5, 20));

		System.out.println("Before sorting  : " + l);

		// using predefine sorting(Asc)
		Collections.sort(l);

		// using our own defined sorting (without lambda)
		Collections.sort(l, new ComparatorTest());

		// using our own defined sorting(with lambda)
		Collections.sort(l, (o1, o2) -> {
			if (o1 > o2) {
				return -1;
			}
			return o1 < o2 ? 1 : 0;
		});

		System.out.println("After sorting  : " + l);
	}

	@Override
	public int compare(Integer o1, Integer o2) {
		if (o1 > o2) {
			return -1;
		}
		return o1 < o2 ? 1 : 0;
	}

}
/*
 * Comparator is an Interface which contains only single abstract method : compare() 
 * public int compare(Object obj1, Object obj2)
 * 
 * return -ve if obj1 has to come before obj2 
 * return +ve if obj1 has to come after obj2 
 * return 0 if obj1 and obj2 are equal
 * 
 */