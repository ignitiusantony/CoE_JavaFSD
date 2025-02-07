package LibraryManagementSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
 public static void main(String[] args) throws Throwable {
	Scanner sc=new Scanner(System.in);
	BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	boolean p1=true;
	boolean p2;
	LibraryManager lib=new LibraryManager();
	while(p1) {
		System.out.println(" 1.Admin \n 2.User \n 3.Get User Info \n 4.Exit");
		int option=sc.nextInt();
		p2=true;
		switch(option) {
		case 1:
			while(p2) {
				System.out.println(" 1.Add User \n 2.Add Book \n 3.Exit ");
				int op=sc.nextInt();
				switch(op) {
				case 1:
					User user=new User();
					System.out.println("Enter user name:");
					String userName=bf.readLine();
					System.out.println("Enter user Id:");
					String userId=sc.next();
					user.setNames(userName);
					user.setUserID(userId);
					lib.addUser(user);
					break;
				case 2:
					Book book=new Book();
					System.out.println("Enter Title:");
					String title=bf.readLine();
					System.out.println("Enter Author:");
					String author=bf.readLine();
					System.out.println("Enter ISBN:");
					String isbn=sc.next();
					book.setTitle(title);
					book.setAuthor(author);
					book.setISBN(isbn);
					lib.addBook(book);
					break;
				case 3:
					p2=false;
					break;
				}
			}
			break;
		case 2:
			LibraryManager.userList.forEach(System.out::println);
			System.out.println("Enter User Id:");
			String userId=sc.next();
			User user=LibraryManager.userList.stream().filter(p->p.getUserID().equals(userId)).findFirst().orElse(null);
			if(user!=null) {
				Thread t1=new Thread(new UserSession(lib,userId));
				t1.start();
			}
			else {
				System.out.println("User Not Found");
			}
			break;
			
		case 3:
			lib.userList.stream().forEach(System.out::println);
			break;
			
		case 4:
			p1=false;
			Thread save=new Thread(()->{
				try {
					lib.save();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			save.start();
			save.join();
			break;
		}
}
}
}