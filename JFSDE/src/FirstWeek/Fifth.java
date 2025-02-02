package FirstWeek;

import java.util.Arrays;
import java.util.Scanner;
class StringProcessor{
	public String reverseString(String str){
        return new StringBuffer(str).reverse().toString();
	}
	public int countOccurences(String text,String sub,int count) {
		if(!text.contains(sub)||text.isEmpty()) {
			return count;
		}
		return countOccurences(text.substring(text.indexOf(sub)+sub.length()), sub, count+1);
	}
	public String[] splitAndCapitalize(String str) {
		String[] s=str.split(" ");
		for(int i=0;i<s.length;i++) {
			s[i]=s[i].toUpperCase();
		}
		return s;
	}
}
public class Fifth {
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	boolean b=true;
	StringProcessor sp=new StringProcessor();
	while(b) {
		System.out.println("1.reverse string \n2.count occurences \n3.split and capitalize");
		int op=sc.nextInt();
		switch(op) {
		case 1:
			System.out.println("Enter String: ");
			String s=sc.next();
			System.out.println(sp.reverseString(s));
			break;
		case 2:
			System.out.println("Enter String: ");
			String s1=sc.next();
			System.out.println("Enter subString: ");
			String sub=sc.next();
			System.out.println(sp.countOccurences(s1, sub, 0));
			break;
		case 3:
			System.out.println("Enter String: ");
			sc.nextLine();
			String s2=sc.nextLine();
			System.out.println(Arrays.toString(sp.splitAndCapitalize(s2)));
			break;
		default:
			b=false;
			break;
		}
	}
}}
