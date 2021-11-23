package 기초백준추천문제;

import java.util.Scanner;

public class BOJ_1789_수들의합 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long S=sc.nextLong();
		long ans=0;
		long tmp=0;
		while(true) {
			tmp+=++ans;
			if(tmp>S)break;
		}
		System.out.println(--ans);
	}
}
