package 준비운동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2460_지능형기차2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int ans=0;
		int tmp=0;
		for(int i=0;i<10;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int K=Integer.parseInt(st.nextToken());
			tmp=tmp+K-N;
			ans=Integer.max(tmp, ans);
		}
		System.out.println(ans);
	}
}
