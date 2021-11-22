package Class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_7579_�� {
	//��������
	//2�����迭�� ����Ͽ� �׸������λ������� �޸𸮹���Ʈ ���� �ּҷ� ����Ͽ� Ǯ��ôµ� ����
	//�׸��Ͽ� �ٸ������� �õ��Ͽ� �賶����ó�� �����Ͽ����ϴ�.
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
		//�Ʒ��� ���� dy�� ���ٷ��ϰ� �����غôµ� ���к��ϰ� �߰��ǹǷ� ����.
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
		//�׷��Ƿ� 2�����迭�� ����� �����غý��ϴ�.
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
				if(dy[i][j]>=M)ans=Math.min(j, ans);//����Ͽ� ���� �ֽ�ȭ �����ִ°���
			}
		}		
		System.out.println(ans);
	}
}
