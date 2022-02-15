package Level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class 신고결과받기 {
	public static void main(String[] args) {
		String[] id_list= {"muzi", "frodo", "apeach", "neo"};
		String[] report= {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k =2;
		System.out.println(Arrays.toString(solution(id_list,report,k)));
	}

	private static int[] solution(String[] id_list, String[] report, int k) {
		Map<String, HashSet<String>> result=new HashMap<>();
		Map<String, Integer> idx=new LinkedHashMap<String, Integer>();
		for(int i=0;i<id_list.length;i++) {
			idx.put(id_list[i],i);
		}
		for(String x: report) {
			String[] temp=x.split(" ");
			if(result.containsKey(temp[1])) {
				result.get(temp[1]).add(temp[0]);
			}else {
				HashSet<String> hash=new HashSet<>();
				hash.add(temp[0]);
				result.put(temp[1],hash);
			}
		}
		int[] answer=new int[id_list.length];
		for(int i=0;i<id_list.length;i++) {
			String Check_id=id_list[i];
			if(result.containsKey(Check_id)) {
				int size=result.get(Check_id).size();
				if(size>=k) {
					Iterator iter=result.get(Check_id).iterator();
					while(iter.hasNext()) {
						answer[idx.get(iter.next())]++;
					}
				}
			}
		}
		return answer;
	}

}
