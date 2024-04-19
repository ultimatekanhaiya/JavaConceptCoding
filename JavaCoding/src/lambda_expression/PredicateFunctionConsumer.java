package lambda_expression;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateFunctionConsumer {

	public static void main(String[] args) {

		List<Student> list = populateStudentData();

		Predicate<Student> marksGreaterThan = s -> s.getMarks() > 60;

		Function<Student, String> getGrade = s -> {

			int marks = s.getMarks();

			if (marks >= 80) {
				return "A";
			} else if (marks >= 70) {
				return "B";
			} else if (marks >= 60) {
				return "C";
			} else {
				return "D";
			}
		};

		Consumer<Student> studentInfo = s -> System.out
				.println("Name: " + s.getName() + " | " + "Grade " + getGrade.apply(s));
		
		
		for(Student s : list) {
			if(marksGreaterThan.test(s)) {
				studentInfo.accept(s);
			}
		}
	}

	public static List<Student> populateStudentData() {

		List<Student> list = new ArrayList<>();
		list.add(new Student("kamal", 101, 80));
		list.add(new Student("raj", 102, 71));
		list.add(new Student("rahul", 103, 90));
		list.add(new Student("pawan", 104, 50));
		list.add(new Student("ravi", 105, 60));
		list.add(new Student("shivam", 106, 65));
		list.add(new Student("madhu", 107, 85));

		return list;

	}

}
