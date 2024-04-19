package reflection;

import java.io.Serializable;
import java.sql.SQLException;

public strictfp class Employee implements Serializable, Cloneable {

	public static int eno = 111;
	public static String ename = "kanhaiya";
	public static String address;

	public Employee() {

	}

	public Employee(int eno, String address) {
		super();
		this.eno = eno;
		this.address = address;
	}

	public String add(int a, int b) {
		return "added";
	}

	public void delete(int id) throws java.sql.SQLException {
	}

}
