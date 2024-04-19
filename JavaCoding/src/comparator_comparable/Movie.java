package comparator_comparable;

import java.util.Objects;

public class Movie implements Comparable<Movie> {

	private String name;
	private double rating;
	private int year;

	public Movie() {
		super();
	}

	public Movie(String name, double rating, int year) {
		super();
		this.name = name;
		this.rating = rating;
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public int compareTo(Movie o) {
		if (this.year < o.year) {
			return -1;
		}
		return this.year > o.year ? 1 : 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, rating, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(name, other.name);
	}

}
