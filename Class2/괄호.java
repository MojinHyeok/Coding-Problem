package Class2;

import java.util.Scanner;

public class κ΄νΈ {
	//λ¬Έμ λ₯? λ΄€μ ? ?¬λ°λ₯Έ κ΄νΈ?Όλ©? ?Όμͺ½κ³Ό ?€λ₯Έμͺ½? κ· ν?΄ λ§μΌλ©? ?κΈ? ?λ¬Έμ (cnt?κ³? )λ₯? cnt??¬ ?κ°μΌλ©? ??€κ³? ?κ°ν???΅??€.!
	//? μ‘°κ±΄λ§? ?¬?©??€λ©? ())(()?΄?? κ°μ? κ²½μ°? ??κΈ? ?λ¬Έμ μ‘°κΈ ? μ‘°κ±΄? μΆκ??΄?Ό ??€κ³? λ¬Έμ λ₯? ???€κ°? ?κΌμ΅??€.
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			String str=sc.next();
			int left=0;
			int right=0;
			boolean check=true;
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)=='(')left++;
				else right++;
				if(left<right) {
					check=false;
					break;
				}
			}
			if(left==right&&check)System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
