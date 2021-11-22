package 백준문제풀이;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_17471게리맨더링 {
	static int[] popul;
	static boolean[] visit;
	static boolean[] visited;
	static int N,ans;
	static ArrayList<Integer>[] adj;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		adj=new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			adj[i]=new ArrayList<Integer>();
		}
		popul=new int[N+1];
		visit=new boolean[N+1];
		for(int i=1;i<=N;i++) {
			popul[i]=sc.nextInt();
		}
		for(int i=1;i<=N;i++) {
			int K=sc.nextInt();
			for(int j=0;j<K;j++) {
				adj[i].add(sc.nextInt());
			}
		}
	
		//여기까지가 입력값 받기..		
		ans=99999;
		powerset(1);
		if(ans==99999)System.out.println(-1);
		else System.out.println(ans);
	}
	//먼저 분리를 하는과정
	static void powerset(int idx) {
		if(idx==N+1) {

			check();
			return;
		}
		visit[idx]=true;
		powerset(idx+1);
		visit[idx]=false;
		powerset(idx+1);
	}
	//분리를 한이후에 true는 true끼리 연결되어있느지 false는 false끼리 연결되어있는지확인을 한다.
	private static void check() {
		visited=new boolean[N+1];
		visited[0]=true;//생략해두되는과정
		for(int i=1;i<=N;i++) {//여기서는 true의 맨처음만나느지점부터 쭈루룩 연결되어있는지 확인합니다.
			if(visit[i]==true) {
				dfs(i);
				break;
			}
		}
		for(int i=1;i<=N;i++) {//여기서는 false의 맨처음 만나는 지점부터 쭈루룩 연결되어 있는지 확인합니다.
			if(visit[i]==false) {
				dfs(i);
				break;
			}
		}
		for(int i=1;i<=N;i++) {//그래서  dfs과정을 지나갔을때에 모든 과정이 연결되어있다면 상관없지만 중간에 false가 있다면 그것은 중간에 연결이 끊긴것이끼대문에 바로 리턴
			if(!visited[i])
				return;
		}
		
		int one=0;
		int two=0;
		
		for(int i=1;i<=N;i++) {//그래서 true는 true끼리 false는 false끼리 더합니다.
			if(visit[i]==true) {
				one+=popul[i];
			}
			if(visit[i]==false) {
				two+=popul[i];
			}
		}
		int sum=one-two;
		ans=Math.min(ans, Math.abs(sum));
	}

	private static void dfs(int x) {//여기서는 true값으로 왔다면 그값으로 계속 연결되어있는지 확인하는 과정.
		boolean curr=visit[x];
		visited[x]=true;
		for(int i=0;i<adj[x].size();i++) {
			if(visited[adj[x].get(i)]==false&&visit[adj[x].get(i)]==curr) {
				visited[adj[x].get(i)]=true;
				dfs(adj[x].get(i));
			}
		}
		
	}
}
