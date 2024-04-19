package streamAPI;

public class Student {

	Student() {
		super();
	}
	Student(String name, int marks) {
		this.studentMarks = marks;
		this.studentName = name;
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
	
	
}
