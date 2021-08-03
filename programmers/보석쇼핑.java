package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ∫∏ºÆºÓ«Œ {
	public static void main(String[] args) {
		String[] temp= {"A","B","B","B","B","B","B","C","B","A"};
		System.out.println(Arrays.toString(solution(temp)));
	}
	public static int[] solution(String[] gems) {
        int[] answer = {0,0};
        ArrayList<String> result=new ArrayList<>();
        for(String x :gems) {
        	if(!result.contains(x))result.add(x);
        }
        HashMap<String, Integer> hs=new HashMap<>();
        int idx=0;
        while(true) {
        	if(!hs.containsKey(gems[idx]))hs.put(gems[idx],1);
        	else hs.put(gems[idx],hs.get(gems[idx])+1);
        	if(hs.size()==result.size())break;
        	idx++;
        }
        int start=0;
        int end=idx;
        int ans_start=0;
        int ans_end=idx;
        
        int ans=idx;
        out: while(end<gems.length) {
        	String temp=gems[start];
        	System.out.println(temp+" "+start+" "+end+" "+ans);
        	if(hs.get(temp)-1>0) {
        		start++;
        		hs.put(temp, hs.get(temp)-1);
        		if(end-start<ans) {
        			ans_start=start;
        			ans_end=end;
        			ans=end-start;
        		}
        	}else if(hs.get(temp)-1==0) {
        		if(end-start<ans) {
        			ans_start=start;
        			ans_end=end;
        			ans=end-start;
        		}
        		end++;
        		if(end==gems.length)break out;
        		hs.put(gems[end], hs.get(gems[end])+1);
        	}
        }
        answer[0]=ans_start+1;
        answer[1]=ans_end+1;
        return answer;
    }
}
