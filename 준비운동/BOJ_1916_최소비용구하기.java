package 준비운동;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1916_최소비용구하기 {
//	문제풀이 생각
//	직관적으로 봤을 때 생각했던 문제풀이는 
//	DFS로 접근하는 것을 생각해 봤습니다.
//	시작점과 도착점이 주어진다면 시작점에서 DFS를 모든 곳을 탐색해 본 이후 만약 도착점에 도착했을 때 값이 최소가 되는 값을 구하면 될거라 생각했습니디. 
//	여기서 고려해야 할 점은 boolean으로 이미 갔던 지역을 체크 해 줘야한다는 점 입니다. 무한 루프를 하면 안되니..
//	위의사항.. 시간초과 발생..
//	2번째 방법다익스트라 알고리즘 구현
	
	static class Node implements Comparable<Node>{
		int end;
		int weight;
		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}		
	}
	
	static int[][] map;
	static int ans,N;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		int M=sc.nextInt();
		List<ArrayList<Node>> list=new ArrayList<>();
		ans=Integer.MAX_VALUE;
		map=new int[N+1][N+1];
		check=new boolean[N+1];
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		for(int i=0;i<M;i++) {
			int from=sc.nextInt();
			int to=sc.nextInt();
			int K=sc.nextInt();
			list.get(from).add(new Node(to,K));
		}
		int start=sc.nextInt();
		int end=sc.nextInt();
		int[] ans=new int[N+1];
		Arrays.fill(ans, Integer.MAX_VALUE);
		PriorityQueue<Node> pq =new PriorityQueue<>();
		ans[start]=0;
		pq.add(new Node(start,0));
		while(!pq.isEmpty()) {
			Node curNode=pq.poll();
			int cur=curNode.end;
			if(!check[cur]) {
				check[cur]=true;
				for(Node node: list.get(cur)) {
					if(!check[node.end]&&ans[node.end]>ans[cur]+node.weight) {
						ans[node.end]=ans[cur]+node.weight;
						pq.add(new Node(node.end,ans[node.end]));
					}
				
				}
			}
			
		
		}
		
		
		System.out.println(ans[end]);
	}
//	private static void DFS(int cur, int end, int tmp) {
//		if(cur==end) {
//			ans=Integer.min(tmp, ans);
//			return;
//		}
//		for(int i=1;i<=N;i++) {
//			if(map[cur][i]!=0&&!check[i]) {
//				check[i]=true;
//				DFS(i,end,tmp+map[cur][i]);
//				check[i]=false;
//			}
//		}
		
//	}

}
