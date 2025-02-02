package FirstWeek;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StringAnagram{
	public List<Integer> anagram(String s,String p){
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<=s.length()-p.length();i++) {
			if(isAnagram(s.substring(i,i+p.length()),p)) {
				list.add(i);
			}
		}
		return list;
	}

	public boolean isAnagram(String substring,String p) {
		for(int i=0;i<p.length();i++) {
			boolean n=false;
			for(int j=0;j<substring.length();j++) {
				if(p.charAt(i)==substring.charAt(j)) n=true;
			}
			if(!n) return false;
		}
		return true;
	}
}
public class Seventh {
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String s=sc.next();
	String p=sc.next();
	StringAnagram a=new StringAnagram();
	System.out.println(a.anagram(s,p));
	}
}
