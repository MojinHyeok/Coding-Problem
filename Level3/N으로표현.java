package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class N으로표현 {
	public static void main(String[] args) {
		int N=5;
		int number=26;
		System.out.println(solution(N,number));
	}

	private static int solution(int N, int number) {
		int answer=0;
		int[] dy=new int[32001];
		Arrays.fill(dy, Integer.MAX_VALUE);
		ArrayList<Integer> arr=new ArrayList<>();
		Queue<Integer> que=new LinkedList<>();
		arr.add(N);
		que.add(N);
		dy[N]=1;
		while(!que.isEmpty()) {
			int cur=que.poll();
			//덧셈
			for(int i=0;i<arr.size();i++) {
				int n=arr.get(i);
				if(cur+n<=32000&&dy[cur]+dy[n]<9&&dy[cur+n]>dy[cur]+dy[n]) {
					dy[cur+n]=dy[cur]+dy[n];
					que.add(cur+n);
					arr.add(cur+n);
				}
				//뺄셈
				if(cur-n>0&&dy[cur]+dy[n]<9&&dy[cur-n]>dy[cur]+dy[n]) {
					dy[cur-n]=dy[cur]+dy[n];
					que.add(cur-n);
					arr.add(cur-n);
				}
				//곱셈
				if(cur*n<=32000&&dy[cur]+dy[n]<9&&dy[cur*n]>dy[cur]+dy[n]) {
					dy[cur*n]=dy[cur]+dy[n];
					que.add(cur*n);
					arr.add(cur*n);
				}
				//나눗셈
				if(cur/n>0&&dy[cur]+dy[n]<9&&dy[cur/n]>dy[cur]+dy[n]) {
					dy[cur/n]=dy[cur]+dy[n];
					que.add(cur/n);
					arr.add(cur/n);
				}
				
			}
			//십의자리 더하기
			if((cur*10+N)<=32000&&dy[cur]+1<9&&dy[cur*10+N]>dy[cur]+1) {
				dy[cur*10+N]=dy[cur]+1;
				que.add(cur*10+N);
			}
			
			
		}
		answer=dy[number];
		if(answer==Integer.MAX_VALUE)answer=-1;
		return answer;
	}

}
