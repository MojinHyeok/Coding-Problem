package Class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9466_팀프로젝트 {
//	�ʹ� ������ DFS�� ������ ������ �ӽ� �迭�� ����� visitüũ�� �Ͽ� �� �� �� visit �� ���� üũ�� �Ѵٸ� ����Ŭ�� �����. �����Ͽ� �׶� ī��Ʈ�� �Ͽ� ���� ���ϴ� �������� �Ͽ��µ� �ð� �ʰ��� �����ȴ�. 
//
//	�׷���  �ڵ带 visitüũ�� �״�� ���� �� �ְ� ���� ���̾���.
//
//	������ TC�� ������ �����غ��ڽ��ϴ�.
//
//	1	2	3	4	5	6	7
//	3	4	3	7	3	4	6
//	3 	4	3 	7	3	4	6
//
//	���� ������ TC�� 3 1 3 7 3 4 6�ε� ���ظ� ���� ������ ���ɸ� ������ �ϰڽ��ϴ�.
//
//	���⼭ ����ؾ� �ϴ� ���� 
//
//	2���� ���۰� 4���� ���� 7���� ������ ����غ��ڽ��ϴ�.
//
//	2->4->7->6->4
//
//	4->7->6->4
//
//	7->6->4->7
//
//	�̷��� �Ȱ��� �ൿ�� �ݺ��ϹǷ� �̷��� ���� �ذ��ϱ� ����
//
//	2������ DFS�� �� ���� 2���� �������� ������ DFS ���鼭 �� �ܰ� ������ �� ����  2���� �������� ������ ���ϴ�. �׷��鼭 ������ 6->4���� ���� ���� 4���� ���� 2���� �������� ������ �����Ƿ� ����Ŭ�� �����ȴٰ� �Ǵ��Ͽ�
//
//	5-2�� �Ǿ� 3���� ������ �� �ֽ��ϴ�.
//
//	�׸��� ����Ŭ�� ���� �ִٸ� ������ �ʿ䰡 �����Ƿ� 4���� ������ �ϳ� 6���� ������ �ϳ� 7���� ������ �ϳ� ������ ũ�� �ǹ� �����ϴ�.
//
	static int[] arr;
	static int[] level;
	static int[] starts;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		int TC=Integer.parseInt(br.readLine());
		for(int t=0;t<TC;t++) {
			int N=Integer.parseInt(br.readLine());
			arr=new int[N+1];
			level=new int[N+1];
			starts=new int[N+1];
			st=new StringTokenizer(br.readLine());
			ans=N;
			for(int i=1;i<=N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			for(int i=1;i<=N;i++) {
				if(level[i]==0) {
					check(i,1,i);
				}
			}
			System.out.println(ans);
		}
	}
	private static void check(int curr, int cnt,int start) {
		if(level[curr]!=0) {
			if(start!=starts[curr])return;
			else {
				ans-=cnt-level[curr];
				return;
			}
		}
		level[curr]=cnt;
		starts[curr]=start;
		check(arr[curr],cnt+1,start);
	}
}
