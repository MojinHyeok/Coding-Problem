package Class3;

import java.util.Scanner;

public class BOJ_1074_Z {
	static int n,r,c,cnt;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		r=sc.nextInt();
		c=sc.nextInt();
		
		int size=(int)Math.pow(2,n);
		cnt=0;
		dfs(size,r,c);
		System.out.println(cnt);
	}
	private static void dfs(int size, int r2, int c2) {
		if(size==1)return;
		if(r2<size/2&& c2<size/2)dfs(size/2,r2,c2);//1사분면
		else if(r2 < size/2 && c2 >= size/2) {//2사분면
			cnt += size * size / 4;
			dfs(size/2, r2, c2 - size/2);
		}
		else if(r2 >= size/2 && c2 < size/2) {//3사분면
			cnt += (size * size / 4) * 2;
			dfs(size/2, r2 - size/2, c2);
		}
		else {//4사분면
			cnt += (size * size / 4) * 3;
			dfs(size/2, r2 - size/2, c2 - size/2);
		}

	}
}
