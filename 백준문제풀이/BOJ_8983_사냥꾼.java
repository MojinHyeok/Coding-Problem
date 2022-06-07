package 백준문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_8983_사냥꾼 {

	static class node{
		int x;
		int y;
		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int M,N,L;
	static int[] gun;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x;
		int y;
		int ans = 0;
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		gun = new int[M];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++) {
		
			gun[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(gun);
		for(int i=0; i<N; i++) {
			st =new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			if(search(x,y))ans ++;
		}
		System.out.println(ans);
	}
	
	private static boolean search(int x, int y) {
		int start =0;
		int end = M;
		int mid;
		int dist ;
		while(start<=end) {
			mid = (start+end)/2;
			if(mid>=M)return false;
			dist = getDist(x,y,gun[mid]);
			
			if(dist<=L)return true;
			
			if(x>gun[mid]) {
				
				start=mid+1;
			}else {
				
				end = mid-1;
			}
			
		}
		return false;
	}

	private static int getDist(int x, int y, int idx) {
		int xDist = Math.abs(x-idx);
		return xDist+y;
	}

}
