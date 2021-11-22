package SW_SWTest;

import java.util.Arrays;
import java.util.Scanner;

public class 벽돌깨기 {
	static int N,W,H,ans;

	static int[] temp;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for(int t=1;t<=TC;t++) {
			N=sc.nextInt();
			W=sc.nextInt();
			H=sc.nextInt();
			int[][] arr=new int[H][W];
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			ans=99999;
			dfs(arr,0);
			System.out.println("#"+t+" "+ans);
		}
	}
	static void deepCopy(int[][] org,int[][] map) {
		for(int i=0;i<org.length;i++) {
			map[i]=Arrays.copyOf(org[i], org[i].length);
		}
	}
	static void dfs(int[][] arr,int idx) {
		if(idx==N) {
			ans=Math.min(ans, getCnt(arr));
			return;
		}
		for(int i=0;i<arr[0].length;i++) {
			int[][] map=new int[arr.length][arr[0].length];
			deepCopy(arr,map);
			for(int k=0;k<map.length;k++) {
				if(map[k][i]!=0) {
					bomb(map,k,i);
					break;
				}
			}
			down(map);
			dfs(map,idx+1);
		}
	}
	static void bomb(int[][] arr,int x,int y) {
		if(x>=0&&y>=0&&x<arr.length&&y<arr[0].length) {

			int temp=arr[x][y];
			arr[x][y]=0;
			for(int i=1;i<temp;i++) {
				bomb(arr,x,y+i);
				bomb(arr,x,y-i);
				bomb(arr,x+i,y);
				bomb(arr,x-i,y);
				
			}
		}
	}
	static void down(int[][] arr) {
		for(int i=arr.length-1;i>=0;i--) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]==0) {
					for(int k=i;k>=0;k--) {
						if(arr[k][j]!=0) {
							arr[i][j]=arr[k][j];
							arr[k][j]=0;
							break;
						}
					}
				}
			}
		}
	}
	static int getCnt(int[][] arr) {
		int cnt=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]!=0)cnt++;
			}
		}
		return cnt;
	}

}
