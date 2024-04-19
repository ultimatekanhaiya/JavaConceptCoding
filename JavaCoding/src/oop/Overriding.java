package oop;

import java.io.EOFException;

public class Overriding {

	public static void main(String[] args) {

		Parent p = new Parent();
		p.m1();

		Child c = new Child();
		c.m1();

		Parent pc = new Child();
		pc.m1();
		
		/* IMPORTANT : 
		 * 
		 * In overriding method resolution always takes care by JVM based on runtime object
		 * and hence overriding is also considered as runtime polymorphism or dynamic polymorphism or late binding.
		 * 
		 * */
		
//		pc.m2(); can not call child method from parent reference
	}

}

class Parent {
	public void m1() {
		System.out.println("Parent version");
	}
}

class Child extends Parent {
	public void m1() {
		System.out.println("Child version");
	}

	public void m2() {
		System.out.println("extra Child method");
	}
}

class A {
	void m1() throws Exception {
		
	}
}

class B extends A {
	void m1() throws EOFException {}
}

class C extends B {
	void m1() throws EOFException {
		
	}
}