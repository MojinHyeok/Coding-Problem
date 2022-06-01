package 코테꿀문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14466_소가길을건너간이유6 {
	
	static class node {
		int x;
		int y;
		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static class bridge{
		int r1;
		int r2;
		int c1;
		int c2;
		public bridge(int r1, int c1, int r2, int c2) {
			super();
			this.r1 = r1;
			this.r2 = r2;
			this.c1 = c1;
			this.c2 = c2;
		}
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	static int N;
	static int[][] map ;
	static List<bridge> bridges ;
	static List<node> cow;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int ans=0;
		map =new int[N+2][N+2];
		bridges =new ArrayList<>();
		cow = new ArrayList<>();
		for(int i=0;i<R;i++) {
			st =new StringTokenizer(br.readLine());
			int r1=Integer.parseInt(st.nextToken());
			int c1=Integer.parseInt(st.nextToken());
			int r2=Integer.parseInt(st.nextToken());
			int c2=Integer.parseInt(st.nextToken());
			bridges.add(new bridge(r1,c1,r2,c2));
		}
		for(int i=0; i<K; i++ ) {
			st =new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			cow.add(new node(x,y));
		}
		int idx=0;
		for(node x: cow) {
			idx++;
			if(map[x.x][x.y]==0) {
				findcow(x,idx);				
			}
		}
		for(int i=0;i<K-1;i++) {
			for(int j=i+1;j<K;j++) {
				if(map[cow.get(i).x][cow.get(i).y]!= map[cow.get(j).x][cow.get(j).y])ans++;
			}
		}
		System.out.println(ans);
	}
	private static void  findcow(node x,int cow) {
		boolean[][] visit = new boolean[N+2][N+2];
		Queue<node> que =new LinkedList<>();
		visit[x.x][x.y]=true;
		map[x.x][x.y]=cow;
		que.add(x);
		while(!que.isEmpty()) {
			node cur =que.poll();
			out:for(int d=0;d<4;d++) {
				int dx = cur.x+dr[d];
				int dy = cur.y+dc[d];
				if(dx<=0||dy<=0||dx>=N+1||dy>=N+1||visit[dx][dy])continue;
				for(bridge br : bridges) {
					if(br.r1==cur.x&&br.c1==cur.y&&br.r2==dx&&br.c2==dy)continue out;
					if(br.r1==dx&&br.c1==dy&&br.r2==cur.x&&br.c2==cur.y)continue out;
				}
				visit[dx][dy]=true;
				map[dx][dy]=cow;
				que.add(new node(dx,dy));
			}
		}
	}
}
