package Class5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2252_줄세우기 {
	//위상정렬문제 
	//구현을 어떻게 할지 고민해서 풀어보기..
	//여기서 중요한것은 "번호 A, B가 주어진다. 이는 학생 A가 학생 B의 앞에 서야 한다는 의미이다." 이점이다 그러므로 A,B가 주어질 때에 B는 A보다 뒤에있어야하므로 이점을 주의하며 코드를 작성해본다.
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int[] indegree=new int[N+1];
		ArrayList<Integer>[] key=new ArrayList[N+1];
		Queue<Integer> queue=new LinkedList<>();
		ArrayList<Integer> result=new ArrayList<>();
		for(int i=0;i<=N;i++) {
			key[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++) {
			int from=sc.nextInt();
			int to=sc.nextInt();
			key[from].add(to);
			indegree[to]++;
		}
		for(int i=1;i<=N;i++) {//indegree가0이라면 그것은 바로 출력가능하다고 판단
			if(indegree[i]==0)queue.add(i);
		}
		while(!queue.isEmpty()) {
			int node=queue.poll();
			result.add(node);
			for(int i=0;i<key[node].size();i++) {//인접리스트와 연결된 모든 것을 고려하는 단계
				indegree[key[node].get(i)]--;
				if(indegree[key[node].get(i)]==0)queue.add(key[node].get(i));//0이됬다면 그것은 출력할 수 있다고 판단.
			}
		}
		for(int i=0;i<result.size();i++) {
			System.out.print(result.get(i)+" ");
		}
	}

}
