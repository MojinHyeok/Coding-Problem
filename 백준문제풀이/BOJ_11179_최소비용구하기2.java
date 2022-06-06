package 백준문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11179_최소비용구하기2 {
	
	static class node implements Comparable<node>{
		int to;
		int value;
		String route;
		int cnt ;
		public node(int to, int value, String route, int cnt) {
			super();
			this.to = to;
			this.value = value;
			this.route = route;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(node o) {
			return this.value-o.value;
		}
	}
	
	static int N;
	static List<node>[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		String ans ;
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			list[i]= new ArrayList<>();
		}
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			list[from].add(new node(to,value, "",0));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		
		ans = Dijkstra(start,goal);
		String[] tmp = ans.split("\\*");
		System.out.println(tmp[0]);
		System.out.println(tmp[1]);
		System.out.println(tmp[2]);
		
	}
	private static String Dijkstra(int start, int goal) {
		PriorityQueue<node> pq = new PriorityQueue<>();
		int[] dist = new int[N+1];
		String ans ="";
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(node x : list[start]) {
			
			dist[x.to]=x.value;
			pq.add(new node(x.to,x.value,Integer.toString(start)+" "+Integer.toString(x.to),2));
			if(x.to==goal) {
				ans = ans= Integer.toString(dist[x.to])+"*"+2+"*"+Integer.toString(start)+" "+Integer.toString(x.to);
			}
		}
		dist[start]=0;
		while(!pq.isEmpty()) {
			
			node cur = pq.poll();
		
			if(dist[cur.to]<cur.value) continue;
			for(node next : list[cur.to]) {
				
				if(dist[next.to]>cur.value + next.value) {
					
					dist[next.to]=cur.value + next.value;
					pq.add(new node(next.to, cur.value + next.value, cur.route+" "+Integer.toString(next.to),cur.cnt+1));
					if(next.to==goal) {
						
						ans= Integer.toString(dist[next.to])+"*"+ Integer.toString(cur.cnt+1)+"*"+cur.route+" "+Integer.toString(next.to);
					}
				}
			}
			
		}
		
		return ans;
	}

}
