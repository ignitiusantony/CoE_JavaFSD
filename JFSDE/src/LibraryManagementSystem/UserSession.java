package LibraryManagementSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UserSession extends Thread{

	public UserSession(LibraryManager lib,String userId) throws BookNotFoundException, UserNotFoundException, MaxBooksAllowedException, IOException {
		Scanner sc=new Scanner(System.in);
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		boolean p2=true;
		while(p2) {
			System.out.println("1.Search Book \n 2.Reserve Book \n 3.Borrow Book \n 4.Return Book \n 5.Exit");
			int op=sc.nextInt();
			switch(op) {
			case 1:
				System.out.println("Enter book title");
				String title=bf.readLine();
				System.out.println(lib.searchBook(title));
				break;
			case 2:
				System.out.println("Enter ISBN");
				String isbn1=bf.readLine();
				lib.reserveBook(isbn1, userId);
				break;
			case 3:
				System.out.println("Enter ISBN");
				String isbn2=bf.readLine();
				lib.borrowBook(isbn2, userId);
				break;
			case 4:
				System.out.println("Enter ISBN");
				String isbn3=bf.readLine();
				lib.returnBook(isbn3, userId);
				break;
			default:
				p2=false;
				break;
			}
		}
	}
   
}
