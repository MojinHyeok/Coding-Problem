package 백준문제풀이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1654랜선자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int[] arr=new int[N];
		int maxv=0;
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			maxv=Math.max(maxv, arr[i]);
		}
		Arrays.sort(arr);
		int start=0;
		int mid=0;
		int ans=0;
		while(start<=maxv) {
			mid=(start+maxv)/2;
			int cnt=0;
			for(int i=0;i<N;i++) {
				cnt+=arr[i]/mid;
			}
			if(cnt>=K) {
				start=mid+1;
				ans=Math.max(mid,ans);
			}
			else {
				maxv=mid-1;
			}
			
		}
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
		
	}

}
