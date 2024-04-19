package streamAPI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestStudentData {
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("Raj",20));
		studentList.add(new Student("kamal",19));
		studentList.add(new Student("Ram",30));
		studentList.add(new Student("Ravi",25));
		applyGraceMarks(studentList);
		
		for(Student x : studentList) {
			System.out.println(x.getStudentMarks());
		}
		
	}
	
	public static List<Student> applyGraceMarks(List<Student> studentList) {
		return studentList
				.stream()
				.filter(i -> i.getStudentMarks() < 30)
				.map(j -> {j.setStudentMarks(j.getStudentMarks()+5); return j;}).collect(Collectors.toList());
				
	}
}
