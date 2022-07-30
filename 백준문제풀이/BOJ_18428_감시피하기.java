package 백준문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_18428_감시피하기 {
	
	public static class node{
		int x;
		int y;
		public node (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static String[][] map;
	static boolean[] visit;
	static int N;
	static List<node> obstacles = new ArrayList<>();
	static List<node> teachers  = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		map =new String[N][N];
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=st.nextToken();
				if(map[i][j].equals("X")) {
					obstacles.add(new node (i,j));
				}
				if(map[i][j].equals("T")) {
					teachers.add(new node(i,j));
				}
			}
		}
		visit = new boolean[obstacles.size()];
		DFS(0,0);
		System.out.println("NO");
		
	}
	private static void DFS(int idx, int start) {
		if(idx ==3) {
			if(check()) {
				System.out.println("YES");
				System.exit(0);
			}else {
				return;
			}
		};
		for(int i=start; i < obstacles.size();i++) {
			node cur = obstacles.get(i);
			map[cur.x][cur.y]="O";
			DFS(idx+1,i+1);
			map[cur.x][cur.y]="X";
		}
		
	}
	private static boolean check() {
		
		for(int i = 0; i < teachers.size(); i++) {
			node cur = teachers.get(i);
			int curX = cur.x;
			int curY= cur.y;
			for(int x = curX -1; x >= 0 ; x--) {
				if(map[x][curY].equals("S")) {
										
					return false;
				}
				if(map[x][curY].equals("O")) {
					
					break;
				}
			}
			for(int x = curX +1; x < N; x++) {
				if(map[x][curY].equals("S")) {
					
					return false;
				}
				if(map[x][curY].equals("O")) {
					
					break;
				}
			}
			for(int y = curY -1; y >= 0 ; y--) {
				if(map[curX][y].equals("S")) {
										
					return false;
				}
				if(map[curX][y].equals("O")) {
					
					break;
				}
			}
			for(int y = curY +1; y < N; y++) {
				if(map[curX][y].equals("S")) {
					
					return false;
				}
				if(map[curX][y].equals("O")) {
					
					break;
				}
			}
		}
		return true;
	}

}
