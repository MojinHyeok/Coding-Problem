package 백준문제풀이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110_공유기설치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		int[] arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		long start=1;
		long end=arr[N-1]-arr[0];
		long mid=0;
		long ans=0;
		while(start<=end) {
			mid=(start+end)/2;
			int cnt=1;
			long install=arr[0];
			for(int i=1;i<N;i++) {
				if(arr[i]-install>=mid) {
					cnt++;
					install=arr[i];
				}
			}
			if(cnt>=C) {
				ans=mid;
				start=mid+1;
			}
			else end=mid-1;
		}
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}
