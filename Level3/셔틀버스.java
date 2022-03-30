package Level3;

import java.util.PriorityQueue;

public class 셔틀버스 {
	public static void main(String[] args) {
		int n=2;
		int t=10;
		int m=2;
		String[] timetable= {"09:10", "09:09", "08:00"};
		System.out.println(solution(n,t,m,timetable));
	}

	private static String solution(int n, int t, int m, String[] timetable) {
		
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(String time:timetable) {
			int timeIntValue=convertTimetoInt(time);
			pq.add(timeIntValue);
		}
		//마지막 버스제외 모든 버스를 돌려 최대한 크루들을 회사로 보내기
		for(int i=0;i<n-1;i++) {
			int curTime=540+i*t;
			for(int j=0;j<m;j++) {
				if(pq.peek()<=curTime)pq.poll();
			}
		}
		//마지막 버스에대해 판단하는 
		int curTime=540+(n-1)*t;
		int ans=0;
		int size=0;
		for(int i=0;i<m;i++) {
			if(!pq.isEmpty()&&pq.peek()<=curTime) {
				ans=Math.max(ans, pq.poll());
				size++;
			}
		}
		//만약 버스가 가득 찬상태라면 최대로 늦게오신 분보다 1분먼저 오면 된다고판단
		if(size==m)ans-=1;
		//만약 그렇지 않다면 그냥 버스가 오는 시간에 맞춰서 오면 된다고 판단.
		else {
			ans=curTime;
		}
		
		StringBuilder sb=new StringBuilder();
		int hour=ans/60;
		int min=ans%60;
		if(hour<=9) {
			sb.append("0");
			sb.append(Integer.toString(hour));
			sb.append(":");
		}else {
			sb.append(hour);
			sb.append(":");
		}
		if(min<=9) {
			sb.append("0");
			sb.append(Integer.toString(min));
		}else {
			sb.append(min);
		}
		return sb.toString();
	}
	//다음번엔 이 방법을 사용..
//	String tmp=String.format("%02d:%02d", hour,min);
	private static int convertTimetoInt(String time) {
		int hour=Integer.parseInt(time.substring(0,2));
		int min=Integer.parseInt(time.substring(3,5));
		return hour*60+min;
	}
}
