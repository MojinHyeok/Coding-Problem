package 코테꿀문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18500_미네랄2 {
	/**
	 * 1. 구현.
	 * Map을 R+2 C+2로 설정하여 구현
	 * 막대를 던졌을 때 미네랄을 만나면 체크를 진행합니다.
	 * 체크는 먼저 미네랄이 동떨어져 있는게 있는지 체크하는 것.
	 * 1층에 있는 미네랄들을 하나씩 위로탐색을 진행합니다. 그리하여 진행하면서 만약 카운팅을 하나씩 하면서 올라가는데 
	 * 지금 총 있는 미네랄 갯수랑 탐색을 진행했을 때 갯수가 맞지 않다면 그때는 동떨어져있는게 있다고 판단하여
	 * 동떨어져있는 미네랄들을 아래로 내리는 작업들을 진행합니다.
	 * @param args
	 */
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static class node{
		int x;
		int y;
		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		map = new char[R+2][C+2];
		int cnt = 0;
		for(int i=1; i <= R; i++) {
			String str = br.readLine();
			for(int j=1;j<=C; j ++) {
				map[i][j]=str.charAt(j-1);
				if(map[i][j]=='x')cnt++;
			}
		}
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i < N;i ++) {
			int level =Integer.parseInt(st.nextToken())-1;
			if(i%2 == 0) {
				for(int j =1 ;j<= C; j++) {
					if(map[R-level][j]=='x') {
						cnt--;
						map[R-level][j]='.';
						check(cnt,R,C);
						break;
					}
				}
			}else {
				for(int j=C; j>=1; j--) {
					if(map[R-level][j]=='x') {
						cnt--;
						map[R-level][j]='.';
						check(cnt,R,C);
						break;
					}
				}
			}
		}
		for(int i=1;i<=R;i++) {
			for(int j=1;j<=C;j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
		
	}
	private static void check(int cnt,int R,int C) {
		visit= new boolean[R+2][C+2];
		Queue<node> que =new LinkedList<>(); 
		int count =0;
		for(int i=1;i<=C;i++) {
			if(map[R][i]=='x'&&!visit[R][i]) {
				que.add(new node(R,i));
				visit[R][i]=true;
				count++;
				
			}
		}
		while(!que.isEmpty()) {
			node cur = que.poll();
			for(int d=0;d<4;d++) {
				int dx = cur.x+dr[d];
				int dy = cur.y+dc[d];
				if(dx>=1&&dy>=1&&dx<=R&&dy<=C&&!visit[dx][dy]&&map[dx][dy]=='x') {
					count++;
					que.add(new node(dx,dy));
					visit[dx][dy]=true;
				}
				
			}
			
		}
		if(count != cnt) {
			gravity(cnt,R,C);
		}
		
	}
	private static void gravity(int cnt, int r, int c) {
		List<node> arr =new ArrayList<>();
		for(int i=r;i>=2;i--) {
			for(int j=1;j<=c;j++) {
				if(!visit[i][j]&&map[i][j]=='x') {
					map[i][j]='.';
					arr.add(new node(i,j));
					
				}
			}
		}
		while(true) {
			boolean check =true;
			for(node x: arr) {
				if((map[x.x+1][x.y]=='x'&&visit[x.x+1][x.y])||x.x==r) {
					check= false;
					break;
				}
			}
			
			if(!check) {
				for(node x: arr) {
					map[x.x][x.y]='x';
				}
				break;
			}
			for(node x : arr) {
				x.x++;
			}
			
		}
		
		
		
	}
}
