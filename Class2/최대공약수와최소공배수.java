package Class2;

import java.util.Scanner;

public class 최대공약수와최소공배수 {
	//문제를 보고나서 풀이방향은 mod를 사용해서 푸는방법
	//유클리드호제법
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int X=sc.nextInt();
		int Y=sc.nextInt();
		System.out.println(UC(X,Y));
		System.out.println(X*Y/UC(X,Y));
	}
	static int UC(int x ,int y) {
		if(y>x){
			int temp;
			temp=x;
			x=y;
			y=temp;
		}
		if(y==0)return x;
		else {
			return UC(y,x%y);
		}
	}

}
