package oop;

public class Overloading {

	public static void main(String[] args) {

		Animal a = new Animal();
		m1(a);

		Monkey m = new Monkey();
		m1(m);

		Animal am = new Monkey();
		m1(am);
		
		/* IMPORTANT : 
		 * 
		 * In Overloading method resolution always takes care by compiler based on referenced type 
		 * hence overloading is also considered as compile time polymorphism or static polymorphism or early binding.
		 * 
		 * */

	}

	public static void m1(Animal a) {
		System.out.println("Animal version");
	}

	public static void m1(Monkey m) {
		System.out.println("Monkey version");
	}

}

class Animal {

}

class Monkey extends Animal {

}