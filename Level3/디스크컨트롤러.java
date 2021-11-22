package Level3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
	public static void main(String[] args) {
		int[][] temp= {{1, 9},{2, 6},{0,3}};
		int r=solution(temp);
		System.out.println(r);
	}
	 public static int solution(int[][] jobs) {
	        int answer = 0;
	        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1]-o2[1];
				}
			});
	        Arrays.sort(jobs,new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					
					return o1[0]-o2[0];
				}
			});
	        for(int[] x:jobs) System.out.println(Arrays.toString(x));
	        int cur=0;
	        int idx=0;
	        while(idx<jobs.length||!pq.isEmpty()) {
	        	while(idx<jobs.length&&jobs[idx][0]<=cur) {
	        		pq.add(new int[] {jobs[idx][0],jobs[idx][1]});
	        		idx++;
	        	}
	        	if(pq.isEmpty()) cur=jobs[idx][0];
	        	else {
	        		int[] temp=pq.poll();
	        		answer+=cur+temp[1]-temp[0];
	        		cur+=temp[1];
	        	}
	        }
	        answer/=jobs.length;
	        return answer;
	    }
}
