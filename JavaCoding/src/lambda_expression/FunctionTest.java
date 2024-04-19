package lambda_expression;

import java.util.function.Function;

public class FunctionTest {
	public static void main(String[] args) {
		
		String name = "Kanhaiya";
		
		Function<String,Integer> f = s -> s.length();		
		System.out.println(f.apply(name));
		
		String sentence = "Hi This Is Kanhaiya Sharma";
		
		System.out.println(removeAllSpaces(sentence));
		
		subStringToUpperCase("kanhaiyaSharma");
		
		ComposeVsAndThen(2);
	}
	
	public static String removeAllSpaces(String sentence) {
		Function<String,String> removeSpace = s -> s.replaceAll(" ", "");
		return removeSpace.apply(sentence);
	}
	
	public static Integer countSpaces(String sentence) {
		Function<String,Integer> removeSpace = s -> s.length() - s.replaceAll(" ", "").length();
		return removeSpace.apply(sentence);
	}
	
	//chaining of Functional Interface
	public static void subStringToUpperCase(String word) {
		
		Function<String,String> f = s -> s.toUpperCase();
		Function<String,String> f2 = s -> s.substring(0, 8);
		
		System.out.println(f.andThen(f2).apply(word));		
	}
	
	//compose() vs andThen()
	public static void ComposeVsAndThen(int number) {
		Function<Integer,Integer> f = i -> i + i;
		Function<Integer,Integer> f2 = i -> i*i*i;
		
		System.out.println("Compose : In compose f2 apply first then f1 : "  + f.compose(f2).apply(number));
		System.out.println("andThen : In andThen f1 apply first then f2 : "  + f.andThen(f2).apply(number));
	}
	 
}


/*
 * Function is a Interface contains only one abstract method : apply()
 * 1.To perform certain operation and to return some result we should go for function.
 * 2.interface Function<T,R> {
 * 		R apply(T t);
 * }
 * Function can take 2 type parameters. First one represent input argument type and
 * second one represent return type.
 * Function can return any type of value.
 * Instead of Function<T,R> we can use IntFunction<R>
 * 
 */
