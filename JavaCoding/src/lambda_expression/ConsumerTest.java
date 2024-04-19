package lambda_expression;

import java.util.function.Consumer;

public class ConsumerTest {
	
	public static void main(String[] args) {
		
		Consumer<String> c = s -> System.out.println(s);
		c.accept("hello");
	}

}


/*
 *Consumer is an Interface contains only single abstract method : accept()
 * interface Consumer<T>
 *  {
 *  	void accept(T t);
 *  }
 * Consumer didn't return anything.
 * We can chain Consumer using andThen() method.
 * */
 