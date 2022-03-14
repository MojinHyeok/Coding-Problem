package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import Level3.경주로건설.node;

public class 길찾기게임_트리구현_전위_후위_구현__중요__ {
	static class node{
		int x,y,num;
		node left,right;
		public node(int num,int x,int y) {
			this.num=num;
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) {
		int[][] nodeinfo= {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		System.out.println(Arrays.toString(solution(nodeinfo)));
	}

	private static int[][] solution(int[][] nodeinfo) {
		int[][] answer= new int[2][nodeinfo.length];
		ArrayList<Integer> pre=new ArrayList<>();
		ArrayList<Integer> post =new ArrayList<>();
		node[] tree=new node[nodeinfo.length];
		
		for(int i=0;i<nodeinfo.length;i++) {
			tree[i]=new node(i+1,nodeinfo[i][0],nodeinfo[i][1]);
		}
		Arrays.sort(tree,new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				return o2.y-o1.y;
			}
		});
		node root=tree[0];
		for(int i=1;i<tree.length;i++) {
			maketree(root,tree[i]);
		}
		
		preorder(root,pre);
		postorder(root,post);
		for(int i=0;i<tree.length;i++) {
			answer[0][i]=pre.get(i);
			answer[1][i]=post.get(i);
		}
		return answer;
	}

	private static void postorder(node root, ArrayList<Integer> post) {
		if(root.left!=null) {
			postorder(root.left,post);
		}
		if(root.right!=null) {
			postorder(root.right,post);
		}
		post.add(root.num);
		
	}

	private static void preorder(node root, ArrayList<Integer> pre) {
		pre.add(root.num);
		if(root.left!=null) {
			preorder(root.left,pre);
		}
		if(root.right!=null) {
			preorder(root.right,pre);
		}
		
	}

	private static void maketree(node root, node node) {
		if(node.x>root.x) {
			if(root.right==null) {
				root.right=node;
			}else {
				maketree(root.right,node);
			}
		}else {
			if(root.left==null) {
				root.left=node;
			}else {
				maketree(root.left,node);
			}
		}
		
	}
}
