package Class2;

import java.util.Scanner;

public class 괄호 {
	//문제를 봤을 때 올바른 괄호라면 왼쪽과 오른쪽의 균형이 맞으면 되기 때문에 (cnt하고 )를 cnt하여 똑같으면 된다고 생각하였습니다.!
	//위 조건만 사용한다면 ())(()이와 같은 경우는 안되기 때문에 조금 더 조건을 추가해야 한다고 문제를 풀다가 느꼈습니다.
	
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
