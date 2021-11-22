package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {
	public static void main(String[] args) {
		int[][] temp= {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		System.out.println(solution(6, temp));
	}
	public static int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<Integer>[] map=new ArrayList[edge.length+1];
        for(int i=0;i<edge.length;i++) {
        	map[i]=new ArrayList<>();
        }
        for(int i=0;i<edge.length;i++) {
        	int start=edge[i][0];
        	int end=edge[i][1];
        	map[start].add(end);
        	map[end].add(start);
        }
        int[] indegree=new int[n+1];
        boolean[] visit=new boolean[n+1];
        visit[1]=true;
        visit[0]=true;
        Queue<Integer> que=new LinkedList<>();
        que.add(1);
        int temp=0;
        int curTemp=0;
        while(!que.isEmpty()) {
        	int size=que.size();
        	temp++;
        	for(int i=0;i<size;i++) {
        		int cur=que.poll();
        		for(int j=0;j<map[cur].size();j++) {
        			if(!visit[map[cur].get(j)]) {
        				indegree[map[cur].get(j)]=temp;
        				visit[map[cur].get(j)]=true;
        				curTemp=temp;
        				que.add(map[cur].get(j));
        			}
        		}
        	}
        }
        for(int i=1;i<=n;i++) {
        	if(indegree[i]==curTemp)answer++;
        }
        return answer;
    }

}
