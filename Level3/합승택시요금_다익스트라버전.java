package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class 합승택시요금_다익스트라버전 {
	public static void main(String[] args) {
		int[][] temp= {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		System.out.println(solution(6,4,6,2,temp));
	}
	static class node implements Comparable<node>{
		int to,weight;
		public node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(node o) {
			return this.weight-o.weight;
		}	
	}
	static List<ArrayList<node>> list =new ArrayList<>();
	public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        for(int i=0;i<=n;i++) {
        	list.add(new ArrayList<>());
        }
        for(int i=0;i<fares.length;i++) {
        	list.get(fares[i][0]).add(new node(fares[i][1],fares[i][2]));
        	list.get(fares[i][1]).add(new node(fares[i][0],fares[i][2]));
        }
        
        int[] startA=new int[n+1];
        int[] startB=new int[n+1];
        int[] start=new int[n+1];
        Arrays.fill(startA, 20000001);
        Arrays.fill(startB, 20000001);
        Arrays.fill(start,20000001);
        startA=Dijkstra(a,startA);
        startB=Dijkstra(b,startB);
        start=Dijkstra(s,start);
        for(int i=1;i<=n;i++){
        	answer=Math.min(answer, startA[i]+startB[i]+start[i]);
        }
        
        
        return answer;
}
	private static int[] Dijkstra(int start,int[] costs) {
		PriorityQueue<node> pq=new PriorityQueue<>();
		for(node cur:list.get(start)) {
			costs[cur.to]=cur.weight;
		}
		costs[start]=0;
		for(node temp:list.get(start))pq.add(temp);
		while(!pq.isEmpty()) {
			node curnode=pq.poll();
			if(costs[curnode.to]<curnode.weight)continue;
			for(node next:list.get(curnode.to)) {
				if(costs[next.to]>curnode.weight+next.weight) {
					costs[next.to]=curnode.weight+next.weight;
					pq.add(new node(next.to,curnode.weight+next.weight));
				}
			}
		}
		
		
		return costs;
		
	}

}
