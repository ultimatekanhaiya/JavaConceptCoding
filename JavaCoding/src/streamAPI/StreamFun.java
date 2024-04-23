package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFun {

	public static void main(String[] args) {

		Double[] darr = { 10.5, 10.6, 10.7, 10.8, 10.9 };

		Stream<Double> s = Stream.of(darr);
		s.forEach(System.out::println);

		// NOTE : different ways to create stream

		// From Collection
		List<Integer> salaryList = Arrays.asList(3000, 4000, 9000, 1000, 3500);
		Stream<Integer> streamFromIntegerList = salaryList.stream();

		// From Array
		Integer[] salaryArray = { 3000, 4000, 9000, 1000, 3500 };
		Stream<Integer> streamFromIntegerArray = Arrays.stream(salaryArray);

		// From static method
		Stream<Integer> streamFromStaticMethod = Stream.of(3000, 4000, 9000, 1000, 3500);

		// From stream builder
		Stream.Builder<Integer> streamBuilder = Stream.builder();
		streamBuilder.add(300).add(9000).add(4000);

		Stream<Integer> streamFromBuilder = streamBuilder.build();

		// From stream iterate
		Stream<Integer> streamFromIterate = Stream.iterate(1, e -> e + 2).limit(5);

		// NOTE : Intermediate operation on stream

		// filter
		// filters the elements
		Stream<String> mystream = Stream.of("Hello", "World", "Hi", "Bye", "See You");
		mystream.filter(e -> e.length() > 5).collect(Collectors.toList());

		// map
		// used to transform each element
		mystream.map(e -> e.toLowerCase()).collect(Collectors.toList());

		// flatMap(flatmap convert a 2D list into a 1D list)
		// used to iterate over each element of the complex collection and helps to
		// flatten it.
		List<List<String>> nestedList = Arrays.asList(
				Arrays.asList("I", "am", "learing", "java"),
				Arrays.asList("and", "java", "is", "fun"),
				Arrays.asList("it", "is", "easy", "to", "learn"));

		Stream<String> stringStream = nestedList.stream().flatMap(list -> list.stream().map(String::toLowerCase));

		// distinct
		// remove duplicates from stream
		Integer[] arr = { 2, 3, 4, 5, 3, 2, 6, 7, 8, 1 };
		Arrays.stream(arr).distinct().toArray(Integer[]::new);

		// sorted
		// sort the elements
		Arrays.stream(arr).sorted().toArray(Integer[]::new);

		// peek
		// helps you to see the intermediate results of the stream which is getting
		// processed
		// This method exists mainly to support debugging, where you want to see the
		// elements as they flow past a certain point in a pipeline:
		Stream.of("one", "two", "three", "four")
				.filter(e -> e.length() > 3)
				.peek(e -> System.out.println("Filtered value: " + e))
				.map(String::toUpperCase)
				.peek(e -> System.out.println("Mapped value: " + e))
				.collect(Collectors.toList());

		// limit
		// Truncate the stream, to have no longer than given maximum size
		List<Integer> numbers = Arrays.asList(2, 1, 3, 4, 6);
		numbers.stream().limit(3);// O/P: 2,1,3

		// skip
		// skip the first n elements of the stream
		numbers.stream().skip(3); // O/P: 4,6

		// mapToInt
		// helps to work with primitive "int" data types
		List<String> numberList = Arrays.asList("2", "4", "3", "5");
		numberList.stream().mapToInt(e -> Integer.parseInt(e));

		// NOTE: Terminal operations

		// forEach
		// perform action on each element of the stream DO NOT Return any value
		numbers.stream().forEach(System.out::println);

		// toArray
		// collects the elements of the stream into an array
		numbers.stream().filter(e -> e > 3).toArray();

		// reduce(BinaryOperator<T> accumulator)
		// does reduction on the elements of the stream. perform associative aggregation
		// function.
		numbers.stream().reduce((a, b) -> a + b).get();

		// collect(Collector<T,A,R> collector)
		// can be used to collect the elements of the stream into a list
		numbers.stream().filter(e -> e > 3).collect(Collectors.toList());

		// min(Comparator<T> comparator) and max(Comparator<T> comparator)
		// finds the minimum or maximum element from the stream based on the comparator
		// provided
		numbers.stream().min((a, b) -> a - b);

		// count
		// returns the count of elements present in the stream
		numbers.stream().count();

		// anyMatch(Predicate<T> predicate)
		// checks if any value in the stream match the given predicate and return the
		// boolean
		numbers.stream().anyMatch(val -> val > 3);// O/P true

		// allMatch(Predicate<T> predicate)
		// check if all the values in the stream match the given predicate and return
		// the boolean
		numbers.stream().allMatch(val -> val > 3);// O/P false

		// noneMatch
		// check if none of the values in the stream match the given predicate and
		// return
		// the boolean
		numbers.stream().noneMatch(val -> val > 3);// O/P false

		// findFirst
		// find the first element of the stream
		numbers.stream().filter(e -> e > 3).findFirst().get();

		// findAny
		// find any random element of the stream
		numbers.stream().filter(e -> e > 3).findAny().get();
	}

}
