package 백준문제풀이;
import java.util.Scanner;

public class BOJ_9663_NQueen {
	static boolean[][] map;
	static int N,count;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
			N=sc.nextInt();
			map=new boolean[N][N];
			count=0;
			dfs(0);
			System.out.println(count);
	}
	static void dfs(int cnt) {
		if(cnt==N) {
			count++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(isable(cnt,i)) {
				map[cnt][i]=true;
				dfs(cnt+1);
				map[cnt][i]=false;
			}
		}
	}
	private static boolean isable(int cnt, int x) {
		for(int i=0;i<cnt;i++) {
			if(map[i][x]==true)return false;
		}
		for(int i=cnt,j=x;i>=0&&j>=0;i--,j--) {
			if(map[i][j]==true)return false;
		}
		for(int i=cnt,j=x;i>=0&&j<N;i--,j++) {
			if(map[i][j]==true)return false;
		}
		return true;
	}
}
