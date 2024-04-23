package interfaces;

public class DefaultMethod implements interf1 {

	public static void main(String[] args) {
		DefaultMethod d = new DefaultMethod();
		d.m1();
	}

	@Override
	public void m1() {
		System.out.println("overriden default");
	}

}

interface interf1 {

	default void m1() {
		System.out.println("common default");
	}

}

// interface Interf {
// @Override
// // A default method cannot override a method from java.lang.Object
// default String toString() {
// return "";
// }
// }

/*
 * Interface default methods are by default available to the implementation
 * class, it can directly use it or override it if want its own
 * unique implementation.
 */
