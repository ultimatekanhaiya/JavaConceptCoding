package streamAPI;

import java.util.Comparator;

public class Student implements Comparable<Student>, Comparator<Student> {

	Student() {
		super();
	}

	Student(String name, int marks) {
		this.studentName = name;
		this.studentMarks = marks;
	}

	private String studentName;

	private int studentMarks;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String name) {
		this.studentName = name;
	}

	public int getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(int studentMarks) {
		this.studentMarks = studentMarks;
	}

	@Override
	public int compare(Student o1, Student o2) {
		// sorting in descending order
		if (o1.studentMarks == o2.studentMarks) {
			return o2.studentName.compareTo(o1.studentName);
		}
		return o2.studentMarks - o1.studentMarks;
	}

	@Override
	public int compareTo(Student o) {
		// sorting ascending order
		if (this.studentMarks == o.studentMarks) {
			return this.studentName.compareTo(o.studentName);
		}
		return this.studentMarks - o.studentMarks;
	}

	@Override
	public String toString() {
		return "studentName: " + this.studentName + ", studentMarks: " + this.studentMarks;
	}

}
