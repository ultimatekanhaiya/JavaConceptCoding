/**
 * Using generics concept to create utility methods
 * Creating a singleton list/set. (Collections.singletonList(T item))
 * A utility to find the first element in a list matching a condition.
 * Converting an array to a List.
 */
package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MyCollectionUtils {
    public static void main(String[] args) {

        String[] names = {"Alice", "Bob", "Charlie"};
        List<String> nameList = arrayToList(names);
        System.out.println(findFirstMatch(nameList, s -> s.startsWith("C")));

        Integer[] numbers = {1, 2, 35, 4, 45};
        List<Integer> numList = arrayToList(numbers);
        System.out.println(findFirstMatch(numList, e -> e > 25));


    }

    public static <T> List<T> arrayToList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    public static <T> T findFirstMatch(List<T> list, Predicate<T> condition) {
        for (T el : list) {
            if (condition.test(el)) return el;
        }
        return null;
    }

}
