package streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPower {
    public static void main(String[] args) {

        String s = "Hello world";

        // System.out.println(reverseString(s));

        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(4, 1, 5, 3, 7, 2, 6));

        // cube(list);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Raj", 80));
        students.add(new Student("Ravi", 70));
        students.add(new Student("Rohit", 75));
        students.add(new Student("Rahul", 90));
        students.add(new Student("Raju", 95));
        students.add(new Student("mandal", 95));
        students.add(new Student("Avdhesh", 60));
        students.add(new Student("Ankur", 50));
        students.add(new Student("priya", 83));
        students.add(new Student("preeti", 65));

        // getStudentMarksAbove70(students);

        // sortStudentDesc(students);

        // topThreeStudentMarks(students);

        // getStudentMarksLessThan3rdHighest(students);

        // findSumOfAllMarks(students);

        // averageStudtentMarksAbove70(students);

        // countOccurenceOfCharacters(s);

        // findDuplicates(s);

        getFirstNonReaptingCharacter(s);

    }

    // 1. reverse string word by word
    public static String reverseString(String s) {
        String[] sarr = s.split(" ");
        return Arrays.stream(sarr).map(StreamPower::reverseWord2).collect(Collectors.joining(" "));

    }

    // 2. get cube of int > 50 in sorted order
    public static void cube(List<Integer> list) {
        list.stream().map(e -> e * e * e).filter(c -> c > 50).sorted().forEach(System.out::println);
    }

    // 3. get student whose marks > 70 and sort them by marks if same marks then use
    // name.
    public static void getStudentMarksAbove70(List<Student> students) {
        students.stream().filter(s -> s.getMarks() > 70)
                .sorted()
                .forEach(System.out::println);
    }

    // hepler method to reverse single String word using StringBuffer.reverse()
    public static String reverseWord(String s) {
        return new StringBuffer(s).reverse().toString();
    }

    // sort student based on their marks in desc order
    public static void sortStudentDesc(List<Student> students) {
        students.stream().sorted((o1, o2) -> o2.getMarks() - o1.getMarks()).forEach(System.out::println);
    }

    // fetch top 3 marks student
    public static void topThreeStudentMarks(List<Student> students) {
        students.stream().sorted((o1, o2) -> o2.getMarks() - o1.getMarks()).limit(3).forEach(System.out::println);
    }

    // fetch all student having marks less than 3rd highest marks
    public static void getStudentMarksLessThan3rdHighest(List<Student> students) {
        students.stream().sorted((o1, o2) -> o2.getMarks() - o1.getMarks()).skip(3).forEach(System.out::println);
    }

    // find sum of all marks of students
    public static void findSumOfAllMarks(List<Student> students) {
        int result = students.stream().mapToInt(student -> student.getMarks()).reduce((a, b) -> a + b).getAsInt();
        System.out.println(result);

        // or
        int result2 = students.stream().mapToInt(student -> student.getMarks()).sum();
        // System.out.println(result2);

    }

    // fetch all students having marks > 70 and their marks avg.
    public static void averageStudtentMarksAbove70(List<Student> students) {
        double result = students.stream().mapToInt(student -> student.getMarks()).filter(s -> s > 70).average()
                .getAsDouble();
        System.out.println(result);

    }

    // count occurrences of each character in a string
    public static void countOccurenceOfCharacters(String s) {
        Map<String, Long> map = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        map.forEach((a, b) -> System.out.println(a + " -- " + b));

        for (Map.Entry<String, Long> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }

    // find all duplicate elements in a string
    public static void findDuplicates(String s) {
        Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1).forEach(System.out::println);

    }

    // find first non-reapting Character from a string
    public static void getFirstNonReaptingCharacter(String s) {

        String firstNonRepeatElement = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
                .filter(e -> e.getValue() == 1).findFirst().get().getKey();

        System.out.println(firstNonRepeatElement);

        // 1. HashMap doesn't preserve order of insertion, also we can't sort it by
        // using sorted() method of stream.
        // 2. char c is a primitive, so we can't use toString method on it.
        // 3. once stream is consumed we can't use it again for other operations.
        // Example : Stream<String> stream = Arrays.stream(s.split(""))
        // fisrt use : stream.collect(Collectors.groupingBy(e -> e,
        // Collectors.counting()));
        // second use : stream..filter(c -> map.containsKey(c) && map.get(c) ==
        // 1).limit(1).forEach(System.out::println);
    }

    // hepler method to reverse single String word custom
    public static String reverseWord2(String s) {
        char[] carr = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = carr[i];
            carr[i] = carr[j];
            carr[j] = temp;
            i++;
            j--;
        }
        return new String(carr);
    }

}
