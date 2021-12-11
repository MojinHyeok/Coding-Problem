package 최근빈출유형백준;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_9470_Strahler순서 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for(int t=0;t<TC;t++) {
			int K=sc.nextInt();
			int M=sc.nextInt();
			int P=sc.nextInt();
			int ans=1;
			int[] con=new int[M+1];
			List<Integer> li[]=new List[M+1];
			List<Integer> counting[]=new List[M+1];
			for(int i=1;i<=M;i++) {
				li[i]=new ArrayList<>();
				counting[i]=new ArrayList<>();
			}
			for(int i=0;i<P;i++) {
				int from=sc.nextInt();
				int to=sc.nextInt();
				li[from].add(to);
				con[to]++;
			}
			Queue<Integer> que=new LinkedList<>();
			for(int i=1;i<=M;i++) {
				if(con[i]==0) {
					counting[i].add(1);
					que.offer(i);
				}
			}
			while(!que.isEmpty()) {
				int cur=que.poll();
				int count=counting[cur].get(0);
				ans=Math.max(ans, count);
				for(int i=0;i<li[cur].size();i++) {
					int next=li[cur].get(i);
					if(counting[next].isEmpty())counting[next].add(count);
					else {
						if(counting[next].get(0)==count)counting[next].add(count);
						else if(counting[next].get(0)<count) {
							counting[next].clear();
							counting[next].add(count);
						}
					}
					if(--con[next]==0) {
						que.offer(next);
						if(counting[next].size()>1) {
							int value=counting[next].get(0);
							counting[next].clear();
							counting[next].add(value+1);
						}
					}
				}
			}
			System.out.println(K+" "+ans);
		}
	}
}
