package Level3;

import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설 {
	static class node{
		int x,y,value,dir;
		public node(int x,int y,int value, int dir) {
			this.x=x;
			this.y=y;
			this.value=value;
			this.dir=dir;

		}
	}
	static int[] dr= {0,0,1,-1};
	static int[] dc= {1,-1,0,0};
	public static void main(String[] args) {
		int[][] temp= {{0, 0, 0, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 1, 1, 1, 0},{1, 0, 0, 1, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 1, 0}};
		System.out.println(solution(temp));
	}
	//0은 오른쪽 1 왼쪽 2 아래 3 위쪽
	private static int solution(int[][] board) {
		int answer=Integer.MAX_VALUE;
		int[][] map=new int[board.length][board[0].length];
		Queue<node> que=new LinkedList<>();
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]==0)map[i][j]=Integer.MAX_VALUE;				
			}
		}
		map[0][0]=0;
		if(board[0][1]==0) {
			que.add(new node(0,1,100,0));
			map[0][1]=100;
		}
		if(board[1][0]==0) {
			map[1][0]=100;
			que.add(new node(1,0,100,2));
		}
		boolean[][][] visit= new boolean[board.length][board[0].length][4];
		while(!que.isEmpty()) {
			node cur=que.poll();
			System.out.println(cur.x+" "+cur.y+" "+cur.value+" "+cur.dir);
			if(cur.x==board.length-1&&cur.y==board[0].length-1) {
				answer=Math.min(answer, cur.value);
			}
			for(int i=0;i<4;i++) {
				int dx=cur.x+dr[i];
				int dy=cur.y+dc[i];
				if(dx>=0&&dy>=0&&dx<board.length&&dy<board[0].length&&board[dx][dy]!=1) {
					if(cur.dir==i&&(cur.value+100<=map[dx][dy]||!visit[dx][dy][i])) {
						map[dx][dy]=cur.value+100;
						que.add(new node(dx,dy,cur.value+100,i));
						visit[dx][dy][i]=true;
					}
					else if(cur.dir!=i&&(cur.value+600<=map[dx][dy]||!visit[dx][dy][i])) {
							map[dx][dy]=cur.value+600;
							que.add(new node(dx,dy,cur.value+600,i));
							visit[dx][dy][i]=true;
					}
				}
			}
		}		
		return answer;
	}

}
