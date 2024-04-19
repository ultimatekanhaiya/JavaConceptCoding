package exceptions;

public class TryCatchFinallyTest {
	public static void main(String[] args) {
		System.out.println("statement 1");

		try {
			m1(0);
			System.out.println("statement 2");
		} catch (ArithmeticException ae) {
			m1(2);
		} finally {
			System.out.println("All resources closed");
		}
	}

	public static void m1(int a) {
		System.out.println(10 / a);
	}

}
