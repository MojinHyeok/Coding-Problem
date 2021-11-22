package Class4;

import java.util.Scanner;

public class BOJ_9465스티커 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for(int t=0;t<TC;t++) {
			int N=sc.nextInt();
			int[][] map=new int[2][N];
			int[][] result=new int[2][N];
			for(int i=0;i<2;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			result[0][0]=map[0][0];
			result[1][0]=map[1][0];
			result[0][1]=map[0][1]+result[1][0];
			result[1][1]=map[1][1]+result[0][0];
			for(int i=2;i<N;i++) {
				int value=Math.max(result[0][i-2], result[1][i-2]);
				result[0][i]=map[0][i]+Math.max(value,result[1][i-1]);
				result[1][i]=map[1][i]+Math.max(value,result[0][i-1]);
			}
			System.out.println(Math.max(result[0][N-1], result[1][N-1]));
		}
	}
}
