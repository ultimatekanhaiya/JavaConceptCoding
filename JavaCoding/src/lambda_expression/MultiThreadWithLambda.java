package lambda_expression;

public class MultiThreadWithLambda {

	static Runnable r = () -> {
		for (int i = 0; i < 5; i++) {
			System.out.println("Child Thread");
		}
	};

	public static void main(String[] args) {
		Thread t = new Thread(r);
		t.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Main Thread");
		}
	}
}
