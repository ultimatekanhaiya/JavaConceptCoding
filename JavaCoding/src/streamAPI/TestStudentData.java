//REFERENCE : https://www.youtube.com/watch?v=Ul_7T2WJIuQ&ab_channel=JavaTechie

package streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestStudentData {
	public static void main(String[] args) {

		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("Raj", 20));
		studentList.add(new Student("kamal", 19));
		studentList.add(new Student("Ram", 30));
		studentList.add(new Student("Ravi", 25));
		applyGraceMarks(studentList);

		for (Student x : studentList) {
			System.out.println(x.getMarks());
		}

		List<Student> studentList2 = Arrays.asList(
				new Student(1, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 67,
						Arrays.asList("+912632632782", "+1673434729929")),
				new Student(2, "Pulkit", 56, "Male", "Computer Engineering", "Delhi", 67,
						Arrays.asList("+912632632762", "+1673434723929")),
				new Student(3, "Ankit", 25, "Female", "Mechanical Engineering", "Kerala", 164,
						Arrays.asList("+912632633882", "+1673434709929")),
				new Student(4, "Satish Ray", 30, "Male", "Mechanical Engineering", "Kerala", 26,
						Arrays.asList("+9126325832782", "+1671434729929")),
				new Student(5, "Roshan", 23, "Male", "Biotech Engineering", "Mumbai", 12,
						Arrays.asList("+012632632782")),
				new Student(6, "Chetan", 24, "Male", "Mechanical Engineering", "Karnataka", 12,
						Arrays.asList("+9126254632782", "+16736784729929")),
				new Student(7, "Arun", 26, "Male", "Electronics Engineering", "Karnataka", 324,
						Arrays.asList("+912632632782", "+1671234729929")),
				new Student(8, "Nam", 31, "Male", "Computer Engineering", "Karnataka", 433,
						Arrays.asList("+9126326355782", "+1673434729929")),
				new Student(9, "Sonu", 27, "Female", "Computer Engineering", "Karnataka", 7,
						Arrays.asList("+9126398932782", "+16563434729929", "+5673434729929")),
				new Student(10, "Shubham", 26, "Male", "Instrumentation Engineering", "Mumbai", 98,
						Arrays.asList("+912632646482", "+16734323229929")));

		// filterStudentRank(studentList2);
		// findStudentByCity(studentList2, "Karnataka");
		// extractAllDepartments(studentList2);
		// findAllContactNumbers(studentList2);
		// fetchStudentByDepartment(studentList2);
		// departmentWithMaxStudent(studentList2);
		// findAverageAgeOfMaleAndFemale(studentList2);
		// findHighestRankByDepartment(studentList2);
		// findSecondHighestRank(studentList2);
		// findNthHighestRank(studentList2, 2);
		// findAllStudentWithNthRank(studentList2, 5);
		findAllStudentWithNthRank(studentList2, 2);

	}

	public static List<Student> applyGraceMarks(List<Student> studentList) {
		return studentList
				.stream()
				.filter(i -> i.getMarks() < 30)
				.map(j -> {
					j.setMarks(j.getMarks() + 5);
					return j;
				}).collect(Collectors.toList());

	}

	// filter student rank between 50 to 100
	public static void filterStudentRank(List<Student> students) {
		students.stream().filter(e -> e.getRank() >= 50 && e.getRank() <= 100).forEach(System.out::println);
	}

	// find student who stay in X city and then sort by name
	public static void findStudentByCity(List<Student> students, String city) {
		students.stream().filter(e -> e.getCity().equals(city)).sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
				.forEach(System.out::println);

		// or
		students.stream().filter(e -> e.getCity().equals(city))
				.sorted(Comparator.comparing(Student::getName, Comparator.reverseOrder()))
				.forEach(System.out::println);
	}

	// extract all available department names
	public static void extractAllDepartments(List<Student> students) {
		students.stream().map(e -> e.getDept()).distinct().forEach(System.out::println);
	}

	// find all the contact numbers
	public static void findAllContactNumbers(List<Student> students) {
		students.stream().flatMap(e -> e.getContacts().stream()).distinct().forEach(System.out::println);
	}

	// count students by department
	public static void fetchStudentByDepartment(List<Student> students) {
		students.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.counting()))
				.forEach((a, b) -> System.out.println(a + " : " + b));
	}

	// find department with max students
	public static void departmentWithMaxStudent(List<Student> students) {

		Map.Entry<String, Long> result = students.stream()
				.collect(Collectors.groupingBy(Student::getDept, Collectors.counting()))
				.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println(result);

		// OR
		Map.Entry<String, Long> result2 = students.stream()
				.collect(Collectors.groupingBy(Student::getDept, Collectors.counting()))
				.entrySet().stream().reduce((a, b) -> a.getValue() > b.getValue() ? a : b).get();
		// System.out.println(result2);
	}

	// NOTE:important => find average of male and female students
	public static void findAverageAgeOfMaleAndFemale(List<Student> students) {
		students.stream().collect(Collectors.groupingBy(Student::getGender))
				.entrySet().stream().map(e -> {
					Double d = e.getValue().stream().mapToInt(f -> f.getAge()).average().getAsDouble();
					return e.getKey() + " : " + d;
				})
				.forEach(System.out::println);

		// OR
		Map<String, Double> map = students.stream()
				.collect(Collectors.groupingBy(Student::getGender,
						Collectors.averagingInt(Student::getAge)));
		System.out.println(map);
	}

	// find highest rank in each department
	public static void findHighestRankByDepartment(List<Student> students) {
		students.stream().collect(Collectors.groupingBy(Student::getDept))
				.entrySet().stream().map(e -> e.getValue().stream().min(Comparator.comparing(Student::getRank)).get())
				.forEach(System.out::println);

		// OR

		Map<String, Optional<Student>> stdMap = students.stream().collect(
				Collectors.groupingBy(Student::getDept, Collectors.minBy(Comparator.comparing(Student::getRank))));
		System.out.println(stdMap);
	}

	// find student with second highest rank
	public static void findSecondHighestRank(List<Student> students) {
		Student s2 = students.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst().get();
		System.out.println(s2);
	}

	// find nth highest rank of student
	public static void findNthHighestRank(List<Student> students, int n) {
		students.stream().sorted(Comparator.comparing(Student::getRank)).distinct().skip(n - 1).limit(1)
				.forEach(System.out::println);
	}

	// REFERENCE :
	// https://www.youtube.com/watch?v=eBDN04LlEOg&t=834s&ab_channel=JavaTechie
	// find all students with nth highest rank
	public static void findAllStudentWithNthRank(List<Student> students, int n) {
		Map.Entry<Integer, List<String>> s3 = students.stream()
				.collect(Collectors.groupingBy(Student::getRank,
						Collectors.mapping(Student::getName, Collectors.toList())))
				.entrySet().stream().sorted(Comparator.comparing(e -> e.getKey()))
				.collect(Collectors.toList()).get(n - 1);
		System.out.println(s3);

		// OR
		Map.Entry<Integer, List<String>> s4 = students.stream()
				.collect(Collectors.groupingBy(Student::getRank,
						Collectors.mapping(Student::getName, Collectors.toList())))
				.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
				.collect(Collectors.toList()).get(n - 1);

	}
}