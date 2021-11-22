package 준비운동;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_3460_이진수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			int K=Integer.parseInt(br.readLine());
			String tmp="";
			while(K!=1) {
				tmp+=K%2;
				K/=2;
			}
			tmp+=K;
			for(int j=0;j<tmp.length();j++) {
				if(tmp.charAt(j)=='1')sb.append(j+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
