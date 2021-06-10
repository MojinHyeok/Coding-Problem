package Class2;

import java.util.Scanner;

public class 팰린드롬수 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			String str=sc.next();
			if(str.equals("0"))break;
			String str2="";
			for(int i=str.length()-1;i>=0;i--) {
				str2+=str.charAt(i);
			}
			if(str.equals(str2))System.out.println("yes");
			else System.out.println("no");
		}
	}

}
