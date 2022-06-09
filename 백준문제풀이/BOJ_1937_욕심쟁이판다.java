package 백준문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1937_욕심쟁이판다 {
	
	static int N;
	static int[][] map;
	static int[][] DP;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N= Integer.parseInt(br.readLine());
		map=new int[N][N];
		DP=new int[N][N];
		int ans=0;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(DP[i][j]==0) {
					ans = Math.max(ans, DFS(i,j));
				}
			}
		}
		System.out.println(ans);
	}
	private static int DFS(int x, int y) {
		int tmp= 0;
		for(int d=0;d<4;d++){
			int dx = x + dr[d];
			int dy = y + dc[d];
			if(dx>=0&&dy>=0&&dx<N&&dy<N) {
				if(DP[dx][dy]!=0&&map[x][y]<map[dx][dy]) {
					tmp = Math.max(DP[dx][dy]+1, tmp);
				}
				if(DP[dx][dy]==0&&map[x][y]<map[dx][dy]) {
					tmp= Math.max(DFS(dx,dy)+1, tmp);
				}
			}
		}
		tmp = Math.max(tmp, 1);
		DP[x][y]=tmp;
		return tmp;
		
	}
}
