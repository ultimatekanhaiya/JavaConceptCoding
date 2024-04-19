package lambda_expression;

//import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {
		
		String[] arr = {"Kamal", "kanhaiya", "prem", "ravi", "raju"};
		
		String[] sarr = {"Teja", "kanhaiya", "prem", "rahul", "raju", "", null};

		int[] x = { 0, 5, 10, 15, 20, 25, 30 };

		Predicate<Integer> p = i -> i > 10;
		Predicate<Integer> p2 = i -> i % 2 == 0;

		System.out.println("Array elements greater than 10");
		m1(p, x);

		System.out.println("Array elements / by 10");
		m1(p2, x);

		System.out.println("Array elements not greater than 10");
		m1(p.negate(), x);

		System.out.println("Array elements greater than 10 and / by 10");
		m1(p.and(p2), x);
		
		//get all name starts with K
		System.out.println("Name starts with K");
		nameStartsWithK(arr);
		
		System.out.println("Non null and empty elements of array");
		removeNullAndEmpty(sarr);
		
	}

	public static void m1(Predicate<Integer> p, int[] k) {

		for (int x : k) {
			if (p.test(x)) {
				System.out.println(x);
			}
		}
	}

	public static void nameStartsWithK(String[] arr) {
		Predicate<String> startsWithK = s -> s.charAt(0) == 'k' || s.charAt(0) == 'K';
		for (String s : arr) {
			if (startsWithK.test(s)) {
				System.out.println(s);
			}
		}
	}
	
	//predicate example to remove empty and null value of String array
	public static void removeNullAndEmpty(String[] arr) {
		Predicate<String> removeNUllEmpty = s -> s == null || s.isEmpty();
		for(String s : arr) {
			if(removeNUllEmpty.negate().test(s)) {
				System.out.println(s);
			}
		}
	}

}

/*
 * Predicate is a boolean function. 
 * 	interface Predicate<T> {
 * 		boolean test(T t);
 * 	}
 * Predicate Interface provides : boolean
 * test(T t) function. predicate also provides chaining function like : and(),
 * or(), negate().
 * Predicate Interface is available in java.util.function package.
 * 
 * Instead of using 'Predicate<Integer> p' we can use 'IntPredicate p'
 * 
 */
