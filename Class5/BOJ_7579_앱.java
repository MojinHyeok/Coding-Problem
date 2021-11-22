package Class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_7579_앱 {
	//문제접근
	//2차원배열을 사용하여 그리디적인생각으로 메모리바이트 수를 최소로 사용하여 풀어봤는데 오답
	//그리하여 다른생각을 시도하여 배낭문제처럼 접근하였습니다.
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][] arr=new int[N][2];
		st=new StringTokenizer(br.readLine());
		StringTokenizer st1=new StringTokenizer(br.readLine());
		int sum=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<1;j++) {
				arr[i][0]=Integer.parseInt(st.nextToken());
				arr[i][1]=Integer.parseInt(st1.nextToken());
				sum+=arr[i][1]+1;
			}
		}
//		Arrays.sort(arr,new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] t1, int[] t2) {
//				return t1[1]-t2[1];
//			}
//		});
//		for(int[] x:arr)
//			System.out.println(Arrays.toString(x));
		int ans=Integer.MAX_VALUE;
		int[][] dy=new int[N][sum+1];
		//아래와 같이 dy를 한줄로하고 실행해봤는데 무분별하게 추가되므로 포기.
		//		int ans=Integer.MAX_VALUE;
		//		int[] dy=new int[sum+1];
		//		for(int i=0;i<N;i++) {
		//			int memory=arr[i][0];
		//			int money=arr[i][1];
		//			for(int j=money;j<sum;j++) {
		//				dy[j]=Math.max(dy[j], dy[j-money]+memory);
		//				if(dy[j]>=M)ans=Math.min(j, ans);
		//			}
		//		}
		//그러므로 2차원배열로 만들어 구현해봤습니다.
		for(int i=0;i<N;i++) {
			int memory=arr[i][0];
			int money=arr[i][1];
			for(int j=0;j<=sum;j++) {
				if(i==0) {
					if(j>=money)dy[i][j]=memory;
				}
				else {
					if(j>=money)dy[i][j]=Math.max(dy[i-1][j],dy[i-1][j-money]+memory);
					else dy[i][j]=dy[i-1][j];
				}
				if(dy[i][j]>=M)ans=Math.min(j, ans);//계속하여 답을 최신화 시켜주는과정
			}
		}		
		System.out.println(ans);
	}
}
