package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class 순위검색 {
	public static void main(String[] args) {
		String[] info= {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query= {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		System.out.println(Arrays.toString(solution(info,query)));
	}
	static HashMap<String, ArrayList<Integer>> map;
	private static int[] solution(String[] info, String[] query) {
		int[] answer= new int[query.length];
		map=new HashMap<>();
		for(String x: info) {
			String[] sentence=x.split(" ");
			makeSentence(sentence,"",0);
		}
		for(String x : map.keySet()) {
			Collections.sort(map.get(x));
		}
		
		for(int i=0; i< query.length;i++) {
			query[i]=query[i].replaceAll(" and ", "");
			String[] sentence=query[i].split(" ");
			int ans=0;
			if(map.get(sentence[0]) == null) {
				
				answer[i]=0;
			}else {
				answer[i]=binarysearch(sentence[0],Integer.parseInt(sentence[1]));
			}
		}
		
		return answer;
		
	}
	private static int binarysearch(String x, int score) {
		ArrayList<Integer> list=map.get(x);
		int start=0;
		int end=list.size()-1;
		while(start<=end) {
			int mid=(start+end)/2;
			if(list.get(mid)<score) {
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		return list.size()-start-1;
		
	}
	
	
	private static void makeSentence(String[] sentence, String x, int idx) {
		if(idx==4) {
			if(map.get(x)==null) {
				ArrayList<Integer> list=new ArrayList<>();
				map.put(x, list);
			}
			map.get(x).add(Integer.parseInt(sentence[idx]));
			return;
		}
		makeSentence(sentence, x+"-",idx+1);
		makeSentence(sentence,x+sentence[idx],idx+1);
		
	}
}
