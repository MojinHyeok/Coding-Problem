package 백준문제풀이;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7569토마토 {
	static int[] dr= {-1,1,0,0,0,0};
	static int[] dc= {0,0,-1,1,0,0};
	static int[] dz= {0,0,0,0,1,-1};
	static int row,column,ans,num;
	static int[][][] map;
	static boolean[][][] visit;
	static Queue<int[]> queue=new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		column=sc.nextInt();
		row=sc.nextInt();
		num=sc.nextInt();
		
		map=new int[num][row][column];
		visit=new boolean[num][row*num][column];
		for(int k=0;k<num;k++) {
			for(int i=0;i<row;i++) {
				for(int j=0;j<column;j++) {
					map[k][i][j]=sc.nextInt();
					if(map[k][i][j]==1)queue.add(new int[] {i,j,k});
				}
			}
		}
		ans=0;
		int answer=bfs();
		boolean check=false;
		out:for(int k=0;k<num;k++) {
			for(int i=0;i<row;i++) {
				for(int j=0;j<column;j++) {
					if(map[k][i][j]==0) {
						check=true;
						break out;
					}
					
				}
			}
		}
		if(check)System.out.println(-1);
		else System.out.println(answer);
		
		
	}
	static int bfs() {
		while(true) {
			int temp=queue.size();		
			boolean value=false;
			for(int i=0;i<temp;i++) {
				int[] curr=queue.poll();
				visit[curr[2]][curr[0]][curr[1]]=true;
				for(int d=0;d<6;d++) {
					int dx=curr[0]+dr[d];
					int dy=curr[1]+dc[d];
					int dz1=curr[2]+dz[d];
					if(dx>=0&&dy>=0&&dx<row&&dy<column&&dz1>=0&&dz1<num&&visit[dz1][dx][dy]==false&&map[dz1][dx][dy]==0) {
						value=true;
						map[dz1][dx][dy]=1;
						queue.add(new int[] {dx,dy,dz1});
					}
				}
			}
			if(value)ans++;
			if(queue.isEmpty())break;
		}
		return ans;
	}
}
