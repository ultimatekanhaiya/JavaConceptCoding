package streamAPI;

import java.util.stream.Stream;

public class StreamOf {

	public static void main(String[] args) {

		Double[] darr = { 10.5, 10.6, 10.7, 10.8, 10.9 };

		Stream<Double> s = Stream.of(darr);

		s.forEach(System.out::println);

	}

}
