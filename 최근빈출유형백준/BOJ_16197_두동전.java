package 최근빈출유형백준;

import java.util.Scanner;

public class BOJ_16197_두동전 {

	static char[][] map;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,1,-1};
	static int N,M,answer;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		map=new char[N][M];
		int x1=0,y1=0,x2 = 0,y2=0;
		int tmp=0;
		for(int i=0;i<N;i++) {
			String str=sc.next();
			for(int j=0;j<M;j++) {
				map[i][j]=str.charAt(j);
				if(tmp==0&&map[i][j]=='o') {
					x1=i;
					y1=j;
					tmp++;
				}else if(tmp==1&&map[i][j]=='o') {
					x2=i;y2=j;
				}
			}
		}
		answer=Integer.MAX_VALUE;
		
		DFS(0,x1,y1,x2,y2);
		answer=(answer==Integer.MAX_VALUE)?-1:answer;
		System.out.println(answer);
		
	}
	private static void DFS(int idx,int x1,int y1,int x2,int y2) {
		if(idx>=10||idx>=answer)return;
		for(int i=0;i<4;i++) {
			int dx1=x1+dr[i];
			int dy1=y1+dc[i];
			int dx2=x2+dr[i];
			int dy2=y2+dc[i];
			if((dx1<0||dy1<0||dx1>=N||dy1>=M)&&(dx2<0||dy2<0||dx2>=N||dy2>=M))continue;
			if((dx1<0||dy1<0||dx1>=N||dy1>=M)||(dx2<0||dy2<0||dx2>=N||dy2>=M)) {
				answer=Math.min(answer, idx+1);
				return;
			}
			if(map[dx1][dy1]=='#') {
				dx1=x1;
				dy1=y1;
			}
			if(map[dx2][dy2]=='#') {
				dx2=x2;
				dy2=y2;
			}
			if((dx1==dx2)&&(dy1==dy2))continue;
			DFS(idx+1,dx1,dy1,dx2,dy2);
		}
		
	}
}
