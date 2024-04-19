package interfaces;

public class AmbigutyInDefault implements Left, Right {

	public static void main(String[] args) {

		AmbigutyInDefault a = new AmbigutyInDefault();
		a.m1();

	}

	@Override
	public void m1() {

		// my own impl of default method
		// System.out.println("My own implementation");

		// use Left Interface default method
		// Left.super.m1();

		// use Right Interface default method
		Right.super.m1();
	}

}

interface Left {
	default void m1() {
		System.out.println("Left default");
	}
}

interface Right {
	default void m1() {
		System.out.println("Right default");
	}
}