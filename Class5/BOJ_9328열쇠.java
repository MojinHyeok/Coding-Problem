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
//	���� �ذ��
//	�� ������ �����ؾ� �� ����
//
//	 ����̴� ó������ ������ �ۿ� ������, ���� �����ڸ��� �� �����̳� ���� ���� ���� ������ �峪�� �� �ִ�. ������ ���� ���ؼ�, �� ���� �� �� �ִ� ������ ������ 0��, 1��, �Ǵ� �� �̻��̰�, ������ ���迡 ���ؼ�, �� ����� �� �� �ִ� ���� ������ 0��, 1��, �Ǵ� �� �̻��̴�. ����� ���� �� ����� �� �ִ�.
//
//	������ ���� �ֿ��ߴ� ���� �� �����ϴ�. �������� ���� �� �־����� �� �����̳� ���� ���� ���� ������ �峪�� �� �ִٴ� ���� �̿��ؾ� �մϴ�.
//
//	�׸��Ͽ� ���� �ۿ��� �� �� �ִ� �� ��𼭵� ���� ����  mapũ�⸦ ������ �迭����+2 �Ͽ� �����Ͽ��ݴϴ�.
//
//	�׸��Ͽ� �ʿ� ���� ������ ��� ���� 1���� �����Ͽ� ������ �����մϴ�. �׸��Ͽ� 0��� ��������� 0���� ������ ���� ���� ���� ������ �峪��ϴ�.
//
//	�� ��° ������ ���� Ű�� ��� ó���� ���ΰ��� ���ؼ��Դϴ�. 
//
//	�� ó���� ���� ���� ������ �迭�� �����Ͽ��µ� ���� �����ؾ� �� ���� ���� ������ 2�� Ȥ�� �̻��� ���� �ִٰ� �Ͽ� ArrayList�� ����Ͽ����ϴ�. Ű�� ������ ������ ������ �ִ����� �߿��� ���̶� �迭�� �׳� ����Ͽ����ϴ�.
//
//
//
//	�ó�������
//
//	 BFS�� �̿��Ͽ� ��ü�� Ž���ϸ鼭 ���� �����ٸ� Ű�� �ִٸ� �ٷ� ���� �湮ó���� �����ϰ� ���� �����µ� Ű�� ���ٸ� Arraylist�� x��ǥ�� y��ǥ�� �����մϴ�. 
//
//	�� ���� Ž���� �ϴ� Ű�� �����ٸ� Ű�� ���� ������ �����ϰ� ���� Ű�� ������ ArrayList�� ����� ���� �� �� �ִٸ� �� ������ �̵��Ͽ� ��� Ž���� �����մϴ�.
//
//	�̷��� Ž���� �Ͽ� ������ �����ٸ� �÷��� 1�� �ϸ鼭 ���� �����մϴ�.
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
