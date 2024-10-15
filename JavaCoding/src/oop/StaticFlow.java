package oop;

public class StaticFlow {

	static int i = 10;

	static {
		m1();
		System.out.println("First static block");
	}

	public static void main(String[] args) {
		m1();
		System.out.println("main method");
	}

	public static void m1() {
		System.out.println(j);
	}

	static {
		System.out.println("second static block");
	}

	static int j = 20;
}

// identification of static members from top to bottom
// execution of static variable assignment and static block from top to bottom
// execution of main method