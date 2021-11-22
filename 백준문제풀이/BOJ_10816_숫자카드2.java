package 백준문제풀이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_10816_숫자카드2 {
	static int N;
	static int[] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		map=new int[N];
		for(int i=0;i<N;i++) {
			map[i]=Integer.parseInt(st.nextToken());
		}
		int M=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		Arrays.sort(map);
		for(int i=0;i<M;i++) {
			int target=Integer.parseInt(st.nextToken());
			sb.append(upper(target)-low(target)+" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int upper(int value) {
		int start=0;
		int end=map.length-1;
		int mid=0;
		while(start<end) {
			mid=(start+end)/2;
			if(value<map[mid])end =mid;
			else {
				start=mid+1;
			}
		}
		if(end==map.length-1)end++;//맨끝 배열에 있으면 1을 추가해줘야한다.0부터시작하니 이런현상이 나오는거 같다.
		return end;
		
	}

	private static int low(int value) {
		int start=0;
		int end=map.length-1;
		int mid=0;
		while(start<end) {
			mid=(start+end)/2;
			if(value<=map[mid])end =mid;
			else {
				start=mid+1;
			}
		}
		return end;
		
	}


}
