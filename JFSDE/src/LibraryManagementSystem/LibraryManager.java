package LibraryManagementSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryManager extends LibrarySystem {
    static List<User> userList = new ArrayList<>();
    static List<Book> bookList = new ArrayList<>();

    @Override
    public synchronized void borrowBook(String ISBN, String userID)
            throws BookNotFoundException, UserNotFoundException, MaxBooksAllowedException {
        User user = userList.stream().filter(p -> p.getUserID().equals(userID)).findFirst().orElse(null);
        Book book = bookList.stream().filter(p -> p.getISBN().equals(ISBN)).findFirst().orElse(null);

        if (book == null) {
            throw new BookNotFoundException();
        } else if (user == null) {
            throw new UserNotFoundException();
        } else if (user.getBorrowedBooks()!=null && user.getBorrowedBooks().size() >= 5) {
            throw new MaxBooksAllowedException();
        } else if (book.getReserved() != null && !book.getReserved().equals(user)) {
            System.out.println("This book is reserved for " + book.getReserved().getNames().toUpperCase());
        } else {
            user.getBorrowedBooks().add(book);
            book.setBorrowed(true);
            book.setReserved(null);
            System.out.println(book.getTitle().toUpperCase() + " borrowed successfully");
        }
    }

    @Override
    public synchronized void returnBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException {
        User user = userList.stream().filter(p -> p.getUserID().equals(userID)).findFirst().orElse(null);
        Book book = bookList.stream().filter(p -> p.getISBN().equals(ISBN)).findFirst().orElse(null);

        if (book == null) {
            throw new BookNotFoundException();
        } else if (user == null) {
            throw new UserNotFoundException();
        } else if (!user.getBorrowedBooks().contains(book)) {
            System.out.println("User did not borrow this book.");
        } else {
            user.getBorrowedBooks().remove(book);
            book.setBorrowed(false);
            System.out.println(book.getTitle().toUpperCase() + " returned successfully");
        }
    }

    @Override
    public synchronized void reserveBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException {
        User user = userList.stream().filter(p -> p.getUserID().equals(userID)).findFirst().orElse(null);
        Book book = bookList.stream().filter(p -> p.getISBN().equals(ISBN)).findFirst().orElse(null);

        if (book == null) {
            throw new BookNotFoundException();
        } else if (user == null) {
            throw new UserNotFoundException();
        } else if (book.getReserved() != null) {
            System.out.println("This book is already reserved");
        } else {
            book.setReserved(user);
            System.out.println(book.getTitle().toUpperCase() + " is reserved for " + user.getNames().toUpperCase());
        }
    }

    @Override
    public synchronized Book searchBook(String title) {
        return bookList.stream().filter(p -> p.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
    }

    @Override
    public synchronized void addBook(Book book) {
        if (bookList.contains(book)) {
            System.out.println("Book is already present");
        } else {
            bookList.add(book);
            System.out.println(book.getTitle().toUpperCase() + " added successfully.");
        }
    }

    @Override
    public synchronized void addUser(User user) {
        if (userList.contains(user)) {
            System.out.println("User is already present");
        } else {
            userList.add(user);
            System.out.println(user.getNames().toUpperCase() + " is added successfully.");
        }
    }

    public void save() throws IOException {
        try (ObjectOutputStream objOutUser = new ObjectOutputStream(new FileOutputStream("userInfo.txt"));
             ObjectOutputStream objOutBook = new ObjectOutputStream(new FileOutputStream("bookInfo.txt"))) {
            objOutUser.writeObject(userList);
            objOutBook.writeObject(bookList);
        }
    }

    public LibraryManager() throws ClassNotFoundException, IOException {
        File userFile = new File("userInfo.txt");
        if (userFile.exists() && userFile.length() > 0) {
            try (ObjectInputStream objInUser = new ObjectInputStream(new FileInputStream(userFile))) {
                userList = (List<User>) objInUser.readObject();
            }
        }
        File bookFile = new File("bookInfo.txt");
        if (bookFile.exists() && bookFile.length() > 0) {
            try (ObjectInputStream objInBook = new ObjectInputStream(new FileInputStream(bookFile))) {
                bookList = (List<Book>) objInBook.readObject();
            }
        }
    }
}
