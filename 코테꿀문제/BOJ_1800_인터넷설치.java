package 코테꿀문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1800_인터넷설치 {
	
	static int N,P,K;
	static class node implements Comparable<node>{
		int end;
		int value;
		public node(int end, int value) {
			super();
			this.end = end;
			this.value = value;
		}
		@Override
		public int compareTo(node o) {
			// TODO Auto-generated method stub
			return this.value- o.value;
		}
		
	}
	static List<node>[] list ;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		P=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		dist = new int[N+1];
		for(int i=1;i<=N;i++) {
			list[i]=new ArrayList<>();
		}
		int end =0;
		for(int i=0;i<P;i++) {
			st =new StringTokenizer(br.readLine());
			
			int from =Integer.parseInt(st.nextToken());
			int to =Integer.parseInt(st.nextToken());
			int value =Integer.parseInt(st.nextToken());
			
			list[from].add(new node(to,value));
			list[to].add(new node(from,value));
			end = Integer.max(end, value);
		}
		int start = 0;
		int ans=-1;
		while(start<=end) {
			int mid = (start+end)/2;
			if(dijstra(mid)) {
				ans=mid;
				end=mid-1;
			}else {
				start= mid+1;
			}
		}
		if(ans==-1) System.out.println(-1);
		else System.out.println(ans);
		
	
	}
	private static boolean dijstra(int mid) {
		PriorityQueue<node> pq =new PriorityQueue<>();
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1]=0;
		pq.add(new node(1,0));
		while(!pq.isEmpty()) {
			node cur =pq.poll();
			int now=cur.end;
			int value =cur.value;
			
			if(dist[now]<value)continue;
			
			for(node x : list[now]) {
				int next = x.end;
				int nextvalue = value;
				if(x.value>mid)nextvalue++;
				if(nextvalue<dist[next]) {
					dist[next]=nextvalue;
					pq.add(new node(next,nextvalue));
				}
			}
			
		}
		
		return dist[N]<=K;
	}

}
