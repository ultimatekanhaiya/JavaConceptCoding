package lambda_expression;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierTest {

	public static void main(String[] args) {

		// supplier to get system date
		Supplier<Date> getDate = () -> new Date();

		System.out.println(getDate.get());
		
		System.out.println(generateOTP());

	}

	public static String generateOTP() {
		
		Supplier<String> getOTP = () -> {
			
			String otp = "";
			for(int i = 0; i < 6; i++) {
				otp +=(int)(Math.random()*10);
			}
			return otp;
		};
		
		return getOTP.get();
	}

}

/*
 * Supplier is an Interface contains single abstract method : get()
 * 
 * interface Supplier<R> { R get(); }
 * 
 * Supplier will not take any input but will always return something.
 * 
 */
