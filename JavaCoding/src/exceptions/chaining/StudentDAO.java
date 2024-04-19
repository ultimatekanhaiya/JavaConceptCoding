package exceptions.chaining;

import java.sql.SQLException;

public class StudentDAO {

	public void list() throws DAOException {
		try {

			DBUtils.executeQuery("SELECT");

		} catch (SQLException ex) {
			throw new DAOException("Error querying students from database", ex);
		}
	}
}
