package streamAPI;

public class Student implements Comparable<Student> {

	Student() {
		super();
	}

	Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	private String name;

	private int marks;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public int compareTo(Student o) {
		// sorting ascending order
		if (this.marks == o.marks) {
			return this.name.compareTo(o.name);
		}
		return this.marks - o.marks;
	}

	@Override
	public String toString() {
		return "studentName: " + this.name + ", studentMarks: " + this.marks;
	}

}
