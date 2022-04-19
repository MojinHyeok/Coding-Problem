package 백준문제풀이;

import java.util.Scanner;

public class BOJ_1717_집합의표현 {
	static int[] num;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n =sc.nextInt();
		int m =sc.nextInt();
		num =new int[n+1];
		for(int i=1;i<=n;i++) {
			num[i]=i;
		}
		for(int i=0; i<m;i++) {
			int command=sc.nextInt();
			int a=sc.nextInt();
			int b=sc.nextInt();
			if( command == 1 ) {
			
				check(a,b);
			}else {
				
				union(a,b);
			}
			
		}
	}
	
	private static void union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot!=bRoot)num[aRoot]=bRoot;
	}
	
	private static  int find (int x) {
		if(num[x]==x)return x;
		return num[x]=find(num[x]);
	}
	private static void check (int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) {
			
			System.out.println("YES");
		}else {
			
			System.out.println("NO");
		}
	}
	
}
