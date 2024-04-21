package streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPower {
    public static void main(String[] args) {

        System.out.println(reverseString("Hello world"));

        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(4, 1, 5, 3, 7, 2, 6));
        cube(list);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Raj", 80));
        students.add(new Student("Ravi", 70));
        students.add(new Student("Rohit", 75));
        students.add(new Student("Rahul", 90));
        students.add(new Student("Raju", 95));
        students.add(new Student("Anmol", 95));
        getStudent(students);

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
    public static void getStudent(List<Student> students) {
        students.stream().filter(s -> s.getStudentMarks() > 70).sorted(new Student()::compare)
                .forEach(System.out::println);
    }

    // hepler method to reverse single String word using StringBuffer.reverse()
    public static String reverseWord(String s) {
        return new StringBuffer(s).reverse().toString();
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
