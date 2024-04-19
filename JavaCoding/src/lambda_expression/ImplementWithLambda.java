package lambda_expression;

public class ImplementWithLambda {

	public static void main(String[] args) {

		SumInterface i = (a, b) -> a + b;
		System.out.println(i.sum(5, 3));
	}
}
