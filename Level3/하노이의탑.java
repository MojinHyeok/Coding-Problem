package Level3;

import java.util.ArrayList;

public class 하노이의탑 {
	public static void main(String[] args) {
		System.out.println(solution(2));
	}
	static class node{
		int start,to;

		public node(int start, int to) {
			super();
			this.start = start;
			this.to = to;
		}
	}
	static ArrayList<node> list=new ArrayList<>();
	private static int[][] solution(int n) {
		
		DFS(n,1,2,3);
		int[][] answer;
		answer=new int[list.size()][2];
		for(int i=0;i<list.size();i++) {
			node cur=list.get(i);
			answer[i][0]=cur.start;
			answer[i][1]=cur.to;
		}
		return answer;
	}

	private static void DFS(int n, int start, int mid, int to) {
		System.out.println(start+" "+mid+" "+to);
		if(n==1) {
			list.add(new node(start,to));
			System.out.println(start+" "+to+" 여기는 그곳");
			return;
		}
		DFS(n-1,start,to,mid);
		list.add(new node(start,to));
		System.out.println(start+" "+to+" 여기는 그곳");
		DFS(n-1,mid,start,to);
		
	}
}
