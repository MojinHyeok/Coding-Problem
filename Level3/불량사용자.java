package Level3;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class 불량사용자 {
	static ArrayList<Integer>[] Combination;
	static boolean[] CheckCombination;
	static HashSet<String> answer;
	public static void main(String[] args) {
		String[] user_id= {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id= {"fr*d*", "abc1**"};
		System.out.println(solution(user_id,banned_id));
	}
	private static int solution(String[] user_id, String[] banned_id) {
		answer=new HashSet<>();
		int ban_length=banned_id.length;
		int user_length=user_id.length;
		CheckCombination=new boolean[user_length];
		Combination=new ArrayList[ban_length];
		for(int i=0;i<ban_length;i++) {
			Combination[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<ban_length;i++) {
			int banIdLength=banned_id[i].length();
			for(int j=0;j<user_length;j++) {
				if(banIdLength!=user_id[j].length())continue;
				boolean CheckSuccess=true;
				for(int k=0;k<banIdLength;k++) {
					if(banned_id[i].charAt(k)=='*')continue;
					if(banned_id[i].charAt(k)!=user_id[j].charAt(k)) {
						CheckSuccess=false;
						break;
					}
				}
				if(CheckSuccess) {
					Combination[i].add(j);
				}
			}
		}
		DFS(0,ban_length,0,banned_id);
		
		return answer.size();
		
	}
	private static void DFS(int idx, int Goal,int start, String[] banned_id) {
		if(idx==Goal) {
			String temp="";
			for(int i=0;i<CheckCombination.length;i++) {
				if(CheckCombination[i])temp+=i;
			}
			answer.add(temp);
			return;
		}
		for(int j=0;j<Combination[idx].size();j++) {
			int temp_index=Combination[idx].get(j);
			if(!CheckCombination[temp_index]) {
				CheckCombination[temp_index]=true;
				DFS(idx+1,Goal,start+1,banned_id);
				CheckCombination[temp_index]=false;
			}
		}
		
	}

}
