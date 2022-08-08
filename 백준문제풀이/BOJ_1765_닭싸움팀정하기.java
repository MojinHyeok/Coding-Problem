package 백준문제풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1765_닭싸움팀정하기 {

	static int[] parent;
	static Map<Integer, ArrayList<Integer>> E;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		int answer = 0;
		boolean[] visit = new boolean[N + 1];
		E = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 1; i <= N; i++) {
			parent[i] = i;

		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String R = st.nextToken();
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if ("F".equals(R)) {
				Union(from, to);
			}
			if ("E".equals(R)) {
				if (E.get(from) == null) {
					ArrayList<Integer> tmp = new ArrayList<>();
					tmp.add(to);
					E.put(from, tmp);
				} else {
					ArrayList<Integer> tmp = E.get(from);
					tmp.add(to);
					E.put(from, tmp);
				}
				if (E.get(to) == null) {
					ArrayList<Integer> tmp = new ArrayList<>();
					tmp.add(from);
					E.put(to, tmp);
				} else {
					ArrayList<Integer> tmp = E.get(to);
					tmp.add(from);
					E.put(to, tmp);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (E.get(i)!=null&&E.get(i).size() >= 2) {
				for (int j = 0; j < E.get(i).size(); j++) {
					for (int k = j + 1; k < E.get(i).size(); k++) {
						Union(E.get(i).get(j), E.get(i).get(k));
					}

				}
			}
		}
		for (int i = 1; i <= N; i++) {
			if (visit[find(i)] == false) {
				answer++;
				visit[find(i)] = true;
			}
		}
		System.out.println(answer);

	}

	private static void Union(int from, int to) {
		int Aroot = find(from);
		int Broot = find(to);
		if (Aroot == Broot)
			return;
		parent[Aroot] = Broot;

	}

	private static int find(int x) {
		if (x == parent[x])
			return x;
		return find(parent[x]);
	}

}
