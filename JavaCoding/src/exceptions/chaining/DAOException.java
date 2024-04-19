package exceptions.chaining;

public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

}
