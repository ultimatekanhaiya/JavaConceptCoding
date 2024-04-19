package lambda_expression;

import java.util.Arrays;
import java.util.TreeSet;

public class CollectionTreeSet {

	public static void main(String[] args) {

		TreeSet<Integer> ts = new TreeSet<>((o1, o2) -> o2 - o1);
		ts.addAll(Arrays.asList(new Integer[] { 2, 3, 6, 5, 4, 9, 8 }));
		System.out.println(ts);

		TreeSet<Student1> ts2 = new TreeSet<>();

		/*
		 * If we do not extend Comparable Interface in user define class then we will
		 * get : java.lang.ClassCastException: class testing.Student1 cannot be cast to
		 * class java.lang.Comparable As TreeSet uses "BalancedTree" which always save
		 * objects according to some sorting order.
		 */
		ts2.add(new Student1(101, "raj"));
		ts2.add(new Student1(102, "ravi"));
		ts2.add(new Student1(103, "kavi"));
		ts2.add(new Student1(104, "mavi"));

		System.out.println(ts2);
	}

}

class Student1 implements Comparable<Student1> {

	private int id;

	private String name;

	Student1() {
		super();
	}

	Student1(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		Student1 s = (Student1) o;
		return id == s.getId();
	}

	@Override
	public int compareTo(Student1 s) {
		return this.id - s.getId();
	}

	public String toString() {
		return "Name : " + name + " ID : " + id;
	}

}
