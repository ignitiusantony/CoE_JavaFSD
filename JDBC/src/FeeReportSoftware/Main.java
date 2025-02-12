package FeeReportSoftware;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
public static void main(String[] args) throws SQLException, ClassNotFoundException {
	Scanner sc=new Scanner(System.in);
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/Tech";
	Connection con = DriverManager.getConnection(url,"root","root");
	UserInterface ui =new UserInterface(con);
	boolean b=true;
	while(b) {
		System.out.println("1.Admin\n2.Accountant\n3.Exit");
		int op=sc.nextInt();
		switch(op) {
		case 1:
			ui.admin();
			break;
		case 2:
			ui.accountant();
			break;
		case 3:
			b=false;
			con.close();
			break;
		}
	}
}
}
