/*
 * If we want to provide implementation to an interface method m1() and we already have another method m2()
 * with the same required implementation then we should go for method reference. So m1 is referring to m2
 * Interf i = MethodReferenceTest::m2
 * Best benefit of this is code reusability.
 * NOTE : To use method reference compulsory both method should have same arguments type.
 * Method name can be different, return can be different, modifier can be different.
 * syntax for method reference
 * 	static :
 * 		className::methodName -> Test::m2
 * 	instance :
 * 		objectReference::methodName -> t::m3 or new Test()::m3
 * NOTE: We can use method-Reference and lambda-expression for functional interface only, and both can replace
 * each other.
 * 
 * NOTE :
 * Q. Does a Test constructor run when creating new Test[] array?
 * A. No, when you create a new array of objects using Test[]::new, the individual constructors for the Test objects 
 * are not automatically invoked. The array is created, but the elements within the array (individual Test objects) are 
 * not instantiated until you explicitly create them.

 * Q. How constructor reference of Test array : Test[]::new get it size?
 * A. The Test[]::new syntax is a special case for array creation where the size is implicitly determined when the 
 * array is actually created. Unlike with other constructor references, you don't need to explicitly pass the size 
 * when using Test[]::new in the context of array creation. The size is determined dynamically at runtime.
 
 * */

package method_reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodReferenceTest {
	public static void main(String[] args) {

		// ********method reference**********

		// instance method reference
		Interf i = new MethodReferenceTest()::m3;
		i.m1();

		// static method reference
		Interf i2 = MethodReferenceTest::m2;
		i2.m1();

		// *********constructor reference**********

		// using lambda
		Interf1 j = (a) -> new Sample[a];
		j.m1(2);

		// using constructor reference
		Interf1 k = Sample[]::new;
		k.m1(2);

		toArray(Sample[]::new);

		// Example :
		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(new Integer[] { 20, 10, 30, 50, 5 }));

		Integer[] arr = list.stream().toArray(Integer[]::new);
		for (int x : arr) {
			System.out.println(x);
		}
	}

	public static void m2() {
		System.out.println("static method reference");
	}

	public void m3() {
		System.out.println("instance method reference");
	}

	public static <A> A[] toArray(Interf1<A[]> inf) {
		return null;
	}

}

class Sample {
	Sample() {
		System.out.println("Sample constructor");
	}
}

interface Interf {
	void m1();
}

interface Interf1<R> {
	R m1(int i);
}
