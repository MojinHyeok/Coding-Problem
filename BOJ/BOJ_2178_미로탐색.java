package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2178_¹Ì·ÎÅ½»ö {
	static int[][] map;
	static class node{
		int x;
		int y;
		int cnt;
		public node(int x, int y,int cnt) {
			this.x = x;
			this.y = y;
			this.cnt=cnt;
		}
		
	}
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int ans=0;
		map=new int[N][M];
		for(int i=0;i<N;i++) {
			String Str=sc.next();
			for(int j=0;j<M;j++) {
				map[i][j]=Str.charAt(j)-'0';
			}
		}
		boolean[][] check=new boolean[N][M];
		Queue<node> queue=new LinkedList<>();
		queue.add(new node(0,0,1));
		out:while(!queue.isEmpty()) {
			int size=queue.size();
			for(int i=0;i<size;i++) {
				node cur=queue.poll();
				if(cur.x==N-1&&cur.y==M-1) {
					System.out.println(cur.cnt);
					break out;
				}
				for(int j=0;j<4;j++) {
					int nextX=cur.x+dx[j];
					int nextY=cur.y+dy[j];
					if(nextX<0||nextY<0||nextX>=N||nextY>=M)continue;
					if(map[nextX][nextY]==1&&check[nextX][nextY]==false) {
						check[nextX][nextY]=true;
						queue.add(new node(nextX,nextY,cur.cnt+1));
					}
					
				}
			}
		}
	}
}
