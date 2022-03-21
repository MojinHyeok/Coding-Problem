package Level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 거리두기확인하기 {
	static class node{
		int x;
		int y;
		int distance;
		int cnt;
		public node(int x, int y, int distance, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.distance = distance;
			this.cnt = cnt;
		}
	}
	static int[] dr= {0,0,-1,1};
	static int[] dc= {1,-1,0,0};
	public static void main(String[] args) {
		String[][] places= {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		System.out.println(Arrays.toString(solution(places)));
		
	}
	
	
	//접근 방법
	//문제를 읽었을 때 생각했 던 접근 방법은 BFS의 풀이방식을 생각하였습니다. 문제를 읽고 P를 다 큐에 넣어서 2칸안에 P를 만나는지 확인을 하면 될것이라 생각하였습니다.
	// 하지만 이 접근 방법의 문제는 어떻게 체크처리를 진행할 것인가 였습니다. 그리하여 5x5라면 비트마스크로 충분히 시도해볼만하다고 생각하여 비트마스크로 체크를 진행해보는 것을 생각해봤습니다.
	//그리하여 체크는 비트마스크를 통해 해결하여 문제 풀이를 진행하였습니다.
	private static int[] solution(String[][] places) {
		int[] answer= new int[5];
		for(int d=0;d<5;d++) {
			char[][] map=new char[5][5];
			int[][] check=new int[5][5];
			boolean CheckDistance=true;
			Queue<node> que=new LinkedList<>();
			int cnt=0;
			for(int i=0;i<5;i++) {
				String line=places[d][i];
				for(int j=0;j<5;j++) {
					map[i][j]=line.charAt(j);
					if(map[i][j]=='P') {
						que.add(new node(i,j,0,cnt));
						check[i][j]=1<<cnt;
						cnt++;
					}
				}
			}
			out: while(!que.isEmpty()) {
				node cur=que.poll();
				for(int i=0;i<4;i++) {
					int dx=cur.x+dr[i];
					int dy=cur.y+dc[i];
					if(dx<0||dy<0||dy>=5||dx>=5)continue;
					//비트마스크를 체크, 갈 수 있는지, 2칸 이상 진행했는지 확인.
					if(map[dx][dy]!='X'&&check[dx][dy]<(check[dx][dy]|1<<cur.cnt)&&cur.distance<2) {
						check[dx][dy]=(check[dx][dy]|1<<cur.cnt);
						if(map[dx][dy]=='P') {
							CheckDistance=false;
							break out;
						}
						que.add(new node(dx,dy,cur.distance+1,cur.cnt));
					}
				}
			}
			if(CheckDistance)answer[d]=1;
			else answer[d]=0;
			
		}

		return answer;
	}
}
