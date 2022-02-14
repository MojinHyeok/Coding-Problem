package Level3;

import java.util.ArrayList;

public class 양과늑대 {
	static int answer;
	static ArrayList<Integer>[] tree;
	public static void main(String[] args) {
		int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
		int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
		System.out.println(solution(info,edges));
		
	}

	private static int solution(int[] info, int[][] edges) {
		answer =0;
		//트리형태의 정보 저장
		tree=new ArrayList[info.length];
		for(int i=0;i<info.length;i++) {
			tree[i]=new ArrayList<>();
		}
		for(int[] edge: edges) {
			int parent=edge[0];
			int child=edge[1];
			tree[parent].add(child);
		}
		//DFS가 진행 되면서 각 node를 방문하면서 다음에 방문할 노드들에 대한 list생성
		//이렇게 진행을 하지 않는다면 모든 node에서 같은 다음노드를 공유하게 됨.
		ArrayList<Integer> visitList= new ArrayList<>();
		visitList.add(0);
		DFS(0,0,0,visitList,info);
		return answer;
	}

	private static void DFS(int sheepCnt, int wolfCnt, int Curnode, ArrayList<Integer> visitList, int[] info) {
		sheepCnt+=info[Curnode]^1;
		wolfCnt +=info[Curnode];
		answer=Math.max(answer,sheepCnt);
		if(sheepCnt<=wolfCnt)return;
		ArrayList<Integer> copy=new ArrayList<>();

		copy.addAll(visitList);
		//현재 방문한 노드중  더 방문할 노드가 있다면 추가.
		if(tree[Curnode].size()!=0)copy.addAll(tree[Curnode]);
		//Integer객체가 필요하므로 valueof사용
		copy.remove(Integer.valueOf(Curnode));
		
		for(int nextnode:copy) {
			DFS(sheepCnt,wolfCnt,nextnode,copy,info);
		}
		
		
	}
}
