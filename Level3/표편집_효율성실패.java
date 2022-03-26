package Level3;

import java.util.LinkedList;
import java.util.Stack;

public class 표편집_효율성실패 {
	public static void main(String[] args) {
		int n=8;
		int k=2;
		String[] cmd= {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		System.out.println(solution(n,k,cmd));
	}

	private static String solution(int n, int k, String[] cmd) {
		LinkedList<String> list=new LinkedList<>();
		Stack<String> stack=new Stack<>();
		for(int i=0;i<n;i++) {
			list.add(Integer.toString(i));
		}
		int cur=k;
		int size=n;
		for(String x : cmd) {
			if ( x.charAt(0)=='D' ) {
				cur+=Integer.parseInt(x.substring(2));
			}
			else if( x.charAt(0)=='U'  ) {
				cur-=Integer.parseInt(x.substring(2));
			}
			else if( x.charAt(0)=='C') {
			
				String org=list.get(cur);
				list.remove(cur);
				stack.add(Integer.toString(cur)+" "+org);
				size--;
				if(size==cur) {
					cur--;
				}
			}
			else if ( x.charAt(0)=='Z') {
				size++;
				String insertValue=stack.pop();
				String[] InsertCmd=insertValue.split(" ");
				list.add(Integer.parseInt(InsertCmd[0]), InsertCmd[1]);	
				if(Integer.parseInt(InsertCmd[0])<=cur)cur++;
			}
		}
		boolean[] Check=new boolean[n];
		while(!stack.isEmpty()) {
			String insertValue=stack.pop();
			String[] InsertCmd=insertValue.split(" ");
			Check[Integer.parseInt(InsertCmd[1])]=true;
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<n;i++) {
			if(Check[i])sb.append("X");
			else sb.append("O");
		}
		return sb.toString();
	}

}
