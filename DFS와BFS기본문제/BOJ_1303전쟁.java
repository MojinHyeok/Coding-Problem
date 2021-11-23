package DFS와BFS기본문제;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1303전쟁 {
	static int N,M;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,1,-1};
	static char[][] map;
	static boolean[][] check;
	static class node{
		int x,y;
		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		map=new char[M][N];
		check=new boolean[M][N];
		for(int i=0;i<M;i++) {
			String str=sc.next();
			for(int j=0;j<N;j++) {
				map[i][j]=str.charAt(j);
			}
		}
		//ans 우리팀 ans2적군
		int ans=0;
		int ans2=0;
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(check[i][j]==false) {
					char tmp=map[i][j];
					int tmpV=1;
					check[i][j]=true;
					Queue<node> queue=new LinkedList<BOJ_1303전쟁.node>();
					queue.add(new node(i,j));
					while(!queue.isEmpty()) {
						node cur=queue.poll();
						for(int d=0;d<4;d++) {
							int dr=cur.x+dx[d];
							int dc=cur.y+dy[d];
							if(dr>=0&&dc>=0&&dr<M&&dc<N&&!check[dr][dc]&&map[dr][dc]==tmp) {
								check[dr][dc]=true;
								tmpV++;
								queue.add(new node(dr,dc));
							}
						}						
					}
					if(tmp=='W')ans+=tmpV*tmpV;
					else ans2+=tmpV*tmpV;
				}
			}
		}
		System.out.println(ans+" "+ans2);
	}

}
