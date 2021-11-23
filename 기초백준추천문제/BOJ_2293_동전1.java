package 기초백준추천문제;

import java.util.Scanner;

public class BOJ_2293_동전1 {
	//문제접근
	//처음에는 중복조합을 만들어 K를 만든다면 1+를 하여 답을 구하려했는데 시간초과가 나타났다.
	// 다른방법을 고려해야하는데..
	static int[] num;
	static int N,ans,K;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		num=new int[N];
		int[] arr=new int[N+1];
		int[] dp=new int[K+1];
		dp[0]=1;
		for(int i=1;i<=N;i++) {
			arr[i]=sc.nextInt();
			for(int j=arr[i];j<=K;j++) {
				dp[j]+=dp[j-arr[i]];
			}
		}
		System.out.println(dp[K]==0?-1:dp[K]);
		//아래는 중복조합
//		for(int i=0;i<N;i++) {
//			num[i]=sc.nextInt();
//		}
//		ans=0;
//		DFS(0,0,0);
	}
	
	
	//중복조합구하는가정
//	private static void DFS(int idx, int start, int tmp) {
//		if(tmp>=K) {
//			if(tmp==K)ans++;
//			return;
//		}
//		for(int i=start;i<N;i++) {
//			DFS(idx+1,i,tmp+num[i]);
//		}
//		
//	}

}
