package 백준문제풀이;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_23290_마법사상어와복제 {
	static class node{
		int x;
		int y;
		int dir;
		public node(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		
	}
	static List<node>[][] map;
	static int[][] fishFlavor;
	static int[] dr = {0,-1,-1,-1,0,1,1,1};
	static int[] dc = {-1,-1,0,1,1,1,0,-1};
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int M;
	static int ans;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N = sc.nextInt();
		M = sc.nextInt();
		ans=0;
		map =new ArrayList[6][6];
		fishFlavor = new int[6][6];
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=4;j++) {
				map[i][j]=new ArrayList<>();
			}
		}
		for(int i=0;i<N;i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			int dir=sc.nextInt();
			map[x][y].add(new node(x,y,dir));
		}
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		DFS(x,y,0);
		System.out.println(ans);
	}
	private static void DFS(int x, int y, int idx) {
		Queue<node> que=new LinkedList<>();
		List<node>[][] tmpMap = new ArrayList[6][6];
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=4;j++) {
				tmpMap[i][j]=new ArrayList<>();
				if(map[i][j].size()>=1) {
					for(int k = 0; k< map[i][j].size(); k++) {
						que.add(map[i][j].get(k));
					}
				}
			}
		}
		if(idx==M) {
			ans=que.size();
			return;
		}
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=4; j++) {
				if(map[i][j].size()>=1) {
					for(int k = 0; k< map[i][j].size(); k++) {
						node cur= map[i][j].get(k);
						int fish_x = cur.x;
						int fish_y = cur.y;
						int fish_dir = cur.dir;
						boolean check = false;
						for(int c=0;c<8;c++) {
							int tmp_dir=convert(fish_dir-c-1);
							int tmp_x = fish_x + dr[tmp_dir];
							int tmp_y = fish_y + dc[tmp_dir];
							if(tmp_x>=1&&tmp_y>=1&&tmp_x<=4&&tmp_y<=4&&fishFlavor[tmp_x][tmp_y]==0&&!(tmp_x==x&&tmp_y==y)) {
								tmpMap[tmp_x][tmp_y].add(new node(tmp_x,tmp_y,tmp_dir+1));
								check = true;
								break;
							}
						}
						if(!check) {
							tmpMap[fish_x][fish_y].add(new node(fish_x,fish_y,fish_dir));
						}
						
					}
				}
			}
		}
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=4;j++) {
				if(fishFlavor[i][j]>=1)fishFlavor[i][j]--;
			}
		}
		int maxv=-1;
		int first = 0;
		int second = 0;
		int third = 0 ;
		
		boolean[][] visit=new boolean[6][6];
		for(int i=0;i<4;i++) {
			int shark_x = x + dx[i];
			int shark_y = y + dy[i];
			int cnt = 0;
			if(shark_x<=0||shark_y<=0||shark_x>=5||shark_y>=5)continue;
			if(tmpMap[shark_x][shark_y].size()>=1) {
				cnt+=tmpMap[shark_x][shark_y].size();
			}
			visit[shark_x][shark_y]=true;
			for(int j=0;j<4;j++) {
				int second_shark_x = shark_x + dx[j];
				int second_shark_y = shark_y + dy[j];
				int second_cnt = 0 + cnt;
				if(second_shark_x<=0||second_shark_y<=0||second_shark_x>=5||second_shark_y>=5)continue;
				if(tmpMap[second_shark_x][second_shark_y].size()>=1&&!visit[second_shark_x][second_shark_y]) {
					second_cnt+=tmpMap[second_shark_x][second_shark_y].size();
				}
				visit[second_shark_x][second_shark_y]=true;
				for(int k=0;k<4;k++) {
					int third_shark_x = second_shark_x + dx[k];
					int third_shark_y = second_shark_y + dy[k];
					int third_cnt = 0 + second_cnt;
					if(third_shark_x<=0||third_shark_y<=0||third_shark_x>=5||third_shark_y>=5)continue;
					if(tmpMap[third_shark_x][third_shark_y].size()>=1&&!visit[third_shark_x][third_shark_y]) {
						third_cnt+=tmpMap[third_shark_x][third_shark_y].size();
						

					}
					if(maxv<third_cnt) {
						maxv=third_cnt;
						first=i;
						second=j;
						third=k;
					}
					
				}
				visit[second_shark_x][second_shark_y]=false;
			}
			visit[shark_x][shark_y]=false;
		}
		x=x+dx[first];
		y=y+dy[first];
		if(tmpMap[x][y].size()>=1) {
			tmpMap[x][y]=new ArrayList<>();
			fishFlavor[x][y]=2;
		}
		x=x+dx[second];
		y=y+dy[second];
		if(tmpMap[x][y].size()>=1) {
			tmpMap[x][y]=new ArrayList<>();
			fishFlavor[x][y]=2;
		}
		x=x+dx[third];
		y=y+dy[third];
		if(tmpMap[x][y].size()>=1) {
			tmpMap[x][y]=new ArrayList<>();
			fishFlavor[x][y]=2;
		}
		while(!que.isEmpty()) {
			node cur = que.poll();
			tmpMap[cur.x][cur.y].add(new node(cur.x,cur.y,cur.dir));
		}
		map= tmpMap;
		DFS(x,y,idx+1);
	}
	private static int convert(int x) {
		if(x<0) {
			return 8+x;
		}
		return x;
		
	}

}
