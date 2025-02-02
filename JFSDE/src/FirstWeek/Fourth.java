package FirstWeek;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class User implements Serializable{
	private static final long serialVersionUID = 1L;
	String name;
	String email;
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + "]";
	}
	
}		
class UserManager{
	File f;
	List<User> userList=new LinkedList<>();
	public void addUser(String name,String email){
		userList.add(new User(name, email));
	}
	public void saveUsersToFile(String file_name) {
		f=new File(file_name);
		try {
			FileOutputStream fout=new FileOutputStream(f);
			ObjectOutputStream objout=new ObjectOutputStream(fout);
			objout.writeObject(userList);
			objout.close();
			fout.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void loadUsersFromFile(String file_name) {
        f = new File(file_name);
        if (!f.exists() || f.length() == 0) {
            System.out.println("No data found.");
            return;
        }
		FileInputStream fin;
		try {
			fin = new FileInputStream(f);
			ObjectInputStream objin=new ObjectInputStream(fin);
			userList=(List<User>) objin.readObject();
			objin.close();
			fin.close();
			for(User s:userList) {
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
public class Fourth {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean b=true;
		UserManager user=new UserManager();
		while(b) {
			System.out.println("1.add user \n2.add user to file \n3.get user from file");
			int op=sc.nextInt();
			switch(op) {
			case 1:
				System.out.println("Enter user name:");
				String name=sc.next();
				System.out.println("Enter email:");
				String email=sc.next();
				user.addUser(name, email);
				break;
			case 2:
				System.out.println("Enter File name: ");
				String file_name=sc.next();
				user.saveUsersToFile(file_name);
				break;
			case 3:
				System.out.println("Enter File name: ");
				String filename=sc.next();
				user.loadUsersFromFile(filename);
				break;
			default:
				b=false;
				break;
			}
		}
	}
}
