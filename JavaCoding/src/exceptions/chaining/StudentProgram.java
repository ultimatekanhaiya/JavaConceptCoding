
/*
 * Reference : https://www.codejava.net/java-core/exception/understanding-java-exception-chaining-with-code-examples
 * */

package exceptions.chaining;

public class StudentProgram {

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
		StudentManager manager = new StudentManager(dao);

		try {

			manager.findStudents("Tom");

		} catch (StudentException ex) {
			ex.printStackTrace();
		}
	}

}
