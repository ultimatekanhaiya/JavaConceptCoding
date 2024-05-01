package string_formatting;

import java.util.Arrays;
import java.util.List;

public class StringMethods {
    public static void main(String[] args) {
        List<String> nos = Arrays.asList("1", "2", "3", "4", "5");
        String result = String.join("-", nos);
        System.out.println(result);// output : 1-2-3-4-5
        // testing
    }

}
