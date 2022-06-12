package 코테꿀문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1516_게임개발 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		List<Integer>[] list;
		int[] indegree;
		int[] DP;
		int[] time;
		Queue<Integer> que;
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		indegree = new int[N+1];
		time = new int[N+1];
		DP = new int[N+1];
		que = new LinkedList<Integer>();
		for(int i=1;i<=N;i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextToken());
			time[i]=value;
			
			while(st.hasMoreTokens()) {
				value = Integer.parseInt(st.nextToken());
				if(value != -1) {
					list[value].add(i);
					indegree[i]++;
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0) {
				que.add(i);
				DP[i]=time[i];
			}
		}
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			
			for(int x : list[cur]) {
				indegree[x]--;
				DP[x]=Math.max(DP[x], DP[cur]+time[x]);
				
				if(indegree[x]==0)que.add(x);
			}
		
		}
		for(int i=1;i<=N;i++) {
			sb.append(DP[i]+"\n");
		}
		System.out.println(sb.toString());
	}

}
