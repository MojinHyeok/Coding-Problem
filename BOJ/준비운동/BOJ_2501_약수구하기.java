package 준비운동;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2501_약수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int cnt=0;
		boolean check=false;
		for(int i=1;i<=N;i++) {
			if(N%i==0) {
				cnt++;
				if(cnt==K) {
					bw.write(String.valueOf(i));
					check=true;
				}
			}
		}
		if(!check)bw.write(String.valueOf(0));
		bw.flush();
		bw.close();
	}

}
