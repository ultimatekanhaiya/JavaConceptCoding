/*
 * Reference for Date checking isValid or not : 
 * 1.https://www.baeldung.com/java-string-valid-date
 * 2.https://howtodoinjava.com/java/date-time/date-validation/#:~:text=We%20can%20use%20LocalDate's%20parse,the%20string%20to%20Localdate%20instance.&text=The%20given%20below%20is%20a,MM%2Ddd%2Dyyyy%E2%80%9C.
 * 3. https://howtodoinjava.com/java/date-time/compare-localdates/
 * */

package date_and_time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidatorUsingLocalDate implements DateValidator {

	public static void main(String[] args) {

		DateTimeFormatter dateFormatter = DateTimeFormatter.BASIC_ISO_DATE;
		DateValidator validator = new DateValidatorUsingLocalDate(dateFormatter);
		System.out.println(validator.isValid("20190228"));
	}

	private DateTimeFormatter dateTimeFormatter;

	DateValidatorUsingLocalDate(DateTimeFormatter formatter) {
		this.dateTimeFormatter = formatter;
	}

	@Override
	public boolean isValid(String date) {
		try {
			LocalDate.parse(date, this.dateTimeFormatter);
		} catch (DateTimeParseException e) {
			return false;
		}
		return true;
	}

}
