package Class2;

import java.util.Scanner;

public class 괄호 {
	//문제�? 봤을 ?�� ?��바른 괄호?���? ?��쪽과 ?��른쪽?�� 균형?�� 맞으�? ?���? ?��문에 (cnt?���? )�? cnt?��?�� ?��같으�? ?��?���? ?��각하???��?��?��.!
	//?�� 조건�? ?��?��?��?���? ())(()?��?? 같�? 경우?�� ?��?���? ?��문에 조금 ?�� 조건?�� 추�??��?�� ?��?���? 문제�? ???���? ?��꼈습?��?��.
	
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
