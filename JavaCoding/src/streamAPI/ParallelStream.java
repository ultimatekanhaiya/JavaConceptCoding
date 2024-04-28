package streamAPI;

import java.util.Arrays;
import java.util.List;

public class ParallelStream {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99, 110);

        // sequential processing
        long sequentialProcessingStartTime = System.currentTimeMillis();
        numbers.stream().map(val -> val * val).forEach(System.out::println);
        System.out.println(
                "Sequential processing took: " + (System.currentTimeMillis() - sequentialProcessingStartTime) + " ms");

        // parallel processing
        long parallelProcessingStartTime = System.currentTimeMillis();
        numbers.parallelStream().map(val -> val * val).forEach(System.out::println);
        System.out.println(
                "Parellel processes took: " + (System.currentTimeMillis() - parallelProcessingStartTime) + " ms");

    }
}
