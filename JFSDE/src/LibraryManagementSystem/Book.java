package LibraryManagementSystem;

import java.io.Serializable;

public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	private String title;
	private String author;
	private String ISBN;
	private boolean borrowed;
	private User reserved;
	public boolean isBorrowed() {
		return borrowed;
	}
	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	@Override
	public String toString() {
		return "Title=" + title + ", Author=" + author + ", ISBN=" + ISBN + ", Borrowed=" + borrowed
				+ ", Reserved=" + reserved + "";
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public User getReserved() {
		return reserved;
	}
	public void setReserved(User reserved) {
		this.reserved = reserved;
	}

}
