package 백준문제풀이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[] arr=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int ans=0;
		int start=1;
		int end=arr[N-1];
		int mid=0;
		while(start<=end) {
			mid=(start+end)/2;
			int cnt=0;
			for(int i=0;i<N;i++) {
				int temp=arr[i]-mid;
				if(temp>0)cnt+=temp;
			}
			if(cnt>=M) {
				ans=mid;
				start=mid+1;
			}
			else end=mid-1;
		}
		sb.append(end);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
