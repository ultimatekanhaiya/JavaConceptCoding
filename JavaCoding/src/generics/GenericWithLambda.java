package generics;

public class GenericWithLambda {

	public static void main(String[] args) {

		Interf<Integer> i = (a, b) -> a + b;
		
		Interf<Integer> i2 = (a, b) -> 2 * (a + b);

		Interf<Integer> i3 = i.and(i2);

		System.out.println(i3.add(4, 5));
	}

}

@FunctionalInterface
interface Interf<T extends Number> {

	Integer add(T a, T b);

	default Interf<T> and(Interf<T> other) {
		return (a, b) -> add(a, b) + other.add(a, b);
	}

}

/*
 * In above default method we are returning lambda expression and lambda expression is implementation of abstract method 
 * of a Functional Interface to which it is referring.
 * 
 * Example : Predicate<Integer> p = i -> i > 10; So here (i -> i > 10) is lambda exp for test() method of Predicate<T> interface.
 * 
 * So in above case return type of and() method is Interface itself otherwise lambda cannot know which interface method it need to infer; 
 * and here it is implementation of add() method of Interf interface whose return type is integer because of this only we are 
 * able to use mathematical operators like +, -, *, / etc.   
 * 
 * 
 * */
 