package generics;

public class GenericWithLambda {

	public static void main(String[] args) {

		Interf<Integer> i = (a, b) -> a + b;

		Interf<Integer> i2 = (a, b) -> 2 * (a + b);

		Interf<Integer> i3 = i.mul(i2);

		System.out.println(i3.math(4, 5));

	}

}

@FunctionalInterface
interface Interf<T extends Number> {

	Integer math(T a, T b);

	default Interf<T> add(Interf<T> other) {
		return (a, b) -> math(a, b) + other.math(a, b);
	}

	default Interf<T> sub(Interf<T> other) {
		return (a, b) -> math(a, b) - other.math(a, b);
	}

	default Interf<T> mul(Interf<T> other) {
		return (a, b) -> math(a, b) * other.math(a, b);
	}

}
/*
 * 1. In above default method, we are returning lambda expression (return (a, b)
 * -> math(a, b) + other.math(a, b);) and lambda
 * expression is always implementation of abstract method of a Functional
 * Interface to which it is referring.
 * 
 * 2. Example : Predicate<Integer> p = i -> i > 10; So here (i -> i > 10) is
 * lambda exp for test() method of Predicate<T> interface.
 * 
 * 3. So in above case return type of and() method is (Interf<T>) interface
 * itself. Hence we can use lambda which is implementation of math() method of
 * Interf interface whose return type is integer because of this only we are
 * able to use mathematical operators like +, -, *, / etc.
 * 
 * 4. so basically lambda is representing the abstract method of functional
 * interface which is math() in our case.
 * 
 * 5. Whenever we saw anything like filter(Predicate<T> p), we can happily
 * replace it with lambda expression.
 * 
 * 6. So while using stream on list with filter it looks like :
 * list.stream().filter(e -> e.getAnything() >
 * something).collect(Collectors.toList());
 * here we replaced Predicate<T> p with = e -> e.getAnything() > something
 * 
 * 7. Interf<T> i = math() = (a,b) -> a+b; //we can provide whatever
 * implementation
 * of math method but it should return same return type
 */