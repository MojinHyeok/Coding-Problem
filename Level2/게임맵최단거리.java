package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

	static class node{
		int x;
		int y;
		int cnt;
		public node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	static int[] dr= {0,0,-1,1};
	static int[] dc= {1,-1,0,0};
	public static void main(String[] args) {
		int[][] maps= {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(solution(maps));
	}
	private static int solution(int[][] maps) {
		int answer=-1;
		Queue<node> que=new LinkedList<>();
		boolean[][] visit=new boolean[maps.length][maps[0].length];
		que.add(new node(0,0,1));
		visit[0][0]=true;
		while(!que.isEmpty()) {
			node cur=que.poll();
			for(int i=0;i<4;i++) {
				int dx=cur.x+dr[i];
				int dy=cur.y+dc[i];
				if(dx<0||dy<0||dx>=maps.length||dy>=maps[0].length) continue;
				if(maps[dx][dy]==1&&!visit[dx][dy]) {
					que.add(new node(dx,dy,cur.cnt+1));
					visit[dx][dy]=true;
					if(dx==maps.length-1&&dy==maps[0].length-1) {
						return cur.cnt+1;
					}
				}
			}
		}
		
		return answer;
	}
}
