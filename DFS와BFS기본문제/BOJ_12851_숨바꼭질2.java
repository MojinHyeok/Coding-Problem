package DFS와BFS기본문제;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_12851_숨바꼭질2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//N은 수빈
		int N=sc.nextInt();
		//M은 동생
		int M=sc.nextInt();
		int ans=0;
		boolean[] check=new boolean[100001];
		Queue<Integer> que=new LinkedList<Integer>();
		que.add(N);
		int time=0;
		while(!que.isEmpty()) {
			if(ans!=0)break;
			
			for(int i=0,size=que.size();i<size;i++) {
				int cur=que.poll();
				check[cur]=true;
				
				if(cur-1==M)ans++;
				else if(cur-1>=0&&!check[cur-1]) {
				
					que.add(cur-1);
				}
				if(cur+1==M)ans++;
				else if(cur+1<=100000&&!check[cur+1]) {
					que.add(cur+1);
				}
				if(cur*2==M)ans++;
				else if(cur*2<=100000&&!check[cur*2]) {
					que.add(cur*2);
				}
			
			}
			time++;	
			}

			
		System.out.println(time);
		System.out.println(ans);
	}
}
