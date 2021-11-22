package Jungol;

import java.util.Arrays;
import java.util.Scanner;

public class 주사위던지기1{
	static int N,M;
	static int[] num;
	static boolean[] check;
	static int[] number= {1,2,3,4,5,6};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		num=new int[N];
		check=new boolean[7];
		switch(M) {
		case 1:
			dice1(0);
			break;
		case 2:
			dice2(0,1);
			break;
		case 3:
			dice3(0);
			break;
		default :
			break;
		}
	}
	private static void dice3(int level) {
		if(level==N) {
			for(int i=0;i<N;i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=6;i++) {
			if(!check[i]) {
				num[level]=i;
				check[i]=true;
				dice3(level+1);
				check[i]=false;
			}
		}
		
	}
	private static void dice2(int level, int start) {
		if(level==N) {
			for(int i=0;i<N;i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start;i<=6;i++) {
			num[level]=i;
			dice2(level+1,i);
		}
		
	}
	private static void dice1(int level) {
		if(level==N) {
			for(int i=0;i<N;i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=6;i++) {
			num[level]=i;
			dice1(level+1);
		}
	}
	
	
	
	
}
