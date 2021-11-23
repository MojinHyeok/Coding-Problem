package 준비운동;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1197_최소스패닝트리 {
	static int N,E,result;
	static int[] parent;
	static PriorityQueue<node> pq=new PriorityQueue<node>();
	static class node implements Comparable<node>{
		int from,to,value;
		public node(int from, int to, int value) {
			this.from = from;
			this.to = to;
			this.value = value;
		}
		@Override
		public int compareTo(node o) {
			// TODO Auto-generated method stub
			return this.value- o.value;
		}
		
	}
	
	public static void Union(int from , int to) {
		int aRoot=find(from);
		int bRoot=find(to);
		if(aRoot==bRoot) return;
		parent[aRoot]=bRoot;
	}
	public static int find(int x)
	{	
		if(parent[x]==x)return x;
		return parent[x]=find(parent[x]);
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		E=sc.nextInt();
		parent=new int[N+1];
		for(int i=1;i<=N;i++) {
			parent[i]=i;
		}
		for(int i=0;i<E;i++) {
			int from =sc.nextInt();
			int to=sc.nextInt();
			int weight=sc.nextInt();
			pq.add(new node(from,to,weight));
		}
		for(int i=0;i<E;i++) {
			node curr=pq.poll();
			int a=find(curr.from);
			int b=find(curr.to);
			if(a==b)continue;
			Union(a,b);
			result+=curr.value;
		}
		System.out.println(result);
	}
}
