package Class2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


public class 주차요금계산 {
	public static void main(String[] args) {
		int[] fees= {180,5000,10,600};
		String[] records= {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		System.out.println(Arrays.toString(solution(fees,records)));
	}

	private static int[] solution(int[] fees, String[] records) {
		
		HashMap<String, Integer> fee=new HashMap<>();
		HashMap<String, Integer> record =new HashMap<>();
		ArrayList<String> car=new ArrayList<>();
		int limitTime=23*60+59;
		for(String str : records) {
			String[] rc=str.split(" ");
			String carNumber=rc[1];
			int time=Integer.parseInt(rc[0].substring(0,2))*60+Integer.parseInt(rc[0].substring(3,5));
			if(!car.contains(carNumber)) {
				car.add(carNumber);
				fee.put(carNumber, 0);
			}
			if(rc[2].equals("IN")) {
				record.put(carNumber, time);
			}else if(rc[2].equals("OUT")) {
				fee.put(carNumber, fee.get(carNumber)+(time-record.get(carNumber)));
				record.remove(carNumber);
			}
		}
		int[] answer=new int[car.size()];
		Collections.sort(car);
		for(int i=0;i<car.size();i++) {
			answer[i]=fees[1];
			String carNumber=car.get(i);
			int time=fee.get(carNumber)-fees[0];
			
			if(record.containsKey(carNumber))time+=limitTime-record.get(carNumber);
			
			if(time>0)answer[i]+=(Math.ceil(time/(fees[2]*1.0))*fees[3]);
		}
		return answer;
	}
}
