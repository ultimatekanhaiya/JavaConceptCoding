package exceptions.chaining;

public class StudentManager {

	private StudentDAO dao;

	public StudentManager(StudentDAO dao) {
		this.dao = dao;
	}

	public void findStudents(String keyword) throws StudentException {
		try {
			dao.list();
		} catch (DAOException ex) {
			throw new StudentException("Error finding students", ex);
		}
	}

}
