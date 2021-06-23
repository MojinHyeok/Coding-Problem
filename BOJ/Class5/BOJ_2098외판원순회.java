package 백준문제풀이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_2098외판원순회 {
	static int N,ans;
	static int[][] map,dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		dp=new int[N][1<<N];
		for(int i=0;i<N;i++) {
			String[] input =br.readLine().split(" ");
//			StringTokenizer st=new StringTokenizer(br.readLine());
			Arrays.fill(dp[i], 9999999);
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(input[j]);
//				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		ans=100000000;
		dp[0][1]=0;
		DFS(0,1);
		System.out.println(ans);

	}
	private static void DFS(int current, int visited) {
		if(visited==((1<<N)-1)) {
			if(map[current][0]==0)return;
			int temp=dp[current][visited]+map[current][0];
			ans=Math.min(temp, ans);
			return;
		}
		
		for(int i=0;i<N;i++) {
			int travel=(1<<i);
			if((visited|travel)==visited)continue;
			if(map[current][i]==0)continue;
			if(dp[current][visited]+map[current][i]<dp[i][visited|travel]) {
				dp[i][visited|travel]=dp[current][visited]+map[current][i];
				DFS(i,visited|travel);
			}
		}
	}
}
