package 준비운동;

import java.util.Scanner;

public class BOJ_14719_빗물{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int H=sc.nextInt();
		int W=sc.nextInt();
		int[] map=new int[W];
		for(int i=0;i<W;i++) {
			map[i]=sc.nextInt();
		}
		
		int ans=0;
		int left=0;
		int right=0;
		int curr=0;
		for(int i=1;i<W-1;i++) {
			curr=map[i];
			left=0;
			right=0;
			for(int j=0;j<i;j++) {
				left=Math.max(left, map[j]);
			}
			for(int k=i+1;k<W;k++) {
				right=Math.max(right, map[k]);
			}
			int maxv=Math.min(left, right);
			if(maxv>curr)ans+=maxv-curr;
		}
		System.out.println(ans);
	}

}
