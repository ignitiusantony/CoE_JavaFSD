package LibraryManagementSystem;

public class UserNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		System.err.println("User is not found");
	}
	

}
