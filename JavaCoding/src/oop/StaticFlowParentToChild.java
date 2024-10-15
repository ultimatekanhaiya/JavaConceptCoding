package oop;

public class StaticFlowParentToChild {

	public static void main(String[] args) {
		Derived derived = new Derived();
		derived.main(new String[] {});
		System.out.println("Main main");
	}

}

class Base {

	static int i = 10;

	static {
		m1();
		System.out.println("Base");
	}

	public static void main(String[] args) {
		m1();
		System.out.println("Base main");
	}

	public static void m1() {
		System.out.println(j);
	}

	static int j = 20;
}

class Derived extends Base {

	static int x = 100;

	static {
		m2();
		System.out.println("Derived first");
	}

	public static void main(String[] args) {
		m2();
		System.out.println("Derived main");
	}

	public static void m2() {
		System.out.println(y);
	}

	static {
		System.out.println("Derived second");
	}

	static int y = 200;

}