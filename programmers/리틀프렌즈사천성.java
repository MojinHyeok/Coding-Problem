package Level3;

import java.util.Arrays;

public class 리틀프렌즈사천성 {
	static int row,column,goal;
	static char[][] map;
	static node[] Alpha;
	static boolean[] check;
	static String ans;
	static class node{
		int x,y;
		char c;
		public node(int x, int y, char c) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	public static void main(String[] args) {
		int m=5;
		int n=5;
		String[] board= { "FGHEI", "BAB..", "D.C*.", "CA..I", "DFHGE" };
		System.out.println(solution(m, n, board));
		
	}

	private static String solution(int m, int n, String[] board) {
		String answer = "";
		row=m;
        column=n;
        goal=0;
        ans="";
        //알파벳 갯수 count하기
        boolean[] visit=new boolean[26];
        Alpha=new node[26];
        map=new char[row][column];
        for(int i=0;i<m;i++) {
        	String str=board[i];
        	for(int j=0;j<n;j++) {
        		map[i][j]=str.charAt(j);
        		if(map[i][j]!='.'&&map[i][j]!='*'&&!visit[map[i][j]-'A']) {
        			visit[map[i][j]-'A']=true;
        			Alpha[map[i][j]-'A']=new node(i,j,map[i][j]);
        			goal++;
        		}
        	}
        }
        check=new boolean[26];
        while(true) {
        	int temp=goal;
        	out: for(int i=0;i<26;i++) {
        		if(!check[i]&&Alpha[i]!=null) {
        			for(int d=0;d<4;d++) {
        				search(i,Alpha[i].x,Alpha[i].y,Alpha[i].c,0,d);
        				if(temp>goal)break out;
        			}
        		}
        	}
        	if(temp==goal||goal==0)break;
        }
        if(goal>0)answer="IMPOSSIBLE";
        else answer=ans;
	    return answer;
	}

	private static void search(int i, int x, int y, char c, int cnt, int d) {
		int dx=x+dr[d];
		int dy=y+dc[d];
		if(dx<0||dy<0||dx>=row||dy>=column||map[dx][dy]=='*')return;
		if(map[dx][dy]==c) {
			map[dx][dy]='.';
			map[Alpha[i].x][Alpha[i].y]='.';
			goal--;
			check[i]=true;
			ans+=Alpha[i].c;
			for(int k=0;k<row;k++) {
				System.out.println(Arrays.toString(map[k]));
			}
			System.out.println();
			return;
		}
		else if(map[dx][dy]-'A'>=0&&map[dx][dy]-'A'<=25)return;
		else if(map[dx][dy]=='.') {
			search(i,dx,dy,c,cnt,d);
			if(cnt==0) {
				
				for(int j=0;j<4;j++) {
					//아래부분은 위로갈때는 아래로갈필요가 없고 왼쪽으로갈때는 오른쪽으로 갈 필요가 없습니다.
					if(j==d)continue;
					if(d==0&&j==1)continue;
					if(d==1&&j==0)continue;
					if(d==2&&j==3)continue;
					if(d==3&&j==2)continue;
					search(i,dx,dy,c,cnt+1,j);
				}
			}
		}
        

		
		
	}

	
	
}
