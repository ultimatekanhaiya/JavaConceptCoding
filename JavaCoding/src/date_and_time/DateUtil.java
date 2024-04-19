/*
 * References for different conversions:
 * 	1. https://mkyong.com/java8/java-8-convert-date-to-localdate-and-localdatetime/
 * 	2. https://www.baeldung.com/java-convert-localdate-sql-date
 * */

package date_and_time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

	public static LocalDate dateToLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static Date localDateToDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * This method expect string in dd-MM-yyyy format only example "18-02-2023"
	 */
	public static Date stringToDate(String sdate) {
		Date date = null;
		try {
			return new SimpleDateFormat("dd-MM-yyyy").parse(sdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static java.sql.Date localDateToSqlDate(LocalDate localDate) {
		return java.sql.Date.valueOf(localDate);
	}

	//java.sql.Date to LocalDate => LocalDate date = sqlDate.toLocalDate();
}
