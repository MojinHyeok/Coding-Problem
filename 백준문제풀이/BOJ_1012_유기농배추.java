package 백준문제풀이;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1012_유기농배추 {
	static int[][] map;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,1,-1};
	static int cnt;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		Queue<Integer> queue=new LinkedList<Integer>();
		for(int t=0;t<TC;t++) {
			int column=sc.nextInt();
			int row=sc.nextInt();
			int num=sc.nextInt();
			map=new int[row][column];
			for(int i=0;i<num;i++) {
				int dy=sc.nextInt();
				int dx=sc.nextInt();
				map[dx][dy]=1;
			}
			cnt=0;
			for(int i=0;i<row;i++) {
				for(int j=0;j<column;j++) {
					if(map[i][j]==1) {
						map[i][j]=0;
						queue.add(i);
						queue.add(j);
						cnt++;
						while(!queue.isEmpty()) {
							int dx=queue.poll();
							int dy=queue.poll();
							for(int k=0;k<4;k++) {
								if(dx+dr[k]>=0&&dy+dc[k]>=0&&dx+dr[k]<row&&dy+dc[k]<column&&map[dx+dr[k]][dy+dc[k]]==1) {
									queue.add(dx+dr[k]);
									queue.add(dy+dc[k]);
									map[dx+dr[k]][dy+dc[k]]=0;
								}
							}
						}
						
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
