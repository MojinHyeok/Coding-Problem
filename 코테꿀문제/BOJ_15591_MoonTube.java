package 코테꿀문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15591_MoonTube {
	static class node {
		int to;
		int value;
		public node(int to, int value) {
			super();
			this.to = to;
			this.value = value;
		}
	}
	/**
	 * 1. 구현
	 * 문제의 중점은 K값이 이상인 것들을 확인하는 것이 주요하고, 문제의 쟁점은 연결된 좌표중 최소값을 가지고만 활용하는 것이다.
	 * 그리하여 연결리스트를 만들어 만약 연결된 값이 K값 미만이라면 그 번호는 아예 들어가지를 않는다.
	 * 
	 * 2. 시간복잡도
	 * 시간 복잡도는 2초 인데 
	 * 2초의 경우 2억정도가 나오므로 
	 * BFS를 통해 Q번 반복, 인접리스트의 경우 V+E
	 * (5000+5000)* 5000 =5*107승이라 가능하다
	 * 3. 변수
	 *
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		ArrayList<node>[] list = new ArrayList[N+1];
		boolean[] visit ;
		Queue<Integer> que;
		for(int i=1;i<=N;i++) {
			list[i]=new ArrayList<>();
		}
		for(int i=0;i<N-1; i++) {
			st=new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			list[from].add(new node(to,value));
			list[to].add(new node(from,value));
		}
		
		for(int i=0; i < Q; i++) {
			st =new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int stand = Integer.parseInt(st.nextToken());
			que = new LinkedList<>();
			visit = new boolean[N+1];
			visit[stand] = true;
			que.add(stand);
			int ans = 0;
			while(!que.isEmpty()){
				int cur = que.poll();
				
				for(node x : list[cur]) {
					if(!visit[x.to]&&x.value>=K) {
						visit[x.to]=true;
						que.add(x.to);
						ans++;
						
					}
				}
				
			}
			sb.append(ans+"\n");
		}
		
		System.out.println(sb.toString());
		
	}

}
