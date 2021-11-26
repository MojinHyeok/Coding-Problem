package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카드짝맞추기 {
	public static void main(String[] args) {
		int[][] temp= {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
		System.out.println(solution(temp,1,0));
	}
	static ArrayList<int[]> list=new ArrayList<>();
	static int[] num;
	static boolean[] check;
	static class node{
		int x,y,cnt;
		public node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static Queue<node> que;
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	private static int solution(int[][] board, int r, int c) {
		int answer=1000000;
		int tmp=0;
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]>tmp)tmp=board[i][j];
			}
		}
		check=new boolean[tmp+1];
		num=new int[tmp];
		permutation(tmp,0);
		for(int[] per:list) {
			int[][] tmpBoard=new int[board.length][board[0].length];
			//임시 보드 생성
			for(int i=0;i<board.length;i++) {
				System.arraycopy(board[i], 0, tmpBoard[i], 0, board[i].length);
			}
			node curNode=new node(r,c,0);
			for(int Goal:per) {
				curNode=BFS(Goal,tmpBoard,curNode);
				tmpBoard[curNode.x][curNode.y]=0;
				curNode=BFS(Goal,tmpBoard,curNode);
				tmpBoard[curNode.x][curNode.y]=0;
			}
			answer=Math.min(answer, curNode.cnt);
		}
		
		
		return answer;
	}
	
	private static node BFS(int goal, int[][] tmpBoard,node curNode) {
		que=new LinkedList<>();
		que.add(curNode);
		boolean[][] visit=new boolean[4][4];
		System.out.println(curNode.x+" "+curNode.y);
		visit[curNode.x][curNode.y]=true;
		while(!que.isEmpty()) {
			node cur=que.poll();
			if(tmpBoard[cur.x][cur.y]==goal)return new node(cur.x,cur.y,cur.cnt+1);
			for(int d=0;d<4;d++) {
				int dx=cur.x+dr[d];
				int dy=cur.y+dc[d];
				if(dx>=0&&dy>=0&&dx<4&&dy<4&&!visit[dx][dy]) {
					visit[dx][dy]=true;
					System.out.println(dx+" "+dy+" "+(cur.cnt+1));
					que.add(new node(dx,dy,cur.cnt+1));
				}
			}
			for(int d=0;d<4;d++) {
				node temp=crtl(cur.x,cur.y,d,tmpBoard);
				int dx=temp.x;
				int dy=temp.y;
				if((cur.x!=dx||cur.y!=dy)&&!visit[dx][dy]) {
					visit[dx][dy]=true;
					que.add(new node(dx,dy,cur.cnt+1));
					
				}
			}
		}

		return null;
	}
	private static node crtl(int x, int y, int d,int[][]tmpBoard) {
		x+=dr[d];
		y+=dc[d];
		while(x>=0&&y>=0&&x<4&&y<4) {
			if(tmpBoard[x][y]!=0) {
				return new node(x,y,0);
			}
			x+=dr[d];
			y+=dc[d];
		}
		return new node(x-dr[d],y-dc[d],0);
		
	}
	private static void permutation(int tmp, int idx) {
		if(idx==tmp) {
			int[] temp=new int[tmp];
			System.arraycopy(num, 0, temp,0, tmp);
			list.add(temp);
			return;
		}
		for(int i=1;i<=tmp;i++) {
			if(!check[i]) {
				check[i]=true;
				num[idx]=i;
				permutation(tmp, idx+1);
				check[i]=false;
			}
		}
		
	}

}
