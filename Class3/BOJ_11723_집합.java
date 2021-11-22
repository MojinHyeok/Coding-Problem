package Class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_11723_집합 {
	//문제접근
	//문제 처음 봤을 때 Hashset으로 풀려고 해봤지만 시간초과가 떠서 다른방법으로 풀어야했다
	//문제분류를 보니 비트마스크라고 적혀있어 비트마스크를 활용해봤습니다.
	//Scanner 를 사용하여 시간초과가 뜨는지 궁금하여 Scanner방식에서 BufferedReader을 사용하였습니다.
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter  bw= new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		int bit=0;
//		HashSet<Integer> hs=new HashSet<>();
		for(int i=0;i<N;i++) {
			
			StringTokenizer str=new StringTokenizer(br.readLine());
			String str3=str.nextToken();
			if(str3.equals("add")) {
//				hs.add(sc.nextInt());
				bit=bit|1<<(Integer.parseInt(str.nextToken())-1);
			}
			else if(str3.equals("check")) {
				int num=Integer.parseInt(str.nextToken());
				if((bit&1<<(num-1))==1<<(num-1))sb.append(1+"\n");
				else sb.append(0+"\n");
//				if(hs.contains(sc.nextInt()))System.out.println(1);
//				else System.out.println(0);
			}
			else if (str3.equals("remove")) {
				bit=bit&~(1<<Integer.parseInt(str.nextToken())-1);
//				hs.remove(sc.nextInt());
			}
			else if (str3.equals("toggle")) {
				bit=bit^1<<(Integer.parseInt(str.nextToken())-1);
//				int num=sc.nextInt();
//				if(hs.contains(num))hs.remove(num);
//				else hs.add(num);
			}
			else if(str3.equals("all")) {
				bit=~0;
//				hs=new HashSet<>();
//				for(int j=1;j<=20;j++) {
//					hs.add(j);
//				}
			}
			else if(str3.equals("empty")) {
				bit=0;
//				hs=new HashSet<>();
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}

}
