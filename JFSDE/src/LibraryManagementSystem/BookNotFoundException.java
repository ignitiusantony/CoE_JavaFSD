package LibraryManagementSystem;

public class BookNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public BookNotFoundException() {
		System.err.println("Book is not found");
	}
	
}
