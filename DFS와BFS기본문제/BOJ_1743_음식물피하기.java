package DFS와BFS기본문제;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1743_음식물피하기 {
	static class node{
		int x ,y;

		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}	
	}
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int K=sc.nextInt();
		int[][] map=new int[N+1][M+1];
		boolean[][] check=new boolean[N+1][M+1];
		for(int i=0;i<K;i++) {
			int dx=sc.nextInt();
			int dy=sc.nextInt();
			map[dx][dy]=1;
		}
		int ans=0;
		for(int i=0;i<=N;i++) {
			for(int j=0;j<=M;j++) {
				if(map[i][j]==1) {
					int tmp=1;
					check[i][j]=true;
					Queue<node> que=new LinkedList<>();
					que.add(new node(i,j));
					//BFS작업
					while(!que.isEmpty()) {
						node cur=que.poll();
						for(int d=0;d<4;d++) {
							int dr=cur.x+dx[d];
							int dc=cur.y+dy[d];
							//맵안에있는지 확인, 음식물 쓰레기가 있는지 확인, 이전에 이미 체크햇는지 확인.
							if(dr>=1&&dc>=1&&dr<=N&&dc<=M&&map[dr][dc]==1&&!check[dr][dc]) {
								check[dr][dc]=true;
								tmp++;
								que.add(new node(dr,dc));
							}
						}
					}
					ans=Math.max(ans, tmp);
				}
			}
		}
		System.out.println(ans);
		
	}
}
