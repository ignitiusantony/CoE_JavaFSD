package LibraryManagementSystem;

public class MaxBooksAllowedException extends Exception {

	private static final long serialVersionUID = 1L;

	public MaxBooksAllowedException() {
		System.err.println("Max Books borrowed");
	}

}
