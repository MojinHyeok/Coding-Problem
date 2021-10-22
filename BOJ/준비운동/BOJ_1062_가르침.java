package 준비운동;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1062_가르침 {
	static int N,K,ans;
	static String[] arr;
	static boolean[] check=new boolean[26];
	static boolean[] leng;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		ans=0;
		leng=new boolean[N];
		K-=5;
		if(K<0) {
			System.out.println(0);
			System.exit(0);
		}
		arr=new String[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.next();
		}
		check['a'-'a']=true;
		check['n'-'a']=true;
		check['t'-'a']=true;
		check['i'-'a']=true;
		check['c'-'a']=true;
		for(int i=0;i<N;i++) {
			String sen=arr[i];
			String tmp="";
			for(int j=0;j<sen.length();j++) {
				if(!check[sen.charAt(j)-'a']) {
					tmp+=sen.charAt(j);
				}		
			}
			arr[i]=tmp;
		}
		for(int i=0;i<N;i++) {
			if(arr[i].length()==0)leng[i]=true;
			System.out.println(arr[i]);
		}
		
		DFS(0,0);
		System.out.println(ans);
	}
	private static void DFS(int level,int start) {
		if(level==K) {
			int tmp=0;
			for(int i=0;i<N;i++) {
				boolean CheckV=true;
				for(int j=0;j<arr[i].length();j++) {
					if(!check[arr[i].charAt(j)-'a']) {
						CheckV=false;
						break;
					}
				}
				if(CheckV)tmp++;
			}
			ans=Math.max(ans, tmp);
			return;
		}
		
		for(int i=start;i<26;i++) {
			if(!check[i]) {
				check[i]=true;
				DFS(level+1,i);
				check[i]=false;
		}
		
	}
	}
	}


