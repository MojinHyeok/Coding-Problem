package Class5;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2473_세용액 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		long[] arr=new long[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextLong();
		}
		Arrays.sort(arr);
		long ans1 = 0,ans2=0,ans3=0;
		long ans=Long.MAX_VALUE;
		int start=0;
		while(start<N-1) {
			int start2=start+1;
			int end=N-1;
			while(start2<end) {
				long sum=arr[start]+arr[start2]+arr[end];
				if(ans>Math.abs(sum)) {
					ans=Math.abs(sum);
					ans1=arr[start];
					ans2=arr[start2];
					ans3=arr[end];
				}
				if(sum<0)start2++;
				else end--;
			}
			start++;
		}
		System.out.print(ans1+" "+ans2+" "+ans3);
	}
}
