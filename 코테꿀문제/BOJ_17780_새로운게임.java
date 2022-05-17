package 코테꿀문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_17780_새로운게임 {
	/**
	 * 1. 구현을 어떻게 할지
	 * 맵은 N +2 만큼 구현
	 * 그 이후 말들에 대한 정보(x좌표, y좌표, 방향, 몇번째 배열에 있는지)들을 가지고 있는 배열을 하나 생성
	 * 그리고 맵에는 LinkedList를 이용하여 빨간색의 경우에는 맨위부터 하나씩 추가하고 파란색 or 흰색의 경우 맨아래부터(Queue)를 활용하여 이동시킵니다.  
	 * 이동시키면서 말들에 대한 정보들을 최신화 시켜주는 것을 잊지않는다.
	 * 방향을 바꿔주는 것은 계속 해야함
	 * 
	 *  이문제를 하면서 헷갈렸던 것은.. 파란색을 만나 방향을 바꿀 때 고려해야할것들..을 생각하지 못한것?
	 *  파란색을 만났을 때 방향전환을 고려!!
	 *  이번에서는 벽을 만나고 방향을 고려할 때 그냥 다 넣는 과정을 진행하면서 방향을 돌리지 않고 그냥 넣어버렸는데 그 과정을 생각해야한다.
	 * @param args
	 */
	

	static class node{
		int x;
		int y;
		int dir;
		int level;
		public node(int x, int y, int dir, int level) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.level = level;
		}
	}
	static int[] dr= {0,0,0,-1,1};
	static int[] dc= {0,1,-1,0,0};
	static LinkedList<Integer>[][] info ;
	static int[][] map;
	static node[] horse ;
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N+2][N+2];
		info = new LinkedList[N+2][N+2];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				info[i][j]=new LinkedList<>();
			}
		}
		horse =new node[K+1];
		for(int i=1; i<=K; i++) {
			st =new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			horse[i] = new node(x,y,dir,1);
			info[x][y].add(i);
		}
		int ans =0;
		while(true) {
			if(ans==1000) break;
			ans ++;
			boolean check = false;
			for(int i=1; i<= K; i ++) {
				node cur = horse[i];
				if(cur.level != 1)continue;
				if(move(cur,N,i)) {
					check= true;
					break;
				};
			}
			if(check)break;
		}	
		if(ans==1000)System.out.println(-1);
		
		else System.out.println(ans);
	}
	private static boolean move(node cur,int N,int idx) {
		int dx = cur.x + dr[cur.dir];
		int dy = cur.y + dc[cur.dir];
		//파란색인지 확인하는 체크
		if((dx>N || dx<1||dy<1||dy>N)||map[dx][dy]==2) {
			int dir = 0;
			if( cur.dir ==2||cur.dir==4) {
				dir = cur.dir - 1;
			}else {
				dir = cur.dir + 1;
			}
			dx = cur.x + dr[dir];
			dy = cur.y + dc[dir];
			if((dx>N || dx<1||dy<1||dy>N)||map[dx][dy]==2){
				horse[idx]=new node(cur.x,cur.y,dir,1);
			}else {
				if( map[dx][dy] == 1) {
					int cnt = info[dx][dy].size();
					int size = info[cur.x][cur.y].size();
					if(cnt+size>=4)return true;
					for(int i=0; i<size-1; i++) {
						cnt++;
						int index = info[cur.x][cur.y].pollLast();
						node tmp = horse[index];
						horse[index] = new node(dx,dy,tmp.dir,cnt);
						info[dx][dy].add(index);
					}
					cnt++;
					info[cur.x][cur.y].poll();
					horse[idx] = new node(dx,dy,dir,cnt);
					info[dx][dy].add(idx);
				}else if(map[dx][dy]== 0) {
					int cnt = info[dx][dy].size();
					int size = info[cur.x][cur.y].size();
					if(cnt+size>=4)return true;
					cnt++;
					info[cur.x][cur.y].poll();
					horse[idx]=new node(dx,dy,dir,cnt);
					info[dx][dy].add(idx);
					for(int i=1; i<size; i++) {
						cnt++;
						int index = info[cur.x][cur.y].poll();
						node tmp = horse[index];
						horse[index] = new node(dx,dy,tmp.dir,cnt);
						info[dx][dy].add(index);
					}
				}
				
			}
			
			//빨간색에 대한 체크
		}else if(map[dx][dy] == 1) {
			int cnt = info[dx][dy].size();
			int size = info[cur.x][cur.y].size();
			if(cnt+size>=4)return true;
			for(int i=0; i<size; i++) {
				cnt++;
				int index = info[cur.x][cur.y].pollLast();
				node tmp = horse[index];
				horse[index] = new node(dx,dy,tmp.dir,cnt);
				info[dx][dy].add(index);
			}
			//흰색에 대한 체크.
		}else if (map[dx][dy]==0) {
			int cnt = info[dx][dy].size();
			int size = info[cur.x][cur.y].size();
			if(cnt+size>=4)return true;
			for(int i=0; i<size; i++) {
				cnt++;
				int index = info[cur.x][cur.y].poll();
				node tmp = horse[index];
				horse[index] = new node(dx,dy,tmp.dir,cnt);
				info[dx][dy].add(index);
			}
		}
		
		
		return false;
	}
 	
}
