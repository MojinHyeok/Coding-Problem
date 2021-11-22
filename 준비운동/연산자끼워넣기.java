package 준비운동;

import java.util.Scanner;

public class 연산자끼워넣기 {
	static int[] num,math;
	static int N,maxV,minV;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		maxV=Integer.MIN_VALUE;minV=Integer.MAX_VALUE;
		N=sc.nextInt();
		num=new int[N];
		for(int i=0;i<N;i++) {
			num[i]=sc.nextInt();
		}
		math=new int[4];
		for(int i=0;i<4;i++) {
			math[i]=sc.nextInt();
		}
		sum(1,num[0]);
		System.out.println(maxV);
		System.out.println(minV);
	}
	private static void sum(int level,int sum) {
		if(level==N) {
			maxV=Integer.max(sum, maxV);
			minV=Integer.min(sum, minV);
			return;
		}
		if(math[0]>0) {
			math[0]--;
			sum(level+1,sum+num[level]);
			math[0]++;
		}
		if(math[1]>0) {
			math[1]--;
			sum(level+1,sum-num[level]);
			math[1]++;
		}
		if(math[2]>0) {
			math[2]--;
			sum(level+1,sum*num[level]);
			math[2]++;
		}
		if(math[3]>0) {
			math[3]--;
			sum(level+1,sum/num[level]);
			math[3]++;
		}
	}
	
}
