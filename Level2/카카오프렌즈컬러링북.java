package Level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
	static int[] dr= {0,0,1,-1};
	static int[] dc= {1,-1,0,0};
	static class node{
		int x,y;
		int value;
		public node(int x, int y,int value) {
			super();
			this.x = x;
			this.y = y;
			this.value=value;
		}
		
	}
	public static void main(String[] args) {
		int m=6;
		int n=4;
		int[][] picture= {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		System.out.println(Arrays.toString(solution(m,n,picture)));
	}

	private static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] map=new boolean[m][n];
        Queue<node> que=new LinkedList<>();
        
        for(int i=0;i<m;i++) {
        	for(int j=0;j<n;j++) {
        		int Cnt=0;
        		if(!map[i][j]&&picture[i][j]!=0) {
        			numberOfArea++;
        			que.add(new node(i,j,picture[i][j]));
        			while(!que.isEmpty()) {
        				node cur=que.poll();
        				if(!map[cur.x][cur.y]) {
        					Cnt++;
        					map[cur.x][cur.y]=true;
        					for(int d=0;d<4;d++) {
        						int dx=cur.x+dr[d];
        						int dy=cur.y+dc[d];
        						if(dx<0||dy<0||dx>=m||dy>=n)continue;
        						if(!map[dx][dy]&&picture[dx][dy]==cur.value) {
        							que.add(new node(dx,dy,cur.value));
        						}
        					}
        				}
        			}
        			maxSizeOfOneArea=Integer.max(maxSizeOfOneArea, Cnt);
        		}
        	}
        }
        
        
        
        int[] answer = new int[2];        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
          
        return answer;
	}

}
