package LibraryManagementSystem;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	   private String userID;
	   private List<Book> borrowedBooks;
	public String getNames() {
		return name;
	}
	public void setNames(String name) {
		this.name = name;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}
	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", userID=" + userID + ", borrowedBooks=" + borrowedBooks + "]";
	}


}
