package lambda_expression;

public class ImplementWithoutLambda {

	public static void main(String[] args) {

		SumInterface i = new Demo();

		System.out.println(i.sum(2, 3));
	}
}

class Demo implements SumInterface {

	@Override
	public int sum(int a, int b) {
		return a + b;
	}

}

/*
 * If we didn't use Lambda Expression then we have to create a implementation class
 * first and then provide the implementation for Interface method.Then only we use that
 * method.
 * But if we are using Lambda Expression then there is no need for Implementation class
 * we can directly provide implementation for interface method and use it.
 * 
 * */
 