package Level3;

import java.util.Stack;

public class 표편집 {
	
	static class node {
		node prev= null;
		node next=null;
		boolean Check=false;
	}
	
	public static void main(String[] args) {
		int n=8;
		int k=2;
		String[] cmd= {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		System.out.println(solution(n,k,cmd));
	}

	private static String solution(int n, int k, String[] cmd) {
		node[] link=new node[1000001];
		link[0]=new node();
		for(int i=1;i<n;i++) {
			
			link[i]=new node();
			link[i].prev=link[i-1];
			link[i-1].next=link[i];
		}
		
		Stack<node> delete=new Stack<>();
		node cur=link[k];
		for(String x: cmd) {
			if ( x.charAt(0)=='D' ) {
				int cnt=Integer.parseInt(x.substring(2));
				for(int i=0;i<cnt;i++) {
					cur=cur.next;
				}
			}
			else if( x.charAt(0)=='U'  ) {
				int cnt=Integer.parseInt(x.substring(2));
				for(int i=0;i<cnt;i++) {
					cur=cur.prev;
				}
			}
			else if( x.charAt(0)=='C') {
				cur.Check=true;
				delete.push(cur);
				node prev=cur.prev;
				node next=cur.next;
				if(prev!=null) {
					prev.next=next;
				}
				if(next!=null) {
					next.prev=prev;
					cur=next;
				}
				else {
					cur=prev;
				}
			}
			else if ( x.charAt(0)=='Z') {
				node tmp=delete.pop();
				node prev=tmp.prev;
				node next=tmp.next;
				tmp.Check=false;
				if(prev!=null) {
					prev.next=tmp;
				}
				if(next!=null) {
					next.prev=tmp;
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++) {
			if(link[i].Check)sb.append('X');
			else sb.append('O');
		}
		return sb.toString();
	}
}
