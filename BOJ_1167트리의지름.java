package Class4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_1167트리의지름 {
	static class Node{
		int node,weight;

		public Node(int node, int weight) {
			super();
			this.node = node;
			this.weight = weight;
		}
		
	}
	static List<Node>[] graph;
	static int ans;
	static boolean[] visit;
	static Node maxNode;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		graph=new ArrayList[N+1];
		visit=new boolean[N+1];
		for(int i=0;i<=N;i++)graph[i]=new ArrayList<>();
		for(int i=0;i<N;i++) {
			int from=sc.nextInt();
			while(true) {
				int to=sc.nextInt();
				if(to==-1)break;
				int weight=sc.nextInt();
				graph[from].add(new Node(to,weight));
			}
		}
		graph[0].add(new Node(1,0));
		ans=0;
		Node maxN;
		maxN=dfs(graph[0].get(0),0);
		visit=new boolean[N+1];
		maxNode=null;
		ans=0;
		dfs(maxN,0);
		System.out.println(ans);
	}
	public static Node dfs(Node v,int weight) {
		if(ans<weight) {
			ans=weight;
			maxNode=v;
		}
		visit[v.node]=true;
		for(Node cur:graph[v.node]) {
			if(!visit[cur.node])
				dfs(cur,weight+cur.weight);
			
		}
		return maxNode;
	}
	
}
