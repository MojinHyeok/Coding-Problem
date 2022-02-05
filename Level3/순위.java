package Level3;

import java.util.HashSet;

public class 순위 {
	
	static class  person{
		HashSet<Integer> WinList=new HashSet<>();
		HashSet<Integer> LoseList=new HashSet<>();
		int number;
		public person(int number) {
			this.number = number;
		}
		
	};
	
	public static void main(String[] args) {
		int n=5;
		int[][] results= {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		System.out.println(solution(n,results));	
	}

	public static int solution(int n, int[][] results) {
		int answer=0;
		person[] result=new person[n+1];
		for(int i=1;i<=n;i++) {
			result[i]=new person(i);
		}
		int results_length=results.length;
		for(int i=0;i<results_length;i++) {
			int winner=results[i][0];
			int loser=results[i][1];
			//위너의 성적표 넣는 과정
			for(Integer x:result[loser].WinList) {
				result[winner].WinList.add(x);
			}
			result[winner].WinList.add(loser);
			//진사람의 성적표 넣는과정
			for(Integer x:result[winner].LoseList) {
				result[loser].LoseList.add(x);
			}
			result[loser].LoseList.add(winner);
		}
		for(int i=1;i<=n;i++) {
			int size=result[i].WinList.size()+result[i].LoseList.size();
			if(size==n-1)answer++;
		}
	
		return answer;
	}


}
