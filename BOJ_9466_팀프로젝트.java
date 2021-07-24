package Class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9466_팀프로젝트 {
//	초반 접근은 DFS를 시작할 때마다 임시 배열을 만들어 visit체크를 하여 한 번 더 visit 한 곳을 체크를 한다면 사이클이 생겼다. 생각하여 그때 카운트를 하여 답을 구하는 형식으로 하였는데 시간 초과가 떠버렸다. 
//
//	그래서  코드를 visit체크를 그대로 가질 수 있게 가는 것이었다.
//
//	문제의 TC를 가지고 진행해보겠습니다.
//
//	1	2	3	4	5	6	7
//	3	4	3	7	3	4	6
//	3 	4	3 	7	3	4	6
//
//	본래 문제의 TC는 3 1 3 7 3 4 6인데 이해를 위해 저러한 테케를 가지고 하겠습니다.
//
//	여기서 고려해야 하는 점은 
//
//	2번의 시작과 4번의 시작 7번의 시작을 고려해보겠습니다.
//
//	2->4->7->6->4
//
//	4->7->6->4
//
//	7->6->4->7
//
//	이렇게 똑같은 행동을 반복하므로 이러한 것을 해결하기 위해
//
//	2번부터 DFS를 돌 때에 2번의 시작점을 가지고 DFS 돌면서 한 단계 안으로 들어갈 때에  2번의 시작점을 가지고 들어갑니다. 그러면서 마지막 6->4번을 만날 때에 4번은 본래 2번의 시작점을 가지고 있으므로 사이클이 생성된다고 판단하여
//
//	5-2가 되어 3명이 유추할 수 있습니다.
//
//	그리고 사이클이 돌고 있다면 순서는 필요가 없으므로 4에서 시작을 하나 6에서 시작을 하나 7에서 시작을 하나 순서는 크게 의미 없습니다.
//
	static int[] arr;
	static int[] level;
	static int[] starts;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		int TC=Integer.parseInt(br.readLine());
		for(int t=0;t<TC;t++) {
			int N=Integer.parseInt(br.readLine());
			arr=new int[N+1];
			level=new int[N+1];
			starts=new int[N+1];
			st=new StringTokenizer(br.readLine());
			ans=N;
			for(int i=1;i<=N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=1;i<=N;i++) {
				if(level[i]==0) {
					check(i,1,i);
				}
			}
			System.out.println(ans);
		}
	}
	private static void check(int curr, int cnt,int start) {
		if(level[curr]!=0) {
			if(start!=starts[curr])return;
			else {
				ans-=cnt-level[curr];
				return;
			}
		}
		level[curr]=cnt;
		starts[curr]=start;
		check(arr[curr],cnt+1,start);
	}
}
