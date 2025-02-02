package FirstWeek;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Third {
     public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
		int num=sc.nextInt();
		System.out.println(processInput(num));
		}
		catch(InputMismatchException e) {
			System.out.println(e);
		}
		catch(ArithmeticException e) {
			System.err.println(e.getMessage());
		}
	}

	public static double processInput(int num) {
		return 1.0/num;
	}
}
