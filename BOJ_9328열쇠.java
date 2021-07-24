package Class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_9328열쇠 {
//	문제 해결법
//	이 문제의 주의해야 할 점은
//
//	 상근이는 처음에는 빌딩의 밖에 있으며, 빌딩 가장자리의 빈 공간이나 문을 통해 빌딩 안팎을 드나들 수 있다. 각각의 문에 대해서, 그 문을 열 수 있는 열쇠의 개수는 0개, 1개, 또는 그 이상이고, 각각의 열쇠에 대해서, 그 열쇠로 열 수 있는 문의 개수도 0개, 1개, 또는 그 이상이다. 열쇠는 여러 번 사용할 수 있다.
//
//	이점이 가장 주요했던 점인 것 같습니다. 시작점이 따로 안 주어지고 빈 공간이나 문을 통해 빌딩 안팎을 드나들 수 있다는 점을 이용해야 합니다.
//
//	그리하여 빌딩 밖에서 들어갈 수 있는 문 어디서든 들어가기 위해  map크기를 원래의 배열보다+2 하여 진행하여줍니다.
//
//	그리하여 맵에 대한 정보는 행과 열은 1부터 진행하여 정보를 저장합니다. 그리하여 0행과 마지막행과 0열과 마지막 열을 통해 빌딩 안팎을 드나듭니다.
//
//	두 번째 주의할 점은 키를 어떻게 처리할 것인가에 대해서입니다. 
//
//	맨 처음에 문에 대한 정보를 배열로 저장하였는데 문제 주의해야 할 점에 문의 개수가 2개 혹은 이상일 수도 있다고 하여 ArrayList를 사용하였습니다. 키의 정보는 어차피 가지고 있는지만 중요한 것이라 배열을 그냥 사용하였습니다.
//
//
//
//	시나리오는
//
//	 BFS를 이용하여 전체를 탐색하면서 문을 만난다면 키가 있다면 바로 열고 방문처리를 진행하고 문을 만났는데 키가 없다면 Arraylist에 x좌표와 y좌표를 저장합니다. 
//
//	그 이후 탐색을 하다 키를 만난다면 키에 대한 정보를 저장하고 얻은 키를 가지고 ArrayList에 저장된 문을 열 수 있다면 그 문으로 이동하여 계속 탐색을 진행합니다.
//
//	이렇게 탐색을 하여 문서를 만난다면 플러스 1을 하면서 답을 유추합니다.
	static public class node{
		int x,y;
		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	};
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,1,-1};
	static int ans,row,column,cnt;
	static char[][] map;
	static boolean[][] visit;
	static boolean[] key;
	static ArrayList<node>[] door;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		int TC=Integer.parseInt(br.readLine());
		for(int t=0;t<TC;t++) {
			st=new StringTokenizer(br.readLine());
			row=Integer.parseInt(st.nextToken());
			column=Integer.parseInt(st.nextToken());
			map=new char[row+2][column+2];
			door=new ArrayList[26];
			for(int i=0;i<26;i++) {
				door[i]=new ArrayList<>();
			}
			for(int i=1;i<=row;i++) {
				String str=br.readLine();
				for(int j=1;j<=column;j++) {
					map[i][j]=str.charAt(j-1);
				}
			}
			visit=new boolean[row+2][column+2];
			cnt=1;
			String str=br.readLine();
			key=new boolean[26];
			if(!str.equals("0")) {
				for(int i=0;i<str.length();i++) {
					int temp=str.charAt(i);
					cnt+=temp-'a';
					key[temp-'a']=true;
				}				
			}
			ans=0;
			godocment(0, 0);
			System.out.println(ans);
		}	
	}
	private static void godocment(int x,int y) {
		Queue<node> queue=new LinkedList<node>();
		queue.add(new node(x,y));
		while(!queue.isEmpty()) {
			node curr=queue.poll();
			for(int i=0;i<4;i++) {
				int dx=curr.x+dr[i];
				int dy=curr.y+dc[i];
				if(dx>=0&&dy>=0&&dx<=row+1&&dy<=column+1) {
					if(visit[dx][dy]||map[dx][dy]=='*')continue;
					else if (map[dx][dy]=='.'||map[dx][dy]=='\u0000') {
						queue.add(new node(dx,dy));
						visit[dx][dy]=true;
					}
					else if(map[dx][dy]>=65&&map[dx][dy]<=90) {
						if(key[map[dx][dy]-'A']) {
							queue.add(new node(dx,dy));
							visit[dx][dy]=true;
						}else if(!key[map[dx][dy]-'A']) {
							door[map[dx][dy]-'A'].add(new node(dx,dy));
						}
							
					}else if(97<=map[dx][dy]&&map[dx][dy]<=122) {
						if(!key[map[dx][dy]-'a']) {
							key[map[dx][dy]-'a']=true;
							visit[dx][dy]=true;
							if(door[map[dx][dy]-'a'].size()!=0) {
								for(int j=0;j<door[map[dx][dy]-'a'].size();j++) {
									node current=door[map[dx][dy]-'a'].get(j);
									visit[current.x][current.y]=true;
									queue.add(new node(current.x,current.y));
								}
							}
							queue.add(new node(dx,dy));
						}else {
							queue.add(new node(dx,dy));
							visit[dx][dy]=true;
						}
					}else if(map[dx][dy]=='$') {
						ans++;
						queue.add(new node(dx,dy));
						visit[dx][dy]=true;
					}
				}
			}
		}
	}
}
