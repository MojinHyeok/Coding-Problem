package Class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10942_�Ӹ���� {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=null;
		st=new StringTokenizer(br.readLine());
		int[] arr=new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		boolean[][] dy=new boolean[N+1][N+1];
		for(int i=1;i<=N;i++) {
			dy[i][i]=true;
		}
		for(int i=1;i<N;i++) {
			if(arr[i]==arr[i+1])dy[i][i+1]=true;
		}
		for(int i=2;i<=N;i++) {
			for(int j=1;i+j<=N;j++) {
				if(arr[j]==arr[i+j]&&dy[j+1][i+j-1])dy[j][i+j]=true;
			}
		}
		int TC=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int t=0;t<TC;t++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			if(dy[start][end])sb.append(1+"\n");
			else sb.append(0+"\n");
		}
		System.out.println(sb);
	}
}
