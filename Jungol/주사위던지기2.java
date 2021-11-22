package Jungol;

import java.util.Scanner;

public class 주사위던지기2{
	static int N,M;
	static int[] num;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		num=new int[N];
		dice(0,0);
	}
	private static void dice(int level,int sum) {
		if(level==N) {
			if(sum==M) {
				for(int i=0;i<N;i++) {
					System.out.print(num[i]+" ");
				}
				System.out.println();
			}
			return;
		}
		for(int i=1;i<=6;i++) {
			num[level]=i;
			dice(level+1,sum+i);
		}
		
	}

}
