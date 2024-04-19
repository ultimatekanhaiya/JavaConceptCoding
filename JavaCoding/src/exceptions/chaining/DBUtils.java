package exceptions.chaining;

import java.sql.SQLException;

public class DBUtils {

	public static void executeQuery(String sql) throws SQLException {
		throw new SQLException("Syntax Error");
	}
}
