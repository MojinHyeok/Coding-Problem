package 준비운동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2693_N번째큰수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			int[] tmp=new int[10];
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				int num=Integer.parseInt(st.nextToken());
				tmp[j]=num;
			}
			Arrays.sort(tmp);
			System.out.println(tmp[7]);
		}
	}
}
