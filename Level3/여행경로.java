package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 여행경로 {
	
	static boolean[] check;
	static ArrayList<String> answers;
	public static void main(String[] args) {
//		String[][] temp2= {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[][] temp2= {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
		System.out.println(Arrays.toString(solution(temp2)));
	}

	private static String[] solution(String[][] temp) {
		answers= new ArrayList<>();
		check=new boolean[temp.length];
//		Arrays.sort(temp,new Comparator<String[]>() {
//			@Override
//			public int compare(String[] o1, String[] o2) {
//				if(o1[0].toString().contentEquals(o2[0].toString()))return o1[1].toString().compareTo(o2[1].toString());
//				return o1[0].toString().compareTo(o2.toString());
//			}
//		});
		DFS(temp,0,temp.length,"ICN","ICN");
		Collections.sort(answers);
		String[] answer=answers.get(0).split(" ");
		return answer;
	}

	private static void DFS(String[][] temp, int idx, int Goal, String current,String answer) {
		if(idx==Goal) {
			answers.add(answer);
			return ;
		}
		for(int i=0;i<Goal;i++) {
			if(temp[i][0].equals(current)&&!check[i]) {
				check[i]=true;
				DFS(temp,idx+1,Goal,temp[i][1],answer+" "+temp[i][1]);
				check[i]=false;
			}
		}
		
	}
}
