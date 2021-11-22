package SW_SWTest;

import java.util.Arrays;
import java.util.Scanner;

public class 활주로건설 {
	static int[][] map;
	static int X,N;
	static boolean[][][] visit;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for(int tc=1;tc<=TC;tc++) {
			N=sc.nextInt();
			map=new int[N][N];
			X=sc.nextInt();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=sc.nextInt();
				}
			}
		
			int ans=0;
			for(int i=0;i<N;i++) {
				if(garo(i,0)) {
					ans++;
				}
				if(sero(0,i)) {
					ans++;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	static boolean garo(int x ,int y) {
		int leng=1;
		
		for(int i=0;i<N-1;i++) {
			if(map[x][i]<map[x][i+1]) {
				if(map[x][i+1]-map[x][i]>1)return false;
				if(leng<X)return false;
				leng=1;
				continue;
			}
			if(map[x][i]>map[x][i+1]) {
				if(map[x][i]-map[x][i+1]>1)return false;
				if(leng<0)return false;
				leng=1;
				leng-=X;
				continue;
			}
			leng+=1;
		}
		if(leng<0)return false;
		return true;
		
	}
	static boolean sero(int x ,int y) {
		int leng=1;
		
		for(int i=0;i<N-1;i++) {
			if(map[i][y]<map[i+1][y]) {
				if(map[i+1][y]-map[i][y]>1)return false;
				if(leng<X)return false;
				leng=1;
				continue;
			}
			if(map[i][y]>map[i+1][y]) {
				if(map[i][y]-map[i+1][y]>1)return false;
				if(leng<0)return false;
				leng=1;
				leng-=X;
				continue;
			}
			leng+=1;
		}
		if(leng<0)return false;
		return true;
		
	}

}
