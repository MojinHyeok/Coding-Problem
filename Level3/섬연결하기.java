package Level3;

import java.util.PriorityQueue;

public class 섬연결하기 {
	static class node implements Comparable<node>{
		int start;
		int end;
		int value;
		public node(int start, int end, int value) {
			super();
			this.start = start;
			this.end = end;
			this.value = value;
		}
		@Override
		public int compareTo(node o) {
	
			return this.value- o.value;
		}
		
	}
	static int[] parent;
	public static void main(String[] args) {
		int n=4;
		int[][] costs= {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		System.out.println(solution(n,costs));
	}
	
	private static void union(int from, int to) {
		parent[from]=to;
	}
	private static int find(int x) {
		if(parent[x]==x)return x;
		return parent[x]=find(parent[x]);
	}
	
	private static int solution(int n, int[][] costs) {
		int answer = 0;
		PriorityQueue<node> que=new PriorityQueue<>();
		for(int i=0;i<costs.length;i++) {
			que.add(new node(costs[i][0],costs[i][1],costs[i][2]));
		}
		parent=new int[n];
		for(int i=0;i<n;i++) {
			parent[i]=i;
		}
		int cnt = 0;
		while(!que.isEmpty()) {
			node cur=que.poll();
			int x = find(cur.start);
			int y = find(cur.end);
			if(x!=y) {
				union(x,y);
				cnt++;
				answer+=cur.value;
			}

			if(cnt==n-1)break;
			
		}
		return answer;
	}
}
