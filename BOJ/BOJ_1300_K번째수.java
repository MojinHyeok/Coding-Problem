package 백준문제풀이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1300_K번째수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		int K=Integer.parseInt(br.readLine());
		long start=1;
		long end=K;
		long ans=0;
		while(start<=end) {
			long mid=(start+end)/2;
			long cnt=0;
			for(int i=1;i<=N;i++) {
				cnt+=Math.min(mid/i, N);
			}
			if(cnt<K)start=mid+1;
			else {
				ans=mid;
				end=mid-1;
			}
		}
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
