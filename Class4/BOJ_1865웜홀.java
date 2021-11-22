package Class4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_1865웜홀 {
	static class Node{
		int node,weight;
		public Node(int node, int weight) {
			super();
			
			this.node = node;
			this.weight = weight;
		}
	}
	static int N,M,W;
	static boolean check;
	static boolean[] visit;
	static int[] result;
//	static int[][] map;
	static List<Node>[] graph;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for(int t=0;t<TC;t++) {
			N=sc.nextInt();
			M=sc.nextInt();	
			W=sc.nextInt();
			graph=new ArrayList[N+1];
			for(int i=0;i<=N;i++)graph[i]=new ArrayList<>();
			for(int i=0;i<M;i++) {
				int from=sc.nextInt();
				int to=sc.nextInt();
				int weight=sc.nextInt();
				graph[from].add(new Node(to,weight));
				graph[to].add(new Node(from,weight));
			}
			for(int i=0;i<W;i++) {
				int from=sc.nextInt();
				int to=sc.nextInt();
				int weight=sc.nextInt();
				graph[from].add(new Node(to,-weight));
			}
			result =new int[N+1];
			Arrays.fill(result, 99999999);
//			visit=new boolean[N+1];
//			check=false;
			result[1]=0;
			boolean update=false;
			out:for(int i=1;i<=N;i++) {
				update=false;
				for(int j=1;j<=N;j++) {
					for(Node cur : graph[j]) {
						if(result[cur.node]>result[j]+cur.weight) {
							result[cur.node]=result[j]+cur.weight;
							update=true;
							if(i==N) {
								update=true;
								break out;
							}
						}
					}
					
				}
			}
			
			if(update)System.out.println("YES");
			else System.out.println("NO");
		}
		
	}
//	private static void dfs(int start,int current,int value) {
//		if(start==current&&value!=0) {
//			if(value<0)check=true;
//			return;
//		}
//		for(Node cur:graph[current]) {
//			if(!visit[cur.node]) {
//				visit[cur.node]=true;
//				dfs(start,cur.node,value+cur.weight);
//				visit[cur.node]=false;
//			}
//		}
//	}

}
