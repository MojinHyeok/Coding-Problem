package 백준문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17182_우주탐사선 {
	static class space{
		int route;
		int start;
		int value;
		public space(int route, int start, int value) {
			this.route= route;
			this.start=start;
			this.value = value;
		}
	}
	
	static int[][] DP;
	static int[][] map;
	static int check,N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = Integer.MAX_VALUE;
		N = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		check = (1<<N)-1;
		map =new int[N][N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		DP =new int[1<<N][N];
		BFS(start);
		for(int i=0; i<N;i++) {
			answer = Math.min(answer, DP[check][i]);
		}
		System.out.println(answer);
		
	}


	private static void BFS(int start) {
		Queue<space> que =new LinkedList<>();
		que.add(new space(1<<start,start,0));
		
		for(int i=0;i < DP.length;i++) {
			for(int j=0;j<N;j++) {
				DP[i][j]=Integer.MAX_VALUE;
			}
		}
		while(!que.isEmpty()) {
			space cur = que.poll();
			
			if(cur.route == check)continue;
			int next;
			for(int i=0; i<N;i++) {
				if(cur.start==i)continue;
				
				next = cur.route|(1<<i);
				if(DP[next][i]>map[cur.start][i]+cur.value) {
					DP[next][i]= map[cur.start][i]+cur.value;
					que.add(new space(next,i,DP[next][i]));
				}
				
			}
			
		}
		
		
	}
}
