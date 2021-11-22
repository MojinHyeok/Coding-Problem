package 백준문제풀이;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_4991로봇청소기 {
	static class point{
		int x,y,dist,cnt;
		public point(int x, int y, int dist, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.cnt = cnt;
		}
		
		
	}
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,1,-1};
	static int row,column,cnt,ans;
	static char[][] map;
	static boolean[][][] visit;
	static Queue<point> queue ;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			column=sc.nextInt();
			row=sc.nextInt();
			if(row==0&&column==0)break;
			cnt=0;
			int dx=0;
			int dy=0;
			map=new char[row][column];
			for(int i=0;i<row;i++) {
				String str=sc.next();
				for(int j=0;j<column;j++) {
					map[i][j]=str.charAt(j);
					if(map[i][j]=='*') {
						map[i][j]=(char)(cnt+'0');
						cnt++;
					};
					if(map[i][j]=='o') {
						dx=i;dy=j;
						map[i][j]='.';
					}
				}
			}
			visit=new boolean[row][column][1<<cnt];
			ans=Integer.MAX_VALUE;
			queue=new LinkedList<point>();
			queue.offer(new point(dx,dy,0,0));
			
			BFS();
			if(ans==Integer.MAX_VALUE) {
				System.out.println(-1);
			}
			else {
				System.out.println(ans);
			}
		}
	}
	private static void BFS() {
		while(!queue.isEmpty()) {
			point curr=queue.poll();
//			System.out.println(curr.x+" "+curr.y+" "+row+" "+column);
			visit[curr.x][curr.y][0]=true;
			if(curr.cnt==(1<<cnt)-1) {
				ans=curr.dist;
				break;
			}
			for(int d=0;d<4;d++) {
				int nr=curr.x+dr[d];
				int nc=curr.y+dc[d];
				if(nr>=0&&nc>=0&&nr<row&&nc<column&&!visit[nr][nc][curr.cnt]&&map[nr][nc]!='x') {
					if('0'<=map[nr][nc]&&map[nr][nc]<='9') {
						int newcnt=curr.cnt|(int)Math.pow(2,(map[nr][nc]-'0'));
						queue.offer(new point(nr,nc,curr.dist+1,newcnt));
						visit[nr][nc][newcnt]=true;
					}
					else {
						queue.offer(new point(nr,nc,curr.dist+1,curr.cnt));
						visit[nr][nc][curr.cnt]=true;
					}
				}
			}
		}
	}
	
}
