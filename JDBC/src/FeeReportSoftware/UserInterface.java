package FeeReportSoftware;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {
	static Connection con;
	public UserInterface(Connection con){
		UserInterface.con=con;
	}
	public void admin() throws SQLException {
		Scanner sc=new Scanner(System.in);
		Accountants Acc=new Accountants(con);
		boolean b=true;
		while(b) {
			System.out.println("1.Add new accountants.\r\n"
					+ "2.View existing accountants.\r\n"
					+ "3.Edit accountant details.\r\n"
					+ "4.Delete accountants.\r\n"
					+ "5.Logout");
			int op=sc.nextInt();
			switch(op) {
			case 1:
				System.out.print("Enter ID: ");
		        int id = sc.nextInt();
		        sc.nextLine();
		        System.out.print("Enter Name: ");
		        String name = sc.nextLine();
		        System.out.print("Enter Email: ");
		        String email = sc.nextLine();
		        System.out.print("Enter Phone: ");
		        String phone = sc.nextLine();
		        System.out.print("Enter Password: ");
		        String password = sc.nextLine();
				Acc.newAccountants(id,name,email,phone,password);
				break;
			case 2:
				Acc.existingAccountants();
				break;
			case 3:
				System.out.print("Enter ID: ");
		        int id3 = sc.nextInt();
		        sc.nextLine();
		        System.out.println("Which field do you want to edit? (name/email/phone/password): ");
		        String field = sc.nextLine();
		        System.out.print("Enter new " + field + ": ");
		        String newValue = sc.nextLine();
		        Acc.editAccountantDetails(id3, field, newValue);
				break;
			case 4:
				System.out.print("Enter ID: ");
		        int id2 = sc.nextInt();
				Acc.deleteAccountants(id2);
				break;
			case 5:
				b=false;
				con.close();
				break;
			}
		}
	}
	public void accountant() throws SQLException {
        Scanner sc = new Scanner(System.in);
        Students stu = new Students(con);
        boolean b = true;

        while (b) {
            System.out.println(
                    "1. Add new students.\r\n"
                    + "2. View student records.\r\n"
                    + "3. Edit student details.\r\n"
                    + "4. Delete student records.\r\n"
                    + "5. Check Due Fee\r\n"
                    + "6. Logout");

            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter Total Fee: ");
                    double fee = sc.nextDouble();
                    System.out.print("Enter Amount Paid: ");
                    double paid = sc.nextDouble();
                    sc.nextLine();
                    double due = fee - paid;
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    stu.addStudent(name, email, course, fee, paid, due, address, phone);
                    break;
                case 2:
                    stu.viewStudents();
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    int studentId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Which field do you want to edit? (name/email/course/fee/paid/due/address/phone): ");
                    String field = sc.nextLine();
                    System.out.print("Enter new " + field + ": ");
                    String newValue = sc.nextLine();
                    stu.editStudentDetails(studentId, field, newValue);
                    break;
                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int delId = sc.nextInt();
                    stu.deleteStudent(delId);
                    break;
                case 5:
                    stu.checkDueFees();
                    break;
                case 6:
                    b = false;
                    break;
                    }
            }
        }
    }

