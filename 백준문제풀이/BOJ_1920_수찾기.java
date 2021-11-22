package 백준문제풀이;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1920_수찾기 {
	static int N;
	static int[] map;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		map=new int[N];
		for(int i=0;i<N;i++) {
			map[i]=sc.nextInt();
		}
		int M=sc.nextInt();
		Arrays.sort(map);
		for(int i=0;i<M;i++) {
			System.out.println(Check(sc.nextInt()));
		}
	}

	private static int Check(int value) {
		int start=0;
		int end=map.length-1;
		int mid=0;
		while(start<=end) {
			mid=(start+end)/2;
			if(value==map[mid])return 1;
			else {
				if(value>map[mid])start=mid+1;
				else end=mid-1;
			}
		}
		return 0;
	}

}
