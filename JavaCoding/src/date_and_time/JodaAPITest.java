/*
 * Reference to look for Date format and conversion : https://mkyong.com/java8/java-8-how-to-convert-string-to-localdate/
 * Important classes in Joda Api
 * 1.LocalDate, 2.LocalTime, 3.LocalDateTime, 4.Period, 5.Year, 6.ZoneId, 7.ZoneDateTime etc.
 * */

package date_and_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class JodaAPITest {

	public static void main(String[] args) {

		LocalDate date = LocalDate.now();
		System.out.println(date);

		LocalDate d = LocalDate.of(2022, 03, 27);
		System.out.println(d);

		LocalTime time = LocalTime.now();
		System.out.println(time);

		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);

		int dd = date.getDayOfMonth();
		int mm = date.getMonthValue();
		int yyyy = date.getYear();

		System.out.printf("%d-%d-%d", dd, mm, yyyy);
		System.out.println();

		System.out.println(stringToLocalDate("16-03-2022"));
			
		ZoneId id = ZoneId.of("America/Los_Angeles");
		ZonedDateTime dt = ZonedDateTime.now(id);
		System.out.println(dt);
		
		getAge("04-09-1996");
	}

	public static LocalDate stringToLocalDate(String date) {

		// Note: If the String is in ISO_LOCAL_DATE(yyyy-mm-dd -> 2022-08-16) format, we
		// can parse the String directly, no need conversion.
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");

//		String test = "2022-08-16";
//		LocalDate d1 = LocalDate.parse(test);

		return LocalDate.parse(date, formatter);
	}

	public static void getAge(String birthYear) {
		LocalDate birthday = stringToLocalDate(birthYear);
		LocalDate today = LocalDate.now();

		Period p = Period.between(birthday, today);

		System.out.printf("Your Age is %d years, %d months, %d days", p.getYears(), p.getMonths(), p.getDays());

	}

}
