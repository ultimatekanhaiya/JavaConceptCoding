/*
 * Reference : https://howtodoinjava.com/java8/comparator-example-lambda/
 * https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/
 * */
package comparator_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorTest2 {
	public static void main(String[] args) {
		ArrayList<Movie> list = new ArrayList<>();
		list.add(new Movie("Force Awakens", 8.3, 2015));
		list.add(new Movie("Force Awakens", 8.3, 2014));
		list.add(new Movie("Star Wars", 8.7, 1977));
		list.add(new Movie("Empire Strikes Back", 8.8, 1980));
		list.add(new Movie("Return of the Jedi", 8.4, 1983));

		Collections.sort(list, new SortMovieByName());
		
		//sorting a movie based on name but if similar name then on bases of year in acs order.
		Collections.sort(list, (m1, m2) -> {
			if (!m1.equals(m2)) {
				return m1.getName().compareTo(m2.getName());
			}
			return m1.getYear() - m2.getYear();
		});
		
		//using method reference
		Collections.sort(list, Comparator.comparing(Movie::getName).thenComparing(Movie::getYear));
		
		System.out.println("Movies after sorting : ");
		for (Movie movie : list) {
			System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
		}
	}

}

class SortMovieByName implements Comparator<Movie> {

	@Override
	public int compare(Movie o1, Movie o2) {
		return o1.getName().compareTo(o2.getName());
	}

	class SortMovieByYear implements Comparator<Movie> {

		@Override
		public int compare(Movie o1, Movie o2) {
			if (o1.getYear() < o2.getYear()) {
				return -1;
			}
			return o1.getYear() > o2.getYear() ? 1 : 0;
		}

	}

}