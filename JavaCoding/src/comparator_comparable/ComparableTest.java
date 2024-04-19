package comparator_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class ComparableTest {
	public static void main(String[] args) {
		TreeSet<String> t = new TreeSet<>();
		t.add("K");
		t.add("Z");// Z.compareTo(K)
		t.add("A");// A.compareTo(K)
		t.add("A");// A.compareTo(A)
		System.out.println(t);

		// Example2
		ArrayList<Movie> list = new ArrayList<>();
		list.add(new Movie("Force Awakens", 8.3, 2015));
		list.add(new Movie("Star Wars", 8.7, 1977));
		list.add(new Movie("Empire Strikes Back", 8.8, 1980));
		list.add(new Movie("Return of the Jedi", 8.4, 1983));

		Collections.sort(list);

		System.out.println("Movies after sorting : ");
		for (Movie movie : list) {
			System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
		}
	}

}

/*
 * obj1.compareTo(obj2) NOTE: obj1 is always the object which is trying to be inserted. 
 * JVM internally calls compareTo method of Comparable Interface while inserting elements into treeSet.
 * Collections class contain two overloaded sort() methods.
 * 1. public static <T extends Comparable<? super T>> void sort(List<T> list)
 * 2. public static <T> void sort(List<T> list, Comparator<? super T> c)
 * Note: It is mandatory to implement Comparable Interface in our UserDefine class, if we want
 * to use Collection.sort() method.
 * 
 */